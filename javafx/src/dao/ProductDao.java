package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;

public class ProductDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ProductDao productDao = new ProductDao();
	
	public ProductDao () {
		try {
			// DB���� 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB �ּ� ���� 
		} catch (Exception e) {
			System.out.println("DB���� ����" +  e);
		}
	}
	
	//1. ��ǰ ���
	public boolean add(Product product) {
		try {
			String sql = "insert into product(pname,pimg,pcontent,pcategory,pprice,pactivation,mnum) values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimg());
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPactivation());
			ps.setInt(7, product.getMnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("��Ͽ���" + e);
		}
		return false;
	}
	//2. ��ǰ ���
	public ArrayList<Product> list() {
		ArrayList<Product> productlist = new ArrayList<>();
		try {
		String sql = "select * from product";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			Product product = new Product(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getInt(6),
					rs.getInt(7),
					rs.getString(8),
					rs.getInt(9)
					);
			productlist.add(product);
		}
		return productlist;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sql���� " + e);
		}
		return null;
	}
	//3. ��ǰ ��ȸ
	
	//4. ��ǰ ����
	public boolean delete(int pnum) {
		
		try {
			String sql = "delete from product where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("sql ����" + e);
		}
		return false;
	}
	
	
	//5. ��ǰ ����
	public boolean update( Product product ) {
		
		try {
			String sql = "update product set pname=? , pimg=? , pcontent=?,pcategory=? , pprice=? where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setString( 1 , product.getPname() );
			ps.setString( 2 , product.getPimg() );
			ps.setString( 3 , product.getPcontent() );
			ps.setString( 4 , product.getPcategory() );
			ps.setInt( 5 , product.getPprice() );
			ps.setInt( 6 , product.getPnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e ) { System.out.println( "[SQL ����]"+e  ); }
		return false;
		
	}
	
	
}
