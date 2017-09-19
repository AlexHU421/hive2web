$(function(){
	
});



var TableInit = function (param,htm) {
	var search = param;
	var thm =htm;
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function () {
		$("#list").bootstrapTable('destroy'); 
		if (thm == "User_info"){
		$('#list').bootstrapTable({
			url: 'check_user',		 //请求后台的URL（*）
			method: 'get',					  //请求方式（*）
			toolbar: '#toolbar',				//工具按钮用哪个容器
			striped: true,					  //是否显示行间隔色
			cache: false,					   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,				   //是否显示分页（*）
			sortable: false,					 //是否启用排序
			sortOrder: "asc",				   //排序方式
			queryParams: oTableInit.queryParams,//传递参数（*）
			sidePagination: "server",		   //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,					   //初始化加载第一页，默认第一页
			pageSize: 10,					   //每页的记录行数（*）
//			pageList: [10],		//可供选择的每页的行数（*）
			search: false,					   //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,
			showColumns: false,				  //是否显示所有的列
			showRefresh: true,				  //是否显示刷新按钮
			minimumCountColumns: 1,			 //最少允许的列数
			clickToSelect: true,				//是否启用点击选中行
			height: 500,						//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "ip",					 //每一行的唯一标识，一般为主键列
			showToggle:false,					//是否显示详细视图和列表视图的切换按钮
			cardView: false,					//是否显示详细视图
			detailView: false,				   //是否显示父子表
			columns: [
			          {checkbox: false},
			          {field: 'ip',title: 'ip'},
			          {field: 'name',title: 'User_name'},
			          {field: 'status',title: 'status'}
			       // {field: 'Level',title: '部门级别'}
			          //{},
			          ]
		});
		}
		if (thm == "Sql_status"){
			$('#list').bootstrapTable({
				url: 'check_sql',		 //请求后台的URL（*）
				method: 'get',					  //请求方式（*）
				toolbar: '#toolbar',				//工具按钮用哪个容器
				striped: true,					  //是否显示行间隔色
				cache: false,					   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,				   //是否显示分页（*）
				sortable: false,					 //是否启用排序
				sortOrder: "asc",				   //排序方式
				queryParams: oTableInit.queryParams,//传递参数（*）
				sidePagination: "server",		   //分页方式：client客户端分页，server服务端分页（*）
				pageNumber:1,					   //初始化加载第一页，默认第一页
				pageSize: 10,					   //每页的记录行数（*）
//				pageList: [10,25,50,100],		//可供选择的每页的行数（*）
				search: false,					   //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: false,
				showColumns: false,				  //是否显示所有的列
				showRefresh: true,				  //是否显示刷新按钮
				minimumCountColumns: 1,			 //最少允许的列数
				clickToSelect: true,				//是否启用点击选中行
				height: 500,						//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId: "ip",					 //每一行的唯一标识，一般为主键列
				showToggle:false,					//是否显示详细视图和列表视图的切换按钮
				cardView: false,					//是否显示详细视图
				detailView: false,				   //是否显示父子表
				columns: [
				          {checkbox: false},
				          {field: 'ip',title: 'ip'},
				          {field: 'jobid',title: 'jobId'},
				          {field: 'user_name',title: 'User_name'},
				          {field: 'description',title: 'Description'},
				          {field: 'submission_time',title: 'Submission_time'},
				          {field: 'completion_time',title: 'Completion_time'},
				          {field: 'status',title: 'status'},
				          {field: 'stages',title: 'stages'}
				       // {field: 'Level',title: '部门级别'}
				          //{},
				          ]
			});
			}
	};
	//得到查询的参数
	oTableInit.queryParams = function (params) {
//		var ipOrStatus=document.getElementById('search_cluster_test_ipOrStatus').value;
		var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit: params.limit,   //页面大小
			offset: params.offset,  //页码			
			search: search
		};
		return temp;
	};
	return oTableInit;
};
var ButtonInit = function () {
	var oInit = new Object();
	var postdata = {};
	oInit.Init = function () {
		//初始化页面上面的按钮事件
	};
	return oInit;
};