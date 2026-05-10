<%@ page import="ncu.wyl.test10.exer.Customer" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2026/4/21
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
    <%
        // 从 session 中获取 JavaBean
        Customer customer = (Customer) session.getAttribute("currentCustomer");

        if(customer == null){
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <h1>登录成功！</h1>
    <p1>欢迎回来,<%= customer.getCname()%></p1>
</body>
</html>
