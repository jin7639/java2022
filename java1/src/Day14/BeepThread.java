package Day14;

import java.awt.Toolkit;

public class BeepThread extends Thread {
					// 상속 Thread [멀티스레드 클래스]
	//run메소드 오버라이딩
	@Override
	public void run() { //Thread에 있는 run메소드 재정의[오버라이드]
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //1.객체생성
		for (int i = 0; i < 5; i++) {	//2.5회 반복
			toolkit.beep();	//소리내기
			try {	//일반예외가 무조건 발생 -> 예외처리 무조건
				Thread.sleep(500);	// 0.5초간 일시정지
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	
	
	
	
}//ce
