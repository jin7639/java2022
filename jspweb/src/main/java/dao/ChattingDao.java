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
	public boolean cwrite (Chatting chatting) {
		String sql = "insert into chatting(cname,ccontent) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,chatting.getCname());
			ps.setString(2, chatting.getCcontent());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		return false;
	}
	
	//채팅 출력
	public ArrayList<Chatting> getchattinglist(){
		ArrayList<Chatting> chattinglist = new ArrayList<Chatting>();
		String sql = "select * from chatting order by cno asc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Chatting chatting = new Chatting (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
				chattinglist.add(chatting);
			}
			return chattinglist;
		} catch (Exception e) {
			System.out.println("sql 오류 : "+ e);
		}
		return null;
	}
	
	
	
}
