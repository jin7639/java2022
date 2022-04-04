package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
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
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void findpw(ActionEvent event) {
    	//1.컨트롤에 입력된 값 가져오기
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	//2.DB객체 내 메소드 호출
    	String pw = MemberDao.memberDao.findpw(id, email);
    	//3.결과 확인
    	if (pw != null) {
    		
    		//이메일전송
    		Member.sendmail(email, pw);
    		
			//알람
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림"); //메시지 제목 설정
			alert.setHeaderText("해당 이메일로 비밀번호를 전송했습니다.");
			
			alert.showAndWait();
		}else {
			lblconfirm.setText("동일한 회원정보가 없습니다.");
			
		}
    }
	
}
