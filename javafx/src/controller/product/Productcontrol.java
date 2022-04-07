package controller.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Productcontrol implements Initializable {

	 public static Product select ; // 선택된 버튼의 제품 저장
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show(null); //화면이 처음 열렸을 때는 검색어에 null 넣기
	}
	
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;

    @FXML
    void accadd(ActionEvent event) {
    	Home.home.loadpage("/view/product/productadd.fxml");
    }
    
    @FXML
    private TextField txtsearch;

    @FXML
    private Button btnsearch;

    @FXML
    void accsearch(ActionEvent event) { //검색 버튼 눌렀을 때
    	
    	String search = txtsearch.getText();
    	show(search); // 입력한 검색어 show 메소드에 넣어주기
    	
    }
    
    
    void show(String search) { //메소드화 -> 여러 곳에서 사용가능
    	
    	if (vbox.getChildren().isEmpty() == false) { //vbox가 비어있지 않으면
			vbox.getChildren().remove(0); //vbox내 기존 객체를 삭제
		}
    	
    	//1. 모든 제품 가져오기
		ArrayList<Product> productlist = ProductDao.productDao.list(Home.category, search);
		
		//2. 그리드 클래스 [ 행/열 ]
		GridPane gridPane = new GridPane();
			//그리드 간 여백
			gridPane.setPadding(new Insets(10));
			//버튼 들 여백
			gridPane.setHgap(50);
			gridPane.setVgap(50);
		//3. 반복문
		int i= 0;
		for (int row = 0; row < productlist.size() / 3; row++) {//행
			
			for (int col = 0; col < 3; col++) { //열
				
				//1.이미지
				ImageView imageView = new ImageView( new Image(productlist.get(i).getPimg()));
				
					//이미지 사이즈
					imageView.setFitHeight(200);
					imageView.setFitWidth(200);
				//2.버튼생성 (버튼에 이미지 넣기)
				Button button = new Button(null, imageView);
					//버튼 배경제거
					button.setStyle("-fx-background-color:transparent");
				 	//버튼 id값 넣기
				 	button.setId(i+"");
				 	//버튼 클릭 이벤트
				 	button.setOnAction(e -> {
				 		System.out.println( e.toString() );
				 		//1. 출력한 버튼의 id값 가져오기
				 		int id = Integer.parseInt( e.toString().split(",")[0].split("=")[2]);
				 		//클릭한 제품 번호 저장
				 		select = productlist.get(id);
			 		//화면전환
				 		Home.home.loadpage("/view/product/productview.fxml");
				 	});
				gridPane.add(button, col, row); //해당 열번호, 행번호에 버튼 추가
				i++;
			}
		}
		
		//나머지 값
		int row = productlist.size() / 3;
		int remain = productlist.size() % 3;
		if (remain != 0 ) {
			for (int col = 0; col < remain; col++) {
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg()));
				//이미지 사이즈
				imageView.setFitHeight(200);
				imageView.setFitWidth(200);
			//2.버튼생성 (버튼에 이미지 넣기)
			Button button = new Button(null, imageView);
			 	button.setStyle("-fx-background-color:transparent");
			 	button.setId(i+"");
			 	button.setOnAction(e -> {
			 		System.out.println( e.toString() );
			 		int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
			 		select = productlist.get(id);
			 		//화면전환
			 		Home.home.loadpage("/view/product/productview.fxml");
			 	});
			 	gridPane.add(button, col, row); //해당 열번호, 행번호에 버튼 추가
				i++;
			}
		}
		
		//4.
		vbox.getChildren().add(gridPane);
    }
}
