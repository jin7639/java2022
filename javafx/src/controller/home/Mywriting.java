package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Mywriting implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//1.db에서 모든 게시글 가져오기 --> 작성자가 로그인아이디와 같은 것만 고르기
    	ObservableList<dto.Board> boardliList = BoardDao.boardDao.list();
    	
    		//게시글 작성자 번호랑 로그인한 회원 번호랑 비교
    	
    	
    	
    	//2.tableview에 추가
    	TableColumn tc = mywritingtable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
    	
    	tc = mywritingtable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
    	
    	tc = mywritingtable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
    
    	//3. tableview 에 list연결
    	mywritingtable.setItems(boardliList);
    		
		
	}
	
	 @FXML
	 private Label lblid;

	 @FXML
	 private TableView<dto.Board> mywritingtable;

	 @FXML
	 private TableView<?> myproducttable;

	

	
}
