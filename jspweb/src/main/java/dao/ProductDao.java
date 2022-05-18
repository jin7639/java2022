package dao;

import java.util.ArrayList;

import dto.Category;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao {

	public ProductDao() {
		super();
	}
	
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getProductDao() {
		return productDao;
	}
	
/////////////////////////////////카테고리////////////////////////////////////////////////////
	//1.카테고리 등록 [C]
	public boolean csave(String cname) {
		
		String sql = "insert into category (cname) values ('"+cname+"')";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("1오류 "+ e);
		}
		return false;
	}
	
	//2.카테고리 호출 [R]
	public ArrayList<Category> getcategorylist() {
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(
						rs.getInt(1),
						rs.getString(2)
						);
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			System.out.println("오류 "+ e);
		}
		return null;
	}
	//3.카테고리 수정 [U]
	
	//4.카테고리 삭제 [D]
/////////////////////////////////제품////////////////////////////////////////////////////
	//1.제품 등록 [C]
	public boolean psave(Product product)	{
		
		String sql = "insert into product (pname, pprice, pdiscount, pimg, cno) values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getPprice());
			ps.setFloat(3, product.getPdiscount());
			ps.setString(4, product.getPimg());
			ps.setInt(5, product.getCno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("오류 "+ e);
		}
		return false;
	}
	//2.모든 제품 호출 [R]
	public ArrayList<Product> getproductlist(){
		ArrayList<Product> productlist = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product (
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getFloat(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7)
						);
				productlist.add(product);
			}
			return productlist;
		} catch (Exception e) {
			System.out.println("getproductlist : "+ e);
		}
		return null;
	}
	//3.개별 제품 호출 [R]
	public Product getproduct(int pno) {
		String sql = "select * from product where pno = " + pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Product product = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getFloat(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7)
						);
				return product;
			}
		} catch (Exception e) {
			System.out.println("sql오류 " + e);
		}
		return null;
	}
	//4.제품 수정 [U]
	
	//4-2. 제품 상태 변경
	public boolean activechange(int pno, int active) {
		
		String sql = "update product set pactive = "+active+" where pno = "+pno;
		
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("오류~!!! : "+ e);
		}
		
		return false;
	}
	
	//5.제품 삭제 [D]
////////////////////////////////재고////////////////////////////////////////////////////
	//1.재고 등록 [C]
	public boolean ssave( Stock stock ) {
		try {
			String sql = "insert into stock (scolor, ssize, samount, pno) values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, stock.getScolor());
			ps.setString(2,stock.getSsize());
			ps.setInt(3, stock.getSamount());
			ps.setInt(4, stock.getPno());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("ssave : "+ e);
		}
		return false;
	}
	
	//2.재고 호출 [R]
	public ArrayList<Stock> getStocklist(int pno) {
		ArrayList<Stock> stocklist = new ArrayList<Stock>();
		String sql = "select * from stock where pno = "+pno+" order by scolor asc , ssize desc ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Stock stock = new Stock (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7)
						);
				stocklist.add(stock);
			}
			return stocklist;
		} catch (Exception e) {
			System.out.println("getstocklist : "+ e);
		}
		return null;
	}
	
	//3.재고 수정 [U]
	public boolean stockupdate(int sno, int samount) {
		String sql = "update stock set samount = "+samount+" where sno="+sno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	//4.재고 삭제 [D]
	
}
