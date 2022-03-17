package Day12;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class day12_1 {

	public static void main(String[] args) throws IOException {
		//496p
			//String 문자열 클래스
				//1. java.lang 패키지 [import]소속
				//2. 객체인데 자동 리터럴 [객체가 자동생성]
		String 성명1 = new String("유재석");
		String 성명2 = "유재석";
				//3. 13개의 생성자[문자열, 바이트열 등 ]
				//4. 외부[파일,네트워크 등]로 부터 받은 데이터는 보통 바이트열
		
		//바이트 -> 문자 변환 가능 이유
			//바이트 코드 : +-127표현 가능
			//아스키코드 : 0/1 조합된 7자리
			//유니코드 
		
		
		
		
		//497p
		//	1.여러개 바이트를 저장 할 수 있는 바이트 배열 선언
		byte[] bytes = {72, 101,108, 108, 111 };
					//  H	e	l 	   l	o	
		//2.바이트 배열 ->문자열 변환 [new String(배열명)]
		String str1 = new String(bytes); //String 바이트 -> 아스키 코드 변환
		
		//3.확인
		System.out.println(str1);
		
		//4.특정 위치부터 변환		[new String (배열명, 시작인덱스, 개수)]
		String str2 = new String (bytes , 6 , 4);
		
		//5.확인
		System.out.println("바이트 배열내 6번인덱스 부터 4개 변환"+ str2);
		
		//p.498
			//System.out : 시스템 클래스 내 출력필드
			//System.In : 시스템 클래스 내 입력필드
		byte[] bytes2 = new byte[100];
		
		System.out.println("입력 : "); 	//출력필드내 print 메소드 호출
		
		int readByteNo = System.in.read(bytes2);
		//외부통신 : 자바프로그램 외[ 키보드 , 파일, 네트워크 등] 입출력 일반 예외
		//키보드 입력 ---스트림[통신:바이트]----> 컴퓨터
		//a ->97		// a 엔터 - >97 13[\n:줄바꿈], 10[\r:커서를 앞으로] 	
		String str = new String(bytes2);
		System.out.println("입력받은 바이트 -> 문자열 변환 : "+ Arrays.toString(bytes2));
		
		String str = new String (bytes2, 0 , readByteNo-2);
											//읽은 바이트 수 -1
											// \n, \r
		System.out.println("입력받은 바이트 -> 문자열 변환 : " + str);
		//Scanner 클래스 [System.in 으로부터 입력받은 바이트를 객체에 저장 ]
		Scanner scanner = new Scanner(System.in);
		//Scanner 클래스 메소드
		scanner.next(); //바이트 ->문자열 변환
		scanner.nextInt(); //바이트 -> 정수열 변환
		scanner.nextDouble(); //바이트 -> 실수열 변환
		
		
		
		
	}//me
	
	
}//ce
