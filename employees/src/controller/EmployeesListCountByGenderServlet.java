package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;

@WebServlet("/employees/getEmployeesListCountByGender")
public class EmployeesListCountByGenderServlet extends HttpServlet {
	private EmployeesDao employeesDao; //캡슐화
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		List<Map<String, Object>> list = employeesDao.selectEmployeesListCountByGender();
		//Dao에서 선언한 list가져오기
		System.out.println("list"+list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListCountByGender.jsp").forward(request, response);
		//연동
	}

}
