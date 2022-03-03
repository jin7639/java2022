package Day03;

public class Day03_1 {//cs

	public static void main(String[] args) {//ms
		
//	 제어문
//		 컴퓨터의 판단력을 높임 --> 경우의 수 
//		 컴퓨터를 5살이라고 생각하세요
//		 형태
//			1. IF( 조건[true/false] ) 실행문;
//			2. IF( 조건식 ) 실행문[참];
//					ELSE 실행문 [거짓];
//			3. 실행문이 2줄 이상( ;이 두개 이상)이면 {}묶음
//			4. IF (조건 1) {실행문 [참1];}
//					ELSE IF ( 조건2 ) { 실행문[참2]; }
//					ELSE IF ( 조건3 ) { 실행문[참3]; }
//					ELSE IF ( 조건4 ) { 실행문[참4]; }
//					ELSE IF ( 조건5 ) { 실행문[참5]; }
//					ELSE IF { 실행문[거짓]; }
//			5. if 중첩
//				 IF (조건식) {
//					IF(조건식) {실행문;}
//					ELSE {실행문;}
//					}ELSE {
//						IF(조건식) {실행문;}
//						ELSE { 실행문;}
//					}
					
		
		
		//예제1
			if(3>1) System.out.println("예) 3이 1보다 크다.");
			//만약에 3이 1보다 크면 출력 O, 아니면 출력 X
		//예제2
			if(3>5) System.out.println("예) 3이 5보다 크다.");
			//만약에 3이 5보다 크면 출력 O, 아니면 출력 X
		
			//조건식이 true 이면 실행문 처리
			
		//예제3
			if (3>1)System.out.println("예3_1) 3이 1보다 크다");
			else System.out.println("예3_2) 3이 1보다 작다");
			// 만약에 3이 1보다 크면 예3_1출력
			//아니면 (3이 1보다 작으면) 예3_2출력
			
		//예제4
			if(3>2) {//true 실행문 시작
				System.out.println("true"); 
				System.out.println("3이 2보다 크다");
			}//true 실행문 끝
			else { //false 실행문 시작
				System.out.println("3이 2보다 작다");
			}//false 실행문 끝
			
		//예제5
			if(3>5) System.out.println("예5)3이 5보다 크다");  //실행X
			else if (3>4) System.out.println("예5)3이 4보다 크다");  //실행X
			else if (3>3) System.out.println("예5)3이 3보다 크다");  //실행X
			else if (3>2) System.out.println("예5)3이 2보다 크다");  //실행O
			else System.out.println("true 없음"); //실행X
			//1묶음 ->결과 1개
			
		//예제6
			if (3>5) System.out.println("예5)3이 5보다 크다");  //실행X
			if (3>4) System.out.println("예5)3이 4보다 크다");  //실행X
			if (3>3) System.out.println("예5)3이 3보다 크다");  //실행X
			if (3>2) System.out.println("예5)3이 2보다 크다");  //실행O
			if (3<2) System.out.println("true 없음"); //실행X
			//5개 문장 ->결과 5개
			
			
			
	}//me
	
	
}//ce
