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
				System.out.println("-----------------------���� ��Ȳ ǥ-----------------------");
				LocalDate currentDate = LocalDate.now();
				int currentHour = LocalTime.now().getHour();
				int currentMin = LocalTime.now().getMinute();
				LocalTime currentTime = LocalTime.of(currentHour, currentMin);
				System.out.println("\t\t���� �ð� : " + currentDate+" " + currentTime);
				System.out.println("��¥\t\t������ȣ\t\t�����ð�\t�����ð�\t�ݾ�");
				for (int i = 0; i < Controller.carlist.size(); i++) {
					if (Controller.carlist.get(i).getCarNum() != null) {
						if (Controller.carlist.get(i).getCarOutTime() == null ) {
							if (Controller.carlist.get(i).getCarNum().length() < 8) {
								System.out.printf("%s\t%s\t\t%s\t%s\t%s \n", 
										Controller.carlist.get(i).getCarInDate(),Controller.carlist.get(i).getCarNum(), 
										Controller.carlist.get(i).getCarInTime(), "���� ��", "���� ��" );
							}else {
								System.out.printf("%s\t%s\t%s\t%s\t%s \n", 
										Controller.carlist.get(i).getCarInDate(),Controller.carlist.get(i).getCarNum(), 
										Controller.carlist.get(i).getCarInTime(), "���� ��", "���� ��" );
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
				System.out.println("\t\t\t1.����\t2.����");
				int ch = scanner.nextInt();
				
				if (ch == 1) {//����
					System.out.println("������ȣ : ");
					String carNum = scanner.next();
					
					Controller.carIn(carNum);
					
				}else if (ch == 2) {//����
					System.out.println("������ȣ : ");
					String carNum = scanner.next();
					
					Controller.carOut(carNum);
				}else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
				
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
		}//whlie end
	
	}//me
}//ce
