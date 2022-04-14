package Day15;

public class Day15_2 {

	public static void main(String[] args) {
		
		//인터페이스
			//동일한 목적의 여러 (서로 다른)객체 조작
			//1.인터페이스의 멤버
				//1.상수필드 2.추상메소드 3.디폴트메소드 4.정적메소드
			//2.사용방법
				//public class 클래스명 implements  인터페이스명
				//필수 : 추상메소드 구현
			//3.구현객체 생성
				//클래스로부터 메모리 할당 받으면
			//4.익명객체 생성
				//인터페이스에서 직접 구현
		
			//예1) 구현객체 만들기 : 구현한 메소드 재사용 가능
		게임패드 pad1 = new 메이플스토리() {};
		//인터페이스명 객체명 = new(구현한)클래스명();
			//예2) 익명 객체 만들기 : 구현한 메소드 재사용 불가
		//인터페이스명 객체명 = new 인터페이스명(){추상메소드 구현}
			게임패드 pad2 = new 게임패드() {
				@Override
				public void A버튼() {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void B버튼() {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void C버튼() {
					// TODO Auto-generated method stub
					
				}
			};//구현 끝
		
		
		////////////////////////////////////////////////
			
			//인터페이스 내 구현 객체 교체
			//게임교체 
			pad1 = new 피파온라인();
			//
			게임 g1 = new 게임();
			g1 = new 메이플스토리(); //게임교체
			g1 = new 피파온라인();
			
		////////////////////////////////////////////////

		// 			상속[ extends ] 	vs 인터페이스 [interface]
		// 연결수 			1		vs	다중[여러개]			
		//@Override		재정의[수정]	vs	구현[정의]
		//다형성			부모<-자식		vs	부모<-자식
		//목적			빠른 설계		vs	동일한 목적의 서로 다른 클래드들 조작
		//							vs	추상
	
	}//me
}//ce
