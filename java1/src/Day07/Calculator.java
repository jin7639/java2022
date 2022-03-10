package Day07;

public class Calculator {//cs

	//클래스 선언
	
	//1.필드
	//2.생성자
		//만약에 생성자가 선언이 1개도 없으면
		//기본생성자가 자동 추가 됨
		//기본생성자 : 
	//3.메소드
	void powerOn() {//1. 인수 X, 반환 X
		System.out.println();
	}
		//1. void : 리턴타입
			//void 결과값을 제공하지 않는 함수
//		return; 생략가능 [단 실행부 중간에 사용시함수종료]
		//2. powerOn : 메소드이름[아무거나]
		//3.(매개변수[인수]) : 함수로 들어오는 데이터
		//4. {실행코드} : 함수 실행부
	
	int plus(int x,int y) {
		int result = x+y;
		return result; //함수를 호출했던 곳으로 이동
	}
	//1. int : 리턴타입[함수가 종료되면서 int형 데이터를 반환]
		//5.return 반환값;
		//리턴타입이 int이기때문에 return 에는 무조건 int형 데이터
	//2. plus : 메소드 이름 [아무거나]
	//3. (int x,int y) : int형처럼 2개 매개변수 받기
		//함수 호출시 함수로 들어오는 x와 y 는 int형으로 받기
	//4. { 실행부 }
	
	double divide (int x , int y ) {
		//리턴타입 메소드명 (인수1, 인수2) {실행코드; return 실수데이처=
		double result = (double)x / (double)y;
			//(자료형)변수명 : 강제형변환
			//int 형 번수 ->double [나누기후에 소수점 있을 수 있기 때문에]
		return result;
	}
	
	void powerOff() {//인수X 반환X
		//리턴타입 메소드명() {}
		System.out.println("전원을 끕니다.");
	}
	
	
	
	
}//ce
