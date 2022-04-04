package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Home implements Initializable {
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblloginid.setText(Login.member.getMid());
		lblpoint.setText("포인트 : " + Login.member.getMpoint());
		
		
	}
	
	@FXML //로그아웃 레이블 클릭시
	public void logout(MouseEvent e) {
		//1.Login 정보 지우기
		Login.member = null;
		//2.페이지 전환
		Main.instance.loadpage("/view/login/login.fxml");
	}
	
}
