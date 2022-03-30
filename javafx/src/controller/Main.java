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
    private BorderPane borderpane; //���������� ���� �����̳� ��ü
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("���� �䰡 ����Ǿ����ϴ�.");	
		loadpage("/view/login");
	
	}
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page+".fxml"));
			borderpane.setCenter(parent); //�����̳� (fxml) ����� ������ �ֱ�
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("������ �ҷ����� ���� ���� : "+ e);
		}
	}
	
}
