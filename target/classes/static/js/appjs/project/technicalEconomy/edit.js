$().ready(function() {
	validateRule();
	
	$("#projectName").click(function(){
		var index=layer.open({
			  type: 2,
			  area: ['1000px', '450px'],
			  fixed: false, //不固定
			  maxmin: true,
			  content: '/project/projectManage/projectplanPro'
			});
		//layer.full(index);
	});
	
	
	//部门加载菜单
	$.post("/sale/customer/tree",function(data){
		console.log(data);
		var jsonn=v=eval("{"+data+"}");
		zNodes=jsonn;
		
	});
	
	//部门加载菜单
	$.post("/sale/customer/userTree",function(data){
		console.log(data);
		var json=v=eval("{"+data+"}");
		zNodest=json;
		
	});

	setTimeout('$.fn.zTree.init($("#treeDemo"), setting, zNodes)',500);
	setTimeout('$.fn.zTree.init($("#treeDemot"), settingt, zNodest)',500);
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
		url : "/project/technicalEconomy/update",
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

var settingt = {
	      
        view : {
			dblClickExpand : false
		},
        data: {
            simpleData: {
                enable: true
            }
        },
        callback:{    //第一步
            onClick:zTreeOnClickt
        }

    };

var zNodes =[];
var zNodest =[];
    
    function zTreeOnClick(event, treeId, treeNode) {       //第二步
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
    
    function zTreeOnClickt(event, treeId, treeNode) {       //第二步
        var treeObj = $.fn.zTree.getZTreeObj("treeDemot"),
            nodes = treeObj.getCheckedNodes(true),
            v = "";
       /* for (var i = 0; i < nodes.length; i++) {
            v += nodes[i].name + ",";
            console.log("节点id:" + nodes[i].id + "节点名称" + v); //获取选中节点的值
        }*/
        $(objt).val(treeNode.name);

        layer.close(indext);
    }
    

    var index; 
    var obj;
    var indext; 
    var objt;
    openLayer = function (ob) {
    	obj=ob;
        index = layer.open({
            type: 1,
            area: ['300px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $('.content_wrap')
        });
    }
    
    openLayert = function (ob) {
    	objt=ob;
        indext = layer.open({
            type: 1,
            area: ['300px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $('.content_wrapt')
        });
    }
