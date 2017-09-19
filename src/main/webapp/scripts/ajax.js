
function getXhr(){
	if(window.XMLHttpRequest){
		//Chrome Firefox 等标准浏览器
		return new XMLHttpRequest();
	}
	//早期的IE浏览器
	return new ActiveXObject(
			'Microsoft.XMLHttp');
}
function isValidIP(ip)     
{     
    var reg =  /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/     
    return reg.test(ip);     
}

function isValidIpOrStatus(ipOrStatus)     
{     
     if (isValidStatus(ipOrStatus)){
    	return true;
    }else if (isValidIP(ipOrStatus)){
    	return true;
    }else{
    	return false;
    }
}
function timeFormat(time)
{
    time = time.replace(/-/g,'/');
    var date = new Date(time);
	return date;
}

function isValidStatus(Status)     
{     
    var succeeded="succeeded";
    var running="running";
    var failed="failed";
    var unknown="unknown";
    if (Status == ""){
    	return true;
    }else if (succeeded == Status){
    	return true;
    }else if (running == Status){
    	return true;
    }else if (failed == Status){
    	return true;
    }else if (unknown == Status){
    	return true;
    }else{
    	return false;
    }
}


function add_user_ajax(){
	var xhr = getXhr();
	console.log(xhr);
	var aip=document.getElementById('add_cluster_ip_value');
	var aname=document.getElementById('add_cluster_name_value');
	var astatus=document.getElementById('add_cluster_status_value');
	var ip=document.getElementById('add_cluster_ip_value').value;
	var name=document.getElementById('add_cluster_name_value').value;
	var status=document.getElementById('add_cluster_status_value').value;
	if(isValidIP(ip) && isValidStatus(status) && !name==""){		
	var url = 'add_user?ip='+ip+'&status='+status+'&name='+name;
	console.log(url);
	xhr.open('GET',url);
	xhr.send();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState==4 && xhr.status==200){
			var jsonstr = xhr.responseText;
			console.log("jsonstr="+jsonstr);
			if (jsonstr=="0"){
				aip.value="";
				aname.value="";
				astatus.value="";
				alert("添加失败，请检查添加的IP、Name及STATUS");
			}else if (jsonstr=="1"){
				aip.value="";
				aname.value="";
				astatus.value="";
				alert("添加成功");				
			}				
		}	
	};
	}else{
		aip.value="";
		astatus.value="";
		alert("请输入正确的IP、Name及STATUS(succeeded,running,failed,unknown)");
	}
}

function del_user_ajax(){
	var xhr = getXhr();
	console.log(xhr);
	var dip=document.getElementById('del_cluster_ip_value');
	var dname=document.getElementById('del_cluster_name_value');
	var dstatus=document.getElementById('del_cluster_status_value');
	var ip=document.getElementById('del_cluster_ip_value').value;
	var name=document.getElementById('del_cluster_name_value').value;
	var status=document.getElementById('del_cluster_status_value').value;
	if(isValidIP(ip) && isValidStatus(status) && !name==""){	
	var url = 'del_user?ip='+ip+'&status='+status+'&name='+name;
	console.log(url);
	xhr.open('GET',url);
	xhr.send();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState==4 && xhr.status==200){
			var jsonstr = xhr.responseText;
			console.log("jsonstr="+jsonstr);
			if (jsonstr=="0"){
				dip.value="";
				dname.value="";
				dstatus.value="";
				alert("操作失败，请重试");
			}else if (jsonstr=="1"){
				dip.value="";
				dname.value="";
				dstatus.value="";
				alert("操作成功");				
			}				
		}	
	};
	}else{
		dip.value="";
		dstatus.value="";
		alert("请输入正确的IP及STATUS(succeeded,running,failed,unknown)");
	}
}

function user_info_ajax(){
	var ipOrStatus=document.getElementById('search_cluster_test_ipOrStatus').value;
	var StartTime=0;
	var EndTime=0;
	console.log(ipOrStatus);
	console.log(isValidIpOrStatus(ipOrStatus));
	if (isValidIpOrStatus(ipOrStatus)){
		//1.初始化Table
		var htm ="User_info";
		var oTable = new TableInit(ipOrStatus,StartTime,EndTime,htm);
		oTable.Init();
		//2.初始化Button的点击事件
		var oButtonInit = new ButtonInit();
		oButtonInit.Init();	
		
	}else{
		var ipOrStatus1=document.getElementById('search_cluster_test_ipOrStatus');
		ipOrStatus1.value="";
		alert("请输入正确的IP、Name及STATUS(succeeded,running,failed,unknown)");	
	}
}
function sql_status_ajax(){
	var ipOrStatus=document.getElementById('search_cluster_test_ipOrStatus').value;
	var StartTime=timeFormat(document.getElementById('dtp_input1').value).getTime();
    var EndTime=timeFormat(document.getElementById('dtp_input2').value).getTime();
    console.log("Stesttime:"+StartTime);
    console.log("Etesttime:"+EndTime);
    if(isNaN(StartTime)){
    	StartTime = 946656001000;
    }
    if(isNaN(EndTime)){
    	EndTime = 253402271999000;
    }
    console.log("newStesttime:"+StartTime);
    console.log("newEtesttime:"+EndTime);
    console.log("END-START"+(EndTime-StartTime));
    if(EndTime-StartTime<0){
    alert("输入的开始→结束时间段错误，请重新收入");
    return false;
    }
	console.log(ipOrStatus);
	console.log(isValidIpOrStatus(ipOrStatus));
	if (isValidIpOrStatus(ipOrStatus)){ 
			var htm ="Sql_status";
//			var oTable = new TableInit(ipOrStatus,StartTime,EndTime,htm);
//			oTable.Init();
//			//2.初始化Button的点击事件
//			var oButtonInit = new ButtonInit();
//			oButtonInit.Init();
			$("#jqGrid").jqGrid('clearGridData');  //清空表格
			$("#jqGrid").jqGrid('setGridParam',{  // 重新加载数据
				postData:{
		        	subtime:StartTime,
		        	comtime:EndTime,
		        	search:ipOrStatus
		        	},
			}).trigger("reloadGrid");
	}else{
		var ipOrStatus1=document.getElementById('search_cluster_test_ipOrStatus')
		ipOrStatus1.value="";
		alert("请输入正确的IP及STATUS(succeeded,running,failed,unknown)");	
	}
}



