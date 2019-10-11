<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesListOrderBy</title>
</head>
<body>
	<h1>사원 목록</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a><!-- index로 돌아가기 -->
		</div>
		<!-- 오름차순 -->
		<table border = '1'>
			<thead>
				<tr>
					<th>emp_no</th>
					<th>birth_date</th>
					<th>first_name*</th>
					<th>last_name</th>
					<th>gender</th>
					<th>hire_date</th>
				</tr>
			</thead>
			<tbody><!-- 실제 출력 -->
				<c:forEach var="employees" items="${list}"> <!-- 리스트 가져오기 -->
					<tr>
						<td>${employees.empNo}</td>
						<td>${employees.birthDate}</td>
						<td>${employees.firstName}</td>
						<td>${employees.lastName}</td>
						<td>${employees.gender}</td>
						<td>${employees.hireDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>