package app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		//3.�������� �ΰ� ����
			//1.�̹��� �ҷ�����
		Image image = new Image("/img/stage.jpg");
			//���� ��� vs �����
			//���� ��� : ��� ���
				//C:\Users\504\git\java2022\Javafx2\src\img\���ϸ�.Ȯ����
			//��� ��� : �� ��ġ[���� ������Ʈ ���� src] ���� ���
				// /img/���ϸ�.Ȯ����
			//2.�������� ����
		stage.setResizable(false); //�������� ũ�� ����
		stage.getIcons().add(image); //�������� ������ ����
		
		stage.setTitle("EZEN"); //�������� â �̸�
		stage.show(); //1.�������� ����
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}