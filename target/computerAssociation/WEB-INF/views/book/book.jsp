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
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>电脑义诊</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${path}/static/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="${path}/static/css/admin.css" media="all">
		<script type="text/javascript" src="${path}/static/layui/layui.js"></script>
	</head>
	<body>

		<div class="layui-fluid">
			<div class="layui-card">
				<div class="layui-form layui-card-header layuiadmin-card-header-auto">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">手机号</label>
							<div class="layui-input-block">
								<input type="text" name="userId" id="userId" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">姓名</label>
							<div class="layui-input-block">
								<input type="text" name="name" id="name" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">处理状态</label>
							<div class="layui-input-block">
								<select name="statusText" id="statusText">
									<option value="未处理">未处理</option>
									<option value="处理中">处理中</option>
									<option value="已处理">已处理</option>
								</select>
							</div>
						</div>
						<div class="layui-inline">
							<button class="layui-btn layuiadmin-btn-useradmin" id="book_search">
								<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="layui-card-body">
					<%--头部工具条--%>
					<script type="text/html" id="toolbarDemo">
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="batchdel">删除</button>
						<!--<button class="layui-btn layuiadmin-btn-useradmin" lay-event="add">添加</button>-->
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="flush" id="user_flush">刷新</button>
					</script>

					<table id="LAY-user-manage" lay-filter="LAY-user-manage" class="layui-hide"></table>
						<%--行内工具条--%>
					<script type="text/html" id="table-useradmin-webuser">
                        {{#  if(d.statusText === "已处理"){ }}
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
                        {{#  } else { }}
                        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>处理</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
                        <%--<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-search"></i>查看</a>--%>
                        {{#  } }}

					</script>
				</div>
			</div>
		</div>
		<script>
			layui.use(['table','layer','form'], function() {
				var table = layui.table;
				var layer = layui.layer;
				var $ = layui.$;

				// 渲染表格
				table.render({
					elem: "#LAY-user-manage",
					url: '${path}/admin/book/all',
					method: "GET",
					toolbar:'#toolbarDemo',
					title: '义诊预约信息表',
					response: {
						statusName: 'code' //规定数据状态的字段名称，默认：code
							,
						statusCode: 200 //规定成功的状态码，默认：0
							,
						msgName: 'msg' //规定状态信息的字段名称，默认：msg
							,
						countName: 'count' //规定数据总数的字段名称，默认：count
							,
						dataName: 'data' //规定数据列表的字段名称，默认：data
					},
					parseData: function(res) { //res 即为原始返回的数据
						return {
							"code": res.code, //解析接口状态
							"msg": res.msg, //解析提示文本
							"count": res.count, //解析数据长度
							"data": res.data.data //解析数据列表
						};
					},
					cols: [
						[{
							type: "checkbox",
							fixed: "left"
						}, {
							field: "id",
							width: 100,
							title: "ID",
							sort: !0,
							hide: true,
							align: "center"
						}, {
							field: "userId",
							width: 200,
							title: "电话",
							sort: !0,
							align: "center"
						}, {
							field: "name",
							title: "姓名",
							width: 200,
							align: "center"
						}, {
							field: "grade",
							title: "年级",
                            width: 200,
							align: "center"
						}, {
							field: "major",
							title: "专业",
                            width: 200,
							align: "center"
						}, {
							field: "sex",
							title: "性别",
                            width: 200,
							align: "center"
						}, {
							field: "qq",
							title: "QQ",
                            width: 200,
							align: "center"
						}, {
							field: "brand",
							title: "电脑品牌",
                            width: 200,
							align: "center"
						}, {
							field: "model",
							title: "电脑型号",
                            width: 200,
							align: "center"
						}, {
							field: "demand",
							title: "义诊需求",
                            width: 200,
							align: "center"
						}, {
							field: "description",
							title: "故障描述",
                            width: 200,
							align: "center"
						}, {
							field: "signupTime",
							width: 200,
							title: "申请时间",
							align: "center"
						}, {
							field: "processTime",
							title: "处理时间",
                            width: 200,
							hide: true,
							align: "center"
						}, {
							field: "processResult",
							title: "处理结果",
                            width: 200,
							align: "center"
						}, {
							field: "statusText",
							title: "处理状态",
                            width: 200,
							align: "center"
						}, {
							field: "statusColor",
							title: "处理状态颜色",
							align: "center",
                            width: 200,
							hide: true
						}, {
							title: "操作",
							width: 200,
							align: "center",
							fixed: "right",
							toolbar: "#table-useradmin-webuser"
						}]
					],
					page: true,
					height: "full-220",
					text: "对不起，加载出现异常"
				});

				//监听头工具栏事件
				table.on('toolbar(LAY-user-manage)',function (obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					var data = eval("("+JSON.stringify(checkStatus.data)+")");
					switch (obj.event) {
						case 'batchdel':
							if (data.length === 0) {
								layer.msg('请至少选择一行数据', {icon:2, time:1500});
							}else {
								layer.alert('你确认要删除'+data.length+'条数据吗？', {
									skin: 'layui-layer-molv'
									,closeBtn: 1
									,anim: 1
									,btn: ['确定','取消']
									,icon: 2
									,yes: function () {
										for (var i = 0; i < data.length; i++) {
											console.debug("id:==="+data[i].id);
											//发送请求到后台
											$.post("${path}/admin/book/del",{
												id:data[i].id
											},function (res) {
												if (res.data.status === true) {
													layer.msg(res.data.msg, { icon: 1, time: 1500 });
													//刷新表格数据
													$('#user_flush').click();
												}else if (res.data.status === false){
													layer.msg(res.data.msg, { icon: 2, time: 1500 });
													//刷新表格数据
													$('#user_flush').click();
												}
											});
										}
									}
									,btn2: function () {
										layer.msg('好的,暂时不给你删除。',{ icon: 1, time: 1500 });
									}
								});
							}
							break;
						case 'add':
							// location.href='${path}/admin/user/add_user';
							break;
						case 'flush':
							table.reload('LAY-user-manage',{
								url: '${path}/admin/book/all',
								method: 'GET'
							});
							break;
					}
				});

				//监听行内工具条
				table.on('tool(LAY-user-manage)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					var tr = obj.tr; //获得当前行 tr 的DOM对象

					if(layEvent === 'detail'){ //查看
						var jsonStr = JSON.stringify(data);
						layer.alert(jsonStr);
					} else if(layEvent === 'del'){ //删除
						layer.confirm('你确定要删除ID为'+data.id+'的数据段吗？', function(){
							$.post("${path}/admin/book/del",{
								id:data.id
							},function (res) {
								if (res.data.status === true) {
									layer.msg(res.data.msg, { icon: 1, time: 1500 });
									//刷新表格数据
									$('#user_flush').click();
								}else if (res.data.status === false){
									layer.msg(res.data.msg, { icon: 2, time: 1500 });
									//刷新表格数据
									$('#user_flush').click();
								}
							});
						});
					} else if(layEvent === 'edit'){ //编辑
						location.href = "${path}/admin/book/edit?id="+data.id;
					}
				});
			});
		</script>
		<%
			String msg = (String) request.getSession().getAttribute("msg");
			if (msg!=null){%>
		<script>
			layui.use('layer',function () {
				layer.msg('<%=msg%>',{icon:1,time:1500});
			})
		</script>
		<%}
			request.getSession().removeAttribute("msg");
		%>
	</body>
</html>
