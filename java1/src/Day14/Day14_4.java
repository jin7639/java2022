package Day14;

import java.awt.Toolkit;

public class Day14_4 {

	public static void main(String[] args) {
	//p.576  멀티스레드 개념
		//프로세스 : 운영체제에서는 실행 중인 하나의 애플리케이션
		//운영체제가 프로세스에게 필요한 메모리를 할당해 줌 [자바에서 메모리 관리X, 운영체제(윈도우)가 함o]
		//싱글 스레드 : 코드 읽어주는 흐름 1개 = main 메소드
		//멀티 스레드 : 코드를 읽어주는 흐름 여러개 = main 메소드 외 여러개
		//병렬 : 설계상 병렬흐름이지만 스레드가 하나씩 순차적(우선순위 운영체제가 할당) 처리
			//실행순서 : 코드1 -> 코드2 -> 코드3 -> 코드4 -> 코드5
		//Thread 클래스(새로운 스레드) vs Main 메소드 (메인스레드가 내장)
			//1. Tread 클래스
				//1. 임의클래스에 extends Thread
				//2. run () 메소드 오버라이딩 [재정의]
				//3. 객체 생성
				//4. 객체.start()
				// start() 메소드 호출시 run 메소드 실행
			//2. Runnable 인터페이스 [여러개]
				//1. 임의 클래스에 implements Runnable
				//2. run 메소드 구현 한다.
				//3. Thread 클래스 객체 생성시 생성자에 구현 객체 넣어준다.
				//4. thread 클래스 객체 내 start()메소드 실행
				//* .start() 메소드는 run() 메소드 호출
				//* round() 메소드는 main스레드 제외한 새로운 스레드 만들기
			//3. 익명객체
		//	코드1
		
		//	코드2		코드3
		
		//	코드4		코드5
		
		//(작업스레드1) (작업스레드2)
		
		
		//p.581 예제1
			//싱글스래드 (main스레드)
			//0.5초 간격으로 소리 출력
			//0.5초 간격으로 띵 출력
		System.out.println("-------------싱글 스레드-----------------");
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //소리 관련 메소드 제공 클래스
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep(); //소리 메소드
			try {
				Thread.sleep(500); //현재 스레드(main스레드)를 0.5초간 멈춤
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		for (int i = 0; i <5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); //현재 스레드(main스레드)를 0.5초간 멈춤
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("-----------멀티 스레드 - 인터페이스-------------------");
		
		//p.582 예제2
			//멀티스레드
		//1. 인터페이스에 구현객체
		Runnable beepTask = new BeepTask();
		//2. Thread 클래스 객체 생성시 생성자에 구현 객체 넣기
		Thread thread = new Thread(beepTask);
		//3. thread 객체내 start() 메소드 호출
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); //현재 스레드(main스레드)를 0.5초간 멈춤
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("----------멀티스레드 - 클래스--------------------");
		//p.584 : Thread 클래스를 이용한 멀티스레드
		Thread thread2 = new BeepThread();
		//슈퍼클래스	   = 자식클래스의 생성자
		//		부모 <------ 자식 [자동형변환]
		//		부모 ------> 자식 [강제형변환]
		//2.스레드 객체 내 start() 호출
			//1. run메소드 호출 역할 [멀티스레드 실행]
		thread2.start();	
		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); //현재 스레드(main스레드)를 0.5초간 멈춤
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("----------멀티클래스 - 익명객체--------------------");
		
		//인터페이스 사용방법
			//1.클래스에게 implements 한 후에 구현 -> 구현객체
			//2. 인터페이스에 new 연산자를 통한 추상메소드 구현 -> 익명 객체 
		
		// 익명 스레드 객체
	Runnable runnable = new Runnable() {
				//인터페이스에 new(메모리할당0
				//메모리 할당하기 위해서 추상메소드를 먼저 구현
				//추상메소드를 구현 안 하면 익명객체 선언 불가
		@Override
		public void run() {
			// 구현
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
						Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	};
	Thread thread3 = new Thread(runnable);
	thread3.start();

	for( int i = 0 ; i<5 ; i++ ) {
		System.out.println("띵");
		try { 
			Thread.sleep(500); 
			}
		catch( Exception e ) {
			
		}
	}
	
	System.out.println("----------멀티클래스 - 각 스레드들의 이름--------------------");
		System.out.println("Main메소드 안에 있는 스레드 이름 : " + Thread.currentThread().getName());
			//Thread.currentThread() : 현 코드를 읽어주는 스레드 호출
							//.getName() : 스레드 이름 호출
		System.out.println("작업 스레드1 이름 : "+thread.getName());
		System.out.println("작업 스레드2 이름 : "+thread2.getName());
		System.out.println("작업 스레드3 이름 : "+thread3.getName());
		
		//p.590
		for (int i = 0; i <= 10; i++) {
						//10회 반복처리
			//i가 1일때 가장 먼저스레드 객체 생성 = thread
			// 먼저 생성되어도 순환할당[운영체제가 스케줄링]이므로 가장 먼저 종료되지는 않음
			
			
			//1. i번째 스레드 객체 생성
			Thread thread4 = new CalcThread("thread"+i);
			
			//우선순위
				//만약에 10이 아니면 우선순위 낮게 10이면 우선순위 10
			if (i != 10) {
				thread4.setPriority(Thread.MIN_PRIORITY);
			}else {
				thread4.setPriority(Thread.MAX_PRIORITY);
			}
			
			//2. i번째 스레드 실행
			thread4.start();
		}
		
		
		
	}//me
	
}//ce
