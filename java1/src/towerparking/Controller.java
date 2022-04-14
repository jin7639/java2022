package towerparking;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Day10.Book;
import Team2.Controller;

public class Controller {
	public static ArrayList<Car> carlist = new ArrayList<>();
	
	SimpleDateFormat carInHour = new SimpleDateFormat("HH");
	SimpleDateFormat carInMin = new SimpleDateFormat("mm");
	
	public int carIn(int CarNum, int carParking) {
		
		Car parkingCar = new Car(CarNum,)
	}
	
	public void CarOut(int CarNum) {
		
		for (int i = 0; i < carlist.size(); i++) {
			if (carlist.get(i).getCarNum() == CarNum) {
				
				
			}
		}
		
		
	}//carout end
	
	
	public void CarOut(String CarNum)  {
		for(int i = 0; i <carlist.size(); i++) {
			if(carlist.get(i).getCarNum().equals(CarNum)) {
		//tower[parkNum] = "[    ]";	
		int outcth = Integer.parseInt(carlist.get(i).getCarTimehour());
		int outctm = Integer.parseInt(carlist.get(i).getCarTimemin());
		outcth *= 60;
		int outcattotla = outcth += outctm;
		String nth = nowTimeHour.format(carInTime);
		String ntm = nowTimeMin.format(carInTime);
		
		int int_nth = Integer.parseInt(nth);
		int int_ntm = Integer.parseInt(ntm);
		int_nth *= 60;
		int nowtimetotal = int_nth += int_ntm;
		
		int timepay = nowtimetotal - outcattotla;
		if(timepay < 30) {
			System.out.println("회차 차량입니다.");
		}
		else if(timepay >= 30) {
			System.out.println(timepay);
			payMoney = ((timepay-30)/10);
			if( payMoney == 0) {
				System.out.println("결제하실 금액은 1000원 입니다.");
				payMoney += 1000;
			}
			else {
				System.out.println("결제하실 금액은 "+(payMoney*1000)+"원 입니다.");
				payMoney += (payMoney*1000);
			}
			
			
		}
		else if(timepay >= 480) {
			System.out.println("8시간을 초과하여 5만원입니다.");
			payMoney +=50000;
		}
		System.out.println(nowtimetotal - outcattotla);
		
		
				carlist.remove(i);
			}
		}
		savemoney[day] = payMoney;		
		Controller.inCarSave();
		return;
	}
	
	
}
