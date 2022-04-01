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
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	//컨트롤에 입력된 데이터 가져오기
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwconfirm = txtpwconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	
    	//현재 날짜 가져오기
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date()); //현재날짜를 형식 변환
    	
    	// 유효성검사 [ 제한 ]
    		//1. id 중복 체크
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    	if (result2) {
    		lblconfirm.setText("사용중인 아이디입니다.");
			return;
		}
    	
    		//2. id 형식 체크
    	if (id.length() <4 || id.length() > 10 ) {
    		lblconfirm.setText("아이디는 4~10사이로 입력해주세요");
			return;
		}
    		//3. 비밀번호  형식 체크
    	if (pw.length() < 4 || pw.length() > 10) {
			lblconfirm.setText("비밀번호는 4~10사이로 입력해주세요");
			return;
		}
    		//4. 비밀번호  일치 체크
    	if (! pw.equals(pwconfirm)) { //패스워드와 패스워드 검사가 같지 않으면
    		lblconfirm.setText("비밀번호 다름");
    		return;
		}
    		//5. 이메일 체크
    if (email.indexOf("@") == -1 ) { //만약에 입력한 이메일에 @가 없으면
    	lblconfirm.setText("올바른 이메일 형식이 아닙니다(@포함)");
		return;
	}
    		//6. 주소 체크
    if (! (address.contains("시") && address.contains("구") && address.contains("동"))) {
    	lblconfirm.setText("시/구/동 형식으로 입력해주세요");
		return;
	}
    	//모든 유효성 검사 통과 시 DB에 저장
    		//1. 객체화
    	Member member = new Member(0, id, pw, email, address, 0, since);
    	// 2. DB 객체내 메소드 호출 
		boolean result = MemberDao. memberDao.signup(member);
		// 3. 확인 
		if( result ) {
			//1.메세지창 출력 [Alert : 메시지(알람) 클래스 ]
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림"); //메시지 제목 설정
			alert.setHeaderText("안산시 중고거래 가입을 환영합니다.");
			alert.setContentText("회원가입 성공");
			
			alert.showAndWait();
			//2.화면 전환 [ 로그인페이지 ]
			Login.instance.loadpage("/view/loginpane.fxml");
			
		}else {
			lblconfirm.setText("회원가입 실패 [관리자에게 문의]");
			return;
			
		}
    	
    }
	
}
