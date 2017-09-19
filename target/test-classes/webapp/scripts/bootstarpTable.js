
var TableInit = function (param,StartTime,EndTime,htm) {
	var search = param;
	var stime = StartTime;
	var etime = EndTime;
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function () {
		$("#list").bootstrapTable('destroy'); 
		if (htm == "User_info"){
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
		if (htm == "Sql_status"){
			$('#list').bootstrapTable({
				url: 'check_sql',		 //请求后台的URL（*）
				method: 'get',					  //请求方式（*）
				toolbar: '#toolbar',				//工具按钮用哪个容器
				striped: true,					  //是否显示行间隔色
				cache: false,					   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,				   //是否显示分页（*）
				sortable: true,					 //是否启用排序
				sortOrder: "desc",				   //排序方式
				queryParams: oTableInit.queryParams,//传递参数（*）
				sidePagination: "server",		   //分页方式：client客户端分页，server服务端分页（*）
				pageNumber:1,					   //初始化加载第一页，默认第一页
				pageSize: 10,					   //每页的记录行数（*）
				pageList: [10,25,50,100],		//可供选择的每页的行数（*）
				search: false,					   //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: false,
				showColumns: true,				  //是否显示所有的列
				showRefresh: true,				  //是否显示刷新按钮
				minimumCountColumns: 1,			 //最少允许的列数
				clickToSelect: true,				//是否启用点击选中行
				height: 500,						//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId: "ip",					 //每一行的唯一标识，一般为主键列
				showToggle:false,					//是否显示详细视图和列表视图的切换按钮
				cardView: false,					//是否显示详细视图
				detailView: false,				   //是否显示父子表
				columns: [
				          {field: 'ip',title: 'ip', sortable: true},
//				          {field: 'jobid',title: 'jobId',sortable:true},
//				          {field: 'user_name',title: 'User_name'},
				          {field: 'description',title: 'Description',sortable:true},
				          {field: 'submission_time',title: 'Sub_time',sortable:true},
				          {field: 'completion_time',title: 'Com_time',sortable:true},
				          {field: 'runTime',title: 'RunTime',sortable:true},
//				          {field: 'status',title: 'status'},
//				          {field: 'stages',title: 'stages',sortable:true},
				          {field: 'totalTask',title: 'totalTask', sortable: true},//需要加上！
				          {field: 'status',title: 'status',sortable:true},

//				          {field: 'failedStageID',title: 'failedstage  ID',sortable:true}	
				       // {field: 'Level',title: '部门级别'}
				          //{},
				          ]
			});
			}
		
		if (htm == "Stage_status"){
			$('#list').bootstrapTable({
				url: 'check_stage',		 //请求后台的URL（*）
				method: 'get',					  //请求方式（*）
				toolbar: '#toolbar',				//工具按钮用哪个容器
				striped: true,					  //是否显示行间隔色
				cache: false,					   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,				   //是否显示分页（*）
				sortable: true,					 //是否启用排序
				sortOrder: "RunTime desc",				   //排序方式
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
				          {field: 'logTime',title: 'LogTime'},
				          {field: 'jobID',title: 'JobID'},
				          {field: 'stageID',title: 'StageID'},
				          {field: 'stageStatus',title: 'Status'},
				          {field: 'failedTaskID',title: 'FailedTask  ID'},
				          {field: 'stageDetail',title: 'Detail'},
				          {field: 'stageAllTaskInfo',title: 'AllTaskInfo',sortable:true}
				          ]
			});
			}
		
		if (htm == "task_status"){
			$('#list').bootstrapTable({
				url: 'check_k',		 //请求后台的URL（*）
				method: 'get',					  //请求方式（*）
				toolbar: '#toolbar',				//工具按钮用哪个容器
				striped: true,					  //是否显示行间隔色
				cache: false,					   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,				   //是否显示分页（*）
				sortable: true,					 //是否启用排序
				sortOrder: "RunTime desc",				   //排序方式
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
				          {field: 'logTime',title: 'LogTime'},
				          {field: 'stageID',title: 'stageID'},
				          {field: 'taskID',title: 'taskID'},
				          {field: 'taskRunDetail',title: 'Detail'},
				          {field: 'runTime',title: 'runTime'},
				          {field: 'taskStatus',title: 'Status'},
				          {field: 'failedDetail',title: 'failedDetail'}
				          ]
			});
			}
	};
	//得到查询的参数
	oTableInit.queryParams = function (params) {
		  var searchKey1 = $("#s1").val(); 
          var searchKey2 = $("#s2").val(); 
//		var ipOrStatus=document.getElementById('search_cluster_test_ipOrStatus').value;
		var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit: params.limit,   //页面大小
			offset: params.offset,  //页码			
			search: search,			//查询内容
			stime:stime,			//开始时间
			etime:etime,				//结束时间
			searchKey1:searchKey1,
            searchKey2:searchKey2,
            sortName:this.sortName,		//排序的单元格元素
            sortOrder:this.sortOrder,	//排序顺序（倒序、正序)
            pageindex:this.pageNumber//当前页码
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