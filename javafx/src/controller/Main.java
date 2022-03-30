package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {

	
	 @FXML
    private BorderPane borderpane; //씬빌더에서 만든 컨테이너 객체
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("메인 뷰가 실행되었습니다.");	
		loadpage("/view/login");
	
	}
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page+".fxml"));
			borderpane.setCenter(parent); //컨테이너 (fxml) 가운데에 페이지 넣기
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("페이지 불러오기 실패 사유 : "+ e);
		}
	}
	
}
