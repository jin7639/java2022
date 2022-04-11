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
		//전체 회원수
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText(mtotal + "명");
		
		//전체 제품수
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText(ptotal + "제품");
		
		//전체 게시물 수 
		int btotal = MemberDao.memberDao.counttotal("board");
		lblbtotal.setText(btotal + "개");
		
		//날짜별로 회원 가입 수
		XYChart.Series series = new XYChart.Series<>(); //1. xy 축 계열 생성
		
		// 날짜별로 회원가입 수 체크 [2022-04-11 , 3 ]
		// Map 컬렉션 : 키와 값으로 하나의 엔트리 구성, 날짜 중복체크 가능
					//날짜 가입수
		Map<String , Integer> map = MemberDao.memberDao.datetotal("member", "msince");
			for (String key : map.keySet()) {
				XYChart.Data data = new XYChart.Data<>(key , map.get(key));
				series.getData().add(data);
			}
		mbc.getData().add(series);

		//1.계열생성
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 = MemberDao.memberDao.datetotal2( "board" , "bdate");
		
		for (String key : map2.keySet()) {
			XYChart.Data data = new XYChart.Data<>( key , map2.get(key));
			series2.getData().add(data);
		}
		
		bbc.getData().add(series2);
		
		//1. 계열
		XYChart.Series series3 = new XYChart.Series<>();
		
			series3.setName("국어점수");
		
			XYChart.Data data = new XYChart.Data<>("신동엽", 10);
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("강호동", 20);
			series3.getData().add(data2);
			
			XYChart.Data data3 = new XYChart.Data<>("유재석", 15);
			series3.getData().add(data3);
			
		pbc.getData().add(series3);
		
		XYChart.Series series4 = new XYChart.Series<>();
		
			series4.setName("영어점수");
		
			XYChart.Data data4 = new XYChart.Data<>("신동엽", 25);
			series4.getData().add(data4);
			
			XYChart.Data data5 = new XYChart.Data<>("강호동", 40);
			series4.getData().add(data5);
			
			XYChart.Data data6 = new XYChart.Data<>("유재석", 50);
			series4.getData().add(data6);
			
		pbc.getData().add(series4);
		
		
		//원형차트  카테고리별 개수
		//1. 리스트명 선언
		ObservableList< PieChart.Data> list = FXCollections.observableArrayList();
		
		//2. DB에서 카테고리별 개수
		Map<String, Integer> map3 = MemberDao.memberDao.countcatgegory();
		
		//3. 원형차트 데이터 추가
		for (String key : map3.keySet()) {
			PieChart.Data temp = new PieChart.Data(key, map3.get(key));
			//데이터를 리스트에 추가
			list.add(temp);
		}
		//4. 리스트를 원형차트에 추가
		ppc.setData(list);
		
	}
}
