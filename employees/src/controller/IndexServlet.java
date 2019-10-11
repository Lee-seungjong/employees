package controller;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import model.*;

@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao; //캡슐화
	private DepartmentDao departmentDao;
	private DeptManagerDao deptManagerDao;
	private DeptEmpDao deptEmpDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	//EmployeesDao employeesDao = new EmployeesDao()를 대신
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index 요청");
		
		this.employeesDao = new EmployeesDao();//this.를 써도 똑같다
		int employeesRowCount = employeesDao.selectEmployeesRowCount();
		
		departmentDao = new DepartmentDao();
		int departmentRowCount = departmentDao.selectDepartmentRowCount();
		
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerRowCount();
		
		deptEmpDao = new DeptEmpDao();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpDaoRowCount();
		
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesDaoRowCount();
		
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesDaoRowCount();
		
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentRowCount", departmentRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		//VIEW - /WEB-INF/view/index.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("VIEW - /WEB-INF/view/index.jsp");
		//rd.forward(request, response);
		//오토박싱 레퍼타입(구글링)
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		//출력
	}

}
