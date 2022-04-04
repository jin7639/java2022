package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {

	
	public static Main instance;
	public Main() {
		instance = this;
	}
	
	
	@FXML
    private BorderPane borderpane; //씬빌더에서 만든 컨테이너 객체
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("메인 뷰가 실행되었습니다.");	
		loadpage("/view/login/login.fxml");
		//main.fxml 열기 ->main.fxml 에 borderpane이 있음 -> borderpane 초기화 -> loadpage 실행 -> login 가운데에 실행
		
	}
	public void loadpage(String page) {
		try {
			//페이지(fxml) 객체화
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent); //컨테이너 (fxml) 가운데에 페이지 넣기
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("페이지 불러오기 실패 사유 : "+ e);
		}
	}
	
}
