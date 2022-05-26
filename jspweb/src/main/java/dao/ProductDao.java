package dao;

import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Cart;
import dto.Category;
import dto.Order;
import dto.Orderdetail;
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
			System.out.println("2오류 "+ e);
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
			System.out.println("3오류 "+ e);
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
	
	//장바구니 업데이트 [수정]메소드
	public boolean updatecart(int cartno, int samount, int totalprice) {
		String sql = "update cart set samount = " + samount + " , totalprice = " + totalprice + " where cartno = "+cartno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("장바구니 오류 : "+ e);
		}
		return false;
	}
	
	//장바구니 삭제 메소드
	public boolean deletecart (int cartno) {
		String sql = "delete from cart where cartno = "+cartno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("장바구니 삭제 오류 : "+ e);
		}
		return false;
	}
	//  장바구니 개수 세기
	public int countcart (int mno) {
		int count = 0;
		String sql = "select count(*) from cart where mno = "+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("countcart : " + e);
		}
		return count;
	}
	/////////////////////////////////////////////주문/////////////////////////////////////////////
public boolean saveorder( Order order  ) {
		
		String sql = "insert into porder(ordername,orderphone,orderaddress,ordertotalpay,orderrequest,mno) values(?,?,?,?,?,?)";
		try { 
			ps = con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
			ps.setString( 1 , order.getOrdername() );
			ps.setString( 2 , order.getOrderphone() );
			ps.setString( 3 , order.getOrderaddress() );
			ps.setInt( 4 , order.getOrdertotalpay() );
			ps.setString( 5 , order.getOrderrequest() );
			ps.setInt( 6 , order.getMno() );
			ps.executeUpdate();		
			
			rs = ps.getGeneratedKeys(); // pk 값 호출 
			if( rs.next() ) {
				System.out.println( "pk값 : "+ rs.getInt(1) );
				int pk = rs.getInt(1);
				sql = "insert into porderdetail (samount, totalprice, orderno, sno) select samount, totalprice, "+pk+", sno from cart where mno = "+order.getMno();
				ps = con.prepareStatement(sql);
				ps.executeUpdate();	
				
				sql = "delete from cart where mno = "+order.getMno();
				ps = con.prepareStatement(sql);
				ps.executeUpdate();	
				return true;
			}
		}catch (Exception e) {
			System.out.println("saveorder : " + e);
		}
		return false;
	}
//주문내역 메소드
public JSONArray getorder( int mno ) {
	String sql ="SELECT "
			+ "	A.orderno as 주문번호 , "
			+ "    A.orderdate as 주문일 , "
			+ "    B.orderdetailno as 주문상세번호 , "
			+ "    B.orderdetailactive as 주문상세상태 , "
			+ "    B.samount as 주문상세수량 , "
			+ "    C.sno as 재고번호 , "
			+ "    C.scolor as 색상 , "
			+ "    C.ssize as 사이즈 , "
			+ "    D.pno as 제품번호 , "
			+ "    D.pname as 제품명 ,"
			+ "    D.pimg as 제품사진 "
			+ "FROM "
			+ "porder A JOIN porderdetail B on A.orderno = B.orderno "
			+ "JOIN STOCK C on B.sno = C.sno "
			+ "JOIN product D ON C.pno = D.pno where A.mno = "+mno+" order by A.orderno desc;";
	
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery(); 
			
				JSONArray parentlist = new JSONArray(); //상위리스트
				JSONArray childlist = new JSONArray();	//하위리스트

				int oldorderno = -1; //이전 데이터의 주문번호 변수 (비교하기 위해 만든 것)
				
				while( rs.next() ) {
					JSONObject jsonObject = new JSONObject();
					
					jsonObject.put( "orderno" , rs.getInt( 1 ) ) ;
					jsonObject.put( "orderdate" , rs.getString( 2 ) ) ;
					jsonObject.put( "orderdetailno" , rs.getInt( 3 ) ) ;
					jsonObject.put( "orderdetailactive" , rs.getInt( 4 ) ) ;
					jsonObject.put( "samount" , rs.getInt( 5 ) ) ;
					jsonObject.put( "sno" , rs.getInt( 6 ) ) ;
					jsonObject.put( "scolor" , rs.getString( 7 ) ) ;
					jsonObject.put( "ssize" , rs.getString( 8 ) ) ;
					jsonObject.put( "pno" , rs.getInt( 9 ) ) ;
					jsonObject.put( "pname" , rs.getString( 10 ) ) ;
					jsonObject.put( "pimg" , rs.getString( 11 ) ) ;
					
					//동일한 주문번호 이면 동일한 리스트에 담기
					
					if(oldorderno == rs.getInt(1)) {	//이전 주문번호와 현재 주문번호가 일치하면
						//하위 리스트 초기화 X
						childlist.put(jsonObject); //하위 리스트에 데이터 담기
					}else {
						childlist = new JSONArray(); //하위 리스트 초기화
						childlist.put(jsonObject); // 
						parentlist.put(childlist);
					}
					oldorderno = rs.getInt( 1 );
				}
				return parentlist;
			} catch (Exception e) {
				System.out.println("getorder : " + e);
			}
			return null;
}

