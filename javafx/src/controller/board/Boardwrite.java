package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardwrite implements Initializable {

	 	@FXML
	    private TextField txttitle;

	    @FXML
	    private TextArea txtcontent;

	    @FXML
	    private Button btnwrite;

	    @FXML
	    private Button btnback;

	    @FXML
	    void accback(ActionEvent event) {
	    	Home.home.loadpage("/view/board/board.fxml");
	    }

	    @FXML
	    void accwrite(ActionEvent event) {
	    	//1.컨트롤에 입력된 데이터 가져오기
	    	String title = txttitle.getText(); //해당 fxid 객체에서 입력된 내용물 가져오기
	    	String content = txtcontent.getText();
	    		//작성자 : 현재 로그인된 객체는 login 클래스내 member객체에 저장되어있음
	    	String writer = Login.member.getMid();
	    	//2.객체화
	    	Board board = new Board(0, title, content, writer, null, 0 );
	    	//3.db저장
	    		//1.new 객체를 이용한 메소드 호출
	    		//BoardDao boardDao = new BoardDao();
	    		//boardDao.write(board);	
	    		//2.클래스내 static 변수 호출후 메소드 호출
	    		boolean result = BoardDao.boardDao.write(board);
	    		if (result) {
					//메시지
	    			Alert alert = new Alert( AlertType.INFORMATION);
	    				alert.setHeaderText("게시글이 작성되었습니다.");
	    				alert.showAndWait();
	    				
	    			//페이지 전환
    				Home.home.loadpage("/view/board/board.fxml");
				}else {
					Alert alert = new Alert( AlertType.INFORMATION);
    				alert.setHeaderText("게시글 작성 실패. 관리자에게 문의하세요.");
    				alert.showAndWait();
				}
	    }
	
	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    // TODO Auto-generated method stub
	    
	    }
}
