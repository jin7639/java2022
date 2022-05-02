package dao;

import dto.member;

public class MemberDao extends Dao{
	
	public MemberDao() {
		super();
	}
	
	public static MemberDao memberDao = new MemberDao();		//dao 호출시 반복되는 new 연산자
	public static MemberDao getMemberDao() {return memberDao;}

	public boolean idcheck (String mid) {
		String sql = "select * from member where mid = " + mid;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	

	
	public boolean signup(member member) {
		try {
		//1.sql 작성
		String sql = "insert into member(mid, mpassword, mname, memail, maddress) values(?,?,?,?,?)";
		//2.sql 연결
		
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMemail());
			ps.setString(5, member.getMaddress());
			ps.executeUpdate();
			System.out.println("회원가입");
			return true;
			
		}catch (Exception e) {
			System.out.println("오류 " +e);
		}
		return false;
		
	}
	
	
}
