package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;
import dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
		try {
			
		//1.SQL 작성
			String sql = "insert into board(btitle , bcontent, bwriter)values(?,?,?)";
		//2.SQL 조작
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
		//3.SQL 실행
			ps.executeUpdate();
		//4.SQL 결과
			return true;
		} catch (Exception e) {
			System.out.println("SQL 오류" + e);
		}
		
		return false;
	}
	
	//2.모든 글 호출
	public ObservableList<Board> list() {
		//tableview가 observableList 사용
		
		ObservableList<Board> boardList = FXCollections.observableArrayList();
		try {
			
		//1.SQL 작성
			String sql = "select * from board order by bnum desc";
		//2.SQL 조작
			ps = conn.prepareStatement(sql);
			
		//3.SQL 실행
			rs = ps.executeQuery();	
		//4.SQL 결과		
			while (rs.next()) {
				
				//1. 객체화
				Board board = new Board (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6)
						);
				
				//2. 해당 객체를 리스트에 담기
				boardList.add(board);
				
			}
			return boardList;
		} catch (Exception e) {
			 System.out.println( "[SQL 오류]"+e  );
		}
		return null;
	}
	
	//3. 글 삭제 메소드
	public boolean delete (int bnum) {
		try {
		
			//1. SQL 작성
			String sql = "delete from board where bnum=?";
			//2. SQL 조작
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, bnum);
			//3. SQL 실행
			ps.execute();
			//4. SQL 결과
			return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("삭제오류 " + e);
		}
		return false;
	}
	
	//4. 글 수정 메소드
	public boolean update(int bnum, String title, String content) {
		
		try {
			//1.SQL 작성
			String sql = "update board set btitle= ? , bcontent=? where bnum = ? ";
			//2.SQL 조작
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bnum);
			//3.SQL 실행
			ps.executeUpdate();
			//4.SQL 결과
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//5.댓글 작성 메소드
	public boolean rwrite( Reply reply ) {
		try {
			String sql = "insert into reply(rcontent, rwriter, bnum)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwriter());
			ps.setInt(3, reply.getBnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("sql 오류 "+ e);
		}
		return false;
		
		
	}
	//6.댓글 호출 메소드
	
	public ObservableList<Reply> replylist(int bnum) {
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		try {
			String sql = "select * from reply where bnum = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reply reply = new Reply(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5));
				replylist.add(reply);
			}
			return replylist; 
		} catch (Exception e) {
			System.out.println("sql 오류 여기 오류"+ e);
		}
		return null;
	}
	
	
}
