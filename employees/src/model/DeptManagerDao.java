package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class DeptManagerDao {
	public int selectDeptManagerRowCount() {
		int count = 0;
		final String sql = "select count(*) from dept_manager";
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
