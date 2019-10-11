package model;

import java.sql.*;

import java.util.*;

import db.DBHelper;
import vo.Department;

public class DepartmentDao {
	//부서별 사원수를 출력
	public List<Map<String, Object>> selectDepartmentCountByDeptNo() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		//list로 받아 다형성을 씀으로써 확장성을 높인다
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select d.dept_no, d.dept_name, count(d.dept_no) from dept_emp de inner join departments d on de.dept_no = d.dept_no where de.to_date = '9999-01-01' group by d.dept_no order by count(d.dept_no) desc";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("deptNo", rs.getString("d.dept_no"));
				map.put("deptName", rs.getString("d.dept_name"));
				map.put("count", rs.getInt("count(d.dept_no)"));
				list.add(map);
				//list를 사용했지만 <map>을 사용함으로써 확장가능
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
				DBHelper.close(rs, stmt, conn);
				//연결 종료
			} 
			return list;
	
}
	
	public int selectDepartmentRowCount() {
		int count = 0;//초기화
		final String sql = "select count(*) from departments";//쿼리문 상수 고정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		//try 예외처리
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
	//배열, 출력시 리스트 출력에 쓰인다
	public List<Department> selectDepartmentList() {
		List<Department> list = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select dept_no, dept_name from departments";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Department department = new Department();
				department.setDeptNo(rs.getString("dept_no"));
				department.setDeptName(rs.getString("dept_name"));
				list.add(department);
				//단순히 값만 출력한다
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
		
	}

}
