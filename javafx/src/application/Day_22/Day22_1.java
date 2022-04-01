package application.Day_22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Day21 [javafx]
		//javafx 사용 설정
			//1.javafx 설치
			//2.javafx 프로젝트 설정
			//3.프로젝트내 javafx 라이브러리 추가
			//4.라이브러리 연결 설정


public class Day22_1 extends Application {
					// Application 상속받기
	//1.오버라이딩 [start : javafx 실행]
	@Override
	public void start(Stage 스테이지) throws Exception {
		//1.씬빌더에서 작성한 파일을 객체로 가져오기
		Parent parent = FXMLLoader.load(getClass().getResource("DBtest.fxml"));
		//2.씬 객체를 만들어서 가젼온 fxml 객체를 넣어준다.
		Scene scene = new Scene(parent);
		//3.컨테이너
		스테이지.setScene(scene);
		
		스테이지.show();
		
	}
	
	//2. main메소드 선언
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
