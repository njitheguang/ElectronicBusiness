<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>
	<form method="post" action="user/register.do">
		用户名：<input type="text" name="username"><br> 
		密码：<input type="password" name="password"><br> 
		确认密码：<input type="password" name="password2"><br> 
		<input type="submit" value="提交" />
	</form>
	<br>
</body>
</html>