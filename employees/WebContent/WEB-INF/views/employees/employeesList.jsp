<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesList</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 상단 안내 페이지 -->
	<div class="jumbotron text-center" style="margin-bottom:0">
	  <h1>Employees</h1>
	  <p>employees 프로젝트를 소개하는 페이지 입니다</p> 
	</div>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	      	<!-- employees.jsp -->
	        <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList?limit=10">사원목록</a>
	      </li>
	      <li class="nav-item">
	      	<!-- department.jsp -->
	        <a class="nav-link" href="${pageContext.request.contextPath}/department/getDepartmentList?limit=10">부서목록</a>
	      </li>
	     <div class = dropdown>
	      <li class="nav-item">
	        <a class="nav-link" href="#" data-toggle="dropdown">사원목록 리스트</a>
	         <div class="dropdown-menu">
		      	<a class="dropdown-item" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순</a>
		      	<a class="dropdown-item" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순</a>
		      </div>
	      </li>
	     </div>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무목록</a>
	      </li>  
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계</a>
	      </li>  
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListCountByGender">역대 사원 수</a>
	      </li>  
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/department/getDepartmentCountByDeptNo">현재 재직 사원</a>
	      </li>  
	    </ul>
	  </div>  
	</nav>

<!-- 메인내용 -->
<div class="container">
	<br>
	<h1>사원 목록</h1>
		<form action="${pageContext.request.contextPath}/employees/getEmployeesList" method = "get">
			<!-- request.getContextPath()는 이제 안씀 -->
			<!-- 10개 단위로 출력옵션 -->
			<br>
			<select name = "limit">
				<option value = "10">10</option>
				<option value = "20">20</option>
				<option value = "30">30</option>
				<option value = "40">40</option>
				<option value = "50">50</option>
			</select>
			<button type = "submit" class="btn btn-outline-secondary">사원 목록</button>
		</form>
		<br>
		<table class="table table-bordered">
		<!-- 실제 출력 테이블 -->
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
</div>
</body>
</html>