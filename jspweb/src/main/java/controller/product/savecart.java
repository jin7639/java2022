package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Cart;
import dto.Stock;

/**
 * Servlet implementation class savecart
 */
@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt( request.getParameter("pno"));
		String data = request.getParameter("json");
		
		String mid = (String)request.getSession().getAttribute("login");
				int mno = MemberDao.getMemberDao().getmno(mid);
				
		try {
			JSONArray jsonArray = new JSONArray(data);
			int error = -1;
			int i = 0;
			for (i = 0; i < jsonArray.length(); i++) {
				JSONObject JsonObjcet = jsonArray.getJSONObject(i);
				
				
				
				int amount = Integer.parseInt(JsonObjcet.get("amount").toString());
				int totalprice = Integer.parseInt(JsonObjcet.get("total_price").toString());
				
				String color = JsonObjcet.get("color").toString();
				
				String size = JsonObjcet.get("size").toString();
				
				//sno 구하기
				int sno = 0;
				
				ArrayList<Stock>list = ProductDao.getProductDao().getStocklist(pno);
				for (Stock stock : list) {
					if( stock.getSsize().equals(size) && stock.getScolor().equals(color) ) {
						sno = stock.getSno();
					}
				}
				Cart cart = new Cart(0 ,amount, totalprice, sno, mno);
				
				boolean result = ProductDao.getProductDao().savecart(cart);
				if(result == false) {
					error = i;
				}
			}
			if(error == -1) {
				response.getWriter().print(-1);
			}else {
				response.getWriter().print(i);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
