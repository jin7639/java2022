package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;

public class BoardDao {
	
	private Connection conn; // 1. DB ���� Ŭ����
	private PreparedStatement ps; //2. ����� DB�� SQL����
	private ResultSet rs; //3. SQL ��� ���ڵ� 
	
	public static BoardDao boardDao = new BoardDao();
	
	public BoardDao() {//�����ڿ��� �����ϴ� ���� : ��ü ������ �ٷ� ����
		try {
			// DB���� 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB �ּ� ���� 	
		} catch (Exception e) {

		}
	}
	
	//1.�۾��� �޼ҵ�
	public boolean write(Board board) {
		return false;
	}
	
	//2.��� �� ȣ��
	public boolean boardlist() {
		return false;
	}
	
	//3. �� ���� �޼ҵ�
	public boolean delete (int bnum) {
		return false;
	}
	
	//4. �� ���� �޼ҵ�
	public boolean update(int bnum, String title, String content) {
		return false;
	}
	
	
	
	
	
}
