package application.Day_22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DBtest컨트롤러 {

	
	
	
		@FXML
	    private TextField txtwriter;

	    @FXML
	    private TextField txtcontent;

	    @FXML
	    private Button btnget;

	    @FXML
	    private Button btnwrite;

	    @FXML
	    private Label txtcontentlist;

	    @FXML
	    void get(ActionEvent event) {
	    	System.out.println("DB내 데이터 호출");
	    }

	    @FXML
	    void write(ActionEvent event) {
	    	System.out.println("DB내 데이터 저장");

	    }
	
	
}
