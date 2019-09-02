<%--
  Created by IntelliJ IDEA.
  User: gongsir
  Date: 2019/8/21
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<html>
<head>
    <title>computerAssociation - 登入</title>
</head>
<body>
    <jsp:forward page="/WEB-INF/views/login.jsp" />
</body>
</html>
