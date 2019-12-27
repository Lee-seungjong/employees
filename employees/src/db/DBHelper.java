package db;

import java.sql.*;

//Dao에서 중복되는 연결 코드, 연결 종료코드를 여기에 넣는다
public class DBHelper {
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		// 나중에 cafe24로 주소 변경
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
	return conn;
	}
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		//연결 종료시킬 3개의 변수를 매개 변수로 받는다
		if(rs !=null) {
			try {
				rs.close();
			} catch (SQLException e) { //sql쿼리문 받기
				e.printStackTrace();
			}
			
		} if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				//void 있으므로 return 없음
			}
		}
	}
}
