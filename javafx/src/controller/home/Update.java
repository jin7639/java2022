package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Update implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtemail.setText(Login.member.getMemail());
		txtaddress.setText(Login.member.getMaddress());
	}
	
	@FXML
	private TextField txtemail;
	
	@FXML
	private TextField txtaddress;
	
	@FXML
	private Button btnupButton;
	
	@FXML
	private void update ( ActionEvent e) {
		//1. ��Ʈ�ѷ� �Է��� ������ ��������
		String email = txtemail.getText();
		String address = txtaddress.getText();
		//2. ������Ʈó�� 
		boolean result = MemberDao.memberDao.update(Login.member.getMnum(), email, address);
		if (result) {
			Alert alert = new Alert( AlertType.INFORMATION);
			alert.setHeaderText("ȸ�������� �����Ǿ����ϴ�. �ٽ� �α������ּ���");
			alert.showAndWait();
			Main.instance.loadpage("/view/login/login.fxml");
			Login.member = null;
			
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("ȸ������ ���� ����");
			alert.showAndWait();
		}
	}
	
	
}
