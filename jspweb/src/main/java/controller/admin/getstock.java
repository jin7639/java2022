package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class getstock
 */
@WebServlet("/admin/getstock")
public class getstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getstock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pno = Integer.parseInt(request.getParameter("pno"));
		String field = request.getParameter("field");
		
		ArrayList<Stock> list = ProductDao.getProductDao().getStocklist(pno);
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String html = "";
		
		if(field != null && field.equals("amount") ) {
			String scolor = request.getParameter("scolor");
			String ssize = request.getParameter("ssize");
			for(Stock temp : list) {
				if(temp.getScolor().equals(scolor) && temp.getSsize().equals(ssize)) {
					out.print (temp.getSamount()+","+temp.getUpdatedate());
				}
			}
		}else {
			for (Stock temp : list) {
				html += 
						"<tr>" +
								"<td> "+temp.getScolor()+" </td>" +
								"<td> "+temp.getSsize()+" </td>" +
								"<td> "+temp.getSamount()+" </td>" +
								"<td>"+
									"<button onclick=\'showupdate("+temp.getSno()+")\'>수정</button>"+
								"</td>" +
								"<td>"+
									"<button>삭제</button>"+
								"</td>" +
								"</tr>";
			}
			out.print (html);
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
