
var prefix = "/project/projectManage"
$(function() {
	load();
	
	$('#closeIframe').click(function(){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引 
	    parent.layer.close(index);
	});
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
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
						singleSelect : true, // 设置为true将禁止多选
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
					           // name:$('#searchName').val(),
					            projectName:$('#searchName').val()
								
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
								field : 'projectName', 
								title : '项目名称' 
							},
															{
								field : 'stage', 
								title : '阶段' 
							},
															{
								field : 'professional', 
								title : '专业' 
							},
															{
								field : 'design', 
								title : '设计/校核' 
							},
															{
								field : 'userId', 
								title : '人员' 
							},
															{
								field : 'startDate', 
								title : '开始时间' 
							},
															{
								field : 'endDate', 
								title : '结束时间' 
							},
															{
								field : 'rate', 
								title : '占比' 
							},
															{
								field : 'projectPlanState', 
								title : '列表审核状态' 
							},
															{
								field : 'auditState', 
								title : '审核状态' 
							} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}




$('#transmit').on('click', function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	var row = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (row.length == 0) {
		layer.msg("请选择一条数据");
		return;
	}
	
		    parent.$('#projectName').val(row[0].projectName);
		    parent.$('#taskTrackId').val(row[0].id);
		    parent.$('#stage').val(row[0].stage);
		    parent.layer.close(index);
		
	
});



