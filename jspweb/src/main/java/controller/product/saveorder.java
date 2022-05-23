package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Order;

/**
 * Servlet implementation class saveorder
 */
@WebServlet("/product/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
			
			String mid = (String)request.getSession().getAttribute("login");
			int mno = MemberDao.getMemberDao().getmno(mid);
			String json = request.getParameter("orderjson");
			JSONObject jsonobjet = new JSONObject(json);
			
			String ordername = jsonobjet.getString("ordername").toString();
			String orderphone = jsonobjet.getString("orderphone").toString();
			String orderaddress = jsonobjet.getString("orderaddress").toString();
			int ordertotalpay = jsonobjet.getInt("ordertotalpay"); //Integer.parseInt(jsonobjet.getString("ordertotalpay").toString());
			String orderrequest = jsonobjet.getString("orderrequest").toString();
		
			Order order = new Order(0, null, ordername, orderphone, orderaddress, ordertotalpay, 0, orderrequest, 0, mno);
			
			System.out.println(order.toString());
			
			//1. 주문 DB처리 [PK]
			Boolean result =  ProductDao.getProductDao().saveorder(order);
			System.out.println(result);
			//2. 주문 상세 DB처리 [cart -> orderdetail]
			response.getWriter().print(result);
		} catch (Exception e) {
			System.out.println("오류 : " + e);
		}
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
}
