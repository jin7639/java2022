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
		
		//1.db���� ��� �Խñ� �������� --> �ۼ��ڰ� �α��ξ��̵�� ���� �͸� ����
    	ObservableList<dto.Board> boardliList = BoardDao.boardDao.list();
    	
    		//�Խñ� �ۼ��� ��ȣ�� �α����� ȸ�� ��ȣ�� ��
    	
    	
    	
    	//2.tableview�� �߰�
    	TableColumn tc = mywritingtable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
    	
    	tc = mywritingtable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
    	
    	tc = mywritingtable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
    
    	//3. tableview �� list����
    	mywritingtable.setItems(boardliList);
    		
		
	}
	
	 @FXML
	 private Label lblid;

	 @FXML
	 private TableView<dto.Board> mywritingtable;

	 @FXML
	 private TableView<?> myproducttable;

	

	
}
