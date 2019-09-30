<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/8/21
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统说明</title>
    <style type="text/css">
        .code {
            color: #0000FF;
        }

        a {
            text-decoration: none;
            color: #0000FF;
        }
        a:hover {
            color: #0000FF;
        }

        .layui-row {
            padding-left: 10px;
        }
    </style>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row">
            <div class="layui-text">
                <h3>系统说明</h3>
                西南石油大学计算机协会官网包含(测试阶段，目前部署在个人服务器上，后期正式上线，可申请单独的服务器，修改专属域名)：<br>
                西柚计算机协会移动端（地址：http://39.106.218.57）<br>
                西柚计算机协会PC（地址：http://www.gongsir.club:8080/views）<br>
                后台管理系统（地址：http://www.gongsir.club/computerAssociation）<br>
            </div>
        </div>

        <div class="layui-row">
                <div>
                    <h3>后台管理系统使用手册</h3>
                    <h4>系统开发</h4>
                    <div>
                        1、项目地址
                        <div>
                            <a href="https://gitlab.com/groups/swpu-computerassociation/-/shared" target="_blank">
                                https://gitlab.com/groups/swpu-computerassociation/-/shared
                            </a>
                        </div>
                    </div>
                    <div>
                        2、克隆项目(back)
                        <div class="code">git clone https://gitlab.com/gongsir0630/computerassociation.git</div>
                        3、创建自己的分支
                        <div class="code">git checkout -b our_branch_name (eg:gongSir)</div>
                        4、推送分支到远程
                        <div class="code">git push origin your_branch_name</div>
                    </div>

                    <h4>系统功能</h4>
                    <div>
                        <h5>用户管理</h5>
                    </div>
                    <div>
                        <h5>图片素材管理</h5>
                    </div>
                </div>
        </div>
    </div>
</body>
</html>
