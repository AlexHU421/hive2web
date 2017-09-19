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
        colNames : [ 'ip', 'SQL', 'Sub_Time', 'Com_Time', 'Rum_Time', 'TotalTask', 'tatus'],	//展示列名
        colModel: [         						//后台执行列名
            { name: 'ip', key: true },
            { name: 'Description' },
            { name: 'Sub_time' },
            { name: 'Com_time'},
            { name: 'RunTime' },
            { name: 'totalTask' },
            { name: 'status', formatter: function(value, options, row){
                return "<a href='/crm/user/"+value+"'><i class='fa fa-search'></i>&nbsp;查看</a>&nbsp;&nbsp;" +
                        "<a href='/crm/user/"+value+"/edit'><i class='fa fa-edit'></i>&nbsp;编辑</a>";
            }},          								

        ],
        viewrecords: true,
        sortorder : "desc",
        sortname : 'totalTask',
        height: 400,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
//        multiselect: true,			//复选框按钮
        pager: "#jqGridPager",
        postData:{subtime:1,comtime:2,user:3},
//        caption : "Navigator Example",		//收起、隐藏表格按钮
//        jsonReader : {
//            root: "page.list",
//            page: "page.currPage",
//            total: "page.totalPage",
//            records: "page.totalCount"
//        },
//        jsonReader: {
//            root:"dataRows",                // 数据行（默认为：rows）
//            page: "currPage",               // 当前页
//            total: "totalPages",            // 总页数
//            records: "totalRecords",        // 总记录数
//            repeatitems : false             // 设置成false，在后台设置值的时候，可以乱序。且并非每个值都得设
//        },
//        
//        prmNames : {
//            page:"page", 
//            rows:"limit", 
//            order: "order"
//        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    }).navGrid("#jqGridPager",{edit:false,add:false,del:false});
};