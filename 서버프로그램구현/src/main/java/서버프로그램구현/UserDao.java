package �������α׷�����;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	private static Connection connection; // 1. DB ���� Ŭ����
	private static PreparedStatement ps; //2. ����� DB�� SQL����
	private static ResultSet rs; //3. SQL ��� ���ڵ� 
	
	public static UserDao userDao = new UserDao();
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB �ּ� ���� 	
			System.out.println("���� �Ϸ� ");
		} catch (Exception e) {
			System.out.println("���� ���� " + e);
		}
	}
}
