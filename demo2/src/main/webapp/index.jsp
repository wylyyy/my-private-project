<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session Tracking Demo</title>
    <style>
        body { text-align: center; font-family: Arial; margin-top: 50px; }
        .menu { margin: 30px; }
        .menu a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .menu a:hover { background-color: #45a049; }
    </style>
</head>
<body>
<h1>Session Tracking Demo</h1>
<h3>Choose an example to run:</h3>
<div class="menu">
    <a href="ShowSession">HttpSession Example</a>
    <a href="SendCookie">Send Cookie Example</a>
    <a href="GetCookie">Get Cookie Example</a>
</div>
</body>
</html>