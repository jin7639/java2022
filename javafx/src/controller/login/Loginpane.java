package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Loginpane implements Initializable {

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	
		@FXML
	    private TextField txtid;

	    @FXML
	    private PasswordField txtpw;

	    @FXML
	    private Button btnlogin;

	    @FXML
	    private Button btnsignup;

	    @FXML
	    private Button btnfindid;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    private Button btnfindpw;

	    @FXML
	    void accfindid(ActionEvent event) {
	    	System.out.println("���̵�ã�� �������� �̵�");
	    	Login.instance.loadpage("/view/findidpane.fxml");
	    }

	    @FXML
	    void accfindpw(ActionEvent event) {
	    	System.out.println("��й�ȣ ã�� �������� �̵�");
	    	Login.instance.loadpage("/view/findpwpane.fxml");
	    }

	    @FXML
	    void accsignup(ActionEvent event) {
	    	System.out.println("ȸ������ �������� �̵�");
	    	//ȸ������ ��ư�� ������ login ��Ʈ�� Ŭ���� �� borderpane �����̳� center ������ ����
	    	//���� : �ٸ� Ŭ������ �����̳� ȣ��
	    		//Login login = new Login(); // ���ο� �����̳� ���� [x]
	    		//login.loadpage("/view/signuppane.fxml"); // [x]
	    	//�ذ��� : ���� �����̳� �������� ��� -> this
	    	Login.instance.loadpage("/view/signuppane.fxml");
	    	
	    }

	    @FXML
	    void login(ActionEvent event) {
	    	//1.��Ʈ�ѿ� �Էµ� �� ��������
	    	String id = txtid.getText();
	    	String password = txtpw.getText();
	    	
	    	//2.DB��ü �� �޼ҵ� ȣ��
	    	boolean result = MemberDao.memberDao.login(id, password);
	    	//3.��� Ȯ��
	    	if (result) {
				//������ ��ȯ
	    		//�׽�Ʈ
	    		lblconfirm.setText("�α��� ����");
			}else {
				lblconfirm.setText("������ ȸ�������� �����ϴ�.");
				
			}
	    	
	    	System.out.println("�α���ó��");
	    }
	
}