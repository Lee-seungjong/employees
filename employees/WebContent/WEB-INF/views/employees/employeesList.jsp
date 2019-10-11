<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesList</title>
</head>
<body>
	<h1>사원 목록</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a>
		</div>
		<form action="${pageContext.request.contextPath}/employees/getEmployeesList" method = "get">
			<!-- request.getContextPath()는 이제 안씀 -->
			<select name = "limit">
				<option value = "10">10</option>
				<option value = "20">20</option>
				<option value = "30">30</option>
				<option value = "40">40</option>
				<option value = "50">50</option>
			</select>
			<button>사원 목록</button>
		</form>
		<table border = '1'>
		<!-- 테이블 -->
			<thead>
				<tr>
					<th>사원 번호</th>
					<th>사원 생일</th>
					<th>사원 이름</th>
					<th>사원 성</th>
					<th>사원 성별</th>
					<th>사원 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employees" items="${list}">
				<!-- {String s : list} 를 대체할 코드 -->
				<!-- requestScope.list(리퀘스트안에 리스트를 뽑아주세요 [알아서찾아줘서 list만 써도됨] -->
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