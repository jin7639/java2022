package Day03;

import java.util.Scanner;

public class Day03_7 {//ce
	public static void main(String[] args) {//ms
		
		//공통 변수 [어디서든 사용할 수 있는 변수]
		boolean run = true; // 실행 여부 변수 / true = 실행 false = 종료
		int balance = 0; // 예금액 변수
		
		Scanner scanner = new Scanner(System.in); // 입력객체
		
		while (run) {
			System.out.println("--------------------------------");
			System.out.println("|1.예금 | 2.출금 | 3.잔고 | 4.종료 |");
			System.out.println("--------------------------------");
			System.out.println("선택> ");
			int 선택 = scanner.nextInt();
			if( 선택 == 1) {
				System.out.println("예금액 : "); int 예금액 = scanner.nextInt();
						//입력받은 예금액을 통장에 넣기
				balance += 예금액;
			} else if (선택 == 2) {
				System.out.println("출금액 : "); int 출금액 = scanner.nextInt();
				//만약에 출금액이 예금액보다 더 크면 잔액부족
				if (출금액 > balance) {
					System.out.println("잔액이 부족합니다.");
				}
				//아니면 출금실행
				balance -= 출금액;
			} else if (선택 == 3) {
				System.out.println("잔고 : " + balance);
						
			} else if (선택 == 4) {
				break;
			}else {//그외
				System.out.println("알 수 없는 번호 입니다.");
			}
			
		}
		
		 scanner.close(); 
		
	}//me
	
}//ce
