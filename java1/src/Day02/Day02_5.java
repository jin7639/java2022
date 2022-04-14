package Day02;

import java.util.Scanner;

public class Day02_5 {//cs
	
	public static void main(String[] args) {//ms
		Scanner scanner = new Scanner(System.in);
	
//		//문제2 : 지폐 세기
//		
//		//입력조건 : 금액
//	System.out.println("금액 : "); 	int 금액 = scanner.nextInt();
//	
//		//조건 : 십만원 부터 백원까지의 개수 세기
//	int 십만원 = 금액/100000;
//	int 만원 = (금액 - 십만원*100000)/10000;
//	int 천원 = (금액 - 십만원*100000 - 만원*10000)/1000;
//	int 백원 = (금액 - 십만원*100000 - 만원*10000 - 천원*1000)/100;
//
//		//출력조건 :
//	System.out.println("십만원 : " + 십만원 + " 장");
//	System.out.println("만원 : " + 만원 + " 장");
//	System.out.println("천원 : " + 천원 + " 장");
//	System.out.println("백원 : " + 백원 + " 개");
//		
//	System.out.println("십만원 : " + (금액/100000) + " 장");
//	
//	//금액 = 금액- (금액/100000)*100000;
//	금액 -= (금액/100000)*100000;
//	System.out.println("만원 : "+ (금액/10000)+ "장");
//	
//	금액 -= (금액/10000)*10000;
//	System.out.println("천원 : "+ (금액/1000)+ "장");
//	
//		
//	//문제3
//		//정수를 입력받기
//	System.out.println("문제3) 정수 입력 : "); int num1 = scanner.nextInt();
//		//정수가 7의 배수인지 판단
//			//배수 찾기
//				// 값 % 수 했을때 나머지가 0 이면 값은 그 수의 배수
//	//String 배수7 = num1%7 == 0 ? "7의 배수" : "7의 배수 아님";
//		//출력
//	System.out.println("7의 배수 확인 " + (num1%7==0));
//	
//
//	//문제 4
//		//홀짝 찾기
//			//홀수 : 값 %2 했을 때 나머지가 1
//			//짝수 : 값 %2 했을 때 나머지가 0
//	
//	System.out.println("문제4) 정수 입력 : ");
//	int 문제4 = scanner.nextInt();
//	System.out.println("입력한 정수 홀수 판단 : " + (문제4%2==1));
//		
//	//문제5
//	
//	System.out.println("문제5) 정수 입력 : ");
//	int 문제5 = scanner.nextInt();
//	System.out.println("7의 배수이면서 짝수인지 확인 : " + (문제5%7==0 && 문제5%2==0) );
//	
//	
//	//문제6 : 두개의 정수를 입력받아 더 큰지 출력  [ true , false ]
//	System.out.println("문제6) 정수1 입력");		int 문제6_1 = scanner.nextInt();
//	System.out.println("문제6) 정수2 입력");		int 문제6_2 = scanner.nextInt();
//	int 큰수 = 문제6_1 > 문제6_2 ? 문제6_1 : 문제6_2 ;
//	System.out.println("더 큰 수는 " + 큰수);
//		
//	//문제7 : 반지금을 입력받아 원 넓이 출력하기
//	
//	System.out.println("문제7) 반지름 입력"); 	int 문제7 = scanner.nextInt();
//	System.out.println("원의 넓이 : " + 문제7*문제7*3.14);
//	
//	//문제8 :두 실수를 입력받아 앞 실수의 값이 뒤의 값의 몇 %인지 출력하기
//	
//	System.out.println("문제8)실수1 입력 : ");	double 문제8_1 = scanner.nextDouble();
//	System.out.println("문제8)실수2 입력 : "); 	double 문제8_2 = scanner.nextDouble();
//	double 비율 = ( 문제8_1/문제8_2)*100;
//	System.out.printf("비율 : %.2f %%\n", 비율);
//		// %f 실수표현
//			//%.숫자f			//%.2f : 소수 2자리 까지 표현
//	
//	//문제9 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기]
//		//사다리꼴 계산식 = > (윗변 * 밑변) * 높이 / 2
//	
//	System.out.println("문제9) 윗변 : "); int 윗변 = scanner.nextInt();
//	System.out.println("문제9) 밑변 : "); int 밑변 = scanner.nextInt();
//	System.out.println("문제9) 높이 : "); int 높이 = scanner.nextInt();
//	
//	System.out.println("사다리꼴 넓이는 : " + (윗변 * 밑변)*높이/2);
//	
//	//문제10: 키를 정수를 입력받아 표준체중 출력하기
//		//표준체중 계산식 = > (키 - 100) * 0.9
//	System.out.println("문제10) 키 입력 : "); int 문제10 = scanner.nextInt();
//	System.out.println("문제10) 표준체중 : "+ (문제10 - 100) * 0.9);
//	
//	//문제11 : 키와 몸무게를 입력받아 BMI 출력하기
//		//BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
//	System.out.println("문제11) 키 입력 : "); int 키 = scanner.nextInt();
//	System.out.println("문제11) 몸무게 입력 : "); int 몸무게 = scanner.nextInt();
//	System.out.println("BMI : " + (몸무게 / ((키 / 100.0) * (키 / 100.0)));
//	
//	//문제12: inch 를 입력받아 cm 로 변환하기 [ 1 inch -> 2.54cm ] 
//	System.out.println("문제12) inch 입력 : "); int inch = scanner.nextInt();
//	
//	System.out.println(inch*2.54 + " cm");
//	
//	//문제13:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하기
//			//소수 둘째 자리 까지 점수 출력하기
//			//중간고사 반영비율 => 30 %
//			//기말고사 반영비율 => 30 %
//			//수행평가 반영비율 => 40 %
//	System.out.println("문제13) 중간고사 점수 : "); double 중간 = scanner.nextInt();
//	System.out.println("문제13) 기말고사 점수 : "); double 기말 = scanner.nextInt();
//	System.out.println("문제13) 수행고사 점수 : "); double 수행 = scanner.nextInt();
//	
//	//System.out.println("총점 : " + (중간*0.3 + 기말*0.3 + 수행*0.4) + " 점");
//	중간 *= 0.3;
//	기말 *= 0.3;
//	수행 *= 0.4;
//	System.out.println("총점 : " + (중간+기말+수행));
//	
//	
//	
//	//문제14 :  연산 순서 나열 하고 x와 y값 예측하기
//		int x = 10;
//		int y = x-- + 5 + --x;
//		System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
//			// 1. x-- + 5 -> 감소 전에 먼저 + => 10+5
//			// 2. x-- -> x감소 [x=9]
//			// 3. 15 + --x => [x=8]
//			// 4. 5 + 8 => y = 23
	
	//문제15 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
	System.out.println("나이 : "); int 나이 = scanner.nextInt();
	String 연령대 = 나이 >=40 ? "중년" : 나이 >=20 ? "성인" : "학생";
	
	System.out.println(연령대);
	
	//문제16 : 3개의 정수를 입력받아 오름차순으로 정렬 
	System.out.println("문제16) 정수1입력");		int 정수1 = scanner.nextInt();
	System.out.println("문제16) 정수2입력");		int 정수2 = scanner.nextInt();
	System.out.println("문제16) 정수3입력");		int 정수3 = scanner.nextInt();
	

	
	//문제17 : 4개의 정수를 입력받아 내림차순으로 정렬 
	
	
	// p. 102 확인문제
		
		
	}//me
	
}//ce
