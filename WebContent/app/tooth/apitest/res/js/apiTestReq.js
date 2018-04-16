var rootPath = getRootPath(); // 存储项目根路径
var servicePath = "http://192.168.1.104:8081/api_platform/"; // 存储项目根路径

// 发起请求
function doRequest(method){
	installUrl();
	var netUrl = $("#netUrl").val();
	if(netUrl && (netUrl != (servicePath + "/Res/"))){
		$.ajax({
			url: netUrl,
			type: method,
			data: $("#inputJson").val(),
			contentType: "application/json",
			cache: false,
			selectable: true,
			success: ajaxReqSuccess,
			error: function(err){
				//alert("ajax请求出现异常，请检查. " + err.statusText);
				alert(JSON.stringify(err));
			}
		});
	}
}

// ajax请求成功后处理
function ajaxReqSuccess(result){
	$("#result").val(result);
}

// 清除按钮
function clearResult(){
	$("#result").val("");
}
// js获取项目根路径，如： http://host:port/projectName  
// 通过location.href和location.pathname截取获得
function getRootPath(){  
    var curWwwPath = window.document.location.href;  
    var pathName = window.document.location.pathname;  
    var pos = curWwwPath.indexOf(pathName);  
    var localhostPath = curWwwPath.substring(0,pos);  
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
    return (localhostPath + projectName);  
} 

// 拼装请求的url
function installUrl(){
	var url = servicePath + "Res/";
	
	// 特定源类  
	var specType = $("#specType").val();
	if(specType && specType != ""){
		url += specType + "/";
	}
	// 父资源类型 
	var prestype = $("#prestype").val();
	if(prestype && prestype != ""){
		url += prestype + "/";
	}
	// 父资源标识 
	var pressign = $("#pressign").val();
	if(pressign && pressign != ""){
		url += pressign + "/";
	}
	// 资源类型 
	var restype = $("#restype").val(); 
	if(restype && restype != ""){
		url += restype + "/";
	}
	// 资源标识  
	var ressign = $("#ressign").val();
	if(ressign && ressign != ""){
		url += ressign + "/";
	}
	// 查询参数  
	var queryParam = $("#queryParam").val();
	if(queryParam && queryParam != ""){
		url += "?" + queryParam ;
	}
	
	$("#netUrl").val(url);
}
