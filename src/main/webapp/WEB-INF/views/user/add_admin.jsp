<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/8/21
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>系统管理员</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
		<script type="text/javascript" src="${path}/static/layui/layui.all.js"></script>
	</head>
	<body>
		<div class="layui-container layui-card">
			<div class="layui-fluid">
				<div class="layui-card-header">
					<h2>添加系统管理员信息</h2>
				</div>
			</div>
			<div class="layui-fluid layui-card-body">
				<form class="layui-form" action="${path}/admin/add" method="post">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">账号</label>
							<div class="layui-input-block">
								<input type="text" name="count" id="count" placeholder="请输入账号" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">密码</label>
							<div class="layui-input-block">
								<input type="text" name="password" id="password" placeholder="请输入密码" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">口令</label>
							<div class="layui-input-block">
								<input type="text" name="order" id="order" placeholder="请输入口令" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item layui-col-md-offset1">
						<div class="layui-input-inline">
							<input type="submit" id="btn_addAdmin" class="layui-btn layui-btn-fluid" value="提交">
						</div>
					</div>
					<div class="layui-form-item layui-col-md-offset1">
						<div class="layui-input-inline">
							<button type="button" id="btn_goBack" class="layui-btn layui-btn-fluid" onclick="goBack()">返回</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	<script type="text/javascript">
		// 返回上一页
		function goBack(){
			window.history.go(-1);
		}
	</script>
	</body>
</html>
