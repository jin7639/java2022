package controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.ProductDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable {

	

    @FXML
    private BarChart mbc;

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
		Map<String , Integer> map = MemberDao.memberDao.datetotal();
			for (String key : map.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key , map.get(key));
			series.getData().add(data);
			}
			
		mbc.getData().add(series);

		//1.�迭����
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 = MemberDao.memberDao.datetotal2();
		
		for (String key : map2.keySet()) {
			XYChart.Data data = new XYChart.Data<>( key , map2.get(key));
			series2.getData().add(data);
		}
		pbc.getData().add(series2);
		
		
		
	}
}
