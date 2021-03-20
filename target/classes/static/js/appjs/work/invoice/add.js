$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	
	var str=getMes();
	$('input[name="str"]').val(str);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/work/invoice/save",
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
				required : icon + "请输入姓名"
			}
		}
	})
}


function addRow(){
	var index=$("#plantable").find("tbody").find("tr").length+1;
	var newrow = '<tr>'
		+ '<td><a href="#" onclick="addRow()" >添加</a>&nbsp;&nbsp;<a href="#" onclick="deleteRow(this)" >删除</a></td>'
		+ '<td>'
		+ '<input style="width: 140px;" type="text" />'
		+ '</td>'
		+ '<td>'
		+ '<input style="width: 140px;" type="text">'
		+ '</td>'
		+ '<td>'
		+ '<input style="width: 140px;" type="text">'
		+ '</td>'
		+ '</tr>';
	$("#plantable").find("tbody").prepend(newrow);
	
}

function deleteRow(obj){
	$(obj).parent().parent().remove();
}

function getMes(){

	var lineString='';
	var trs=$("#plantable").find("tbody").find("tr");
	var trl=$("#plantable").find("tbody").find("tr").length-1;
	$.each(trs,function(i,tr){
		var inputs=$(tr).find("input");
		$.each(inputs,function(index,inp){
			var input=$(inp).val();
			lineString = lineString + input +",";
		});

		lineString = lineString+';';

	});
	
	return lineString;
}



