package application;

<<<<<<< HEAD
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application{
					//��� : [ Application : JAVAFX GUI ����Ŭ����]
						//��� ������ ���� Ŭ���� �� ����� ����� �� �ִ�.
	
	@Override
	public void start(Stage stage) throws Exception {
		//javafx �����ϴ� �޼ҵ� [����]		
			//start(Stage �������� �̸�)
		//1.�����̳� ����� [������ ��Ʈ�� ���η� ����]
		VBox box = new VBox();
			//2. ��Ʈ�� �����
		Button button = new Button();
		button.setText("�ݱ�");
		button.setOnAction(e -> Platform.exit()); //�� -> �μ� ���ٽ� (�̸��� ���� �޼ҵ�)
		
		//3.�����̳ʿ� ��Ʈ�� �ֱ�
		box.getChildren().add(button);
=======
import java.awt.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application{
					//��� : [ Application : JAVAFX GUI ����Ŭ����]
						//��� ������ ���� Ŭ���� �� ����� ����� �� �ִ�.
	
@Override
	public void start(Stage stage) throws Exception {
		//javafx �����ϴ� �޼ҵ� [����]		
			//start(Stage �������� �̸�)
		//1.�����̳� ����� [������ ��Ʈ�� ���η� ����]
		VBox box = new VBox();
			//2. ��Ʈ�� �����
		Button button = new Button();
		button.setText("�ݱ�");
		button.setOnAction(e ->)
		
		//3.�����̳ʿ� ��Ʈ�� �ֱ�
		box.getChildren().add(button)
>>>>>>> branch 'master' of https://github.com/jin7639/java2022
		//4.�� ��ü ���� �þ� (�����̳� �ֱ�)
		Scene ��� = new Scene(box, 500, 500); //�����̳� �̸�, ���α���, ���α���
		//5.���������� �� �ֱ�
		stage.setScene(���);
		stage.show(); //�������� ����
		//���� : �������� -> �� -> �����̳� ->�������� ��Ʈ��(��ư, �Է»��� ǥ ��)
	}
	public static void main(String[] args) { //���� ������ ������ �ִ� �޼ҵ�
		launch(args); //start �޼ҵ� ȣ��
	}
}