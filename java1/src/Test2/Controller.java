package Test2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Controller {

	static ArrayList<Car> carlist = new ArrayList<>();
			
	public static void carIn(String carNum) {
		
		LocalDate carInDate = LocalDate.now();
		int carInHour = LocalTime.now().getHour();
		int carInMin = LocalTime.now().getMinute();
		LocalTime carInTime = LocalTime.of(carInHour, carInMin);
		Car car = new Car(carNum, carInDate, carInTime);
		
		carlist.add(car);

		
		return;
	}
	
	public static void carOut(String carNum) {
		for (int i = 0; i < carlist.size(); i++) {
			if (carNum.equals(carlist.get(i).getCarNum()) ) {
				//출차시간
				int carOutHour = LocalTime.now().getHour();
				int carOutMin = LocalTime.now().getMinute();
				LocalTime carOutTime = LocalTime.of(carOutHour, carOutMin);
				carlist.get(i).setCarOutTime(carOutTime);
				//주차요금
				
				long parkingTime = ChronoUnit.MINUTES.between(carlist.get(i).getCarInTime(), carOutTime);
				int parkingFee = ((int) parkingTime - 30 ) /10 *1000;
				if (parkingFee < 0) {
					parkingFee = 0;
				}
				carlist.get(i).setParkingFee(parkingFee);
				
			}
		}
		
		
		
		
	}
	
}//ce
