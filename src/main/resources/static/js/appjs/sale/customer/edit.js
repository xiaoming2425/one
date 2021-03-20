$().ready(function() {
	validateRule();
	
	
	$.post("/sale/customer/tree",function(data){
		console.log(data);
		var jsonn=v=eval("{"+data+"}");
		zNodes=jsonn;
		//console.log(zNodes)
	});
	
	$.post("/sale/customer/userTree",function(res){
		//console.log(res);
		var jsonnn=v=eval("{"+res+"}");
		zNodess=jsonnn;
		console.log(zNodess);
	});
	
	setTimeout('$.fn.zTree.init($("#treeDemo"), setting, zNodes)',500);
	setTimeout('$.fn.zTree.init($("#treeDemoT"), settingT, zNodess)',500);

	$("#deptId").click(function(){
		openLayer();
	});
	
	$("#userId").click(function(){
		openLayerT();
	});
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	var formData=$('#signupForm').serializeJSON();
	var deptid=$("#deptId").attr('val');
	var userid=$("#userId").attr('val');
	formData.userId=userid;
	formData.deptId=deptid;
	var form=JSON.stringify(formData);
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sale/customer/update",
		data : form,// 你的formid
		headers : {
			'Content-Type': 'application/json'
		},
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
			dblClickExpand : false
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
var settingT = {
      
        view : {
			dblClickExpand : false
		},
        data: {
            simpleData: {
                enable: true
            }
        },
        callback:{    //第一步
            onClick:zTreeOnClickT   
        }

    };

var zNodes =[];
var zNodess =[];
    
    function zTreeOnClick(event, treeId, treeNode) {       //第二步
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = treeObj.getCheckedNodes(true),
            v = "";
       /* for (var i = 0; i < nodes.length; i++) {
            v += nodes[i].name + ",";
            console.log("节点id:" + nodes[i].id + "节点名称" + v); //获取选中节点的值
        }*/
        $("#deptId").val(treeNode.name);
        $("#deptId").attr('val',treeNode.id);
        layer.close(index);
    }
    
    
    function zTreeOnClickT(event, treeId, treeNode) {       //第二步
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = treeObj.getCheckedNodes(true),
            v = "";
       /* for (var i = 0; i < nodes.length; i++) {
            v += nodes[i].name + ",";
            console.log("节点id:" + nodes[i].id + "节点名称" + v); //获取选中节点的值
        }*/
        $("#userId").val(treeNode.name);
        $("#userId").attr('val',treeNode.id);
        layer.close(indexT);
    }

    var index; 
    var indexT;// 命名layer弹出层
    openLayer = function () {
        index = layer.open({
            type: 1,
            area: ['300px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $('.content_wrap')
        });
    }
    
    openLayerT = function () {
        indexT = layer.open({
            type: 1,
            area: ['300px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $('.content_wrapT')
        });
    }