package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;
import dto.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static RoomDao roomDao = new RoomDao();
	
	public RoomDao () {
		try {
			// DB연동 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB 드라이버 가져오기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB 주소 연결 
		} catch (Exception e) {
			System.out.println("DB연동 오류" +  e);
		}
	}
	
	// 1. 방저장 메소드
	public boolean roomadd(Room room) {
		try {
			String sql = "insert into room(roname,roip)values(?,?)";
			//테이블에 레코드 추가
			ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoname());
			ps.setString(2, room.getRoip());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("SQL오류 "+e);
		}
		return false;
	}
	
	//2. 방번호 호출 메소드
	public int getroomnum() { //가장 최근 방번호 가져오기
		try {
			String sql = "select max(ronum) from room";
			ps = con.prepareStatement(sql);
			ps.executeQuery();
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		return 0;
	}
	
	//3. 모든 방 호출 메소드
	public ObservableList<Room> roomList() {
		
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by ronum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//next -> 한줄씩 넘어가면서 가져오기
			while (rs.next()) {
				Room room = new Room(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						0
						);
				roomlist.add(room);
			}
			return roomlist;
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		return null;
	}
	
	
	
}
