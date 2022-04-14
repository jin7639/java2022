package Day07;

public class Day07_4 {

	//p.229 : 외부호출
	public static void main(String[] args) {
		
//		1. 객체 선언
		Car2 myCar = new Car2();
//		2. 자동차 시동걸기
		myCar.keyTurnOn();
//		3.자동차 전진 메소드 호출
		myCar.run();
//		4.현재 스피드 확인 메소드 호출
		int speed = myCar.getSpeed();//인수없 반환 있
		System.out.println("현재속도 : "+speed+ "km/s");
		
		
		
	}
}
