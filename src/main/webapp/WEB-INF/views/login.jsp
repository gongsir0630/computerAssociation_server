<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/8/21
  Time: 13:51
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
		<title>登入 - computerAssociation</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
		<link rel="stylesheet" href="${path}/static/css/login.css" media="all">
		<script type="text/javascript" src="${path}/static/layui/layui.all.js"></script>
	</head>
	<body>

		<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
			<!-- 登录表单 -->
			<div class="layadmin-user-login-main">
				<!-- 顶部文字展示 -->
				<div class="layadmin-user-login-box layadmin-user-login-header">
					<h2>computerAssociation</h2>
					<p>西南石油大学计算机协会后台管理系统</p>
					<!-- 交互信息提示 -->
					<p style="color: red">${msg}</p>
				</div>
				<form class="layadmin-user-login-box layadmin-user-login-body layui-form" action="${path}/admin/login" method="post">
					<!-- 用户名 -->
					<div class="layui-form-item">
						<label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
						<input type="text" name="count" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
					</div>
					<!-- 密码 -->
					<div class="layui-form-item">
						<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
						<input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
					</div>
					<!-- 图形验证码 -->
					<div class="layui-form-item">
						<div class="layui-row">
							<!-- 验证码输入框 -->
							<div class="layui-col-xs7">
								<label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
								<input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
							</div>
							<!-- 伪验证码生成 -->
							<div class="layui-col-xs5">
								<div style="margin-left: 10px;">
									<img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
								</div>
							</div>
						</div>
					</div>
					<!-- 登录按钮 -->
					<div class="layui-form-item">
						<input type="submit" class="layui-btn layui-btn-fluid" value="登入">
					</div>
				</form>
			</div>

			<!-- 登录页脚显示 -->
			<div class="layui-trans layadmin-user-login-footer">

				<p>© 2019 <a href="http://www.gongsir.club/computerAssociation" target="_blank">gongsir.club&nbsp;四川成都</a></p>
				<p>
					<span><a href="https://github.com/gongsir0630" target="_blank">Github</a></span>
					<span><a href="http://www.gongsir.club:8080/views" target="_blank">计算机协会前台</a></span>
					<span><a href="https://www.swpu.edu.cn/" target="_blank">西柚官网</a></span>
				</p>
			</div>

		</div>
	</body>
</html>
