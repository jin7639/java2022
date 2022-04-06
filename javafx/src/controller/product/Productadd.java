package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
    	// 1. 컨트롤에 입력된 데이터 가져오기
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt( txtpprice.getText() ) ;	// 문자열 -> 정수열 변환 [ Integer.parseInt ]
    		// * 카테고리
    	String pcategory = null;
    		if( opt1.isSelected() ) { // 만약에 opt1라는 fxid의 컨트롤(라디오버튼)이 선택되었으면
    			pcategory="남성의류";
    		}
    		if( opt2.isSelected() ) { pcategory ="여성의류";}
    		if( opt3.isSelected() ) { pcategory ="게임기기";}
    		if( opt4.isSelected() ) { pcategory ="생활용품";}
    	int mnum = Login.member.getMnum();
    	System.out.println(Login.member.getMnum());
    	// 2. 객체화
    	Product product = new Product(0, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
    	// 3. DB처리
    	boolean result =  ProductDao.productDao.add(product);
    	if( result ) {
    		Alert alert = new Alert(AlertType.INFORMATION ); // 메시지 
    			alert.setHeaderText("제품 등록 완료");
    		alert.showAndWait();	
    		Home.home.loadpage("/view/product/product.fxml"); // 화면전화
    		
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION );
				alert.setHeaderText("제품 등록 실패 [ 관리자에게 문의]");
			alert.showAndWait();
    	}
    	
    }

    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }
    
    private String pimage = null; //메소드 밖에서 선언 : imgadd와 add메소드에서도 사용하려고

    @FXML
    void accimgadd(ActionEvent event) {
    	
    	//1. 파일 선택 클래스
    	FileChooser chooser = new FileChooser();
    	
    	//2. 파일 선택[필터]형식
    	chooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:image file", "*png", "*jpg", "*gif"));
    	
    	//3. 새로운 스테이지
    	File file = chooser.showOpenDialog(new Stage());
    		//파일선택객체.showOpenDialog (스테이지 이름)
    		//fileChooser 화면에서 선택된 파일을 객체화
    	
    	//4. 선택한 파일의 경로 표시
    	txtpath.setText("파일 경로 : "+ file.getPath());
    	
    	//5. 파일경로
    	pimage = file.toURI().toString();
//	    	System.out.println(file.getPath()); // 경로구분선 : \
//	    	System.out.println(file.toURI());	// 경로구분선 : /
//	    	System.out.println(file.toURI().toString()); // 경로구분선 : /
    	//6. 이미지 미리보기
    	Image image = new Image( pimage ); // 해당 이미지의 경로값이 / 구분 되어 있어야함
    	img.setImage(image); //imageview에 이미지 넣어주기
    	
    	// 선택한 파일을 현재 프로젝트 폴더로 복사해오기
    	try {
    		//1. 파일 입력 스트림 [ 이동단위 : 바이트 ]
    		FileInputStream inputStream = new FileInputStream(file); //file : filechooser에서 선택된 파일 객체
    		//2. 파일 출력 스트림
    			//1.새로운 경로 설정
    		File copyfile = new File("C:\\Users\\504\\git\\java2022\\javafx\\src\\img\\" + file.getName());
    		FileOutputStream outputStream = new FileOutputStream(copyfile);
    		//3. 바이트 배열 선언
    		byte[] bytes = new byte[1024*1024*1024]; // 1gb
    		//4. 반복을 이용한 inputStream의 파일 스트림 모두 읽어오기
    		int size;
    		while ( (size = inputStream.read(bytes)) > 0 ) { //읽어올 바이트가 0보다 작으면 반복문 종료
				outputStream.write(bytes , 0 , size);
			}
    		//5. 용량 큰 경우에는 스트림 종료 필수!!!
    		inputStream.close();
    		outputStream.close();
    		//파일명 db저장
    		pimage = copyfile.toURI().toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("파일 오류 " + e);
		}
    	//2. 파일 출력 스트림
    	
    }

	
}
