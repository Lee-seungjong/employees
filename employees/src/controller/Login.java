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
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
//		System.out.println("get login 확인");
//		
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		int empNo = Integer.parseInt(request.getParameter("empNo"));
//		System.out.println("first_name"+firstName);
//		System.out.println("last_name"+lastName);
//		System.out.println("empNo"+empNo);
//		// 세션 요청
//		HttpSession session = request.getSession();
//		
//		Employees employees = new Employees();
//		employees.setFirstName(firstName);
//		int login = employeesDao.selectEmployeesLogin(firstName, lastName, empNo);
//		if(login == 0) {
//			response.sendRedirect("/WEB-INF/views/login.jsp");
//		} else {
//		session.setAttribute("login", login);
//		response.sendRedirect(request.getContentType()+"/WEB-INF/views/index.jsp");
//		}
//	}
	// action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("employees post login 요청 확인");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		System.out.println("first_name"+firstName);
		System.out.println("last_name"+lastName);
		System.out.println("empNo"+empNo);
		// 세션 요청
		HttpSession session = request.getSession();
		
		Employees employees = new Employees();
		employees.setFirstName(firstName);
		int login = employeesDao.selectEmployeesLogin(firstName, lastName, empNo);
		if(login == 0) {
			response.sendRedirect("/WEB-INF/views/login.jsp");
		} else {
		session.setAttribute("login", login);
		response.sendRedirect(request.getContentType()+"/WEB-INF/views/index.jsp");
		}
	}

}
