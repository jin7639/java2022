package controller.board;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class Boardview implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		replytableshow();
		dto.Board board = controller.board.Board.board; //board 컨트롤내 테이블에서 선택된 객체 호출
		
		//각 컨트롤에 선택된 board의 데이터 설정하기
		lblwriter.setText("작성자 : "+board.getBwriter());
		lbldate.setText("작성일 : "+board.getBdate());
		lblview.setText("조회수 : "+board.getBview());
		txttitle.setText(board.getBtitle());
		txtcontent.setText(board.getBcontent());
		
		//만약에 작성자와 현재 로그인된 id가 동일하지 않으면
		if (! board.getBwriter().equals(Login.member.getMid())) {
			btndelete.setVisible(false); //버튼 숨기기
			btnupdate.setVisible(false); //false 숨기기 true 보이기
		}
		//text필드 컨트롤 수정 못하게 잠금처리
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
	}

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnrewrite;

    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblwriter;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private TableView<Reply> replytable;

    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/board/board.fxml");
    }
    
    //댓글 테이블 메소드
    public void replytableshow() {
    	//1. 현재 게시물 번호
    	int bnum = controller.board.Board.board.getBnum();
    	//2. 
    	ObservableList<Reply> replylist = BoardDao.boardDao.replylist( bnum );
		//3.
		TableColumn tc = replytable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("rnum"));
    
		tc = replytable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("rwriter"));

		tc = replytable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("rdate"));
    
		tc = replytable.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("rcontent"));
    
		//4. 테이블 뷰에 리스트 넣어주기
		replytable.setItems(replylist);
    
    }
    
    @FXML
    void accdelete(ActionEvent event) {
    	//1. 경고메시지 알림
    	Alert alert = new Alert( AlertType.CONFIRMATION);
		alert.setHeaderText("해당 게시글을 삭제하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait(); //showAndWait() 메소드의 반환타입 => 선택한 버튼
    	if (optional.get() == ButtonType.OK ) {//2. 확인버튼 눌렀을 때
			//3. 삭제 처리 진행
    		BoardDao.boardDao.delete(
    				controller.board.Board.board.getBnum());
    		Home.home.loadpage("/view/board/board.fxml");
		}
		
		//2. 확인 버튼 눌렀을 때
    	//3. 삭제 처리
    }

    @FXML
    void accrewrite(ActionEvent event) {
		//1. 컨트롤에 입력된 데이터 가져오기
    	String rcontent = txtrecontent.getText();
    	//2.현재 로그인된 정보에서 아이디 가져오기
    	String rwriter = Login.member.getMid();
    	//3.현재 테이블뷰에서 클릭된 게시물의 게시물 번호 가져오기
    	int bnum = controller.board.Board.board.getBnum();
    	//객체화
    	Reply reply = new Reply(0, rcontent, rwriter, null, bnum);
    	//DB처리
    	boolean result = BoardDao.boardDao.rwrite(reply);
    	if (result) {
			Alert alert = new Alert (AlertType.INFORMATION);
				alert.setHeaderText("댓글 등록 성공");
				alert.showAndWait();
				//댓글 입력창 초기화
				txtrecontent.setText("");
				replytableshow();
		}
    
    }

    
    
    
    
    boolean upcheck = true;
    @FXML
    void accupdate(ActionEvent event) {
    	
    	Alert alert = new Alert (AlertType.INFORMATION);
    	if (upcheck) {
	    	alert.setHeaderText("게시글 수정후 수정 완료 버튼을 눌러주세요");
	    	alert.showAndWait();
	    	txttitle.setEditable(true);
	    	txtcontent.setEditable(true);
	    	btnupdate.setText("수정완료");
	    	upcheck = false;
    	}else {
    		//db처리
    		BoardDao.boardDao.update(
    				controller.board.Board.board.getBnum(),
    				txttitle.getText(),
    				txtcontent.getText()
    				);
    		
    		alert.setHeaderText("수정이 완료되었습니다.");
    		alert.showAndWait();
    		txttitle.setEditable(false);
    		txtcontent.setEditable(false);
    		upcheck = true;
    		Home.home.loadpage("/view/board/board.fxml");
    	}
    }
	
}
