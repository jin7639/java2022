package dao;

import java.util.ArrayList;

import dto.Board;
import dto.Chatting;

public class ChattingDao extends Dao{

	public ChattingDao() {
		super();
	}
	
	public static ChattingDao chattingDao = new ChattingDao();
	public static ChattingDao getChattingDao() {
		return chattingDao;
	}
	//채팅 입력
	public boolean send( String nicname , String content , String ip , String file  )  {
		String sql = "insert into teamchatting(cnicname , ccontent ,ip,file )values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , nicname ); ps.setString( 2 , content );  
			ps.setString( 3 , ip );		ps.setString( 4 , file );
			ps.execute(); return true;
		}catch (Exception e) {} return false;
	}
	
	public String receive(  )  {
		String receive = "";
		String sql = "select * from teamchatting;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				receive += rs.getString( 6 ) +"^"+
						rs.getString( 5 ) +"^"+
						rs.getString( 4 ) +"^"+
						rs.getString( 2 ) +"^"+
						rs.getString( 3 )+",";
			}
			return receive;
		}catch (Exception e) {} return null;
	}
}
	
