<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesListCountByGender</title>
</head>
<body>
	<h1>사원수 (성별 group By gender)</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a><!-- index.jsp로 돌아감 -->
		</div>
			<table border = '1'>
				<thead>
					<tr>
						<th>남자</th>
						<th>여자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "map" items = "${list}">
						<td>${map.gender}</td>
						<td>${map.cnt}</td>
					</c:forEach>
				</tbody>
			</table>
</body>
</html>