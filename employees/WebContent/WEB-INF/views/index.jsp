<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
</style>
<body>
<!-- 로그인 접속 확인 -->
<c:if test="${session.sessionId != null }">

</c:if>
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
<!-- 로그인시 보여줌 -->
<div class="container">
		<!-- 로그인시 로그아웃 버튼 활성화 -->
		<c:if test="${check == true}">
			<div>
				<button type = "submit">logout</button>
			</div>
		</c:if>
		<!-- 기본 테이블 -->
		<br>
		<h2>테이블 정보</h2>
		<br>
		<!-- jsp에서 쓰이는 두가지 표현방법 -->
		<div>
			<!-- 이제 안씀 -->
			<ul class="list-group">
			  <li class="list-group-item">EL -> employees table row count : ${employeesRowCount}</li>
			  <!-- 자바코드를 없애는 방법 (근데 복잡함) -->
			  <li class="list-group-item">표현식 -> employees table total row count : <%=request.getAttribute("employeesRowCount") %></li>
			  <!-- 이제 안씀 -->
			</ul>
		</div>
		<br>
		<br>
		<div>
			<table class="table table-bordered">
				<thead>
				<tr>
					<td>테이블 이름</td>
					<td>전체 행의 수</td>
				</tr>
				</thead>
				<tbody>
					<tr>
						<td>employees</td>
						<td>${employeesRowCount}</td><!-- RowCount출력 -->
					</tr>
					<tr>
						<td>department</td>
						<td>${departmentRowCount}</td>
					</tr>
					<tr>
						<td>dept_manager</td>
						<td>${deptManagerRowCount}</td>
					</tr>
					<tr>
						<td>dept_emp</td>
						<td>${deptEmpRowCount}</td>
					</tr>
					<tr>
						<td>salaries</td>
						<td>${salariesRowCount}</td>
					</tr>
					<tr>
						<td>titles</td>
						<td>${titlesRowCount}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 지정된 범위에서 결과 출력 -->
		<div>
			<form method = "post" action = "${pageContext.request.contextPath}/employees/getEmployeesListBetween">
				<input type = "number" name = "begin" placeholder="10001">~<input type = "number" name = "end" placeholder="499999">
				<button type = "submit" class="btn btn-secondary">검색하기</button>
				${minEmpNo} ${MaxEmpName}
			</form><!-- 지정된 범위내에서 원하는 범위를을 입력하면 그만큼 출력해서 사용자에게 보여줌  -->
		</div>
</div>
</body>
</html>