package Day09;

public class Day09_1 {//cs

	public static void main(String[] args) {//ms
		//상속
			//부모에게 물려받는 것
			//현실 : 부모 ---> 자식 선택
			//프로그래밍 : 자식 --->부모 선택
			//extends : 연장하다 [상속하다]
			//목적 : 빠른 설계 [기존에 있던 클래스를 연장해서 새로은 클래스를 설계
			//부모클래스 지정은 하나만 가능
		
		//p.290
		//1.서브클래스로 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		//CellPhone으로부터 상속받은 필드
		System.out.println("모델 : "+dmbCellPhone.model);
		System.out.println("색상 : "+dmbCellPhone.color);
		
		System.out.println("채널 : "+ dmbCellPhone.channel);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		
	}//me
	
	
	
}//ce
