<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body>
	<h1>Index</h1>
		<div>
			<a href = "${pageContext.request.contextPath}">홈으로</a><!-- index.jsp로 돌아감 -->
		</div>
		<h2>테이블 정보</h2>
		<div>
			<table  border = '1'>
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
		<div>
			<ul>
				<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesList?limit=10">사원 목록</a></li><!-- employeesList.jsp로 감 -->
				<li><a href ="${pageContext.request.contextPath}/department/getDepartmentList?limit=10">부서 목록</a></li><!-- departmentList.jsp로 감  -->
				<li>
					사원 목록 first_name
					<br>
					<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순(Limit50)</a>
					<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순(Limit50)</a>
				</li>
				<li>
					<a href = "${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무 목록(distinct)</a>
				</li>
				<li>
					<a href = "${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계 값(count, sum, avg, max,  min, std)</a>
				</li>
				<li>
					<a href = "${pageContext.request.contextPath}/employees/getEmployeesListCountByGender">사원 수(성별 group by gender)</a>
				</li>
				<li>
					<a href = "${pageContext.request.contextPath}/department/getDepartmentCountByDeptNo">현재 부서별 사원수</a>
				</li>
			</ul>
		</div>
		<div>
			<form method = "post" action = "${pageContext.request.contextPath}/employees/getEmployeesListBetween">
				<input type = "number" name = "begin">~<input type = "number" name = "end">
				<button type = "submit">사원목록 between</button>
				${minEmpNo}~${MaxEmpName} 10001~499999
			</form><!-- 지정된 범위내에서 원하는 범위를을 입력하면 그만큼 출력해서 사용자에게 보여줌  -->
		</div>
		
		<div>
			EL -> employees table row count : ${employeesRowCount}
			<!-- 자바코드를 없애는 방법 (근데 복잡함) -->
			<br>
			표현식 -> employees table total row count : <%=request.getAttribute("employeesRowCount") %>
			<!-- 이제 안씀 -->
		</div>
</body>
</html>