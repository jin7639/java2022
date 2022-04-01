package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;


	
public class MemberDao { // DB ���ٰ�ü
		
		private Connection con; // DB������ ���Ǵ� Ŭ���� : DB����Ŭ����
		private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
		private ResultSet rs; // ������� �����ϴ� �������̽� 
		
		public static MemberDao memberDao = new MemberDao(); // DB ���� ��ü;
		
		public MemberDao() {
			try {
				// DB���� 
				Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
						"root","1234"); // 2. DB �ּ� ���� 
			}
			catch(Exception e ) { System.out.println( "[DB ���� ����]"+e  ); }
		}
	
	

	
	//�޼ҵ�
		//���̵� �ߺ�üũ �޼ҵ� (�μ� : ���̵� �μ��� �޾� db�� �����ϴ��� üũ)
		public boolean idcheck (String id) {
			try {
				//1.sql �ۼ�
				//�˻� : select * from ���̺�� where ���� (�ʵ��=��)
				String sql = "select * from member where mid=?";
				
				//2.Sql ����
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				//3. SQL ����
				rs = ps.executeQuery();
				//4.SQL ���
				if (rs.next()) {//���࿡ ���� ������� �����ϸ� => �ش� ���̵� ���� -> �ߺ� O
					return true; //�ش� ���̵�� �ߺ��� ����
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println( "[SQL ����]"+e  );
			}
			return false;
		}
		
		//1.ȸ������ 
		
	public boolean signup (Member member) {
		try {
		
			//1.SQL �ۼ�
			String sql = "insert into member(mid , mpassword, memail,maddress, mpoint, msince)values(?,?,?,?,?,?)";
			//2.SQl ����
			ps = con.prepareStatement(sql);
			ps.setString(1,member.getMid()); //1�� ?�� ���̵� �־��ֱ�
			ps.setString(2,member.getMpassword()); //2�� ?�� ��й�ȣ �־��ֱ�
			ps.setString(3,member.getMemail()); //3�� ?�� �̸��� �־��ֱ�
			ps.setString(4,member.getMaddress()); //4�� ?�� �ּ� �־��ֱ�
			ps.setInt(5,member.getMpoint()); //5�� ?�� ����Ʈ �־��ֱ�
			ps.setString(6,member.getMsince()); //6�� ?�� ������ �־��ֱ�
			//3.SQL ����
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL����"+e);
			return false;
		}
	}
		//2.�α���
	public boolean login (String id, String password) {
		try {
			
		
		//1.SQL �ۼ�
			
			//������ and : ���� and ����
		String sql = "select * from member where mid = ? and mpassword=?";
		
		//2.SQL ����
		
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, password);
		//3.SQL ����\
		rs = ps.executeQuery();
		
		//4.SQL ���
		if (rs.next()) {
			return true; //���̵� ��й�ȣ ���� ->�α��� ����
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL����" + e);
		}
		
		return false; //�α��� ����
	}
		//3.���̵�
	public String findid(String email) {
		return null;
	}
		//4.��й�ȣ
	public String findpassword (String id , String email) {
		return null;
	}
	
	
	
}
