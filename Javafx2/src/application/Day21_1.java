package application;

import java.awt.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application{
					//상속 : [ Application : JAVAFX GUI 관련클래스]
						//상속 받으면 슈퍼 클래느 새 멤버를 사용할 수 있다.
	
@Override
	public void start(Stage stage) throws Exception {
		//javafx 실행하는 메소드 [구현]		
			//start(Stage 스테이지 이름)
		//1.컨테이너 만들기 [여러개 컨트롤 세로로 저장]
		VBox box = new VBox();
			//2. 컨트롤 만들기
		Button button = new Button();
		button.setText("닫기");
		button.setOnAction(e ->)
		
		//3.컨테이너에 컨트롤 넣기
		box.getChildren().add(button)
		//4.씬 객체 만들어서 ㅓ씬 (컨테이너 넣기)
		Scene 장면 = new Scene(box, 500, 500); //컨테이너 이름, 가로길이, 세로길이
		//5.스테이지에 씬 넣기
		stage.setScene(장면);
		stage.show(); //스테이지 열기
		//순서 : 스테이지 -> 씬 -> 컨테이너 ->여러개의 컨트롤(버튼, 입력상자 표 등)
	}
	public static void main(String[] args) { //메인 스레드 가지고 있는 메소드
		launch(args); //start 메소드 호출
	}
}
