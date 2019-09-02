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
		<title>编辑图片</title>
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
					<h2>编辑图片素材</h2>
				</div>
			</div>
			<div class="layui-fluid layui-card-body">
				<form class="layui-form"  method="post" action="${path}/admin/img/edit">
					<input type="hidden" name="id" value="${img.id}">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片ID</label>
							<div class="layui-input-block">
								<input type="text" value="${img.imgId}" name="imgId" id="imgId" placeholder="请输入" required autocomplete="off" class="layui-input" disabled>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片名称</label>
							<div class="layui-input-block">
								<input type="text" value="${img.imgName}" name="imgName" id="imgName" placeholder="请输入" required autocomplete="off" class="layui-input" disabled>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片分类</label>
							<div class="layui-input-block">
								<select id="imgClass" name="imgClass">
									<option value="logo">logo部分</option>
									<option value="index">index首页</option>
									<option value="activity">activity活动</option>
									<option value="news">news动态</option>
									<option value="book">book预约</option>
									<option value="about">about关于</option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片标题</label>
							<div class="layui-input-block">
								<input type="text" value="${img.imgTitle}" name="imgTitle" id="imgTitle" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片描述</label>
							<div class="layui-input-block">
								<input type="text" value="${img.imgDesc}" name="imgDesc" id="imgDesc" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">显示状态</label>
							<div class="layui-input-block">
								<select id="imgShow" name="imgShow">
									<option value="1">显示</option>
									<option value="2">不显示</option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片地址</label>
							<div class="layui-input-block">
								<input type="text" value="${img.imgLink}" name="imgLink" id="imgLink" placeholder="请输入" required autocomplete="off" class="layui-input">
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
			$('#imgClass').find('option[value="${img.imgClass}"]').attr("selected",true);
			$('#imgShow').find('option[value="${img.imgShow}"]').attr("selected",true);
		});
		// 返回上一页
		function goBack(){
			window.history.go(-1);
		}
	</script>
	</body>
</html>
