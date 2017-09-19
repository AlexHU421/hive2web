$(function(){
	pageInit(); 
	});

function pageInit() {
		$("#jqGrid").jqGrid(
				{
        url : '/hive2web/check_sql',
//        mtype : 'post',
        datatype: "json",
        styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式 
        colNames : [ 'Ip', 'SQL', 'Sub_Time', 'Com_Time', 'Rum_Time', 'TotalTask', 'Status'],	//展示列名
        colModel: [         						//后台执行列名
            { name: 'ip', key : true,width:115, sortable:false},
            { name: 'description',width:300, sortable:false},
            { name: 'submission_time',width:155, sortable:false},
            { name: 'completion_time',width:155, sortable:false},
            { name: 'runTime',width:100},
            { name: 'totalTask',width:95, sortable:false},
            { name: 'status',width:100, sortable:false
//            , formatter: function(value, options, row){
//                return "<a href='/crm/user/"+value+"'><i class='fa fa-search'></i>&nbsp;查看</a>&nbsp;&nbsp;" +
//                       "<a href='/crm/user/"+value+"/edit'><i class='fa fa-edit'></i>&nbsp;编辑</a>";}
            },          								

        ],
        viewrecords: true,
        sortorder : "desc",
        sortname : 'Rum_Time',
//        viewsortcols: true,
        height: 400,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 50,
//        autoheight:true,
        width:1200,
//        autowidth:true,
//        multiselect: true,			//复选框按钮
        pager: "#jqGridPager",
        postData:{
        	subtime:1,
        	comtime:99999999999999999,
        	search:""
        	},
//        caption : "Navigator Example",		//收起、隐藏表格按钮
//        jsonReader : {
//             root: "rows",    // json中代表实际模型数据的入口
//             page: "page",    // json中代表当前页码的数据
//             total: "total",    // json中代表页码总数的数据
//             records: "records", // json中代表数据行总数的数据
//             repeatitems: true, // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
//             cell: "cell",
//             id: "id",
//             userdata: "userdata",
//             subgrid: {
//                root:"rows", 
//                repeatitems: true, 
//                cell:"cell"
//            }
//        },
        jsonReader : {
        	root:"rows",
        	page: "page",
        	records: "total",
        	repeatitems: false,
        	id: "0" },
//        
//        prmNames : {
//            page:"page", 
//            rows:"limit", 
//            order: "order"
//        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
            $("#jqGrid").navGrid("#jqGridPager",{edit:false,add:false,del:false,search:false});
        }
    });
};