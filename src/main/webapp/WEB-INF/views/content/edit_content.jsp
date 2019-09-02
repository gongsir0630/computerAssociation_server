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
		<title>编辑模块</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
		<script type="text/javascript" src="${path}/static/layui/layui.js"></script>
	</head>
	<body>
		<div class="layui-container layui-card">
			<div class="layui-fluid">
				<div class="layui-card-header">
					<h2>编辑模块信息</h2>
				</div>
			</div>
			<div class="layui-fluid layui-card-body">
				<form class="layui-form"  method="post" action="${path}/admin/content/edit">
					<input type="hidden" name="id" value="${con.id}">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片ID</label>
							<div class="layui-input-block">
								<input type="text" value="${con.imgId}" name="imgId" id="imgId" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">模块分类</label>
							<div class="layui-input-block">
								<select id="conClass" name="conClass">
									<option value="index-activity">index活动介绍</option>
									<option value="index-server">index服务介绍</option>
									<option value="activity">activity活动</option>
									<option value="book">book预约</option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">label内容</label>
							<div class="layui-input-block">
								<input type="text" value="${con.conLabe}" name="conLabe" id="conLabe" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">p标签内容</label>
							<div class="layui-input-block">
								<textarea cols="25" rows="50" name="conP" id="conP" placeholder="请输入" required autocomplete="off" class="layui-input">${con.conP}</textarea>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">详情链接</label>
							<div class="layui-input-block">
								<input type="text" value="${con.detailAddr}" name="detailAddr" id="detailAddr" placeholder="请输入" required autocomplete="off" class="layui-input">
								<div style="color: #0000FF">请填写公网地址</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item layui-col-md-offset1">
						<div class="layui-input-inline">
							<input type="submit" id="btn_editImg" class="layui-btn layui-btn-fluid" value="提交">
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
		layui.use('form',function () {
			var $ = layui.$;
			$('#conClass').find('option[value="${con.conClass}"]').attr("selected",true);
		});
		// 返回上一页
		function goBack(){
			window.history.go(-1);
		}
	</script>
	</body>
</html>