public boolean cancelorder(int orderdetailno , int active) {
	
	try {
		String sql = "update porderdetail set orderdetailactive = "+active+" where orderdetailno = "+orderdetailno;
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
		return true;
	} catch (Exception e) {
		System.out.println("cancel : " + e);
	}
	return false;
}

public JSONArray getchart(int type,int value) {
							// value == sno
	String sql = "";
	JSONArray ja = new JSONArray();
	if (type == 1) {
		
		sql = "select substring_index(orderdate, ' ',1) as 날짜, "
					+ "sum(ordertotalpay) from porder "
					+ "group by 날짜 order by 날짜 desc";
	}else if( type == 2 ) {
		sql = "select sum(A.samount), D.cname "
				+ "from porderdetail A, stock B, product C, category D "
				+ "where A.sno = B.sno and B.pno = C.pno and C.cno = D.cno "
				+ "group by D.cname order by orderdetailno desc";
	}else if( type == 3 ) {//재고번호 - > 제품별 판매량 추이
		sql = "select"
				+ "	substring_index(A.orderdate , ' ',1) as 날짜,"
				+ "    B.samount "
				+ "from porder A, porderdetail B, stock C  "
				+ "where A.orderno = B.orderno  "
				+ "and B.sno = C.sno  "
				+ "and C.pno = (select pno from stock where sno = "+value+") "
				+ "group by 날짜 order by 날짜 desc";
	}
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			JSONObject jo = new JSONObject();
			if(type == 1 || type == 3) {
				jo.put("date", rs.getString(1));
				jo.put("value", rs.getInt(2));
				ja.put(jo);
				System.out.println(jo);
			}else if( type == 2 ){
				jo.put("value", rs.getInt(1));
				jo.put("category", rs.getString(2));
				ja.put(jo);
			}
		}
		return ja;
	} catch (Exception e) {
		System.out.println("getchart : " + e);
	}
	return null;
}
	
	//오늘 주문 상세 호출
	public ArrayList<Orderdetail> getorderdetail() {
		String sql = "select A.*, substring_index(B.orderdate , ' ' , 1)  as 날짜 "
				+ "from porderdetail A, porder B "
				+ "where A.orderno = B.orderno\r\n"
				+ "and substring_index(B.orderdate,' ', 1) = substring_index(now(),' ',1) "
				+ "and A.orderdetailactive = 3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<Orderdetail> list = new ArrayList<Orderdetail>();
			while (rs.next()) {
				Orderdetail orderdetail = new Orderdetail();
				orderdetail.setOrderdetailno(rs.getInt(1));
				orderdetail.setOrderdetailactive(rs.getInt(2));
				orderdetail.setSno(rs.getInt(3));
				orderdetail.setSamount(rs.getInt(4));
				orderdetail.setTotalprice(rs.getInt(5));
				orderdetail.setOrderno(rs.getInt(6));
				
				list.add(orderdetail);
			}
			return list;
		} catch (Exception e) {
			System.out.println("오늘 주문 상세 오류 : " + e);
		}
		return null;
	}
	
	
	
}
