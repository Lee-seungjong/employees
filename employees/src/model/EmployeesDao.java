package model;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import db.DBHelper;
import vo.*;

public class EmployeesDao {
	// 로그인
	public String selectEmployeesLogin(HttpSession session) {
		System.out.println("로그인 확인");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("");
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		return "";
	}
	
	//남,녀 직원수 출력하기
	public List<Map<String, Object>> selectEmployeesListCountByGender() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		//list와 map을 동시에 쓴다
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select gender, count(*) cnt from employees GROUP by gender";
		//예외처리
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
				list.add(map);
				//실제 출력
				//위에서 list<map>으로 받아왔기 때문에 사용가능하며 <>안에 String,Object타입을 선언 했기 때문에
				//String을 쓰고 object는 변환이 가능하다
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	//between 출력하기,()~~()
	public List<Employees> selectEmployeesListBetween(int begin, int end) {
		List<Employees> list = new ArrayList<>();
		//리스트 출력 하니까 list
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees where emp_no BETWEEN ? and ? order by emp_no asc";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			//값을 입력하기 때문에 (post) setint를 써준다
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));;
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
				//list에 출력할 값을 가져옴
			}
			
	} catch(Exception e) { //자바의 변수 생명주기는 {}
		e.printStackTrace();
	} finally {
		DBHelper.close(rs, stmt, conn);
		
	}
	return list;
}
	
	//(?)개 출력 명령시 리스트출력 
	public List<Employees> selectEmployeesListByLimit(int limit) {
		List<Employees> list = new ArrayList<Employees>();
		//배열 선언하기
		//리스트로 매개변수 limit 를 받아와 배열 받아오기
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees LIMIT ?";
		//null값으로 db사용에 필요한 변수선언하기
		//sql 쿼리문
		
		//예외처리
		//드라이버 로딩
		try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, limit);
				rs = stmt.executeQuery();
				
				//반복문으로 결과문 출력 
				while(rs.next()) {
					Employees employees = new Employees();
					employees.setEmpNo(rs.getInt("emp_no"));
					employees.setBirthDate(rs.getString("birth_date"));
					employees.setFirstName(rs.getString("first_name"));
					employees.setLastName(rs.getString("last_name"));;
					employees.setGender(rs.getString("gender"));
					employees.setHireDate(rs.getString("hire_date"));
					list.add(employees);
				}
				
		} catch(Exception e) { //자바의 변수 생명주기는 {}
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
			
		}
		return list;
	}


	public int selectEmployeesRowCount() {
		int count = 0;
		final String sql = "select count(*) from employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

	
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		DBHelper.close(rs, stmt, conn);
	}
		return count;
}
	//오름차순 내림차순 출력하기
	public List<Employees> selectEmployeesListOrderBy(String order) {
		List<Employees> list = new ArrayList<Employees>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		//동적 쿼리
		//입력되는 명령에따라 작동되는 쿼리문이 달라진다
		if(order.equals("asc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name asc limit 50";
		} else if(order.equals("desc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name desc limit 50";
		}
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
				//출력 리스트
			}
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		DBHelper.close(rs, stmt, conn);
	}
		
		return list;
	}
}
