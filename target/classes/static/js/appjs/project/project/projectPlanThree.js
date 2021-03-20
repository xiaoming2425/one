
var prefix = "/project/project"
$(function() {
	loadPlanList();
});

function loadPlanList() {
	$('#exampleTable3')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/listplan", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
								auditState:"4",
								projectPlanId:"1",
					           // name:$('#searchName').val(),
					            projectName:$('#searchNameList').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'projectNo', 
									title : '项目编号' 
								},
								
																{
									field : 'projectName', 
									title : '项目名称' 
								},
																{
									field : 'customerId', 
									title : '委托单位' 
								},
																{
									field : 'ownersUnit', 
									title : '业主单位' 
								},
																{
									field : 'projectManager', 
									title : '项目经理' 
								},
																{
									field : 'saleManager', 
									title : '销售经理' 
								},
																{
									field : 'startDate', 
									title : '开始日期' ,
									formatter : function(value, row, index) {
										 return changeDateFormat(value)
									}
								},
																{
									field : 'endDate', 
									title : '预计完成日期' 
								},
																{
									field : 'projectPlanState', 
									title : '审核状态' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var f = '<a class="btn btn-success btn-sm '+s_resetPwd_h+'" href="#" title="发送"  mce_href="#" onclick="sendPlanList(\''
										+ row.projectPlanId+"'"+','+"'"+row.projectPlanState+"',"+"'"+row.projectName+"',"+"'"+row.id
										+ '\')"><i class="fa fa-key"></i></a> ';
										return f;
									}
								} ]
					});
			}


//转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(cellval) {
    
    if (cellval != null) {
       var arr=cellval.split(" ");
        return arr[0];
    }
}



function reLoadPlanList() {
	$('#exampleTable3').bootstrapTable('refresh');
}


function sendPlanList(id,projectPlanState,projectName,projectId) {

	if(projectPlanState=='退回'||projectPlanState=='未发送'||projectPlanState=='不同意'){
		$.ajax({
			url : prefix+"/sendPlanList",
			type : "post",
			data : {
				'id' : projectId,
				'projectName' : projectName,
				'projectPlanId' : id
			},
			success:function(res){
				if(res.code=='0'){
					layer.msg("发送成功!");
					setTimeout("location.href='/activiti/task/todo'",500);
				}else{
					layer.msg("发送失败!");
				}
			}
		});
	}else{
		layer.msg("此状态不能发送!");
	}
}

