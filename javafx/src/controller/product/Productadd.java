package controller.product;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class Productadd implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

    @FXML
    private Button btnback;

    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private TextField txtpprice;

    @FXML
    private RadioButton opt1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private ImageView img;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnimg;

    @FXML
    private Label txtpath;

    @FXML
    void accadd(ActionEvent event) {
    	//1.컨트롤에 입력된 데이터 가져오기
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt(txtpprice.getText());
    		//카테고리
    	String pcategory = null;
    	if (opt1.isSelected()) {//만약에 opt1이라는 fxid의 컨트롤이 선택되면
			pcategory="남성의류";
		}
    	if (opt2.isSelected()) {//만약에 opt2이라는 fxid의 컨트롤이 선택되면
			pcategory="여성의류";
		}
    	if (opt3.isSelected()) {//만약에 opt3이라는 fxid의 컨트롤이 선택되면
			pcategory="게임기기";
		}
    	if (opt4.isSelected()) {//만약에 opt4이라는 fxid의 컨트롤이 선택되면
			pcategory="생활용품";
		}
    	
    	int mnum = Login.member.getMnum();

    	//2.객체화
    	Product product = new Product(0, pname, null, pcontent, pcategory, pprice, 1, null, mnum);
    	//3.DB처리
    	
    	//4.결과처리
    }

    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }

    @FXML
    void accimgadd(ActionEvent event) {

    }

	
}
