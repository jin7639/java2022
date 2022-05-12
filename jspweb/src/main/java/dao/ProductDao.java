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
		return null;
	}
	//3.개별 제품 호출 [R]
	public Product getproduct() {
		return null;
	}
	//4.제품 수정 [U]
	
	//5.제품 삭제 [D]
////////////////////////////////재고////////////////////////////////////////////////////
	//1.재고 등록 [C]
	public boolean ssave() {
		return false;
	}
	//2.재고 호출 [R]
	public ArrayList<Stock> getstocklist(){
		return null;
	}
	//3.재고 수정 [U]
	
	//4.재고 삭제 [D]
	
}
