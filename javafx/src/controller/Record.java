package controller;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.ProductDao;
import dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable {

    @FXML
    private PieChart ppc;
    
    @FXML
    private BarChart mbc;

    @FXML
    private BarChart bbc;
    
    @FXML
    private BarChart pbc;

    @FXML
    private Label lblptotal;

    @FXML
    private Label lblbtotal;

	@FXML
	private Label lblmtotal;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//��ü ȸ����
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText(mtotal + "��");
		
		//��ü ��ǰ��
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText(ptotal + "��ǰ");
		
		//��ü �Խù� �� 
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText(btotal + "��");
		
		//��¥���� ȸ�� ���� ��
		XYChart.Series series = new XYChart.Series<>(); //1. xy �� �迭 ����
		
		// ��¥���� ȸ������ �� üũ [2022-04-11 , 3 ]
		// Map �÷��� : Ű�� ������ �ϳ��� ��Ʈ�� ����, ��¥ �ߺ�üũ ����
					//��¥ ���Լ�
		Map<String , Integer> map = MemberDao.memberDao.datetotal("member", "msince");
			for (String key : map.keySet()) {
				XYChart.Data data = new XYChart.Data<>(key , map.get(key));
				series.getData().add(data);
			}
		mbc.getData().add(series);

		//1.�迭����
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 = MemberDao.memberDao.datetotal2( "board" , "bdate");
		
		for (String key : map2.keySet()) {
			XYChart.Data data = new XYChart.Data<>( key , map2.get(key));
			series2.getData().add(data);
		}
		
		bbc.getData().add(series2);
		
		//1. �迭
		XYChart.Series series3 = new XYChart.Series<>();
		
			series3.setName("��������");
		
			XYChart.Data data = new XYChart.Data<>("�ŵ���", 10);
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("��ȣ��", 20);
			series3.getData().add(data2);
			
			XYChart.Data data3 = new XYChart.Data<>("���缮", 15);
			series3.getData().add(data3);
			
		pbc.getData().add(series3);
		
		XYChart.Series series4 = new XYChart.Series<>();
		
			series4.setName("��������");
		
			XYChart.Data data4 = new XYChart.Data<>("�ŵ���", 25);
			series4.getData().add(data4);
			
			XYChart.Data data5 = new XYChart.Data<>("��ȣ��", 40);
			series4.getData().add(data5);
			
			XYChart.Data data6 = new XYChart.Data<>("���缮", 50);
			series4.getData().add(data6);
			
		pbc.getData().add(series4);
		
		
		//������Ʈ  ī�װ��� ����
		//1. ����Ʈ�� ����
		ObservableList< PieChart.Data> list = FXCollections.observableArrayList();
		
		//2. DB���� ī�װ��� ����
		Map<String, Integer> map3 = MemberDao.memberDao.countcatgegory();
		
		//3. ������Ʈ ������ �߰�
		for (String key : map3.keySet()) {
			PieChart.Data temp = new PieChart.Data(key, map3.get(key));
			//�����͸� ����Ʈ�� �߰�
			list.add(temp);
		}
		//4. ����Ʈ�� ������Ʈ�� �߰�
		ppc.setData(list);
		
	}
}
