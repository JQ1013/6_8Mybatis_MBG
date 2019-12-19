<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh_CN">
    <head>
        <title>Title</title>
    </head>
    <body>

        <table border="1" cellspacing="0" cellpadding="5">
            <tr align="center">
                <th>id</th>
                <th>teacherName</th>
                <th>className</th>
                <th>address</th>
                <th>birthday</th>
            </tr>

            <%--el表达式本质是调用getter方法,info这个对象中有getList()方法--%>
            <c:forEach items="${info.list}" var="t">
                <tr align="center">
                    <td>${t.id}</td>
                    <td>${t.teacherName}</td>
                    <td>${t.className}</td>
                    <td>宝安区</td>
                    <td><%=new Date()%>
                    </td>

                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <a href="${pp}/getAll?pn=1">首页</a>
                    <a href="${pp}/getAll?pn=${info.prePage}">上一页</a>

                    <%--连续分页显示--%>
                    <c:forEach items="${info.navigatepageNums}" var="num">
                        <c:if test="${num==info.pageNum}">
                            [${num}]
                        </c:if>

                        <c:if test="${num!=info.pageNum}">
                            <a href="${pp}/getAll?pn=${num}">${num}</a>
                        </c:if>
                    </c:forEach>
                    <a href="${pp}/getAll?pn=${info.nextPage}">下一页</a>
                    <a href="${pp}/getAll?pn=${info.pages}">末页</a>
                </td>
            </tr>

        </table>
    </body>
</html>
