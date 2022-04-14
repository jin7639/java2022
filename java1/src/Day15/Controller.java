package Day15;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {

	//1.배열
	//public static Car[] carlist = new Car[100];
	//2.리스트
	public static ArrayList<Car> carlist = new ArrayList<>();
	
	
	//입차 메소드
	public static boolean carIn(String carNum) {
		
		//입차 코드 작성
			//1.입력받은 차량번호 (인수) 가져온다.
			//2.입차날짜 구한다
		LocalDate carInDate = LocalDate.now();
			//3. 입차 시간을 구한다
		int carInHour = LocalTime.now().getHour();
		int carInMin = LocalTime.now().getMinute();
		LocalTime carInTime = LocalTime.of(00, 05);
			//  출차시간 , 금액은 출차시에
			//4.차량번호, 입차날짜, 입차시간 -> 3개변수 -> 객체화
		Car car = new Car(carInDate, carNum, carInTime);
			//5.차량객체를 배열이나 리스트에 저장
		carlist.add(car);
			//6. 파일처리 or DB 처리 ----> 나중에!
		
		return false;
	}
	//출차 메소드
	public static boolean carOut(String carNum) {
		
		//until
		//1. 입력받은 차량번호(인수)가져온다
		//2. 배열이나 리스트내 동일한 차량번호를 찾아서
		//3. 출차시간(현재시간)을 구한다
		
		
		for (int i = 0; i < carlist.size(); i++) {
			if (carNum.equals(carlist.get(i).getcarNum())) {
				//출차시간표시
				int carOutHour = LocalTime.now().getHour();
				int carOutMin = LocalTime.now().getMinute();
				LocalTime carOutTime = LocalTime.of(carOutHour, carOutMin);
				carlist.get(i).set출차시간(carOutTime);
				
				//주차요금계산
				long parkingTime = ChronoUnit.MINUTES.between( carlist.get(i).getcarInTime() , carOutTime );
				int parkingfee =  ( (int)parkingTime - 30 ) /10 *1000;
				if (parkingfee < 0) {
					parkingfee = 0;
				}
				carlist.get(i).set금액(parkingfee);
			}
		}
		//4. 계산 [출차시간 - 입차시간 -> (분-30)/10 *1000
		//    chronounit.min
		//5. [수정]찾은 객체내 출차시간과 금액을 대입한다.
		
		
		return false;
		
		
	}

}



