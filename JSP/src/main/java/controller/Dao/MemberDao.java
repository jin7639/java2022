package controller.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.Board;
import Dto.Member;

public class MemberDao {

	private Connection con; //db연결 클래스
	private PreparedStatement ps; 
	private ResultSet rs;
	
	
	public MemberDao() {
		//jdbc 
		
		//1.드라이브
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC",
					"root","1234"); 
			System.out.println("연동 성공1");
		} catch (Exception e) {
			System.out.println("연동오류 " + e);
		}
	}
		
	public boolean signup(Member member) {
		try {
		//1.sql 작성
		String sql = "insert into member(mid, mpassword, mname) values(?,?,?)";
		//2.sql 연결
		
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.executeUpdate();
			System.out.println("회원가입");
			return true;
			
		}catch (Exception e) {
			System.out.println("sql: " +e);
		}
		return false;
		
	}
	
	public boolean login(String id, String password) {
		try {
			String sql = "select * from member where mid=? and mpassword=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("로그인 오류 "+ e);
		}
		return false;
		
	}
	
	public boolean memberdel(String id) {
		try {
			//1.sql 작성
			String sql = "delete from member where mid=?";
			
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				return true;
		} catch (Exception e) {
			System.out.println("탈퇴 오류 "+ e);
		}
		return false;
	}
	
	public boolean write(Board board) {
		try {
			String sql = "insert into board (btitle, bcontent, bwriter, bdate) values (?, ?, ?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,board.getBtitle());
			ps.setString(2,board.getBcontent());
			ps.setString(3,board.getBwriter());
			ps.setString(4,board.getBdate());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("글쓰기 오류 " + e);
		}
		return false;
		
	}
	
	
	public ArrayList<Board> list() {
		
		ArrayList<Board> boardlist = new ArrayList<Board>();
		try {
			String sql = "select * from board order by bnum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5)
				);
				boardlist.add(board);
				}
			return boardlist;
		} catch (Exception e) {
			System.out.println("게시판 sql" + e);
		}
		return null;
	}
	
	//개별 글 출력
	public Board get(int bnum) {
		String sql = "select * from board where bnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Board board = new Board(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
					);
				return board;
			}
			
		} catch (Exception e) {
			System.out.println("sql 오류 : " + e);
		}
		return null;
	}
	
	
	//게시물 삭제
	public boolean bdelete(int bnum) {
		
		String sql = "delete from board where bnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("삭제오류 " + e);
		}
		
		return false;
	}
	
	public boolean update(int bnum, String title, String content) {
		try {
			String sql = "update board set btitle = ? , bcontent = ? where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,title);
			ps.setString(2,content);
			ps.setInt(3,bnum);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("글수정 오류 " + e);
		}
		return false;
		
	}
	
	
}
