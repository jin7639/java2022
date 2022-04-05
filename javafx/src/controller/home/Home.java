package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable {
	
	public static Home home;
	
	public Home() {
		home = this; //this :현재 클래스 메모리 호출
	}
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@FXML
	private Label lblinfo;
	
	@FXML
	private Label lbldelete;
	
	@FXML
    private BorderPane borderpane;
	
	@FXML
	private Label lblupdate;
	
	@FXML
	public void accupdate(MouseEvent e) {
		loadpage("/view/home/update.fxml");
	}
	
	@FXML
	private Label lblboard;
	
	@FXML
	public void accboard(MouseEvent e) {
		loadpage("/view/board/board.fxml");
		
	}
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("페이지 오류 " + e);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lblloginid.setText(Login.member.getMid() + " 님");
		lblpoint.setText("포인트 : " + Login.member.getMpoint());
		
		
	}
	
	@FXML //로그아웃 레이블 클릭시
	public void logout(MouseEvent e) {
		//1.Login 정보 지우기
		Login.member = null;
		//2.페이지 전환
		Main.instance.loadpage("/view/login/login.fxml");
	}
	
	@FXML
	public void delete(MouseEvent e) {
		
		//1.메시지
		Alert alert = new Alert(AlertType.CONFIRMATION); //확인, 취소 버튼 O
			alert.setHeaderText("정말 탈퇴 하시겠습니까?");
		//2.버튼 확인
		Optional<ButtonType> optional = alert.showAndWait(); //실행
		
		if ( optional.get() == ButtonType.OK ) { //확인버튼 눌렀을 때
			//회원 탈퇴 진행
			Boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
			
			if (result) { //탈퇴성공
				//로그아웃 [ Login 클래스내 Member 객체 null 오류 서정]
				Login.member = null;
				//페이지전환
				Main.instance.loadpage("/view/login/login.fxml");
				
			}else { //탈퇴 실패
				
			}
			
		}//아니면
		
	}
	@FXML
	public void accinfo (MouseEvent e) {
		loadpage("/view/home/info.fxml");
	}
	
}
