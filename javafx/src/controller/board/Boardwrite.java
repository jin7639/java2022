package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardwrite implements Initializable {

	 	@FXML
	    private TextField txttitle;

	    @FXML
	    private TextArea txtcontent;

	    @FXML
	    private Button btnwrite;

	    @FXML
	    private Button btnback;

	    @FXML
	    void accback(ActionEvent event) {
	    	Home.home.loadpage("/view/board/board.fxml");
	    }

	    @FXML
	    void accwrite(ActionEvent event) {

	    }
	
	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    // TODO Auto-generated method stub
	    
	    }
}
