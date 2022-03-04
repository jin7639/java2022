package Day4;

import java.util.Random;
import java.util.Scanner;

public class Day04_3 {//cs
	public static void main(String[] args) {//ms
		
		// 가위바위보
		
		Scanner scanner = new Scanner(System.in);
		
		// 공통 변수 준비
		int 플레이어; //사용자가 선택한 수
		int 컴퓨터; //컴퓨터가 생성한 난수
		int 게임수 = 0; //총 게임실행 수 
		int 플레이어승리수 = 0; //플레이어가 승리한 횟수
		int 컴퓨터승리수 = 0; //컴퓨터가 승리한 횟수
		
		//프로그램 실행
		while(true) { // 프로그램 실행 [ 무한루프 종료 조건 : 3번 입력시에 종료]
			System.out.println("---------가위바위보 게임---------");
			System.out.println("가위(0) 바위(1) 보(2)    종료(3)");
			플레이어 = scanner.nextInt(); //입력한 수 저장
			
			
			//종료조건
			if (플레이어 == 3) {
				System.out.println("게임을 종료합니다.");
				System.out.println("플레이어 승리 : " + 플레이어승리수);
				System.out.println("컴퓨터 승리 : " + 컴퓨터승리수);
				System.out.println("총 게임 수 : " + 게임수);
				if(플레이어승리수 > 컴퓨터승리수) {
					System.out.println("최종 승리 : 플레이어 승리");
					
				} else if (플레이어승리수 < 컴퓨터승리수) {
					System.out.println("최종 승리 : 컴퓨터 승리");
				} else {
					System.out.println("최종 승리 : 무승부");
					break;
				}
			} else if (플레이어>=0 || 플레이어 <3) {
				System.out.println("플레이어가 낸 수 : " + 플레이어 );
				
				Random random = new Random(); //난수 객체 선언
				
				//random.nexInt(); int가 표현할 수 있는 범위 내에서 난수 생성
				//random.nextInt(수); 0~수 전까지 범위내 난수 생성
					///random.nextInt(10); 0부터 9까지 중 난수 생성
					//random.nextInt(11)+10; 10~20중 난수 발생
				
				컴퓨터 = random.nextInt(3); //난수를 정수int로 가져오기
				System.out.println("컴퓨터가 낸 수 : " + 컴퓨터);
				//승리자 판단
				if ( (플레이어 == 0 && 컴퓨터 ==2) || (플레이어 == 1 && 컴퓨터 == 0 ) || (플레이어 == 2 && 컴퓨터==1)) {
					System.out.println("플레이어 승리");
					플레이어승리수++;
					
				} else if ((플레이어 == 0 && 컴퓨터 ==0) || (플레이어 == 1 && 컴퓨터 == 1 ) || (플레이어 == 2 && 컴퓨터==2)) {
					System.out.println("무승부");
				} else {
					System.out.println("컴퓨터승리");
					컴퓨터승리수++;
				}
				게임수++;
			} else {
				System.err.println("알 수 없는 행동입니다.");
			}
			
			
		}//while end
		
		
		
		scanner.close(); 
	}//me

}//ce
