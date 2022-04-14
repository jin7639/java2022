package Test2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class ParkingApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("-----------------------주차 현황 표-----------------------");
				LocalDate currentDate = LocalDate.now();
				int currentHour = LocalTime.now().getHour();
				int currentMin = LocalTime.now().getMinute();
				LocalTime currentTime = LocalTime.of(currentHour, currentMin);
				System.out.println("\t\t현재 시간 : " + currentDate+" " + currentTime);
				System.out.println("날짜\t\t차량번호\t\t입차시간\t출차시간\t금액");
				for (int i = 0; i < Controller.carlist.size(); i++) {
					if (Controller.carlist.get(i).getCarNum() != null) {
						if (Controller.carlist.get(i).getCarOutTime() == null ) {
							if (Controller.carlist.get(i).getCarNum().length() < 8) {
								System.out.printf("%s\t%s\t\t%s\t%s\t%s \n", 
										Controller.carlist.get(i).getCarInDate(),Controller.carlist.get(i).getCarNum(), 
										Controller.carlist.get(i).getCarInTime(), "주차 중", "정산 전" );
							}else {
								System.out.printf("%s\t%s\t%s\t%s\t%s \n", 
										Controller.carlist.get(i).getCarInDate(),Controller.carlist.get(i).getCarNum(), 
										Controller.carlist.get(i).getCarInTime(), "주차 중", "정산 전" );
							}
						}else {
							if (Controller.carlist.get(i).getCarNum().length() < 8) {
								System.out.printf("%s\t%s\t\t%s\t%s\t%d \n", 
										Controller.carlist.get(i).getCarInDate(),Controller.carlist.get(i).getCarNum(), Controller.carlist.get(i).getCarInTime(), 
										Controller.carlist.get(i).getCarOutTime(), Controller.carlist.get(i).getParkingFee() );
							}else {
								
							System.out.printf("%s\t%s\t%s\t%s\t%d \n", 
									Controller.carlist.get(i).getCarInDate(),Controller.carlist.get(i).getCarNum(), Controller.carlist.get(i).getCarInTime(), 
									Controller.carlist.get(i).getCarOutTime(), Controller.carlist.get(i).getParkingFee() );
							}
						}
					}//if end
					
				}//for end
				
				
				System.out.println("-------------------------------------------------------");
				System.out.println("\t\t\t1.입차\t2.출차");
				int ch = scanner.nextInt();
				
				if (ch == 1) {//입차
					System.out.println("차량번호 : ");
					String carNum = scanner.next();
					
					Controller.carIn(carNum);
					
				}else if (ch == 2) {//출차
					System.out.println("차량번호 : ");
					String carNum = scanner.next();
					
					Controller.carOut(carNum);
				}else {
					System.out.println("잘못된 입력입니다.");
				}
				
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
		}//whlie end
	
	}//me
}//ce
