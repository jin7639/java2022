package controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Signuppane implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		
		
	}
	
	@FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpw;

    @FXML
    private PasswordField txtpwconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtaddress;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	//��Ʈ�ѿ� �Էµ� ������ ��������
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwconfirm = txtpwconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	
    	//���� ��¥ ��������
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date()); //���糯¥�� ���� ��ȯ
    	
    	// ��ȿ���˻� [ ���� ]
    		//1. id �ߺ� üũ
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    	if (result2) {
    		lblconfirm.setText("������� ���̵��Դϴ�.");
			return;
		}
    	
    		//2. id ���� üũ
    	if (id.length() <4 || id.length() > 10 ) {
    		lblconfirm.setText("���̵�� 4~10���̷� �Է����ּ���");
			return;
		}
    		//3. ��й�ȣ  ���� üũ
    	if (pw.length() < 4 || pw.length() > 10) {
			lblconfirm.setText("��й�ȣ�� 4~10���̷� �Է����ּ���");
			return;
		}
    		//4. ��й�ȣ  ��ġ üũ
    	if (! pw.equals(pwconfirm)) { //�н������ �н����� �˻簡 ���� ������
    		lblconfirm.setText("��й�ȣ �ٸ�");
    		return;
		}
    		//5. �̸��� üũ
    if (email.indexOf("@") == -1 ) { //���࿡ �Է��� �̸��Ͽ� @�� ������
    	lblconfirm.setText("�ùٸ� �̸��� ������ �ƴմϴ�(@����)");
		return;
	}
    		//6. �ּ� üũ
    if (! (address.contains("��") && address.contains("��") && address.contains("��"))) {
    	lblconfirm.setText("��/��/�� �������� �Է����ּ���");
		return;
	}
    	//��� ��ȿ�� �˻� ��� �� DB�� ����
    		//1. ��üȭ
    	Member member = new Member(0, id, pw, email, address, 0, since);
    	// 2. DB ��ü�� �޼ҵ� ȣ�� 
		boolean result = MemberDao. memberDao.signup(member);
		// 3. Ȯ�� 
		if( result ) {
			//1.�޼���â ��� [Alert : �޽���(�˶�) Ŭ���� ]
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("�˸�"); //�޽��� ���� ����
			alert.setHeaderText("�Ȼ�� �߰�ŷ� ������ ȯ���մϴ�.");
			alert.setContentText("ȸ������ ����");
			
			alert.showAndWait();
			//2.ȭ�� ��ȯ [ �α��������� ]
			Login.instance.loadpage("/view/loginpane.fxml");
			
		}else {
			lblconfirm.setText("ȸ������ ���� [�����ڿ��� ����]");
			return;
			
		}
    	
    }
	
}
