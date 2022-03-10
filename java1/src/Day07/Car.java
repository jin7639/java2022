package Day07;

public class Car {

	//클래스 선언
	
	//1. 필드
	int gas; //가스변수
	
	//2. 생성자
		//생성자 없으면 기본생성자
	
	//3. 메소드
		//1.gas를 외부로부터 받아서 내부에 저장하는 메소드
	void setGas (int gas) {
		//인수 O 반환 X
		//리턴 X 메소드명 (인수1) {네내부변수 ,외부변수
		this.gas = gas;
	}
	
	//2.내부 gas에 데이터 확인 [0=가스없다][1=가스있다]
	boolean isLeftGas() {//인수 X 반환 O
		//논리반환 메소드명()
		if (gas == 0) {
			System.out.println("gas 없습니다.");
			return false; //내부 변수에 gas 가 0이면 false 반환
		}else {
			System.out.println("gas 있습니다.");
			return true; //내부 변수에 gas 가 1이면 true 반환
					
		}
		
	}
	
	//3. gas가 0일때까지 실행하는데 실행할때마다 가스1 씪 감소
	//gas 0이면 함수종료
	
	void run() {
		
		if (gas > 0) {
			System.out.println("달립니다. ( gas잔량 : " + gas);
			gas--;
		} else {
			System.out.println("달립니다. ( gas잔량 : " + gas);
			return;
		}
	}
	
}
