var $parentNode = window.parent.document;

function $childNode(name) {
    return window.frames[name]
}

// tooltips
$('.tooltip-demo').tooltip({
    selector: "[data-toggle=tooltip]",
    container: "body"
});

// 使用animation.css修改Bootstrap Modal
$('.modal').appendTo("body");

$("[data-toggle=popover]").popover();

//折叠ibox
$('.collapse-link').click(function () {
    var ibox = $(this).closest('div.ibox');
    var button = $(this).find('i');
    var content = ibox.find('div.ibox-content');
    content.slideToggle(200);
    button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
    ibox.toggleClass('').toggleClass('border-bottom');
    setTimeout(function () {
        ibox.resize();
        ibox.find('[id^=map-]').resize();
    }, 50);
});

//关闭ibox
$('.close-link').click(function () {
    var content = $(this).closest('div.ibox');
    content.remove();
});

//判断当前页面是否在iframe中
//if (top == this) {
//    var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
//    $('body').append(gohome);
//}

//animation.css
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}

//拖动面板
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable({
            handle: handle,
            connectWith: connect,
            tolerance: 'pointer',
            forcePlaceholderSize: true,
            opacity: 0.8,
        })
        .disableSelection();
};


//编辑器新增的ajax上传图片函数
function sendFile(files, editor, $editable) {
    var size = files[0].size;
    if((size / 1024 / 1024) > 2) {
        alert("图片大小不能超过2M...");
        return false;
    }
    console.log("size="+size);
    var formData = new FormData();
    formData.append("file", files[0]);
    $.ajax({
        data : formData,
        type : "POST",
        url : "/common/sysFile/upload",    // 图片上传出来的url，返回的是图片上传后的路径，http格式
        cache : false,
        contentType : false,
        processData : false,
        dataType : "json",
        success: function(data) {//data是返回的hash,key之类的值，key是定义的文件名
            $('.summernote').summernote('insertImage',data.fileName);
        },
        error:function(){
            alert("上传失败");
        }
    });
}


//图片删除
function deleteImgs(element){
    var prevObj = $(element).prev();
    var id = $(prevObj).attr("id");
    if(id) {
        layer.confirm('确定要删除选中的记录？', {
            btn: ['确定', '取消']
        }, function () {
            $.ajax({
                url: "/common/sysFile/remove",
                type: "post",
                data: {
                    'id': id
                },
                success: function (r) {
                    if (r.code == 0) {
                        // 删除成功
                        $(prevObj).remove();
                        layer.msg(r.msg);
                    } else {
                        layer.msg(r.msg);
                    }
                }
            });
        })
    }
}

function doInitImges(elementId,linkedId,type){
    $.ajax({
        url: "/common/sysFile/initImages",
        type: "post",
        data: {
            'linkedId': linkedId,
            'type':type
        },
        success: function (r) {
            var list =  JSON.parse(r.msg);
           
            for(var i in list){
            	   var imgUrl=list[i].url;
            	   var suffixIndex=list[i].fileName.lastIndexOf(".");  
            	   var suffix=list[i].fileName.substring(suffixIndex+1).toUpperCase();  
            	   if(suffix!="BMP"&&suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"&&suffix!="GIF"){  
            		   imgUrl="/videoType.jpg";
            	   }  
            	   $('#'+elementId).before('<img class="img-rounded image-view" id="' + list[i].id
                           + '" onclick="openImg(this)" src="' + r.uploadShowPath+imgUrl + '">');
            }
        }
    });
}

/**
 * 初始化已有图片
 */
function doInitFieldImges(linkedId,type){
    var content = '';
    $.ajax({
        url: "/common/sysFile/initImages",
        type: "post",
        async: false,
        data: {
            'linkedId': linkedId,
            'type':type
        },
        success: function (r) {
            var list =  JSON.parse(r.msg);
            for(var i in list){
                content = content +  '<img class="img-rounded image-field-view"  src="' + list[i].url + '">';
            }
        }
    });
    return content;
}
