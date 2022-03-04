package Day03;

import java.util.Scanner;

public class Day03_6 {//cs

	public static void main(String[] args) {//ms
		Scanner scanner = new Scanner(System.in);
		
		//문제1 : 입력받은 수 만큼 * 출력
//		System.out.println("문제1) 별개수 : ");	int s1 = scanner.nextInt();
//		for(int i = 1; i<=s1; i++) {
//			System.out.print("*");
//		}
//		System.out.println();
		
		//문제2
//		System.out.println("문제2) 별개수 : ");	int s2 = scanner.nextInt();
//		for ( int i =1 ; i<=s2; i++) {
//			System.out.print("*");
//			if(i%5 == 0) System.out.println();
//		}
		
		//문제3
//		System.out.println("문제3) 줄 수 : ");	int line3 = scanner.nextInt();
//		for ( int i = 1; i <= line3; i++) {
//			// i는 1부터 입력받은 줄 수 까지 1씩 증가
//			
//			//1. 별찍기
//			for (int s = 1 ; s<=i ; s++) {
//				System.out.print("*");
//			}
//			//2. 줄바꿈 처리
//			System.out.println();
//		}
		//순서도
			//사용자가 3을 입력
			//i = 1 	i <= 3 [true]
				//s = 1	s <= 1 [true] -> * -> s++
				//s = 2 s <= 1 [false] ->반복문 종료
			//줄바꿈
			//i=2 i<=3 [true]	
				//s = 1 s<=2 [true] -> * -> s++
				//s = 2 s<=2 [true] -> * -> s++
				//s = 3 s<=2 [false] -> 반복문 종료
			//줄바꿈
			// i = 3 	i <= 3 [true]
				//s = 1 s<=3 [true] -> * -> s++
				//s = 2 s<=3 [true] -> * -> s++
				//s = 3 s<=3 [true] -> * -> s++
				//s = 4 s<=3 [false] -> 반복문 종료
			//줄바꿈
			//i = 4 	i <=3 [false] for1 반복문 종료
		
		//문제4
		
//		System.out.println("문제4) 줄 수 : ");		int line4 = scanner.nextInt();
//		
//		for( int i = 1; i <= line4; i++) {
//			
//			for (int s = 1; s <= line4-i+1; s++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
//		
//		
//		//문제5
//		
//		System.out.println("문제5) 줄 수 : ");		int line5 = scanner.nextInt();
//		// 공백 b는 입력받은수-현재줄수 까지 1씩증가->공백출력
//		for ( int i = 1; i <= line5; i++) {
//			//1. 공백찍기
//			for (int b = 1; b<=line5-i; b++) {
//				System.out.print(" ");
//			}
//			//2. 별찍기
//			for (int s = 1 ; s<=i ; s++) {
//				System.out.print("*");
//			}
//			
//			//3. 줄바꿈 처리
//			System.out.println();
//		} 
		
		
		//문제6
		
//		i = 1	b = 0			s = 1 2 3 4 5
//		i = 2	b = 1			s = 1 2 3 4
//		i = 3	b = 1 2			s = 1 2 3
//		i = 4	b = 1 2 3		s = 1 2
//		i = 5	b = 1 2 3 4		s = 1
//		b는 1부터 현재 줄 수 -1 까지 1씩 증가 공백 출력
//		s는 1부터 입력받은 수 - 현재 줄 수+1 까지
//		System.out.println("문제6) 줄 수 : ");		int line6 = scanner.nextInt();
//		
//		for( int i = 1; i <= line6; i++) {
//			
//			for (int b = 1; b<=i-1 ; b++) {
//				System.out.print(" ");
//			}
//			
//			for (int s = 1 ; s <= line6 - i + 1 ; s++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
//		
//		
//		//문제7
//		
//		System.out.println("문제7) 줄 수 : ");		int line7 = scanner.nextInt();
//		// 공백 b는 입력받은수-현재줄수 까지 1씩증가->공백출력
//		for ( int i = 1; i <= line7; i++) {
//			//1. 공백찍기
//			for (int b = 1; b<=line7-i; b++) {
//				System.out.print(" ");
//			}
//			//2. 별찍기
//			for (int s = 1 ; s<=i+i-1 ; s++) {
//				System.out.print("*");
//			}
//			
//			//3. 줄바꿈 처리
//			System.out.println();
//		} 
//		
//		//문제8
//		System.out.println("문제8) 줄 수 : ");		int line8 = scanner.nextInt();
//		// 공백 b는 입력받은수-현재줄수 까지 1씩증가->공백출력
//		for ( int i = 1; i <= line8; i++) {
//			//1. 공백찍기
//			for (int b = 1; b<=line8-i; b++) {
//				System.out.print(" ");
//			}
//			//2. 별찍기
//			for (int s = 1 ; s<=i+i-1 ; s++) {
//				System.out.print(i);
//			}
//			
//			//3. 줄바꿈 처리
//			System.out.println();
//		} 
//		
		//문제9
		System.out.println("문제9) 줄 수 : ");		int line9 = scanner.nextInt();
		// 공백 b는 입력받은수-현재줄수 까지 1씩증가->공백출력
		for ( int i = 1; i <= line9; i++) {
			//1. 공백찍기
			for (int b = 1; b<=i; b++) {
				System.out.print(" ");
			}
			//2. 별찍기
			for (int s = 1 ; s<=line9+i ; s++) {
				System.out.print("*");
			}
			
			//3. 줄바꿈 처리
			System.out.println();
		} 
		
		

		
		
		
		 scanner.close(); 
	}//me
	
}//ce
