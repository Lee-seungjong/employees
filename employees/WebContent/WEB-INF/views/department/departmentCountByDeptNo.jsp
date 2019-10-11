<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>departmentCountByDeptNo</title>
</head>
<body>
	<h1>현재 부서별 사원 수</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a>
		</div>
			<table border = '1'>
				<thead>
					<tr>
						<th>dept_no</th>
						<th>dept_name</th>
						<th>count</th>
					</tr>
				</thead>
				<tbody>
					 <c:forEach var="map" items="${list}">
						<tr>
							<td>${map.deptNo}</td>
							<td>${map.deptName}</td>
							<td>${map.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</body>
</html>