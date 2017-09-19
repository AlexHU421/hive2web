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

function isValidStatus(Status)     
{     
    var succeeded="succeeded";
    var running="running";
    var failed="failed";
    var unknown="unknown";
    if (succeeded == Status){
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
	console.log(ipOrStatus);
	console.log(isValidIpOrStatus(ipOrStatus));
	if (isValidIpOrStatus(ipOrStatus)){
		//1.初始化Table
		var htm ="User_info";
		var oTable = new TableInit(ipOrStatus,htm);
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
//	var xhr =getXhr();
//	console.log(xhr);
	var ipOrStatus=document.getElementById('search_cluster_test_ipOrStatus').value;
	console.log(ipOrStatus);
	console.log(isValidIpOrStatus(ipOrStatus));
	if (isValidIpOrStatus(ipOrStatus)){ 
	var h3 = document.getElementById('list.h3');
	var li = document.getElementById('list');
	li.style.display="none";
	h3.style.display="";
//	var url = 'check_sql?ipOrStatus='+ipOrStatus
//	xhr.open('GET',url);
//	xhr.send();
//	xhr.onreadystatechange = function(){
//		console.log(xhr.readyState);
//		if(xhr.readyState==4 && xhr.status==200){
//			var jsonstr = xhr.responseText;
//			console.log("jsonstr="+jsonstr);
//			var list= eval('('+jsonstr+')');
//			var tb = document.getElementById('tb');
//			//将数组中的对象拼凑tb元素
//			var str ='';
//			for (var i=0;i<list.length;i++){
//				console.log(list[i]);
//				var person=list[i];
//				console.log("ip="+person.ip);
//				console.log("name="+person.jobid);
//				console.log("name="+person.user_name);
//				console.log("name="+person.description);
//				console.log("name="+person.submission_time);
//				console.log("name="+person.completion_time);
//				console.log("name="+person.ststus);
//				var tr='<tr>'+'<td>'+person.ip+'</td>'+'<td>'+person.jobid+'</td>'+'<td>'+person.user_name+'</td>'+'<td>'+person.description+'</td>'+'<td>'+person.submission_time+'</td>'+'<td>'+person.completion_time+'</td>'+'<td>'+person.status+'</td>'+'</tr>';
//				console.log("li="+li);
//				str+=tr;
//			}
//			console.log(str);
//			//将li元素显示到ul中
//			tb.innerHTML=str;
//			//将数组中数据，显示到ul中
	//1.初始化Table
			var htm ="Sql_status";
			var oTable = new TableInit(ipOrStatus,htm);
			oTable.Init();
			//2.初始化Button的点击事件
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();			
			h3.style.display="none";
			li.style.display="";
//		}
//	};
	}else{
		var ipOrStatus1=document.getElementById('search_cluster_test_ipOrStatus')
		ipOrStatus1.value="";
		alert("请输入正确的IP及STATUS(succeeded,running,failed,unknown)");	
	}
}