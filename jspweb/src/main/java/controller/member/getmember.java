package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class getmember
 */
//localhost:8081/jspweb/member/getmember	URL 정의
@WebServlet("/member/getmember")
public class getmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = (String)request.getSession().getAttribute("login");
		Member member = MemberDao.getMemberDao().getmember(mid);
		
		try {
			JSONObject jsonobject = new JSONObject();
			jsonobject.put("mno", member.getMno());
			jsonobject.put("mid", member.getMid());
			jsonobject.put("mname", member.getMname());
			jsonobject.put("mphone", member.getMphone());
			jsonobject.put("memail", member.getMemail());
			jsonobject.put("maddress", member.getMaddress());
			jsonobject.put("mpoint", member.getMpoint());
			jsonobject.put("mdate", member.getMdate());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json"); //이거 안 넣으면 통신 불가
			response.getWriter().print(jsonobject); //jsonobject 전달
		} catch (Exception e) {
			System.out.println("오류" + e);
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
