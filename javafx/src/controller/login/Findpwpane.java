package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findpwpane implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblconfirm.setText("");
	}
	
	

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpw;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtid;

    @FXML
    void back(ActionEvent event) {
    	Login.instance.loadpage("/view/loginpane.fxml");
    }

    @FXML
    void findpw(ActionEvent event) {
    	//1.��Ʈ�ѿ� �Էµ� �� ��������
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	//2.DB��ü �� �޼ҵ� ȣ��
    	boolean result = MemberDao.memberDao.findpw(id, email);
    	//3.��� Ȯ��
    	if (result) {
			//�˶�
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("�˸�"); //�޽��� ���� ����
			alert.setHeaderText("ȸ������ ��й�ȣ");
			alert.setContentText("");
			
			alert.showAndWait();
		}else {
			lblconfirm.setText("������ ȸ�������� �����ϴ�.");
			
		}
    }
	
}
