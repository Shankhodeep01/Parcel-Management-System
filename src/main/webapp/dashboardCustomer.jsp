<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Dashboard</h1>
    <p>Hello, <%= ((userModel.User) session.getAttribute("user")).getUserName() %>!</p>
    <a href="logout">Logout</a>
</body>
</html>