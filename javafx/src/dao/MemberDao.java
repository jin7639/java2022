package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;


	
public class MemberDao { // DB 접근객체
		
		private Connection con; // DB연동시 사용되는 클래스 : DB연동클래스
		private PreparedStatement ps; // 연결된 DB내 SQL 조작 할때 사용되는 인터페이스 : DB조작인터페이스
		private ResultSet rs; // 결과물을 조작하는 인터페이스 
		
		public static MemberDao memberDao = new MemberDao(); // DB 연동 객체;
		
		public MemberDao() {
			try {
				// DB연동 
				Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB 드라이버 가져오기
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
						"root","1234"); // 2. DB 주소 연결 
			}
			catch(Exception e ) { System.out.println( "[DB 연동 오류]"+e  ); }
		}
	
	

	
	//메소드
		//아이디 중복체크 메소드 (인수 : 아이디를 인수로 받아 db에 존재하는지 체크)
		public boolean idcheck (String id) {
			try {
				//1.sql 작성
				//검색 : select * from 테이블명 where 조건 (필드명=값)
				String sql = "select * from member where mid=?";
				
				//2.Sql 조작
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				//3. SQL 실행
				rs = ps.executeQuery();
				//4.SQL 결과
				if (rs.next()) {//만약에 다음 결과물이 존재하면 => 해당 아이디가 존재 -> 중복 O
					return true; //해당 아이디는 중복이 존재
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println( "[SQL 오류]"+e  );
			}
			return false;
		}
		
		//1.회원가입 
		
	public boolean signup (Member member) {
		try {
		
			//1.SQL 작성
			String sql = "insert into member(mid , mpassword, memail,maddress, mpoint, msince)values(?,?,?,?,?,?)";
			//2.SQl 조작
			ps = con.prepareStatement(sql);
			ps.setString(1,member.getMid()); //1번 ?에 아이디 넣어주기
			ps.setString(2,member.getMpassword()); //2번 ?에 비밀번호 넣어주기
			ps.setString(3,member.getMemail()); //3번 ?에 이메일 넣어주기
			ps.setString(4,member.getMaddress()); //4번 ?에 주소 넣어주기
			ps.setInt(5,member.getMpoint()); //5번 ?에 포인트 넣어주기
			ps.setString(6,member.getMsince()); //6번 ?에 가입일 넣어주기
			//3.SQL 실행
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL실패"+e);
			return false;
		}
	}
		//2.로그인
	public boolean login (String id, String password) {
		try {
			
		
		//1.SQL 작성
			
			//연산자 and : 조건 and 조건
		String sql = "select * from member where mid = ? and mpassword=?";
		
		//2.SQL 조작
		
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, password);
		//3.SQL 실행\
		rs = ps.executeQuery();
		
		//4.SQL 결과
		if (rs.next()) {
			return true; //아이디 비밀번호 동일 ->로그인 성공
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL오류" + e);
		}
		
		return false; //로그인 실패
	}
		//3.아이디
	public String findid(String email) {
		return null;
	}
		//4.비밀번호
	public String findpassword (String id , String email) {
		return null;
	}
	
	
	
}
