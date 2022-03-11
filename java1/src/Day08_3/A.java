package Day08_3;

public class A {//동일한 클래스 내 접근 제한자 사용의미 X

	//전범위 클래스 선언 A
		//1.필드
	A a1 = new A(true);		//현 클래스 에서 public 호출 가능
	A a2 = new A(1); 		//현 클래스에서 default 호출 가능
	A a3 = new A("문자열"); 	//현 클래스에서 private 호출 가능
	
	public int field;
	int field2;
	private int field3;
	
	
	
	
		//2.생성자
	
	public A(boolean b ) {
		field1 = 1;
		field2 = 2;
		field3 = 3;
	}
	
	
	
	
	
	public A(boolean b) {}	//전 범위
	A (int b) {}			//현 패키지 내
	private A (String s) {}	//현 클래스 내
	
		//3. 메소드 
	
}
