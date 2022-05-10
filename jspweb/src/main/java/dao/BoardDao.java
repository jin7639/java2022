package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dto.Board;
import dto.Reply;

public class BoardDao extends Dao{

	public BoardDao() {
		super();	//슈퍼클래스 호출 (DB연동)
			// super.메소드() super.필드명
	}
	
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	//메소드 호출 방법
	//1. 객체를 만든다
	//BoardDao boardDao = new BoardDao();
	//boardDao.write();
	//2. 미리 만들어두고 호출
	//BoardDao.getBoardDao().write();
	
	//1. 게시물 쓰기 메소드 [ 인수 : 작성된 데이터들 = dto  ]
	public boolean write( Board board ) {
		
		String sql = "insert into board( btitle, bcontent, mno, bfile )values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setInt(3, board.getMno());
			ps.setString(4, board.getBfile());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		
		return false;
	}
	//2. 모든 게시물 출력 메소드 [ 추후기능-> 검색 : 조건 ]
	public ArrayList<Board> getBoardlist(){
		
		ArrayList<Board> boardlist = new ArrayList<Board>();
		
			
				
		//내림차순
		String sql = "select * from board order by bno desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						null
						);
						boardlist.add(board);
			}
			
			return boardlist;
		} catch (Exception e) {
			System.out.println("sql 오류 : "+ e);
		}
		
		return null;
	}
	
	//3. 개별 게시물 출력 메소드 [인수:게시물 번호]
	public Board getboard( int bno ) {
		
		//1. sql 작성
		String sql = "SELECT * from board where bno ="+bno;
		try {
			ps = con.prepareStatement(sql);	//2. 연결된 db(con)에 sql 문 설정
			rs = ps.executeQuery();	//3. 조작된 sql실행
			//4.검색결과 rs.next()할때마다 결과물에서 레코드 1개씩 호출
			if (rs.next()) {
				Board board = new Board (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						null
						);
				return board;						
			}
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		
		return null;
	}
	//4. 게시물 수정 메소드 [인수: 게시물 번호 / 수정된 내용]
	public boolean update( Board board ) {
		String sql = "update board set btitle=? , bcontent=? , bfile=? where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBfile());
			ps.setInt( 4 , board.getBno() );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("오류 " + e);
		}
		return false;
	}
	//5. 게시물 삭제 메소드 [ 인수 : 삭제할 게시물번호 ]
	public boolean delete( int bno ) {
		String sql = "delete from board where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		return false;
	}
	//5-2 첨부파일 null로 변경
	public boolean filedelete (int bno ) {
		String sql = "update board set bfile=null where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("첨부파일sql오류 " + e);
		}
		return false;
	}
	//6. 게시물 조회 증가 메소드 [ 인수 : 증가할 게시물번호 ]
	public boolean increview( int bno) {
		String sql = "update board set bview = bview+1 where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("조회수 sql오류 " + e);
		}
		return false;
	}
	
	
	//7. 댓글 작성 메소드 [ 인수 : 작성된 데이터들 = dto ]
	public boolean replywrite(Reply reply) {
		
		String sql = "insert into reply (rcontent,rindex,bno,mno)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRindex());
			ps.setInt(3, reply.getBno());
			ps.setInt(4, reply.getMno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("댓글 sql오류 " + e);
		}
		
		return false;
	}
	//8. 댓글 출력 메소드 [ 인수 : x ]
	public ArrayList<Reply> replylist( int bno ) { 
		ArrayList<Reply> replylist = new ArrayList<Reply>();
		String sql = "select * from reply where bno = "+bno+" and rindex = 0";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						null
						);
				replylist.add(reply);
			}
			return replylist;
		} catch (Exception e) {
			System.out.println("댓글 출력 sql오류 " + e);
		}
		return null;
	}
	//9. 댓글 수정 메소드 [ 인수 : 수정할 댓글 번호 ]
	public boolean replyupdate() {
		
		
		return false;
	}
	//10. 댓글 삭제 메소드 [ 인수 : 삭제할 댓글 번호 ] 
	public boolean replydelete() {
		return false;
	}
	
public ArrayList<Board> getMyBoardlist(int mno){
		
		ArrayList<Board> boardlist = new ArrayList<Board>();
				
		//내림차순
		String sql = "select * from board where mno='"+mno+"'order by bno desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						null
						);
						boardlist.add(board);
			}
			
			return boardlist;
		} catch (Exception e) {
			System.out.println("내가쓴글 sql 오류 : "+ e);
		}
		
		return null;
	}
	
	
}
