package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Cart;
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
	
	public ArrayList<Stock> getStockcolor(int pno) {
		ArrayList<Stock> stocklist = new ArrayList<Stock>();
		String sql = "select  distinct scolor from stock where pno = "+pno;
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
			System.out.println("stockupdate : " + e);
		}
		return false;
	}
	
	
	//4.재고 삭제 [D]
	
	
	
	///////////////////////찜하기///////////////////////
	public int saveplike (int pno, int mno) { 
		try {
			String sql = "select plikeno from plike where pno = "+pno+" and mno = "+mno;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {//존재하면
				sql = "delete from plike where plikeno = "+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 2;	//삭제
			}else {//존재하지 않으면
				sql = "insert into plike(pno,mno)values("+pno+","+mno+")";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 1;	//등록
			}
		} catch (Exception e) {
			System.out.println("saveplike : " + e);
			return 3;	//DB오류
		}
	}
	
	//해당 제품 찜하기 여부 확인
	public boolean getplike( int pno , int mno ) {
		String sql = "select * from plike where pno = "+pno+" and mno ="+mno;
		try { 
			ps = con.prepareStatement(sql); 
			rs = ps.executeQuery();
			if( rs.next() ) {
				return true;
			}
		}catch (Exception e) { 
			System.out.println("getplike : "+ e );
			} return false;
	}
	
	/////////////////////////////////////////장바구니///////////////////////////////////////////////
	public boolean savecart(Cart cart) {
		String sql = "select cartno from cart where sno = "+cart.getSno()+" and mno = "+cart.getMno();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next()) { //장바구니 내 동일한 제품이 존재하면 수량 업데이트
				sql = "update cart set samount = samount + "+cart.getSamount()+" , totalprice = totalprice + "+cart.getTotalprice()+" where cartno = " + rs.getInt(1);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			}else { //존재하지 않으면 등록
				sql = "insert into cart(samount, totalprice, sno, mno) values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cart.getSamount());
				ps.setInt(2, cart.getTotalprice());
				ps.setInt(3, cart.getSno());
				ps.setInt(4, cart.getMno());
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			System.out.println("savecart : " + e);
		}
		return false;
	}
	
/////////////////////////////////////////장바구니 출력///////////////////////////////////////////////
	public JSONArray getcart(int mno) {
		JSONArray jsonArray = new JSONArray();
		String sql = 
				"select  \r\n"
				+ "	A.cartno as 장바구니번호, \r\n"
				+ "    A.samount as 구매수량, \r\n"
				+ "    A.totalprice as 총가격, \r\n"
				+ "	B.scolor as 색상, \r\n"
				+ "	B.ssize as 사이즈,\r\n"
				+ "    B.pno as 제품번호,\r\n"
				+ "    C.pname as 제품명,\r\n"
				+ "    C.pimg as 제품이미지\r\n"
				+ "from cart A \r\n"
				+ "join stock B on A.sno = B.sno \r\n"
				+ "join product C on B.pno = C.pno \r\n"
				+ "where A.mno = "+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("cartno", rs.getInt(1));
				object.put("samount", rs.getInt(2));
				object.put("totalprice", rs.getInt(3));
				object.put("scolor", rs.getString(4));
				object.put("ssize", rs.getString(5));
				object.put("pno", rs.getInt(6));
				object.put("pname", rs.getString(7));
				object.put("pimg", rs.getString(8));
				jsonArray.put(object);
			}
			return jsonArray;
		} catch (Exception e) {
			System.out.println("getcart : " + e);
		}
		return null;
	}
}
