package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

/**
 * Servlet implementation class delete
 */
@WebServlet("/board/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno =  Integer.parseInt( request.getParameter("bno"));
		
		//삭제 전에 파일명 가져오기
		Board board = BoardDao.getBoardDao().getboard(bno);
		String bfile = board.getBfile();

		boolean result = BoardDao.getBoardDao().delete(bno);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	//응답 파일타입 = html
		PrintWriter out = response.getWriter();//html로 내보내기 메소드
		// *java 에서 html 작성하기
		if (result) {
			//*삭제 성공시 해당 파일도 서버에서 지우기
			String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
			File file = new File(uploadpath);
			file.delete();
			
			//html로 내보내기
//			out.println("<html>");
//			out.println("<body>");
//			out.println("</body>");
//			out.println("</html>");
			//js로 내보내기
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 되었습니다.');");
			out.println("location.href='boardlist.jsp';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('해당 게시물 삭제 실패[관리자에게 문의]');");
			out.println("history.back();");
			out.println("</script>");
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
