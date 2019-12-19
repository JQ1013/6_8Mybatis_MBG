<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head lang="zh_CN">
        <title>Title</title>
    </head>
    <%
        String contextPath = request.getContextPath();
        application.setAttribute("pp",contextPath);
    %>
    <body>
        <h1>展示所有员工</h1>
        <a href="${pp}/getAll">点击显示所有员工信息</a>
    </body>
</html>





