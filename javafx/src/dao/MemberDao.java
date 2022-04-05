package dao;

import java.io.FileOutputStream;
import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.cj.QueryReturnType;

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
			System.out.println("SQL���� "+e);
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
		//3.SQL ����
		rs = ps.executeQuery();
		
		//4.SQL ���
		try {
			//���� ��¥ ��������
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    	String logindate = format.format(new Date()); //���糯¥�� ���� ��ȯ
	    	
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (rs.next()) {
			return true; //���̵� ��й�ȣ ���� ->�α��� ����
//			
			
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL���� " + e);
		}
		
		return false; //�α��� ����
	}
	
		
	
	public void lastlogin(String id) {
		
		//1.���� ��¥ ��������
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date()); //���糯¥�� ���� ��ȯ
		
//		//2.��ü
//		��ǰ ��ǰ = new ��ǰ(��ǰ��, ���, ����);

//		//4.����ó��
		try {//����[����]�� �߻��� �� ���� �ڵ� ����					//���ϰ��		,�̾�� = true[�ɼ�]
		FileOutputStream outputStream = new FileOutputStream("D:/lastlogin.txt", true);
		String datetxt = id + "," +since;
		outputStream.write(datetxt.getBytes());	//���ڿ� ->����Ʈ��
		}catch (Exception e) {//����[����] ó��[���] : Exception Ŭ����
			System.out.println("���� ���� "+ e);
		}
		System.out.println("��¥ ���� �Ϸ�");
		
	}
		//3.���̵� ã��
	public String findid(String email) {
		try {
			//���̵�ã�� �� DB����
				//�Է��� �̸����� �����ϸ� �޽���[�˶�]�� ã�� ���̵� �˷��ֱ�
			//1.SQL �ۼ�
			String sql = "select * from member where memail = ?";
			//2.SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			//3.SQL ����
			rs = ps.executeQuery();
			//4.SQL ���
			if (rs.next()) {
				return rs.getString(2);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���̵�ã�� ���� " + e);
		}
		return null;
	}
		//4.��й�ȣ ã��
	public String findpw (String id , String email) {
		try {
		//�н�����ã�� �� DB����
			//�Է��� ���̵�, �̸��� �����ϸ� �޽���[�˶�]�� ã�� ��й�ȣ �˷��ֱ�
		//1.SQL �ۼ�
		String sql = "select * from member where mid = ? and memail=?";
		//2.SQL ����
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, email);
		//3.SQL ����
		rs = ps.executeQuery();
		
		//4.SQL ���
		if (rs.next()) {
			return rs.getString(3);
			
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���̵�ã�� ���� " + e);
		}
		return null;
	
	}	
	
	//5. ���̵� �μ��� ȸ������ ȣ��
	public Member getMember(String id) {
		try {
			//1. SQL �ۼ�
				String sql = "select * from member where mid=?";
			//2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			//3. SQL ����
			rs = ps.executeQuery();
			//4. SQL ���
			if (rs.next()) {
				//1.��ü ����
				Member member = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						//rs.next() : ����� ���� ���ڵ�(��, ����)
						//rs.getInt (�ʵ���� ��ȣ) : �ش� �ʵ��� �ڷ��� ���������� ��������
						//rs.getString(�ʵ���� ��ȣ) : �ش� �ʵ� �ڷ��� ���ڿ��� ��������
						
						);
				//2.��ȯ
				return member;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL ����321 " + e);
		}
		return null;
		
	}
	//6. ȸ��Ż�� [ȸ����ȣ�� �μ��� �޾� �ش� ȸ����ȣ�� ���ڵ� ����]
	public boolean delete(int num) {
		try {
			
			//1. SQL �ۼ�
			String sql = "delete from member where mnum=?";
			//2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			//3. SQL ����
			ps.executeUpdate();
			//4. SQL ���
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL ���� "+ e);
		}
		return false;
	}
	
	//7. ȸ�� ���� [ ȸ����ȣ. �̸���, �ּ� �μ��� �޾Ƽ� ���� ]
	public boolean update( int num, String email, String address ) {
		try {
			
		//1. SQL �ۼ�
			//���� : update ���̺�� set �ʵ��1=������1, �ʵ��2=������2 where ����
		String sql = "update member set memail=?, maddress=? where mnum = ? ";
		//2. SQL ����
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, address);
		ps.setInt(3, num);
	
		//3. SQL ����
		ps.executeUpdate();
		//4. SQL ���
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sql���� " +  e);
		}
		return false;
	}
	
}
