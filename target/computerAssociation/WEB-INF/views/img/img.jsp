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
		<title>图片素材管理</title>
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
				<form class="layui-form layui-card-header layuiadmin-card-header-auto">
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">图片ID</label>
							<div class="layui-input-block">
								<input type="text" name="count" id="count" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<button class="layui-btn layuiadmin-btn-useradmin" id="admin_search">
								<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
							</button>
						</div>
					</div>
				</form>

				<div class="layui-card-body">
					<%--头部工具条--%>
					<script type="text/html" id="toolbarDemo">
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="batchdel">删除</button>
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="add">添加</button>
						<button class="layui-btn layuiadmin-btn-useradmin" lay-event="flush" id="user_flush">刷新</button>
					</script>

					<table id="LAY-user-manage" lay-filter="LAY-user-manage" class="layui-hide" style="line-height: 50px"></table>
						<%--行内工具条--%>
					<script type="text/html" id="table-useradmin-webuser">
						<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
						<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
						<%--<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-search"></i>查看</a>--%>
					</script>

					<script type="text/html" id="showImg">
						<a href="{{d.imgLink}}" class="layui-table-link" target="_blank">
							<img src="{{d.imgLink}}" title="{{d.imgTitle}}" />
						</a>
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
					url: '${path}/admin/img/all',
					method: "GET",
					toolbar:'#toolbarDemo',
					title: '图片素材',
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
							align: "center",
							hide: true
						}, {
							field: "imgId",
							title: "图片ID",
							width: 100,
							align: "center"
						}, {
							field: "imgClass",
							title: "图片分类",
							width: 100,
							align: "center"
						},  {
							field: "imgName",
							title: "图片名称",
							minwidth: 100,
							align: "center"
						},  {
							field: "imgTitle",
							title: "图片标题",
							minwidth: 100,
							align: "center"
						},  {
							field: "imgDesc",
							title: "图片描述",
							minwidth: 100,
							align: "center"
						},  {
							field: "imgLink",
							title: "图片展示",
							minwidth: 100,
							align: "center",
							templet: "#showImg"
						},  {
							field: "imgShow",
							title: "图片状态",
							width: 100,
							align: "center"
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
											$.post("${path}/admin/img/del",{
												id:data[i].id,
												name: data[i].imgName
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
							location.href='${path}/admin/img/add_img';
							break;
						case 'flush':
							table.reload('LAY-user-manage',{
								url: '${path}/admin/img/all',
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
						layer.msg(jsonStr);
					} else if(layEvent === 'del'){ //删除
						layer.confirm('你确定要删除imgId为'+data.imgId+'的图片吗？', function(){
							$.post("${path}/admin/img/del",{
								id:data.id,
								name: data.imgName
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
						location.href='${path}/admin/img/edit?imgId='+data.imgId;
					}
				});
			});
		</script>
	</body>
</html>
