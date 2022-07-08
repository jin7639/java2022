package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MemberDto;

public class Dao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public Dao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/xe?",
					"root","1234");
			System.out.println("연동 성공");
		} catch (Exception e) {
			System.out.println("연동 실패 : "+ e);
		}
		
	}
	public int getlastcustno() {
		String sql = "select max(custno) from member_tbl_02";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public boolean save(MemberDto memberdto) {
		String sql = "insert into xe.member_tbl_02 values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, memberdto.getCustno());
			ps.setString(2, memberdto.getCustname());
			ps.setString(3, memberdto.getPhone());
			ps.setString(4, memberdto.getAddress());
			ps.setString(5, memberdto.getJoindate());
			ps.setString(6, memberdto.getGrade());
			ps.setString(7, memberdto.getCity());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public ArrayList<MemberDto> getlist() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "select * from xe.member_tbl_02";
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
	public MemberDto getmember(int custno) {
		String sql = "select * from xe.member_tbl_02 where custno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custno);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto dto =new MemberDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
				return dto;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
	
	public boolean update(MemberDto memberDto) {
		String sql = "update xe.member_tbl_02 set custname=?, phone=?, address=?, joindate=?,grade=?,city=? where custno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getCustname());
			ps.setString(2, memberDto.getPhone());
			ps.setString(3, memberDto.getAddress());
			ps.setString(4, memberDto.getJoindate());
			ps.setString(5, memberDto.getGrade());
			ps.setString(6, memberDto.getCity());
			ps.setInt(7, memberDto.getCustno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;
	}
	
	public ArrayList<MemberDto> getprice(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "select A.custno,A.custname, A.grade , sum(B.price) "
				+ "from xe.member_tbl_02 A "
				+ "join xe.money_tbl_02 B "
				+ "on A.custno = B.custno "
				+ "group by (A.custno) "
				+ "order by SUM(B.price) DESC";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setCustno(rs.getInt(1));
				memberDto.setCustname(rs.getString(2));
				memberDto.setGrade(rs.getString(3));
				memberDto.setSumprice(rs.getInt(4));
				list.add(memberDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}
}
