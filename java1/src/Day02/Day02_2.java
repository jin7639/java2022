package Day02;

public class Day02_2 {//cs
	public static void main(String[] args) {//ms
		
		//; : 실행 단위 구분
		//동일한 변수명은 사용할 수 없다. [이름이 중복되면 오류(구분불가)]
		
		//2. 메모리를 효율적으로 쓰자
		// p.40 byte : 1바이트 정수 +-128
		byte var1 = -128;
		System.out.println(var1);
		byte var2 = -30;
		System.out.println(var2);
		byte var3 = 30;
		System.out.println(var3);
		//byte var4 = 300;
		//System.out.println(var4);
			//오류 발생 : 128 이상은 저장할 수 없다.
		byte var4 = 'j'; System.out.println(var4);
		 // 문자 -> 정수 변환 [아스키 코드 규칙]
		
		//p.43 char : 2바이트 [1문자] : 유니코드(java,2바이트,전 세계 모든 문자) vs 아스키코드(c)
		char c1 = 'a'; System.out.println(c1);
		char c2 = 97; System.out.println(c2); 		//10진수 표현 : 0~9
		//정수 -> 문자 변환
		char c3 = '\u0041'; System.out.println(c3);		//16진수 표현
		char c4 ='가'; System.out.println(c4);
		char c5 = 44032; System.out.println(c5);
		char c6 = '\uac00'; System.out.println(c6);
		//진법 [2진수만 사용하면 표현단위가 적다 --> 표현단위 다양성 ]
			//2진수 : 0 , 1 / 기계어(2진코드) / 용량(1비트)
			//8진수 : 0 ~ 7
			//10진수 : 0 ~ 9
			//16진수 : 0 ~ 9 a b c d e f
		// p.44 short : 2바이트 정수 +-3만정도
		short num1 = 10000; System.out.println(num1);
		//short num2 = 40000; System.out.println(num2); //오류 발생
		
		//p.45 int : 4바이트 정수 +-20억 (정수 기본타입)
		int num2 = 10; System.out.println(num2); //10진수
		int num3 = 012; System.out.println(num3); //8진수는 앞에 0 붙이기
		int num4 = 0xA; System.out.println(num4); //16진수는 앞에 0x 붙이기
		
		//p.46 long : 8바이트 정수 +- 20억 이상
		long num5 = 10000000000L;	System.out.println(num5);
			//int형 -> long형
		
		//.47 float [데이터 뒤에 f] : 4바이트 / double(실수 기본타입) : 8바이트
		double num6 = 3.14; System.out.println(num6);
		float num7 = 3.14f; System.out.println(num7);
		
		double num8 = 0.123456789123456789; System.out.println(num8);
		float num9 = 0.123456789456123456789123f; System.out.println(num9);
		
		//p.48 boolean : 1비트 [t/f]
			//스위치 : on/off
		boolean bo1 = true; System.out.println(bo1);
		
		//p.49
			//			----->>>>>---------자동형변환 방향------------->>>>
			// *크기 순서 : byte -> short -> int ->long -> float ->double
			//1.자동 형변환 :
				//작은 상자에서 큰 상자로 이동 가능
				//큰 상자에서 작은 상자로 이동 불가
			byte 바이트 = 10;
			int 인트 = 바이트; //자동 형변환 O
			//short 쇼트 = 인트; //자동 현변환 X 오류 발생
			
			//2. 강제 형변환 (캐스트)
				//큰 상자에서 작은 상자로 이동 가능. 단, 데이터 손실 발생
				//(변경할 자료형) 변수명
			short 쇼트 = (short)인트; // int형 변수를 short로 변환하는데 데이터 잘림
	
			//기본 자료형(래퍼 클래스) 사용한 메모리는 변수 -> new X
			//클래스를 사용한 메모리는 객체 -> new O
			
			//자료형 연산시 기본타입으로 변환
			//1. byte + byte = int
			//2. int + byte = int
			//3. int + float = int
			//4. int + double = int
			
			
			
	}//me
	
}//ce

