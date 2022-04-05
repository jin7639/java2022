package dao;

import java.io.FileOutputStream;
import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.cj.QueryReturnType;

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
			System.out.println("SQL실패 "+e);
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
		//3.SQL 실행
		rs = ps.executeQuery();
		
		//4.SQL 결과
		try {
			//현재 날짜 가져오기
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    	String logindate = format.format(new Date()); //현재날짜를 형식 변환
	    	
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (rs.next()) {
			return true; //아이디 비밀번호 동일 ->로그인 성공
//			
			
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL오류 " + e);
		}
		
		return false; //로그인 실패
	}
	
		
	
	public void lastlogin(String id) {
		
		//1.현재 날짜 가져오기
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date()); //현재날짜를 형식 변환
		
//		//2.객체
//		상품 상품 = new 상품(상품명, 재고, 가격);

//		//4.파일처리
		try {//예외[오류]가 발생할 것 같은 코드 묶음					//파일경로		,이어쓰기 = true[옵션]
		FileOutputStream outputStream = new FileOutputStream("D:/lastlogin.txt", true);
		String datetxt = id + "," +since;
		outputStream.write(datetxt.getBytes());	//문자열 ->바이트열
		}catch (Exception e) {//예외[오류] 처리[잡기] : Exception 클래스
			System.out.println("저장 오류 "+ e);
		}
		System.out.println("날짜 저장 완료");
		
	}
		//3.아이디 찾기
	public String findid(String email) {
		try {
			//아이디찾기 → DB연동
				//입력한 이메일이 존재하면 메시지[알람]에 찾은 아이디 알려주기
			//1.SQL 작성
			String sql = "select * from member where memail = ?";
			//2.SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			//3.SQL 실행
			rs = ps.executeQuery();
			//4.SQL 결과
			if (rs.next()) {
				return rs.getString(2);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("아이디찾기 실패 " + e);
		}
		return null;
	}
		//4.비밀번호 찾기
	public String findpw (String id , String email) {
		try {
		//패스워드찾기 → DB연동
			//입력한 아이디, 이메일 존재하면 메시지[알람]에 찾은 비밀번호 알려주기
		//1.SQL 작성
		String sql = "select * from member where mid = ? and memail=?";
		//2.SQL 조작
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, email);
		//3.SQL 실행
		rs = ps.executeQuery();
		
		//4.SQL 결과
		if (rs.next()) {
			return rs.getString(3);
			
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("아이디찾기 실패 " + e);
		}
		return null;
	
	}	
	
	//5. 아이디 인수로 회원정보 호출
	public Member getMember(String id) {
		try {
			//1. SQL 작성
				String sql = "select * from member where mid=?";
			//2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			//3. SQL 실행
			rs = ps.executeQuery();
			//4. SQL 결과
			if (rs.next()) {
				//1.객체 선언
				Member member = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						//rs.next() : 결과내 다음 레코드(줄, 가로)
						//rs.getInt (필드순서 번호) : 해당 필드의 자료형 정수형으로 가져오기
						//rs.getString(필드순서 번호) : 해당 필드 자료형 문자열로 가져오기
						
						);
				//2.반환
				return member;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL 오류321 " + e);
		}
		return null;
		
	}
	//6. 회원탈퇴 [회원번호를 인수로 받아 해당 회원번호의 레코드 삭제]
	public boolean delete(int num) {
		try {
			
			//1. SQL 작성
			String sql = "delete from member where mnum=?";
			//2. SQL 조직
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			//3. SQL 실행
			ps.executeUpdate();
			//4. SQL 결과
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL 오류 "+ e);
		}
		return false;
	}
	
	//7. 회원 수정 [ 회원번호. 이메일, 주소 인수로 받아서 수정 ]
	public boolean update( int num, String email, String address ) {
		try {
			
		//1. SQL 작성
			//수정 : update 테이블명 set 필드명1=수정값1, 필드명2=수정값2 where 조건
		String sql = "update member set memail=?, maddress=? where mnum = ? ";
		//2. SQL 조작
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, address);
		ps.setInt(3, num);
	
		//3. SQL 실행
		ps.executeUpdate();
		//4. SQL 결과
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sql오류 " +  e);
		}
		return false;
	}
	
}
