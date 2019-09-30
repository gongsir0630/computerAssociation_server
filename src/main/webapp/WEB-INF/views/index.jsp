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
		<script type="text/javascript" src="${path}/static/layui/layui.js"></script>
	</head>
	<body class="layui-layout-body">

		<div id="LAY_app">
			<div class="layui-layout layui-layout-admin">
				<!-- 头部区域 -->
				<div class="layui-header">
					<ul class="layui-nav layui-layout-left">
						<li class="layui-nav-item layadmin-flexible" lay-unselect>
							<a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
								<i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
							</a>
						</li>
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="http://gongsir.club:8080/views" target="_blank" title="前台">
								<i class="layui-icon layui-icon-website"></i>
							</a>
						</li>
						<li class="layui-nav-item" lay-unselect>
							<a href="javascript:;" layadmin-event="refresh" title="刷新">
								<i class="layui-icon layui-icon-refresh-3"></i>
							</a>
						</li>
						<!-- 修改搜索请求地址 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach"
							 lay-action="template/tips/search.html?keywords=">
						</li>
					</ul>
					<ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

						<li class="layui-nav-item" lay-unselect>
							<!-- 修改消息通知显示 -->
							<a lay-href="" layadmin-event="message" lay-text="消息中心">
								<i class="layui-icon layui-icon-notice"></i>

								<!-- 需要后端数据进行判断，如果有新消息，则显示小圆点 -->
								<span class="layui-badge-dot"></span>
							</a>
						</li>
						<!-- 主题设置 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="theme">
								<i class="layui-icon layui-icon-theme"></i>
							</a>
						</li>
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="note">
								<i class="layui-icon layui-icon-note"></i>
							</a>
						</li>
						<!-- 切换全屏 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="fullscreen">
								<i class="layui-icon layui-icon-screen-full"></i>
							</a>
						</li>
						<!-- 用户信息展示 -->
						<li class="layui-nav-item" lay-unselect>
							<a href="javascript:;">
								<!-- 用户名 -->
								<cite>${admin.count}</cite>
							</a>
							<dl class="layui-nav-child">
								<dd><a lay-href="set/user/info.html">基本资料</a></dd>
								<dd><a lay-href="set/user/password.html">修改密码</a></dd>
								<hr>
								<!-- 退出登陆 -->
								<dd style="text-align: center;"><a href="${path}/admin/logout">退出</a></dd>
							</dl>
						</li>

						<!-- 关于 -->
						<li class="layui-nav-item layui-hide-xs" lay-unselect>
							<a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
						</li>
						<!-- 更多 -->
						<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
							<a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
						</li>
					</ul>
				</div>

				<!-- 侧边菜单 -->
				<div class="layui-side layui-side-menu">
					<div class="layui-side-scroll">
						<!-- logo显示 -->
						<div class="layui-logo">
							<span>
								<img src="http://39.106.218.57/img/ico_001.png" alt="西柚计算机协会">
								computerAssociation
							</span>
						</div>
						<!-- 菜单列表 -->
						<ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
							<!-- 关于系统 -->
							<li data-name="home" class="layui-nav-item">
								<a href="javascript:;" lay-tips="关于系统" lay-direction="2">
									<i class="layui-icon layui-icon-home"></i>
									<cite>关于系统</cite>
								</a>
								<dl class="layui-nav-child">
									<!-- 设置layui-this,表示默认的选中项 -->
									<dd>
										<a lay-href="${path}/admin/home/console">系统说明</a>
									</dd>
									<dd>
										<a href="${path}/admin/logout">退出系统</a>
									</dd>
								</dl>
							</li>
							<!-- 用户管理 -->
							<li data-name="user" class="layui-nav-item layui-nav-itemed">
								<a href="javascript:;" lay-tips="用户" lay-direction="2">
									<i class="layui-icon layui-icon-user"></i>
									<cite>用户</cite>
								</a>
								<dl class="layui-nav-child">
									<dd class="layui-this">
										<a lay-href="${path}/admin/user/member">协会会员</a>
									</dd>
									<dd>
										<a lay-href="${path}/admin/user/admin">后台管理员</a>
									</dd>
								</dl>
							</li>
							<!-- 图片管理 -->
							<li data-name="img" class="layui-nav-item">
								<a href="javascript:;" lay-tips="图片" lay-direction="2">
									<i class="layui-icon layui-icon-layim-theme"></i>
									<cite>图片素材</cite>
								</a>
								<dl class="layui-nav-child">
									<dd>
										<a lay-href="${path}/admin/img/img">图片管理</a>
									</dd>
									<!--<dd>-->
										<!--<a lay-href="2">2</a>-->
									<!--</dd>-->
								</dl>
							</li>
							<!-- content管理 -->
							<li data-name="content" class="layui-nav-item">
								<a href="javascript:;" lay-tips="content" lay-direction="2">
									<i class="layui-icon layui-icon-layim-theme"></i>
									<cite>content</cite>
								</a>
								<dl class="layui-nav-child">
									<dd>
										<a lay-href="${path}/admin/content/content">content管理</a>
									</dd>
									<!--<dd>-->
										<!--<a lay-href="2">content-2</a>-->
									<!--</dd>-->
								</dl>
							</li>
							<!-- news管理 -->
							<li data-name="news" class="layui-nav-item">
								<a href="javascript:;" lay-tips="新闻" lay-direction="2">
									<i class="layui-icon layui-icon-layim-theme"></i>
									<cite>新闻动态</cite>
								</a>
								<dl class="layui-nav-child">
									<dd>
										<a lay-href="1">news-1</a>
									</dd>
									<dd>
										<a lay-href="2">news-2</a>
									</dd>
								</dl>
							</li>
							<!-- 义诊预约 -->
							<li data-name="book" class="layui-nav-item">
								<a href="javascript:;" lay-tips="义诊" lay-direction="2">
									<i class="layui-icon layui-icon-layim-theme"></i>
									<cite>义诊预约</cite>
								</a>
								<dl class="layui-nav-child">
									<dd>
										<a lay-href="${path}/admin/book/book">预约信息</a>
									</dd>
