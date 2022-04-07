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

	 public static Product select ; // ���õ� ��ư�� ��ǰ ����
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show(null); //ȭ���� ó�� ������ ���� �˻�� null �ֱ�
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
    void accsearch(ActionEvent event) { //�˻� ��ư ������ ��
    	
    	String search = txtsearch.getText();
    	show(search); // �Է��� �˻��� show �޼ҵ忡 �־��ֱ�
    	
    }
    
    
    void show(String search) { //�޼ҵ�ȭ -> ���� ������ ��밡��
    	
    	if (vbox.getChildren().isEmpty() == false) { //vbox�� ������� ������
			vbox.getChildren().remove(0); //vbox�� ���� ��ü�� ����
		}
    	
    	//1. ��� ��ǰ ��������
		ArrayList<Product> productlist = ProductDao.productDao.list(Home.category, search);
		
		//2. �׸��� Ŭ���� [ ��/�� ]
		GridPane gridPane = new GridPane();
			//�׸��� �� ����
			gridPane.setPadding(new Insets(10));
			//��ư �� ����
			gridPane.setHgap(50);
			gridPane.setVgap(50);
		//3. �ݺ���
		int i= 0;
		for (int row = 0; row < productlist.size() / 3; row++) {//��
			
			for (int col = 0; col < 3; col++) { //��
				
				//1.�̹���
				ImageView imageView = new ImageView( new Image(productlist.get(i).getPimg()));
				
					//�̹��� ������
					imageView.setFitHeight(200);
					imageView.setFitWidth(200);
				//2.��ư���� (��ư�� �̹��� �ֱ�)
				Button button = new Button(null, imageView);
					//��ư �������
					button.setStyle("-fx-background-color:transparent");
				 	//��ư id�� �ֱ�
				 	button.setId(i+"");
				 	//��ư Ŭ�� �̺�Ʈ
				 	button.setOnAction(e -> {
				 		System.out.println( e.toString() );
				 		//1. ����� ��ư�� id�� ��������
				 		int id = Integer.parseInt( e.toString().split(",")[0].split("=")[2]);
				 		//Ŭ���� ��ǰ ��ȣ ����
				 		select = productlist.get(id);
			 		//ȭ����ȯ
				 		Home.home.loadpage("/view/product/productview.fxml");
				 	});
				gridPane.add(button, col, row); //�ش� ����ȣ, ���ȣ�� ��ư �߰�
				i++;
			}
		}
		
		//������ ��
		int row = productlist.size() / 3;
		int remain = productlist.size() % 3;
		if (remain != 0 ) {
			for (int col = 0; col < remain; col++) {
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg()));
				//�̹��� ������
				imageView.setFitHeight(200);
				imageView.setFitWidth(200);
			//2.��ư���� (��ư�� �̹��� �ֱ�)
			Button button = new Button(null, imageView);
			 	button.setStyle("-fx-background-color:transparent");
			 	button.setId(i+"");
			 	button.setOnAction(e -> {
			 		System.out.println( e.toString() );
			 		int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
			 		select = productlist.get(id);
			 		//ȭ����ȯ
			 		Home.home.loadpage("/view/product/productview.fxml");
			 	});
			 	gridPane.add(button, col, row); //�ش� ����ȣ, ���ȣ�� ��ư �߰�
				i++;
			}
		}
		
		//4.
		vbox.getChildren().add(gridPane);
    }
}
