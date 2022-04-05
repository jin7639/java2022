package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.BoardDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Board implements Initializable {


	
    @FXML
    private TableView<dto.Board> boardtable; //테이블에 넣을 자료형 선택 [테이블에 게시물 표시하기 위해]

    @FXML
    private Button btnwrite;

    public static dto.Board board;

	@FXML
    void accwrite(ActionEvent event) {
    	//home 클래스내 borderpane center 변경
    	Home.home.loadpage("/view/board/boardwrite.fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    	//1.db에서 모든 게시글 가져오기
    	ObservableList<dto.Board> boardliList = BoardDao.boardDao.list();
//    	System.out.println(boardliList.toString());
//    	//2.tableview에 추가
    	TableColumn tc = boardtable.getColumns().get(0);
//    		//TableColumn 테이블열
//    			//boardtable(fxid).getColumns().get(0); 첫번째 열 호출
    	tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
    	
    	tc = boardtable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
    	
    	tc = boardtable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bwriter"));
    	
    	tc = boardtable.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
    	
    	tc = boardtable.getColumns().get(4);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
    	
    	//3. tableview 에 list연결
    	boardtable.setItems(boardliList);
    		//테이블명(fxid).setItems
    
    	
    	//tableview 에서 해당 셀을 클랙했을 때 이벤트
    	boardtable.setOnMouseClicked( e ->  {
    		//1.테이블에서 클락한 객체를 임시객체에 저장
    		board = boardtable.getSelectionModel().getSelectedItem();
    		//2.조회수 증가
    		
    		//3.페이지 전환
    		System.out.println(board.getBtitle());
    		
    	});
    	// -> : 람다식 (익명함수 : 이름이 없는 함수 [인수와 실행코드만 존재]) 반복호출 불가(일회용)
    	// vs
    	// void 함수명(인수1) {실행코드} : 함수
    }
	
}
