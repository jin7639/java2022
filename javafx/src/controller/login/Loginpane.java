package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
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
			lblconfirm.setText(""); 
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
	    	Login.instance.loadpage("/view/login/findidpane.fxml");
	    }

	    @FXML
	    void accfindpw(ActionEvent event) {
	    	System.out.println("비밀번호 찾기 페이지로 이동");
	    	Login.instance.loadpage("/view/login/findpwpane.fxml");
	    }

	    @FXML
	    void accsignup(ActionEvent event) {
	    	System.out.println("회원가입 페이지로 이동");
	    	//회원가입 버튼을 누르면 login 컨트롤 클래스 내 borderpane 컨테이너 center 페이지 변경
	    	//문제 : 다른 클래스내 컨테이너 호출
	    		//Login login = new Login(); // 새로운 컨테이너 생성 [x]
	    		//login.loadpage("/view/signuppane.fxml"); // [x]
	    	//해결방안 : 기존 컨테이너 가져오는 방법 -> this
	    	Login.instance.loadpage("/view/login/signuppane.fxml");
	    }

	    @FXML
	    void login(ActionEvent event) {
	    	//1.컨트롤에 입력된 값 가져오기
	    	String id = txtid.getText();
	    	String password = txtpw.getText();
	    	
	    	//2.DB객체 내 메소드 호출
	    	boolean result = MemberDao.memberDao.login(id, password);
	    	//3.결과 확인
	    	if (result) {
	    		
	    		//로그인 성공시 성공한 회원정보 저장 [로그아웃시 초기화]
	    		Login.member = MemberDao.memberDao.getMember(id);
				//페이지 전환
	    		Main.instance.loadpage("/view/home/home.fxml");
	    		System.out.println("로그인 성공");
			}else {
				lblconfirm.setText("동일한 회원정보가 없습니다.");
			}
	    }
}
