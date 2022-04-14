package Day09;

/**
 * @author 504
 *
 */
public class Cellphone {
//	1.필드
	String model;
	String color;
	//2.생성자
	//3.메소드 [void : 반환타입없다 (return 생략가능)]
	void powerOn()	{System.out.println("전원을 킵니다.");}
	//반환 없고 메소드명(인수X) {실행코드}
	void powerOff() {System.out.println("전원을 끕니다.");}
	void bell() {System.out.println("벨이 울립니다.");}
	//반환X 인수O
	void sendVoice(String message) { System.out.println("본인: " + message);}
	void recieveVoice(String message) { System.out.println("상대방: " + message);}
	
	
	
}
