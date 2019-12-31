<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>departmentList</title>
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
	<!-- 내용 -->
	<div class="container">
		<br>
		<h1>부서 목록</h1>
		<br>
			<table class="table table-bordered">
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
	</div>
</body>
</html>