<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>titlesListDistinct</title>
</head>
<body>
	<h1>업무목록</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a><!-- index.jsp로 돌아감 -->
		</div>
			<table border = '1'>
					<thead>
						<tr>
							<th>titles</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="row" items="${list}"> <!-- 리스트 출력 row는? -->
						<tr>
							<td>${row}</td>
						</tr>
					</c:forEach>
					</tbody>
			</table>
		
</body>
</html>