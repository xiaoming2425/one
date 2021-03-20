$().ready(function() {
	validateRule();
	
	

	$.post("/sale/customer/userTree",function(data){
		console.log(data);
		var jsonn=v=eval("{"+data+"}");
		zNodes=jsonn;
		
	});

	setTimeout('$.fn.zTree.init($("#treeDemo"), setting, zNodes)',500);

	
});



$.validator.setDefaults({
	submitHandler : function() {
		var lineMes=getMes();
		save(lineMes);
	}
});
function save(lineMes) {
	var projectId=$("#projectId").val();
	var mes={
			"id" : projectId,
			"lineMes" : lineMes
	};
	debugger;
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/project/project/savePlan",
		data : JSON.stringify(mes),// 你的formid
		async : false,
		headers : {
			'Content-Type': 'application/json'
		},
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
				required : icon + "请输入姓名"
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

var zNodes =[];

    
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
    
    


    var index; 
    var obj;
    openLayer = function (ob) {
    	obj=ob;
        index = layer.open({
            type: 1,
            area: ['300px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $('.content_wrap')
        });
    }
    
  
    function addRow(){
    	var index=$("#plantable").find("tbody").find("tr").length+1;
    	var newrow = '<tr>'
			+ '<td><a href="#"  onclick="addRow()" >添加</a>&nbsp;&nbsp;  <a href="#" onclick="deleteRow(this)" >删除</a></td>'
			+ '<td>'
			+ '<input style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" type="text" value="阶段'+turnNum(index)+'"  >'
			+ '</td>'
			+ '<td>'
			+ '<select style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" ><option vlaue="项目建议书">项目建议书</option><option vlaue="可研">可研</option>'
			+ '<option vlaue="初设">初设</option><option vlaue="施工">施工</option><option vlaue="竣工">竣工</option></select>'
			+ '</td>'
			+ '<td>'
			+ '<select  style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;"  ><option vlaue="结构">结构</option><option vlaue="电气">电气</option><option vlaue="结构&电气">结构&电气</option>'
			+ '<option vlaue="技经">技经</option><option vlaue="测量">测量</option></select>'
			+ '</td>'
			+ '<td>'
			+ '<select style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" ><option  vlaue="设计">设计</option><option vlaue="校核">校核</option></select>'
			+ '</td>'
			+ '<td>'
			+ '<input  type="text" style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" readonly="readonly" onclick="openLayer(this)"/>'
			+ '</td>'
			+ '<td>'
			+ '<input  readonly="readonly" style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" onClick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})"  type="text">'
			+ '</td>'
			+ '<td>'
			+ '<input  readonly="readonly" style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" onClick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})"  type="text">'
			+ '</td>'
			+ '<td>'
			+ '<input style="border:1px solid #e5e6e7;color: inherit;border-radius:1px;" type="text"  />'
			+ '</td>'
			+ '</tr>';
    	$("#plantable").find("tbody").append(newrow);
    	
    }
    
    function deleteRow(obj){
    	$(obj).parent().parent().remove();
    }
    
    function turnNum(num){
    	var fgh='';
    	switch(num){
    	case 2 :  fgh='二'; break;
    	case 3 :  fgh='三'; break;
    	case 4 :  fgh='四'; break;
    	case 5 :  fgh='五'; break;
    	case 6 :  fgh='六'; break;
    	case 7 :  fgh='七'; break;
    	case 8 :  fgh='八'; break;
    	case 9 :  fgh='九'; break;
    	case 10 :  fgh='十'; break;
    	case 11 :  fgh='十一'; break;
    	case 12 :  fgh='十二'; break;
    	case 13 :  fgh='十三'; break;
    	case 14 :  fgh='十四'; break;
    	case 15 :  fgh='十五'; break;
    	case 16 :  fgh='十六'; break;
    	case 17 :  fgh='十七'; break;
    	}
    	return fgh;
    }
    

    function getMes(){
    
    	var lineString='';
    	var trs=$("#plantable").find("tbody").find("tr");
    	var trl=$("#plantable").find("tbody").find("tr").length;
    	$.each(trs,function(i,tr){
    		var inputs=$(tr).find("input");
    		$.each(inputs,function(index,inp){
    			var input=$(inp).val();
    			lineString = lineString + input +",";
    		});
    	
    		var selects=$(tr).find("select");
    		$.each(selects,function(ind,sel){
    			var selectval=$(sel).val();
    			lineString = lineString +selectval+","
    		});
    		
    			lineString = lineString+';';
    		
    		
    	
    	});
    	
    	return lineString;
    }
    