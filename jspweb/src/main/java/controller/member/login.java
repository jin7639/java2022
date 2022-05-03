package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		
		//2.객체화 -> 데이터가 적기 때문에 생략
		
		//3. DB처리
		int result = MemberDao.getMemberDao().login(mid, mpassword);
		
		//DB결과
		if( result == 1 ) {
			//로그인 성공시 세션처리 [세션 : 서버에 메모리 할당 -> 모든 페이지에서 동일한 메모리 사용 가능
			HttpSession session = request.getSession(); //Http 내장 세션 호출 [jsp에서는 생략(내장객체가 있음). 서블릿에서는 써야함]
			session.setAttribute("login", mid);
			response.sendRedirect("/jspweb/main.jsp");
		}else if (result == 2) { //아이디 비밀번호 다름
			response.sendRedirect("/jspweb/member/login.jsp?result=2");
			
		}else if (result == 3) { //DB오류
			response.sendRedirect("/jspweb/error.jsp");
			
		}
		doGet(request, response);
	}

}
