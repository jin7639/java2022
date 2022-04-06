package controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.MemberDao;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Productview implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 1. ��Ͽ��� ���õ� ��ǰ�� ��ü�� ȣ�� 
				Product product = Productcontrol.select;
				// 2. �� ��Ʈ�ѿ� �� �ֱ� 
				img.setImage( new Image( product.getPimg() ));
				txtpname.setText( product.getPname() );
				txtpcontent.setText( product.getPcontent() );
					// * õ���� ��ǥ
					DecimalFormat decimalFormat = new DecimalFormat("���� : #,##0 ��");
				txtpprice.setText( decimalFormat.format(product.getPprice() )  );
				if( product.getPactivation() == 1 ) { txtactivation.setText("���� : �Ǹ���"); }
				if( product.getPactivation() == 2 ) { txtactivation.setText("���� : �ŷ���"); }
				if( product.getPactivation() == 3 ) { txtactivation.setText("���� : �ǸſϷ�"); }
				txtpdate.setText( "��ǰ ����� : " + product.getPdate() );
				// * ȸ����ȣ�� �̿��� ȸ��id ã�� [ DAO���� �޼ҵ� �̿� ]
				txtmid.setText( "��ǰ ���ȸ�� : " + MemberDao.memberDao.getmid( product.getMnum() ) );
				
				txtpname.setEditable(false);
				txtpcontent.setEditable(false);
				
				// * ��ǰ���ȸ�� ��ȣ�� �α��ε�ȸ�� ��ȣ�� �������� ������
				if( product.getMnum() != Login.member.getMnum() ) {
					btndelete.setVisible(false);
					btnupdate.setVisible(false);
				}
			}
	
	
		@FXML
	    private Button btnback;

	    @FXML
	    private ImageView img;

	    @FXML
	    private Button btnupdate;

	    @FXML
	    private Button btndelete;

	    @FXML
	    private TextField txtpname;

	    @FXML
	    private Label txtpprice;

	    @FXML
	    private Label txtactivation;

	    @FXML
	    private Label txtpdate;

	    @FXML
	    private Label txtmid;

	    @FXML
	    private TextArea txtpcontent;

	    @FXML
	    void accback(ActionEvent event) {
	    	Home.home.loadpage("/view/product/product.fxml");
	    }

	    @FXML
	    void accdelete(ActionEvent event) {
	    	Alert alert = new Alert( AlertType.CONFIRMATION);
	    		alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
	    	Optional<ButtonType> optional = alert.showAndWait();
	    	if (optional.get() == ButtonType.OK) {
				ProductDao.productDao.delete(Productcontrol.select.getPnum());
	    		Home.home.loadpage("/view/product/product.fxml");
			}
	    }

	    @FXML
	    void accupdate(ActionEvent event) {
	    	Home.home.loadpage("/view/product/productupdate.fxml");
	    	
	    
	    	
	    }

}
