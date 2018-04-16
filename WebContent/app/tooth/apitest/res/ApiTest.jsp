<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API测试</title>
<!-- css -->
<link type="text/css" href="${ctx }/app/public/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="${ctx }/app/tooth/apitest/res/css/apiTest.css" rel="stylesheet" />
</head>
<body>
	<table class="table" style="margin-bottom: -25px;">
		<tr>
			<td style="width:27%" rowspan="2">
				<div class="panel panel-default">
					<div class="panel-heading">资源</div>
					<div class="panel-body">
						<div class="form-inline">
							父资源类型：<input class="form-control" type="text" id="prestype" name="prestype" style="width:70%;" />
						</div>
						<div class="form-inline">
							父资源标识：<input class="form-control" type="text" id="pressign" name="pressign" style="width:70%;" />
						</div>
						<div class="form-inline">
							&nbsp;&nbsp;资源类型：   <input class="form-control" type="text" id="restype" name="restype" style="width:70%;" />
						</div>
						<div class="form-inline">
							&nbsp;&nbsp;资源标识：   <input class="form-control" type="text" id="ressign" name="ressign" style="width:70%;" />
						</div>
						<div class="form-inline">
							&nbsp;&nbsp;特定源类：  
							<select id="specType" name="specType" class="form-control" style="width:70%;">
								<option value=""></option>
								<option value="Counter">Counter</option>
								<option value="Values">Values</option>
							</select>
						</div>
						
					</div>
				</div>
			</td>
			<td>
				<div class="panel panel-default" style="margin-bottom: 26px;">
					<div class="panel-heading">请求操作</div>
					<div class="panel-body">
						<div class="form-inline">
							<button type="button" class="btn btn-success" onclick="doRequest('get')">
								<span class="glyphicon glyphicon-arrow-up"></span>GET(查)</button>
							<button type="button" class="btn btn-info" onclick="doRequest('post')">
								<span class="glyphicon glyphicon-arrow-down"></span>POST(增)</button>
							<button type="button" class="btn btn-warning" onclick="doRequest('put')">
								<span class="glyphicon glyphicon-resize-vertical"></span>PUT(改)</button>
							<button type="button" class="btn btn-danger" onclick="doRequest('delete')">
								<span class="glyphicon glyphicon-remove"></span>DELETE(删)</button>
							<!-- <button type="button" class="btn btn-default" id="tempBtn">
								<span class="glyphicon glyphicon-th"></span>
								组装URL
							</button> -->
						</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">URL</div>
					<div class="panel-body">
						<div class="form-inline">
							.NET URL：<input class="form-control" readonly type="text" id="netUrl" name="netUrl" style="width:92%;"/> 
						</div>
						<div class="form-inline" style="visibility: hidden;">
							JAVA URL：<input class="form-control" readonly type="text" id="javaUrl" name="javaUrl" style="width:92%;" />
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
	<table class="table">
		<tr>
			<td style="width:27%">
				<div class="panel panel-default">
					<div class="panel-heading">资源表</div>
					<div class="panel-body" id="tree" style="height: 423px; overflow: auto;"></div>
				</div>
			</td>
			<td>
				<div class="panel panel-default">
					<div class="panel-heading">查询参数</div>
					<div class="panel-body">
						<textarea class="form-control" id="queryParam" name="queryParam" style="height:97px;"></textarea>
					</div>
					<div class="panel-heading">定制头部【暂时未用】</div>
					<div class="panel-body">
						<textarea class="form-control" disabled readonly id="requestHead" name="requestHead" style="height:97px;"></textarea>
					</div>
					<div class="panel-heading">输入对象(JSON)</div>
					<div class="panel-body">
						<textarea class="form-control" id="inputJson" name="inputJson" style="height:97px;"></textarea>
					</div>
				</div>
			</td>
			<td style="width:45%">
				<div class="panel panel-default">
					<div class="panel-heading">
						返回结果(JSON)&nbsp;&nbsp;
						<button type="button" class="btn btn-default btn-xs" onclick="clearResult()">
							<span class="glyphicon glyphicon-trash"></span>CLEAR
						</button>
					</div>
					
					<div class="panel-body">
						<textarea class="form-control" id="result" name="result" style="height:390px;"></textarea>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
<!-- js -->
<script type="text/javascript" src="${ctx }/app/public/js/json/json2.min.js"></script>
<script type="text/javascript" src="${ctx }/app/public/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/app/public/js/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx }/app/public/js/bootstrap/js/bootstrap-treeview.js"></script>
<script type="text/javascript" src="${ctx }/app/tooth/apitest/res/js/apiTestReq.js"></script>
<script type="text/javascript" src="${ctx }/app/tooth/apitest/res/js/apiTest.js"></script>
</html>