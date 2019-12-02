package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("employees login 확인");
		
		int session = 0;
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");

	}

}
