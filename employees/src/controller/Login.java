package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/login")
public class Login extends HttpServlet {
	private EmployeesDao employeesDao;
	// form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		System.out.println("get 확인");
	}
	// action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("employees login 요청 확인");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		System.out.println("first_name"+firstName);
		// 세션 요청
		HttpSession session = request.getSession();
		
		Employees employees = new Employees();
		employees.setFirstName(firstName);
		int login = employeesDao.selectEmployeesLogin(firstName, lastName, empNo);
		session.setAttribute("login", login);
		
		response.sendRedirect(request.getContentType()+"/index.jsp");
	
	}

}
