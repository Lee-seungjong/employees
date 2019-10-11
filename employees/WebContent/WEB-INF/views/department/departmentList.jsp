<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>departmentList</title>
</head>
<body>
	<h1>부서 목록</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a><!-- index.jsp로 돌아감 -->
		</div>
		<table border = "1">
			<thead>
				<tr>
					<th>부서 이름</th>
					<th>부서 번호</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="department" items="${list}"> <!-- for문 대신 사용 --> <!-- ""안에 값이 들어와야한다 -->
					<tr>
						<td>${department.deptNo}</td>
						<td>${department.deptName}</td> <!-- department.getDeptName() -->
					</tr>
			</c:forEach>
		</tbody>
		</table>
</body>
</html>