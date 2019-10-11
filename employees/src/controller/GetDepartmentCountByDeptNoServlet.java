package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentDao;


@WebServlet("/department/getDepartmentCountByDeptNo")
public class GetDepartmentCountByDeptNoServlet extends HttpServlet {
	private DepartmentDao departmentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentDao = new DepartmentDao();
		List<Map<String, Object>> list = departmentDao.selectDepartmentCountByDeptNo();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/department/departmentCountByDeptNo.jsp").forward(request, response);
	}
}
