package Day15;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				
				//1. 모든 차량 표 출력
					//
						//배열이나 리스트 내 모든 객체 호출 반복문
					//	
				System.out.println("-------------주차 현황 표--------------");
				System.out.println("\t날짜\t차량번호\t\t입차시간\t출차시간\t금액");
				int i = 0;		
				for (Car car : Controller.carlist) {
					if (car.getcarNum() == null) {
						
					}else if (car.get출차시간() == null) {
						System.out.printf("%s\t%s\t\t%s\t%s\t%s \n", 
								car.getcarInDate(), car.getcarNum(),car.getcarInTime(),"주차 중", "정산 전");
					}else
						System.out.printf("%s\t%s\t\t%s\t%s\t%d \n", 
								car.getcarInDate(), car.getcarNum(),car.getcarInTime(),car.get출차시간(), car.get금액());
				
				}
				
				System.out.println("------------------------------------");
				
				System.out.println("\t\t1.입차 \t 2.출차  :");
				int ch = scanner.nextInt();
				if (ch == 1) {
					
					//1. 차량번호를 입력받는다.
					System.out.println("차량번호 : ");
						//입력
					String carNum = scanner.next();
					//2.입력받은 차량번호를 컨트롤내 메소드에게 넘긴다.
					Controller.carIn(carNum) ; //인수전달
					//3.메소드결과에 따른 출력
					boolean 결과 = Controller.carIn(null);
					
				}else if (ch == 2 ) {
					//1. 차량번호를 입력받는다.
					System.out.println("차량번호 : ");
						//입력
					String carNum = scanner.next();
					//2.입력받은 차량번호를 컨트롤내 메소드에게 넘긴다.
					Controller.carOut(carNum) ; //인수전달
					//3.메소드결과에 따른 출력
					boolean 결과 = Controller.carOut(null);
				}
				
				
			} catch (Exception e) {
				System.out.println("사용할 수 없는 입력입니다.");
				scanner = new Scanner(System.in);
			}
			
		} //while end
	}//me
}//ce
