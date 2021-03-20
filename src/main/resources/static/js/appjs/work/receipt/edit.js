$().ready(function() {
	validateRule();
	
	
	$.post("/sale/customer/tree",function(data){
		console.log(data);
		var jsonn=v=eval("{"+data+"}");
		zNodes=jsonn;
		console.log(zNodes);
	});
	
	setTimeout('$.fn.zTree.init($("#treeDemo"), setting, zNodes)',500);
	
	
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/work/receipt/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}




var setting = {
      
        view : {
			dblClickExpand : true
		},
        data: {
            simpleData: {
                enable: true
            }
        },
        callback:{    //第一步
            onClick:zTreeOnClick   
        }

    };



var zNodes =[];

function zTreeOnClick(event, treeId, treeNode) {  
    	 console.log("-----------");//第二步
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = treeObj.getCheckedNodes(true),
            v = "";
       /* for (var i = 0; i < nodes.length; i++) {
            v += nodes[i].name + ",";
            console.log("节点id:" + nodes[i].id + "节点名称" + v); //获取选中节点的值
        }*/
       
        $(obj).val(treeNode.name);
        layer.close(index);
    }
    
    
    var index; 
    var obj=null;
    openLayer = function (ob) {
    	obj=ob;
        index = layer.open({
            type: 1,
            area: ['300px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $('.content_wrap')
        });
    }