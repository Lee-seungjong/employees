package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//다른 패키지 import하기
import model.*;
import vo.*;
import java.util.*;

@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	// employeesDao 사용을 위한 선언
	//캡슐화
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit = 10;
		//페이지의 목록 값
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
			//int 타입을 변환
		}
		System.out.println("GetEmployeesListServlet param limit : " + limit);
		//확인용 코드 
		
		//리스트
		employeesDao =  new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
		//리스트로 출력
		//(limit)로 위에 설정된 만큼 보여줌
	}
}
