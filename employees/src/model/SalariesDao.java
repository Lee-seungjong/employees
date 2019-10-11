package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;

public class SalariesDao {
	//함수를 이용하여 통계값 구하기
	public Map<String, Long> selectSalariesStatistics() {
		Map<String, Long> map = new HashMap<String, Long>();
		//map으로 선언하여 확장성을 높인다 
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(salary),sum(salary),avg(salary),max(salary),min(salary),std(salary) from salaries";
		
		try {
			conn = DBHelper.getConnection(); //DBHelper에서 conn하기 
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				map.put("count", rs.getLong("COUNT(salary)")); //map을 사용했으므로String, long타입
				map.put("sum", rs.getLong("SUM(salary)"));//()안에 들어갈 쿼리문 넣기
				map.put("avg", rs.getLong("AVG(salary)"));
				map.put("max", rs.getLong("MAX(salary)"));
				map.put("min", rs.getLong("MIN(salary)"));
				map.put("std", rs.getLong("STD(salary)"));
				System.out.println(map);
				//한번만 출력되기 때문에 if문
				//마찬가지로 map.add()로 받아올 필요가 없다
				
			}
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		DBHelper.close(rs, stmt, conn);
	}
		return map;
	}
	
	public int selectSalariesDaoRowCount() {
		int count = 0;
		final String sql = "select count(*) from salaries";
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

}
