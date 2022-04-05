package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;

public class BoardDao {
	
	private Connection conn; // 1. DB 연결 클래스
	private PreparedStatement ps; //2. 연결된 DB내 SQL조작
	private ResultSet rs; //3. SQL 결과 레코드 
	
	public static BoardDao boardDao = new BoardDao();
	
	public BoardDao() {//생성자에서 연동하는 이유 : 객체 생성시 바로 연동
		try {
			// DB연동 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB 드라이버 가져오기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB 주소 연결 	
		} catch (Exception e) {

		}
	}
	
	//1.글쓰기 메소드
	public boolean write(Board board) {
		return false;
	}
	
	//2.모든 글 호출
	public boolean boardlist() {
		return false;
	}
	
	//3. 글 삭제 메소드
	public boolean delete (int bnum) {
		return false;
	}
	
	//4. 글 수정 메소드
	public boolean update(int bnum, String title, String content) {
		return false;
	}
	
	
	
	
	
}
