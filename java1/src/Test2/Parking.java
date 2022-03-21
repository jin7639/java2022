package Test2;

import java.util.Scanner;

public class Parking {

	//1. 주차현황표는 항상 출력 : 날짜 차량번호 입차시간 출차시간 금액
		//입차시 출차시간은 주차중 -> 출차시 출차 시간 표시
		//금액 : 주차중 이면 정산전 출차 후에는 금액 표시
	//2. 메뉴에서 1번 선택시 입차
		//차량번호 입력받기
	//3. 메뉴에서 2번 선택시 출차
		//차량번호 입력받기
		//주차 현환표에 출차시간 대입하고 금액 계산하여 표시
	//4. 차량 객체 -> 배열/리스트에 저장
	//5. 금액
		//최초 30분 무료 -> 10분당 1000원
	//6.파일처리 X
	//7.예외발생 상황 처리
	
	public static void main(String[] args) {//ms
		
		Scanner scanner = new Scanner(System.in);
		while(true) { //무한루프 [종료조건 : 없음]
			try {
				System.out.println("-------------주차 현황 표--------------");
				System.out.println("날짜\t차량번호\t입차시간\t출차시간\t금액");
				System.out.printf("%s\t%s\t%s\t%s\t%d \n", "날짜", "차량번호","입차시간","출차시간","금액");
				
				System.out.println("------------------------------------");
				System.out.println("1.입차 2. 출차 | 선택 : ");
				int ch = scanner.nextInt();
				
				if (ch == 1) {//입차
					System.out.println("차량번호 : ");
					String carNum = scanner.next();
					Controller.carIn(carNum);
				}else if (ch == 2) {//출차
					
				}else {
					System.out.println("알 수 없는 입력입니다.");
				}
			} catch (Exception e) {
				System.out.println("알 수 없는 입력입니다.");
				scanner = new Scanner(System.in);
			}
		
		
		
		}//while end
	}//me
	
}//ce
