package Day4;

import java.util.Scanner;

public class Day04_1 {//cs

	public static void main(String[] args) {//ms
		
		// 제어문 : if ,  switch
		// 반복문 : for , while
			//1.초기값 2.조건식 3.증감식 4.실행문
		
		//for 예1)
		for (int i = 1; i<=10; i++) {
			// i는 1부터 10이하 까지 1씩 증가하면서 실행문 반복처리 -> 10번 실행
			System.out.print(i + " ");
		}
		System.out.println();
		
//		for 예2) 1~100 누적합계
		int sum = 0;
		for (int j = 1; j<=100; j++) {
			sum += j; //sum = sum + j
		}
		System.out.println("for 1 ~ 100 누적합 : "+ sum);
		//while 형태
//			초기값;
//			while( 조건식 ) {
//				실행문;
//				증감식;
//			}
		
		//while 예1)
		int i = 1; //초기값
		while (i <= 10) { //조건식 [true이면 실행, 아니면 실행 X ]
			System.out.print(i + " "); //실행문
			i++; //증감식 :없으면 무한루프
		}
		System.out.println();
		
		//while 예2)
		int j = 1;
		int sum2 = 0;
		while (j <= 100) {
			sum2 += j;
			j++;
		}// while end : j 가 101일때 종료
		System.out.println("while 1 ~ 100 누적합 : " + sum2);
		
		//while 예3) 무한루프
		while (true) {// 조건식이 true 실행 // true 상수 -> 무한루프
			System.out.println("무한루프");
			Scanner scanner = new Scanner(System.in);
			int exit = scanner.nextInt();
			if(exit == 3)
				break; //가장 가까운 반복문 탈출 [ if 제외 ]
			scanner.close(); 
		}
		
		
	
		
		
	}//me
	
}//ce
