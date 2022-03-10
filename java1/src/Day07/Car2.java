package Day07;

import java.util.Iterator;

public class Car2 {

//	1. 필드
	int speed;
//	2. 생성자
//		생성자 없으면 기본 생성자 추가
	
//	3. 메소드
	
//	1.현재 필드값을 반환해주는 베소드
	int getSpeed() { //인수X 반환 O
		return speed;
	}
	
//	2. 출력 메소드
	void keyTurnOn() {//인수없 반환없
		System.out.println("키를 돌립니다.");
		
	}
//	3.
	void run() {
		for (int i =0; i<=50; i+=10) {
			speed = i;
			System.out.println("달립니다. 시속 : " + speed +"km/s");
		}
	}
	
	
	
	
}
