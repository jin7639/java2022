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
    private TableView<dto.Board> boardtable; //���̺� ���� �ڷ��� ���� [���̺� �Խù� ǥ���ϱ� ����]

    @FXML
    private Button btnwrite;

    public static dto.Board board;

	@FXML
    void accwrite(ActionEvent event) {
    	//home Ŭ������ borderpane center ����
    	Home.home.loadpage("/view/board/boardwrite.fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    	//1.db���� ��� �Խñ� ��������
    	ObservableList<dto.Board> boardliList = BoardDao.boardDao.list();
//    	System.out.println(boardliList.toString());
//    	//2.tableview�� �߰�
    	TableColumn tc = boardtable.getColumns().get(0);
//    		//TableColumn ���̺�
//    			//boardtable(fxid).getColumns().get(0); ù��° �� ȣ��
    	tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
    	
    	tc = boardtable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
    	
    	tc = boardtable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bwriter"));
    	
    	tc = boardtable.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
    	
    	tc = boardtable.getColumns().get(4);
    	tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
    	
    	//3. tableview �� list����
    	boardtable.setItems(boardliList);
    		//���̺��(fxid).setItems
    
    	
    	//tableview ���� �ش� ���� Ŭ������ �� �̺�Ʈ
    	boardtable.setOnMouseClicked( e ->  {
    		//1.���̺��� Ŭ���� ��ü�� �ӽð�ü�� ����
    		board = boardtable.getSelectionModel().getSelectedItem();
    		//2.��ȸ�� ����
    		
    		//3.������ ��ȯ
    		System.out.println(board.getBtitle());
    		
    	});
    	// -> : ���ٽ� (�͸��Լ� : �̸��� ���� �Լ� [�μ��� �����ڵ常 ����]) �ݺ�ȣ�� �Ұ�(��ȸ��)
    	// vs
    	// void �Լ���(�μ�1) {�����ڵ�} : �Լ�
    }
	
}
