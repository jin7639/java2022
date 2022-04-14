package Day04;

import java.util.Scanner;

public class Day04_2 {//cs
	public static void main(String[] args) {//ms
		
		//Day01 : 입출력
		//Day02 : 변수[저장] 연산 [계산]
		//Day03 : if[제어문] for[반복문]
		
		//자판기
			//1.메뉴판 [1.콜라(300) 2.환차(200) 3.사이다(100) 4.결제]
				//1.메뉴판에서 제품선택하면 장바구니에 넣기
				//2.재고가 부족하면 알림 (재고부족)
			//2.초기 재고 [제품 당 10개]
			//3.결제시 금액 입력받아 결제액 만큼 차감 후 잔돈 출력
				//1.투입한 금액보다 구매액이 크면 결제 취소 ( 금액부족 )
				
		Scanner scanner = new Scanner(System.in);
		
		//공통변수[모든 괄호 내에서 사용하는 변수들]
		int 콜라재고 = 10; int 환타재고 = 10; int 사이다재고 = 10; //재고변수
		int 콜라구매수 = 0; int 환타구매수 = 0; int 사이다구매수 = 0; //장바구니
		
		//프로그램 시작 [ 무한루프 ]
		while (true) {
			System.out.println("-------------------메뉴------------------");
			System.out.println("1.콜라(300) 2.환타(200) 3.사이다(100) 4.결제");
			System.out.println(">>>>>>>선택"); int 선택 = scanner.nextInt();
			
			if( 선택 == 1) { // 콜라구매
				if( 콜라재고 == 0 ) {//재고0이면 구매 불가
					System.err.println("재고가 없습니다.");
				} else { //재고가 있으면 구매
					System.out.println("[[콜라를 담았습니다.]]");
					콜라구매수++;
					콜라재고--;
				}
			}else if ( 선택 == 2 ) { // 환타구매
				if( 환타재고 == 0 ) {//재고0이면 구매 불가
					System.err.println("재고가 없습니다.");
				} else { //재고가 있으면 구매
					System.out.println("[[환타를 담았습니다.]]");
					환타구매수++;
					환타재고--;
				}
			} else if ( 선택 == 3 ) { // 사이다구매
				if( 사이다재고 == 0 ) {//재고0이면 구매 불가
					System.err.println("재고가 없습니다.");
				} else { //재고가 있으면 구매
					System.out.println("[[사이다를 담았습니다.]]");
					사이다구매수++;
					사이다재고--;
				}
			} else if ( 선택 == 4 ) { // 결제
				System.out.println("--------------장바구니---------------");
				
				System.out.println("제품명\t수량\t금액");
				if(콜라구매수 != 0) System.out.println("콜라\t"+콜라구매수+"\t"+300*콜라구매수);
				if(환타구매수 != 0) System.out.println("환타\t"+환타구매수+"\t"+200*환타구매수);
				if(사이다구매수 != 0) System.out.println("사이다\t"+사이다구매수+"\t"+100*사이다구매수);
				int 결제액 = (콜라구매수*300)+(환타구매수*200)+(사이다구매수*100);
				System.out.println("제품 총 결제액 : " + 결제액);
				System.out.println("-----------------------------------");
				System.out.println("1.결제 2.취소"); int 선택2 = scanner.nextInt();
				
				if (선택2 == 1) {//1.결제
					//1.금액을 입력받는다
					//2.금액이 결제액보다 적으면 결제 불가 ->금액 재 입력
					//3.금액이 결제액보다 많으면 결제 성공 ->장바구니 초기화
					
					while(true) { //무한루프 [종료조건 : 금액이 결제액보다 크면 종료 ]
						System.out.println("금액을 넣어주세요."); int 금액 = scanner.nextInt();
						if(금액 < 결제액) {//결제불가
							System.err.println("금액이 부족합니다.");
						} else {//결제 성공[결제액 만큼 차감 후 잔돈 출력] -> 장바구니 초기화
							System.out.println("결제가 완료되었습니다.");
							System.out.println("거스름돈 : "+ (금액-결제액)+ " 원");
							콜라구매수 = 0;	환타구매수 = 0; 사이다구매수 = 0; //구매수 초기화
							break;
						}
					}//while end
					
				} else if (선택2 == 2) {//2. 취소
					System.out.println("구매목록 모두 지우기");
//					for ( int i = 1 ; i <= 콜라구매수; i++) {
//						//i는 1부터 콜라구매수 까지 1씩 증가하면서 
//						콜라재고++;
//					}
					콜라재고 += 콜라구매수; 환타재고 += 환타구매수; 사이다재고 += 사이다구매수; 
					콜라구매수 = 0;	환타구매수 = 0; 사이다구매수 = 0; //구매수 초기화
				} else {
					System.err.println("알 수 없는 행동입니다.");
				}
			} else {
				System.err.println("알 수 없는 행동입니다.");
			}//if end
		
		}//while end
		
		
	}//me

}//ce
