package Day15;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {

	//1.�迭
	//public static Car[] carlist = new Car[100];
	//2.����Ʈ
	public static ArrayList<Car> carlist = new ArrayList<>();
	
	
	//���� �޼ҵ�
	public static boolean carIn(String carNum) {
		
		//���� �ڵ� �ۼ�
			//1.�Է¹��� ������ȣ (�μ�) �����´�.
			//2.������¥ ���Ѵ�
		LocalDate carInDate = LocalDate.now();
			//3. ���� �ð��� ���Ѵ�
		int carInHour = LocalTime.now().getHour();
		int carInMin = LocalTime.now().getMinute();
		LocalTime carInTime = LocalTime.of(00, 05);
			//  �����ð� , �ݾ��� �����ÿ�
			//4.������ȣ, ������¥, �����ð� -> 3������ -> ��üȭ
		Car car = new Car(carInDate, carNum, carInTime);
			//5.������ü�� �迭�̳� ����Ʈ�� ����
		carlist.add(car);
			//6. ����ó�� or DB ó�� ----> ���߿�!
		
		return false;
	}
	//���� �޼ҵ�
	public static boolean carOut(String carNum) {
		
		//until
		//1. �Է¹��� ������ȣ(�μ�)�����´�
		//2. �迭�̳� ����Ʈ�� ������ ������ȣ�� ã�Ƽ�
		//3. �����ð�(����ð�)�� ���Ѵ�
		
		
		for (int i = 0; i < carlist.size(); i++) {
			if (carNum.equals(carlist.get(i).getcarNum())) {
				//�����ð�ǥ��
				int carOutHour = LocalTime.now().getHour();
				int carOutMin = LocalTime.now().getMinute();
				LocalTime carOutTime = LocalTime.of(carOutHour, carOutMin);
				carlist.get(i).set�����ð�(carOutTime);
				
				//������ݰ��
				long parkingTime = ChronoUnit.MINUTES.between( carlist.get(i).getcarInTime() , carOutTime );
				int parkingfee =  ( (int)parkingTime - 30 ) /10 *1000;
				if (parkingfee < 0) {
					parkingfee = 0;
				}
				carlist.get(i).set�ݾ�(parkingfee);
			}
		}
		//4. ��� [�����ð� - �����ð� -> (��-30)/10 *1000
		//    chronounit.min
		//5. [����]ã�� ��ü�� �����ð��� �ݾ��� �����Ѵ�.
		
		
		return false;
		
		
	}

}



