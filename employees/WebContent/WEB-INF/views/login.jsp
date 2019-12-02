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
			<form action = "${pathContext.request.contextPath}/login" method = "post">
				<div>
					login :
					<input type = "text" name = "loginId">
				</div>
				<div>
					password : 
					<input type = "password" name = "loginPw">
				</div>
				<button type = "submit">login</button>
			</form>
		</div>
</body>
</html>