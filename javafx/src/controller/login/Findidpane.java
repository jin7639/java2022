package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Findidpane implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblconfirm.setText("");
		
	}
	
	@FXML
    private TextField txtemail;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    void back(ActionEvent event) {
    	Login.instance.loadpage("/view/loginpane.fxml");
    }

    @FXML
    void findid(ActionEvent event) {
    	//1.컨트롤에 입력된 값 가져오기
    	String email = txtemail.getText();
    	//2.DB객체 내 메소드 호출
    	boolean result = MemberDao.memberDao.findid(email);
    	//3.결과 확인
    	if (result) {
			//알람
    		
		}else {
			lblconfirm.setText("동일한 회원정보가 없습니다.");
			
		}
    	
    	
    }

}
