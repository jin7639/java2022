package Day02;

public class Day02_4 {//cs
	
	public static void main(String[] args) {//ms
		
		//p.64 연산자
		/*
		 * 1. 산술
		 *	// 1.+더하기 2. -빼기 3. *곱하기 4. /나누기 5. %나머지
		 * 2. 비교 [결과는 true 혹은 false]
		 * 		>초과		<미만
		 * 		>=이상	<=이하
		 * 		==같다	!=같지 않다
		 * 3. 논리 [두개이상 비교현산자 사용시]
		 * 		&& and
		 * 		|| or
		 * 		! 부정[반대] true -> false / false -> true
		 * 4. 대입
		 * 		= : 오른쪽 값이 왼쪽으로 이동[저장]
		 * 		+= : 오른쪽 값이 왼쪽 값과 더하기 후에 왼쪽 값에 대입
		 * 			변수명 = 변수명 + 10
		 * 				//1. 변수 호출
		 * 				//2. 변수에 10 더함
		 * 				//3. 해당 변수에 더한 값 대입
		 * 			변수명 += 10
		 * 				//1. 변수 호출
		 * 				//2. 오른쪽 값을 더한 후에 변수에 대입
		 * 		-= *= /= %=
		 * 5. 증감 [* : 일정간격으로 변화]
		 * 	//1. ++: 1증가						2.-- : 1감소
		 * 	//선위 증가 : 우선 증가 -> 다른 명령어 처리	선위 감소
		 * 	//후위 증가 : 다른 명령어 처리 -> 증가		후위 감소
		 * 6. 삼항연산자[조건연산자]
		 * 	조건식 ? 참 : 거짓
		 * 
		 */
		
		//산술연산자 예제
		int 정수1 = 10; int 정수2 = 20; //각각 10과 20을 저장하는 2개의 변수 선언
		System.out.println("더하기 : " + 정수1 + 정수2 ); //문자열+정수 ->연결연산자
		System.out.println("더하기 : " + (정수1 + 정수2) ); //문자열 + (정수1 +정수2)
		System.out.println("빼기 : " + (정수1-정수2));
		System.out.println("곱하기 : " + (정수1*정수2));
		System.out.println("나누기(몫) : " + (정수1/정수2)); //몫:0
		System.out.println("나머지 : "+ (정수1%정수2)); //나머지 10
		
		//증감연산자 예제
		정수1++; //변수명 뒤에 ++ 할 경우 해당 변수내 데이터에 +1
		System.out.println("증가 : " + 정수1);
		정수1--; //변수명 뒤에 -- 할 경우 해당 변수내 데이터에 -1
		System.out.println("감소 : " + 정수1);
		
		System.out.println("선위증가 : " +  ++정수1);	// 11
		System.out.println("후위증가 : " + 정수1++);	// 11
			//명령어처리는 동시처리 불가능 ->처리 순서가 존재
			//++변수 : 먼저 증가후에 print실행
			//변수++ : print 실행 후에 증가
		System.out.println("후위 증가 후 : "+정수1); //12
		
		System.out.println("선위감소 : " + --정수1); //1감소후 출력 ->11
		System.out.println("후위감소 : " + 정수1--); //출력수에 1감소 ->11출력
		
		System.out.println("후위감소 후 : " + 정수1); //10
		
		//비교연산자 예제
		System.out.println("이상 : "+ (정수1>=정수2)); // 10>=20 false
		System.out.println("이하 : "+ (정수1<=정수2));
		System.out.println("초과 : " + (정수1>정수2));
		System.out.println("미만 : " + (정수1<정수2));
		System.out.println("같다 : " + (정수1==정수2));
		System.out.println("같지않다 : " + (정수1 != 정수2));
		
		//논리연산자 예제
			// and && : 2개 이상의 비교 연산자가 모두 true-> 결과도 true. 아니면 false
			// or || : 2개 이상의 비교 연산자가 하나라도 true -> 결과도 true. 아니면 false
		int 정수3 = 30; int 정수4 =40;
		System.out.println("and : " + (정수1 >= 정수2 && 정수4>=정수3));
										//10 >=20 and	40 >=30
											//false		true	-> 결과 false
		System.out.println("or : " + (정수1 >= 정수2 || 정수4 >=정수3));
										//false		or	true	-> 결과 true
		
		System.out.println("not부정 : " + !(정수1 >= 정수2 || 정수4 >=정수3));
											//결과 true -> ! -> false
									
		//대입연산자 예제
		정수1 = 정수1 +10; System.out.println("정수1 : " + 정수1);
		정수1 += 10; 		System.out.println("정수1 : " + 정수1);
		System.out.println("정수1 : " + (정수1-=10) );
		System.out.println("정수1 : " + (정수1/=10));
		
		
		// 조건연산자 예제
		int 점수 = 75;
		char 등급 = 점수 > 90 ? 'A' : 'B';
			// 		조건식	? 참 true : 거짓 false
			//점수가 90 초과면 A대입 아니면 B대입
		
		System.out.println("등급 : "+ 등급);
		char 등급2 = 점수 >90 ? 'A' : 점수 >80 ? 'B' : 'C' ;
		System.out.println("등급 : "+ 등급2);
		
		
	}//me
	
	

}//ce
