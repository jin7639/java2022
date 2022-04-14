package Day03;

import java.util.Scanner;

public class Day03_2 {//cs
	
	public static void main(String[] args) {//ms
		// 입력객체 = { } 당 1번 선언
		Scanner scanner = new Scanner(System.in);
		
		//문제1 : 2개의 정수를 입력받아서 더 큰 수 출력
		System.out.println("정수입력 : ");
		int 문제1_1 = scanner.nextInt();
			//int형 변수 선언하고 입력받은 값을 정수로 가져와서 대입
		System.out.println("정수2입력 : ");
		int 문제1_2 = scanner.nextInt();
		
		//제어
		if (문제1_1 > 문제1_2) 		System.out.println("더 큰 수 : " + 문제1_1);
			//만약에 입력받은 문제1_1 정수가 문제1_2보다 크면 실행. 아니면 다음 조건
		else if (문제1_1 < 문제1_2 ) 	System.out.println("더 큰 수 : " + 문제1_2);
			//만약에 입력받은 문제1_2 정수가 문제1_1보다 크면 실행. 아니면 그 외
		else 						System.out.println("같다");
			//나머지[그 외] 실행
		
		//문제2 : 3개의 정수를 입력받아서 가장 큰 수 출력
		System.out.println("정수1 입력 : ");	int 문제2_1 = scanner.nextInt();
		System.out.println("정수2 입력 : ");	int 문제2_2 = scanner.nextInt();
		System.out.println("정수3 입력 : ");	int 문제2_3 = scanner.nextInt();
		
		int max = 문제2_1; //가장 큰 수를 임시로 저장 
			//max에 첫번째 값 넣어두기
		if ( max < 문제2_2 ) {max = 문제2_2;} //만약에 max 보다 문제2_2가 더 크면 교환
		if (max < 문제2_3) {max = 문제2_3;}	//만약에 max 보다 문제2_3가 더 크면 교환
		
		//문제3 : 4개의 정수를 입력받아서 가장 큰 수 출력
		System.out.println("정수1 입력 : ");	int 문제3_1 = scanner.nextInt();
		System.out.println("정수2 입력 : ");	int 문제3_2 = scanner.nextInt();
		System.out.println("정수3 입력 : ");	int 문제3_3 = scanner.nextInt();
		System.out.println("정수4 입력 : ");	int 문제3_4 = scanner.nextInt();
		
		int max2 = 문제3_1;
		if ( max2 < 문제3_2) { max2 = 문제3_2; }
		if ( max2 < 문제3_3) { max2 = 문제3_3; }
		if ( max2 < 문제3_4) { max2 = 문제3_4; }
		System.out.println("가장 큰 수 : " + max2);
		
		//문제4 : 3개의 정수를 입력받아서 오름차순 정렬
		System.out.println("정수1 입력 : ");	int 문제4_1 = scanner.nextInt();
		System.out.println("정수2 입력 : ");	int 문제4_2 = scanner.nextInt();
		System.out.println("정수3 입력 : ");	int 문제4_3 = scanner.nextInt();
		
		if ( 문제4_1 > 문제4_2 ) {
			//교체 [스왑 = 두개 변수에 데이터 교환방법]
			int temp = 문제4_1; 		//임시변수 = 변수1;
			문제4_1 = 문제4_2;		//변수1 = 변수2;
			문제4_2 = 문제4_3;		//변수2 = 변수3;
		}
		if (문제4_1 > 문제4_3) { int temp = 문제4_1; 문제4_1 = 문제4_3; 문제4_3 = temp;}
		if (문제4_2 > 문제4_3) { int temp = 문제4_2; 문제4_2 = 문제4_3; 문제4_3 = temp;}
		
		System.out.printf("입력한 값 오름차순 : %d %d %d " , 문제4_1, 문제4_2, 문제4_3);
		System.out.println("입력한 값 오름차순 : " + 문제4_1 + 문제4_2 + 문제4_3);
		
		//문제 5 : 4개의 정수를 입력받아서 오름차순 정렬
		System.out.println("문제5) 정수1 입력 : ");	int 문제5_1 = scanner.nextInt();
		System.out.println("문제5) 정수2 입력 : ");	int 문제5_2 = scanner.nextInt();
		System.out.println("문제5) 정수3 입력 : ");	int 문제5_3 = scanner.nextInt();
		System.out.println("문제5) 정수4 입력 : ");	int 문제5_4 = scanner.nextInt();
		
		//첫 번째 값 기준
		if(문제5_1 > 문제5_2) {
			int temp = 문제5_1;	//temp가 정수2보다 큼
			문제5_1 = 문제5_2;
			문제5_2 = 문제5_3;
			문제5_3 = 문제5_4;
		}
		if(문제5_1 > 문제5_3 ) {
			int temp = 문제5_1; //temp가 정수1, 정수1이 정수2와 정수3보다 큼
			문제5_1 = 문제5_2;
			문제5_2 = 문제5_3;
			문제5_3 = 문제5_4;
		}
		if (문제5_1 > 문제5_4) {
			int temp = 문제5_1; 
			문제5_1 = 문제5_2;
			문제5_2 = 문제5_3;
			문제5_3 = 문제5_4;
		}	
		
		//두번째 값 기준
		if (문제5_2 > 문제5_3 ) { int temp = 문제5_2; 문제5_2 = 문제5_3; 문제5_3 = temp; }
		if (문제5_2 > 문제5_4 ) {	int temp = 문제5_2; 문제5_2 = 문제5_3; 문제5_3 = temp; }
		
		//세번째 값 기준
		if (문제5_3 > 문제5_4 ) {	int temp = 문제5_3; 문제5_3 = 문제5_4; 문제5_4 = temp; }
		
		
		
		
		
		
	}//me
	

}//ce
