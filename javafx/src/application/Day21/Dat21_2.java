package application.Day21;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dat21_2 extends Application{ //1. Application 클래스로부터 상속받기

	@Override
	public void start(Stage stage) throws Exception { //2. start 메소드 구현(오버라이드)
		
		//1.FXML 파일 불러오기 : 컨테이너
		Parent parent = FXMLLoader.load(getClass().getResource("test.fxml"));
			// Parent : fxmlLoader.load (getClass().getResource("경로/fxml파일명")
		//2. 씬 객체 생성 : 씬에 컨테이너 넣기
		Scene scene = new Scene(parent);
		//3. 스테이지에 씬 넣기
		stage.setScene(scene);
		//4. 스테이지 시작
		stage.show(); //스테이지 열기
	}
	public static void main(String[] args) {//3. 메인스레드 -> start 메소드 호출
		launch(args); //start 메소드 호출
	}
	
}
