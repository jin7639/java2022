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
			// DB���� 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB �ּ� ���� 
		} catch (Exception e) {
			System.out.println("DB���� ����" +  e);
		}
	}
	
	// 1. ������ �޼ҵ�
	public boolean roomadd(Room room) {
		try {
			String sql = "insert into room(roname,roip)values(?,?)";
			//���̺� ���ڵ� �߰�
			ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoname());
			ps.setString(2, room.getRoip());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("SQL���� "+e);
		}
		return false;
	}
	
	//2. ���ȣ ȣ�� �޼ҵ�
	public int getroomnum() { //���� �ֱ� ���ȣ ��������
		try {
			String sql = "select max(ronum) from room";
			ps = con.prepareStatement(sql);
			ps.executeQuery();
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("sql���� " + e);
		}
		return 0;
	}
	
	//3. ��� �� ȣ�� �޼ҵ�
	public ObservableList<Room> roomList() {
		
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by ronum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//next -> ���پ� �Ѿ�鼭 ��������
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
			System.out.println("sql���� " + e);
		}
		return null;
	}
	
	
	
}
