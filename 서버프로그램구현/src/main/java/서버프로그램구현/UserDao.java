package 서버프로그램구현;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	private static Connection connection; // 1. DB 연결 클래스
	private static PreparedStatement ps; //2. 연결된 DB내 SQL조작
	private static ResultSet rs; //3. SQL 결과 레코드 
	
	public static UserDao userDao = new UserDao();
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB 주소 연결 	
			System.out.println("연동 완료 ");
		} catch (Exception e) {
			System.out.println("연동 실패 " + e);
		}
	}
}
