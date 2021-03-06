package app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		//5. 컨테이너 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		//6.씬 객체 ->컨테이너
		Scene scene = new Scene(parent);
		//7.씬 -> 스테이지
		stage.setScene(scene);
		//3.스테이지 로고 설정
			//1.이미지 불러오기
		Image image = new Image("/img/icon.png");
			//절대 경로 vs 상대경로
			//절대 경로 : 모든 경로
				//C:\Users\504\git\java2022\Javafx2\src\img\파일명.확장자
			//상대 경로 : 현 위치[현재 프로젝트 기준 src] 기준 경로
				// /img/파일명.확장자
		
		//외부폰트 설정
			//1.폰트 가져오기
		Font.loadFont(getClass().getResourceAsStream("LeeSeoyun.ttf"), 20);
			//2. 외부 스타일시트 적용
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
			//2.스테이지 설정
		stage.setResizable(false); //스테이지 크기 고정
		stage.getIcons().add(image); //스테이지 아이콘 설정
		
		stage.setTitle("EZEN"); //스테이지 창 이름
		stage.show(); //1.스테이지 열기
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
