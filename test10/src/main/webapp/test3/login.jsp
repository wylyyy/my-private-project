<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2026/4/21
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <style>
        /* 简单的样式，让页面好看一点 */
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; }
        .login-container { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); width: 300px; }
        h2 { text-align: center; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="password"] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .btn:hover { background-color: #218838; }
        .error-msg { color: red; font-size: 0.9em; text-align: center; }
    </style>
</head>
<body>

<div class="login-container">
    <h2>系统登录</h2>

    <!--
      核心部分：表单
      action: 对应你在 web.xml 或 @WebServlet 中配置的 Servlet 路径 (例如 LoginServlet)
      method: 必须使用 POST，因为涉及到密码传输，且符合题目要求
    -->
    <form action="LoginServlet" method="post">

        <div class="form-group">
            <label for="account">账号：</label>
            <input type="text" id="account" name="account" placeholder="请输入账号" required>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" placeholder="请输入密码" required>
        </div>

        <button type="submit" class="btn">登录</button>
    </form>
</div>

</body>
</html>
