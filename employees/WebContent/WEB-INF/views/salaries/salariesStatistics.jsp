<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>salariesStatistics</title>
</head>
<body>
	<h1>salaries 연봉 통계</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a><!-- index.jsp로 돌아감 -->
		</div>
			<table border = "1">
				<thead>
					<tr>
						<th>count</th>
						<th>sum</th>
						<th>avg</th>
						<th>max</th>
						<th>min</th>
						<th>std</th>
					</tr>
				</thead>
				<tbody>
						<tr><!-- 반복하지 않고 결과를 내야하기때문에 c:foreach 를 안쓴다 -->
							<td>${map.count}</td>
							<td>${map.sum}</td>
							<td>${map.avg}</td>
							<td>${map.max}</td>
							<td>${map.min}</td>
							<td>${map.std}</td>
						</tr>
				</tbody>
			</table>
</body>
</html>