package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import model.*;
import vo.*;


@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	private EmployeesDao employeesDao; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order = request.getParameter("order");
		//dao에서 String 타입으로 매게변수(order)를 받아온다
		
		System.out.println("getEmployeesListOrderBy" + order);
		//order확인코드
		
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListOrderBy(order);
		request.setAttribute("list", list);//리스트 출력
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
		
	}
}
