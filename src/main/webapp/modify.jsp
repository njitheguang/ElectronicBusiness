<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息修改</title>
</head>
<body>
	<form method="post" action="<%=basePath %>user/modify.do/${message.id}">
				ID：<input type="text" name="id" value="${message.id}"><br> 
			用户名：<input type="text" name="username" value="${message.username}"><br> 
			旧密码：<input type="text" name="passwordOld" value="${message.password}"><br> 
			新密码：<input type="text" name="passwordNew"><br> 
			<input type="submit" value="修改" />
	</form>
	<br>
</body>
</html>