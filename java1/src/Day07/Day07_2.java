package Day07;

public class Day07_2 {//cs
	
	public static void main(String[] args) {//ms
		
		//p.223~224 : 리턴값이 없는 메소드
		
		//1.객체선언[빈생성자=기본생성자]
		Car mycar = new Car()	;
		//2.메소드 호출 [인수1개 = 5]
		mycar.setGas(5);
		
		//3.메소드 호출
			if(mycar.isLeftGas() ) {
				System.out.println("출발합니다.");
				mycar.run();
			}
		//5.메소드 호출
			if (mycar.isLeftGas()) {
				System.out.println("가스있음");
			}else {
				System.out.println("가스없음");
			}
		
	}//me

}//ce
