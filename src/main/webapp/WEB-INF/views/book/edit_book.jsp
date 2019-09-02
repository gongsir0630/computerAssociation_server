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
		<title>义诊预约</title>
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
					<h2>处理预约信息</h2>
				</div>
			</div>
			<div class="layui-fluid layui-card-body">
				<form class="layui-form" action="${path}/admin/book/edit" method="post">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">ID</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.id}" name="id" id="id" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">姓名</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.name}" name="name" id="name" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">电话</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.userId}" name="userId" id="userId" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">年级</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.grade}" name="grade" id="grade" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">专业</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.major}" name="major" id="major" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">性别</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.sex}" name="sex" id="sex" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">电脑品牌</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.brand}" name="brand" id="brand" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">电脑型号</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.model}" name="model" id="model" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">义诊需求</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.demand}" name="demand" id="demand" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">故障描述</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.description}" name="description" id="description" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">申请时间</label>
							<div class="layui-input-block">
								<input type="text" readonly value="${book.signupTime}" name="signupTime" id="signupTime" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">处理时间</label>
							<div class="layui-input-block">
								<input type="text" name="processTime" id="processTime" placeholder="请输入" required autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">处理结果</label>
							<div class="layui-input-block">
								<textarea name="processResult" id="processResult" placeholder="请输入处理结果内容" class="layui-textarea"></textarea>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">处理状态</label>
							<div class="layui-input-block">
								<select name="statusText" id="statusText">
									<option value="0">==请选择==</option>
									<option value="处理中">处理中</option>
									<option value="已处理">已处理</option>
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
				layer.msg('<%=msg%>',{icon:2});
			})
		</script>
		<%}
			request.getSession().removeAttribute("msg");
		%>
		<script type="text/javascript">
			layui.use(['form','layer','laydate'],function () {
				var laydate = layui.laydate;
				//执行一个laydate实例
				laydate.render({
					elem: '#processTime' //指定处理时间元素
					,type: 'datetime'
				});
			});
			// 返回上一页
			function goBack(){
				window.history.go(-1);
			}
		</script>
	</body>
</html>