<%--									<dd>--%>
<%--										<a lay-href="2">book-2</a>--%>
<%--									</dd>--%>
								</dl>
							</li>
							<li data-name="set" class="layui-nav-item">
								<a href="javascript:;" lay-tips="设置" lay-direction="2">
									<i class="layui-icon layui-icon-set"></i>
									<cite>设置</cite>
								</a>
								<dl class="layui-nav-child">
									<dd class="layui-nav-itemed">
										<a href="javascript:;">系统设置</a>
										<dl class="layui-nav-child">
											<dd><a lay-href="set/system/website.html">网站设置</a></dd>
											<dd><a lay-href="set/system/email.html">邮件服务</a></dd>
										</dl>
									</dd>
									<dd class="layui-nav-itemed">
										<a href="javascript:;">我的设置</a>
										<dl class="layui-nav-child">
											<dd><a lay-href="set/user/info.html">基本资料</a></dd>
											<dd><a lay-href="set/user/password.html">修改密码</a></dd>
										</dl>
									</dd>
								</dl>
							</li>
							<li data-name="link" class="layui-nav-item">
								<a href="javascript:;" lay-tips="友情链接" lay-direction="2">
									<i class="layui-icon layui-icon-auz"></i>
									<cite>友情链接</cite>
								</a>
								<dl class="layui-nav-child">
									<dd>
										<a href="https://www.swpu.edu.cn" target="_blank">西南石油大学</a>
									</dd>
									<dd>
										<a href="http://gongsir.club:8080/views" target="_blank">西柚计算机协会前台</a>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>

				<!-- 页面标签 -->
				<div class="layadmin-pagetabs" id="LAY_app_tabs">
					<!-- 标签往左翻页 -->
					<div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
					<!-- 标签往右翻页 -->
					<div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
					<!-- 标签关闭 -->
					<div class="layui-icon layadmin-tabs-control layui-icon-down">
						<ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
							<li class="layui-nav-item" lay-unselect>
								<a href="javascript:;"></a>
								<dl class="layui-nav-child layui-anim-fadein">
									<dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
									<dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
									<dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
								</dl>
							</li>
						</ul>
					</div>
					<!-- 默认展示主页标签 -->
					<div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
						<ul class="layui-tab-title" id="LAY_app_tabsheader">
							<li lay-id="user/member" lay-attr="user/member.jsp" class="layui-this" title="主页"><i class="layui-icon layui-icon-home"></i></li>
						</ul>
					</div>
				</div>


				<!-- 主体内容 -->
				<div class="layui-body" id="LAY_app_body">
					<div class="layadmin-tabsbody-item layui-show">
						<iframe src="${path}/admin/user/member" frameborder="0" class="layadmin-iframe"></iframe>
					</div>
				</div>

				<!-- 辅助元素，一般用于移动设备下遮罩 -->
				<div class="layadmin-body-shade" layadmin-event="shade"></div>
			</div>
		</div>
		<script>
			layui.config({
				base: '${path}/static/' //静态资源所在路径
			}).extend({
				index: 'lib/index' //主入口模块
			}).use('index');
		</script>

	</body>
</html>
