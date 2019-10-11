package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import vo.Department;
import java.util.*;

@WebServlet("/department/getDepartmentList")
public class GetDepartmentListServlet extends HttpServlet {
	private DepartmentDao departmentDao;//캡슐화
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentDao = new DepartmentDao();
		List<Department> list = departmentDao.selectDepartmentList();
		
		request.setAttribute("list", list);//리스트 가져오기
		request.getRequestDispatcher("/WEB-INF/views/department/departmentList.jsp").forward(request, response);
	}
}
