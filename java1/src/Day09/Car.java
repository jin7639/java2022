package Day09;

public class Car {

	//1. 필드
	Tire frontLeftTire = new Tire("앞왼쪽",6);	
	Tire frontRightTire = new Tire("앞오른쪽",2);	
	Tire backLeftTire = new Tire("뒤왼쪽",3);	
	Tire backRightTire = new Tire("뒤오른쪽",4);	
	
	//2.생성자
	
	//3.메소드
	int run() {//자동차 회전 [모든 타이어객체가 1회전씩 회전] 메소드
		System.out.println("자동차가 달립니다. ");
		if (frontLeftTire.roll()==false) 	{stop();	return 1;}
		//타이어가 회전을 했는데 결과가 false이면 펑크
		//true이면 수명 남음
		if (frontRightTire.roll()==false) 	{stop();	return 2;}
		if (backLeftTire.roll()==false) 	{stop();	return 3;}
		if (backRightTire.roll()==false) 	{stop();	return 4;}
		return 0;
	}
	void stop() {
		System.out.println("[자동차가 멈춥니다]");
	}
	
	
	
}
