package dao;

import dto.Member;

public class MemberDao extends Dao{
	
	public MemberDao() {
		super();
	}
	
	public static MemberDao memberDao = new MemberDao();		//dao 호출시 반복되는 new 연산자
	public static MemberDao getMemberDao() {return memberDao;}

	public boolean idcheck (String mid) {
		String sql = "select * from member where mid = '"+mid+"'";
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
	

	
	public boolean signup(Member member) {
		try {
		//1.sql 작성
		String sql = "insert into member(mid, mpassword, mname, mphone, memail, maddress) values(?,?,?,?,?,?)";
		//2.sql 연결
		
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			ps.setString(6, member.getMaddress());
			ps.executeUpdate();
			System.out.println("회원가입");
			return true;
			
		}catch (Exception e) {
			System.out.println("오류 " +e);
		}
		return false;
		
	}
	//이메일 중복체크
	public boolean emailcheck (String email) {
		String sql = "select * from member where memail = '"+email+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sql오류 : " + e);
		}
		return false;
	}

	public int login(String mid, String mpassword) {
		String sql = "select * from member where mid = '"+mid+"' and mpassword = '"+mpassword+"'";
		//String sql = "select * from where mid = ? and mpassword = ?";
		try {
			ps = con.prepareStatement(sql);
			//ps.setString(1, mid);
			//ps.setString(2, mpassword);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {
			System.out.println("sql오류 : " + e);
		}
		return 3;
	}
	
	//회원정보 출력 [인수 : 세션에 저장된 회원id ]
	public Member getmember (String mid) {
		//String sql = "select * from member where mid = ? ";
		String sql = "select * from member where mid = '"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Member member = new Member(
						rs.getInt(1),
						rs.getString(2),
						null,
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getString(9)
						);
				return member;
			}
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		return null;
	}
	//패스워드 확인 메소드
	public boolean passwordcheck(String mid, String mpassword) {
		String sql = "select * from member where mid = '"+mid+"' and mpassword = '"+mpassword+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) return true;
		} catch (Exception e) {
			System.out.println("sql오류 "+ e);
		}
		return false;
	}

	public boolean delete(String mid) {
		String sql = "delete from member where mid = '"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}catch (Exception e) {
			System.out.println("sql오류 : "+ e);
		}

		return false;
	}

	public boolean update(Member member) {
		
		try {
			if(member.getMpassword() == null) {	//비밀번호 변경 X
				String sql = "update member set mname =?, mphone=?, memail=?, maddress=? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString( 1, member.getMname());
				ps.setString( 2, member.getMphone());
				ps.setString( 3, member.getMemail());
				ps.setString( 4, member.getMaddress());
				ps.setInt( 5, member.getMnum());
			}else {	//비밀번호 변경 O
				String sql = "update member set mname =?, mpassword =?, mphone=?, memail=?, maddress=? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getMname());
				ps.setString(2, member.getMpassword());
				ps.setString(3, member.getMphone());
				ps.setString(4, member.getMemail());
				ps.setString(5, member.getMaddress());
				ps.setInt(6, member.getMnum());
			}
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("sql오류 "+ e);
		}
		return false;
	}
	
	
	
	
	
}
