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
import dto.Category;

/**
 * Servlet implementation class getcategory
 */
@WebServlet("/admin/getcategory")
public class getcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청X
		ArrayList<Category> arraylist = ProductDao.getProductDao().getcategorylist();
		
		String type = request.getParameter("type");
		//자바에서 js(ajax)에게 html전송
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = "";

		if(type != null && type.equals("option")) {
			for( Category temp : arraylist) {
				html+="<option value=\""+temp.getCno()+"\">"+temp.getCname()+"</option>";
			}
		}else {
			int i = 1;
				//큰따옴표" 출력하려면 /"로 입력
			for( Category temp : arraylist) {
				html += "<input type=\"radio\" name=\"cno\" value=\""+temp.getCno()+"\">"+temp.getCname();
				if (i % 8 == 0) {
					html += "<br>";
				}
				i++;
			}
		}
		out.print (html);
	}
	
		
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
