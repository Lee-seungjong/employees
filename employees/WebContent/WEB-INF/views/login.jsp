<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login form</title>
</head>
<body>
	<h2>login</h2>
		<!-- 로그인 폼 -->
		<div>
			<form action = "${pathContext.request.contextPath}/login" method = "POST">
				<div>
					First_name :
					<input type = "text" name = "firstName" value = "Hong">
				</div>
				<div>
					Last_name : 
					<input type = "password" name = "lastName" value = "Gildong">
				</div>
				<div>
					emp_no
					<input type = "text" name = "empNo" value = "1">
				</div>
				<button type = "submit">login</button>
			</form>
		</div>
</body>
</html>