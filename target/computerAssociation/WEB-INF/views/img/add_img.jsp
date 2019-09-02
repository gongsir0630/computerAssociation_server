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
		<title>上传图片</title>
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
					<h2>添加图片素材</h2>
				</div>
			</div>
			<div class="layui-fluid layui-card-body">
				<form class="layui-form" action="" method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片ID</label>
							<div class="layui-input-block">
								<input type="text" name="imgId" id="imgId" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片分类</label>
							<div class="layui-input-block">
								<select id="imgClass">
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
								<input type="text" name="imgTitle" id="imgTitle" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片描述</label>
							<div class="layui-input-block">
								<input type="text" name="imgDesc" id="imgDesc" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">选择图片</label>
							<div class="layui-input-block">
								<button type="button" class="layui-btn" id="test1">
									<i class="layui-icon">&#xe67c;</i>上传图片
								</button>
							</div>
						</div>
					</div>
					<div class="layui-form-item layui-col-md-offset1">
						<div class="layui-input-inline">
							<input type="button" id="btn_addImg" class="layui-btn layui-btn-fluid" value="提交">
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
		layui.use(['upload','form'], function(){
			var upload = layui.upload;
			var $ = layui.$;

			//执行实例
			var uploadInst = upload.render({
				elem: '#test1' //绑定元素
				,url: '${path}/admin/img/add' //上传接口
				,accept: 'images'
				,auto: false
				,bindAction: '#btn_addImg'
				,data: {
				    imgId: function () {
						return $('#imgId').val();
					},
					imgClass: function () {
						return $('#imgClass option:selected').val();
					},
					imgName: function () {
						return $('#imgName').val();
					},
					imgTitle: function () {
						return $('#imgTitle').val();
					},
					imgDesc: function () {
						return $('#imgDesc').val();
					}
				}
				,done: function(res){
					//上传完毕回调
					if (res.code === 200 && res.data.status === true){
							$('#imgId').val("");
							$('#imgName').val("");
							$('#imgTitle').val("");
							$('#imgDesc').val("");
							layer.msg(res.data.msg,{icon:1, time:1500});
					}
					if (res.code === 1024 || res.data.status === false){
						layer.msg(res.data.msg,{icon:2, time:1500});
					}
				}
				,error: function(){
					//请求异常回调
				}
			});
		});
		// 返回上一页
		function goBack(){
			window.history.go(-1);
		}
	</script>
	</body>
</html>
