package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.directory.SearchControls;

import dto.Product;

public class ProductDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ProductDao productDao = new ProductDao();
	
	public ProductDao () {
		try {
			// DB연동 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB 드라이버 가져오기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234"); // 2. DB 주소 연결 
		} catch (Exception e) {
			System.out.println("DB연동 오류" +  e);
		}
	}
	
	//1. 제품 등록
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
			System.out.println("등록오류" + e);
		}
		return false;
	}
	//2. 제품 출력
	public ArrayList<Product> list(String category , String search) {
		ArrayList<Product> productlist = new ArrayList<>();
		try {
			String sql = null;
			if (category == null && search == null) { //모든 제품 불러오기
				sql = "select * from product";
				ps = con.prepareStatement(sql);
			}
			else if (search == null) {
				sql = "select * from product where pcategory=? order by pnum desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, category);
			}
//			다시 전체목록 불러오기 어떻게 하는거지??
//			else if (category == null) {
//				sql = "select * from product  order by pnum desc";
//				ps = con.prepareStatement(sql);
//			}
			else {
				sql = "select * from product where pcategory=? and pname like '%"+search+"%' order by pnum desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, category);
			}
			
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
			System.out.println("sql오류 " + e);
		}
		return null;
	}
	//3. 제품 조회
	
	//4. 제품 삭제
	public boolean delete(int pnum) {
		
		try {
			String sql = "delete from product where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("sql 오류" + e);
		}
		return false;
	}
	
	
	//5. 제품 수정
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
		}catch(Exception e ) { System.out.println( "SQL 오류 33"+e  ); }
		return false;
		
	}
	
	//상태변경
	public boolean activation(int pnum) {
		try {
			
			String sql = "select pactivation from product where pnum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String upsql = null;
				if (rs.getInt(1) == 1) {
					upsql = "update product set pactivation = 2 where pnum=?";
				}else if (rs.getInt(1) == 2) {
					upsql = "update product set pactivation = 3 where pnum=?";
					
				}else if (rs.getInt(1) == 3) {
					upsql = "update product set pactivation = 1 where pnum=?";
					
				}else {
					
				}
				ps = con.prepareStatement(upsql);
				ps.setInt(1, pnum);
				ps.executeUpdate();
				return true;
				
			}
		} catch (Exception e) {
			System.out.println("sql 오류100 " + e);
		}
		return false;
	}
	
	
	
}
