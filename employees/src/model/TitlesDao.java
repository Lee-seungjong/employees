package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;
import java.util.*;

public class TitlesDao {
	//업무목록(직책)을 보여준다
	public List<String> selectTitltesListDisTinct() {
		List<String> list = new ArrayList<String>();
		//리스트 출력
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select distinct title from titles";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("title"));
				//단순히 한종류만 출력되서 
			}
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		DBHelper.close(rs, stmt, conn);
	}
		return list;
}
		
	
	public int selectTitlesDaoRowCount() {
		int count = 0;
		final String sql = "select count(*) from titles";
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

