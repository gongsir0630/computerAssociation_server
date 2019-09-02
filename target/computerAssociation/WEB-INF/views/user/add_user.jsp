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
		<title>协会会员</title>
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
					<h2>添加会员信息</h2>
				</div>
			</div>
			<div class="layui-fluid layui-card-body">
				<form class="layui-form" action="${path}/admin/user/add" method="post">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">学号</label>
							<div class="layui-input-block">
								<input type="text" name="stunum" id="stunum" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">姓名</label>
							<div class="layui-input-block">
								<input type="text" name="name" id="name" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">学院</label>
							<div class="layui-input-block">
								<input type="text" name="college" id="college" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">专业</label>
							<div class="layui-input-block">
								<input type="text" name="major" id="major" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">年级</label>
							<div class="layui-input-block">
								<input type="text" name="grade" id="grade" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">政治面貌</label>
							<div class="layui-input-block">
								<input type="text" name="political" id="political" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">QQ</label>
							<div class="layui-input-block">
								<input type="text" name="qq" id="qq" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">电话</label>
							<div class="layui-input-block">
								<input type="text" name="phone" id="phone" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">宿舍</label>
							<div class="layui-input-block">
								<input type="text" name="dormitory" id="dormitory" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">会员证编号</label>
							<div class="layui-input-block">
								<input type="text" name="memid" id="memid" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">职务</label>
							<div class="layui-input-block">
								<select name="post" id="post">
									<option value="会员">会员</option>
									<option value="理事">理事</option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">活动等级</label>
							<div class="layui-input-block">
								<select name="activityLevel" id="activityLevel">
									<option value="校级">校级</option>
									<option value="院级">院级</option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">考核等级</label>
							<div class="layui-input-block">
								<select name="assessmentGrade" id="assessmentGrade">
									<option value="优秀">优秀</option>
									<option value="良好">良好</option>
									<option value="合格">合格</option>
									<option value="不合格">不合格</option>
								</select>
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
		<%
			String msg = (String) request.getSession().getAttribute("msg");
			if (msg!=null){%>
		<script>
			layui.use('layer',function () {
				layer.msg('<%=msg%>',{icon:2,time:1500});
			})
		</script>
		<%}
			request.getSession().removeAttribute("msg");
		%>
		<script type="text/javascript">
			layui.use(['form','layer'],function () {

			});
			// 返回上一页
			function goBack(){
				window.history.go(-1);
			}
		</script>
	</body>
</html>
