package Day16;

public class Day16_1 {

public static void main(String[] args) {
	
	//제네릭
	
	//p.656
	
	//1.Bow 객체 생성
	Box box = new Box();
	//2.객체내 메소드 호출 [인수 : String] : Object 가능
	box.set("홍길동");	//자식 ---->부모 O
	//3.객체내 메소드 호출 [반환 : Object ]
	String name = box.get(); 	//부모 ----->자식 X
	
		//자식객체 -> 부모객체 [자동형변환]
		//부모객체 -> 자식객체 [자동X 강제O]
	//4.
	box.set(new Apple()); //[ 인수 : Apple ]
	Apple apple = box.get();
	
}	
	
	
}//ce
