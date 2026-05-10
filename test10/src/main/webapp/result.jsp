<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2026/4/21
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="student" class="ncu.wyl.test10.beans.Student" scope="session"> </jsp:useBean>
<html>
<head>
    <title>接受phones值</title>
</head>
<body>
    <%
        // 1、从请求中获取所有名为:phones 的参数值，他会返回一个String[]
        String[] phones = request.getParameterValues("phones");

        // 2、将获取到的数组设置给 JavaBean
        student.setPhones(phones);
    %>

    <%
        out.println("学生姓名：");
    %>
    <jsp:getProperty name="student" property="stuname"/><br>

    <%
        out.println("是否是成员：");
    %>
    <jsp:getProperty name="student" property="member"/><br>
    <!--3.使用JSTL循环遍历phones数组 -->
    <h3>电话列表：</h3>
    <ul>
        <c:forEach items="${student.phones}" var="phone">
            <li>${phone}</li>
        </c:forEach>
    </ul>
</body>
</html>
