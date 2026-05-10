<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2026/3/29
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="ncu.wyl.test10.beans.Student" scope="session">
    <jsp:setProperty property="stuname" name="student" value="张华"/>
    <jsp:setProperty name="student" property="member" value="true"/>
</jsp:useBean>
<html>
<head>
    <title>测试JSP中使用javaBean</title>
</head>
<body>
    <%
        out.println("学生姓名：");
    %>
    <jsp:getProperty name="student" property="stuname"/><br>

    <%
        out.println("是否是成员：");
    %>
    <jsp:getProperty name="student" property="member"/><br>


    <!-- 让多个输入框使用相同的 name 属性-->
    <form action="result.jsp" method="post">
        <label>电话1：<input type="text" name="phones"></label><br>
        <label>电话2：<input type="text" name="phones"></label><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>