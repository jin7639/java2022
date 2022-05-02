package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class idcheck
 */
@WebServlet("/idcheck")
public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public idcheck() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getParameter("UTF-8");
		String mid = request.getParameter("mid");
		
		// 1. Dao 와 통신해서 해당 id가 있는지 체크
		MemberDao.getMemberDao();
		boolean result = MemberDao.getMemberDao().idcheck(mid);
		// 2. 만약에 해당 아이디가 존재하면 1 존재하지 않으면 2
		if(result) {
			response.getWriter().println(1);
			
		}else {
			response.getWriter().println(2);
			
		}
		System.out.println("통신");
		System.out.println( mid ); // JS에서 데이터 가져오기 확인
		//요청할 때 request
		//응답할 때 response
			//ajax에게 데이터 보내기
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
