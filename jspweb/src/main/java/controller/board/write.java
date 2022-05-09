package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write") //url 정의 = 현재 클래스와 통신할 경로 설정
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//뷰에서 입력받은 것을 서블릿으로 매핑해서 http요청메소드 get으로 Request
			
		//저장경로 - 개발중인 프로젝트 경로
		// String uploadpath = "C:\\Users\\504\\git\\java2022\\jspweb\\src\\main\\webapp\\board\\upload";
		
		//서버폴더 경로
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload");
		//System.out.println("서버경로 : " + request.getSession().getServletContext().getRealPath("/upload"));
		//첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request, // 요청방식
				uploadpath,	//파일저장경로
				1024*1024*10 , //파일 최대 용량 허용 범위
				"UTF-8",	//인코딩 타입
				new DefaultFileRenamePolicy() //동일한 파일명이 있을 경우 자동 이름 변환
				);
		
		request.setCharacterEncoding("UTF-8");
		
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
			HttpSession session = request.getSession();
			String mid = (String) session.getAttribute("login");
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		//객체화
		Board board = new Board(0, btitle, bcontent, mno, 0, null, bfile, null);
	
		//DB처리
		boolean result = BoardDao.getBoardDao().write(board);
		
		//결과
		if (result) {
			response.sendRedirect("/jspweb/board/boardlist.jsp");
		}else {
			response.sendRedirect("/jspweb/board/boardwrite.jsp");
		}
	}
}
