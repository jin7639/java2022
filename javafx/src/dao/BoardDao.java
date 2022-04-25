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
		try {
			
		//1.SQL �ۼ�
			String sql = "insert into board(btitle , bcontent, bwriter)values(?,?,?)";
		//2.SQL ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
		//3.SQL ����
			ps.executeUpdate();
		//4.SQL ���
			return true;
		} catch (Exception e) {
			System.out.println("SQL ����" + e);
		}
		
		return false;
	}
	
	//2.��� �� ȣ��
	public ObservableList<Board> list() {
		//tableview�� observableList ���
		
		ObservableList<Board> boardList = FXCollections.observableArrayList();
		try {
			
		//1.SQL �ۼ�
			String sql = "select * from board order by bnum desc";
		//2.SQL ����
			ps = conn.prepareStatement(sql);
			
		//3.SQL ����
			rs = ps.executeQuery();	
		//4.SQL ���		
			while (rs.next()) {
				
				//1. ��üȭ
				Board board = new Board (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6)
						);
				
				//2. �ش� ��ü�� ����Ʈ�� ���
				boardList.add(board);
				
			}
			return boardList;
		} catch (Exception e) {
			 System.out.println( "[SQL ����]"+e  );
		}
		return null;
	}
	
	//3. �� ���� �޼ҵ�
	public boolean delete (int bnum) {
		try {
		
			//1. SQL �ۼ�
			String sql = "delete from board where bnum=?";
			//2. SQL ����
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, bnum);
			//3. SQL ����
			ps.execute();
			//4. SQL ���
			return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�������� " + e);
		}
		return false;
	}
	
	//4. �� ���� �޼ҵ�
	public boolean update(int bnum, String title, String content) {
		
		try {
			//1.SQL �ۼ�
			String sql = "update board set btitle= ? , bcontent=? where bnum = ? ";
			//2.SQL ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bnum);
			//3.SQL ����
			ps.executeUpdate();
			//4.SQL ���
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//5.��� �ۼ� �޼ҵ�
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
			System.out.println("sql ���� "+ e);
		}
		return false;
		
		
	}
	//6.��� ȣ�� �޼ҵ�
	
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
			System.out.println("sql ���� ���� ����"+ e);
		}
		return null;
	}
	
	
}
