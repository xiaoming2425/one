$().ready(function() {
	validateRule();
	
	$("#customerId").click(function(){
		var index=layer.open({
			  type: 2,
			  area: ['700px', '450px'],
			  fixed: false, //不固定
			  maxmin: true,
			  content: '/sale/customer/customerPro'
			});
		layer.full(index);
	});
	
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/work/contractApply/save",
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

function initImges() {
	var linkedId = $("#id").val();
	doInitImges('delSoreCover',linkedId,'contract_file');
}

layui.use('upload', function () {
	var upload = layui.upload;
	var linkedId = $("#id").val();
	upload.render({
		elem: "#uploadSoreCover", //绑定元素
		url: '/common/sysFile/upload', //上传接口
		multiple: false,
		size: 1000,
		accept: 'file',
		data: {"linkedId": linkedId, "mode_type": "contract_file"},
		done: function (res, index) {
			if (res.code == 0) {
				//上传成功
				$('#delSoreCover').before('<img class="img-rounded image-view "  id="'
					+ res.fileId + '" onclick="openImg(this)" src="' + res.showPath+res.fileUrl + '">');
				layer.msg(res.msg);
			} else {
				//上传失败
				layer.msg(res.msg);
			}
		},
		error: function (res) {
			layer.msg(res.msg);
		}
	});
});