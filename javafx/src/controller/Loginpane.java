package controller;

import java.net.URL;
import java.util.ResourceBundle;

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
	    	System.out.println("아이디찾기 페이지로 이동");
	    }

	    @FXML
	    void accfindpw(ActionEvent event) {
	    	System.out.println("비밀번호 찾기 페이지로 이동");
	    }

	    @FXML
	    void accsignup(ActionEvent event) {
	    	System.out.println("회원가입 페이지로 이동");
	    	//회원가입 버튼을 누르면 login 컨트롤 클래스 내 borderpane 컨테이너 center 페이지 변경
	    	//문제 : 다른 클래스내 컨테이너 호출
	    		//Login login = new Login(); // 새로운 컨테이너 생성 [x]
	    		//login.loadpage("/view/signuppane.fxml"); // [x]
	    	//해결방안 : 기존 컨테이너 가져오는 방법 -> this
	    	Login.instance.loadpage("/view/signuppane.fxml");
	    	
	    }

	    @FXML
	    void login(ActionEvent event) {
	    	
	    
	    	
	    	System.out.println("로그인처리");
	    }
	
}
