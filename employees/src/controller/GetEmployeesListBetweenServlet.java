package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/employees/getEmployeesListBetween")
public class GetEmployeesListBetweenServlet extends HttpServlet {
	private EmployeesDao employeesDao; //캡슐화
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		//시작되는 값begin,end를 받아온다
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListBetween(begin, end);
		//Dao에서 정한 매개변수를 호출한다
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListBetween.jsp").forward(request, response);
	}

}
