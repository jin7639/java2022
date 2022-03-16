package Day10;

public interface RemoteControl {//인터페이스 선언

	//멤버
		//1.상수필드 : 고정된 데이터
	public int MAX_VOLUME = 10;	//리모컨 최대음량
	public int MIN_VOLUME = 0;	//리모컨 최소음량
		//2.추상메소드** : 선언O 구현X
	public void turnOn();	//{}생략 [ 구현X]
	public void turnOff(); 	//구현 x
	public abstract void setVolume(int volume);	//구현 x
		//3.디폴트 메소드 : 선언O 구현O
	default void setMute (boolean mute) {
		if(mute) {
			System.out.println("무음처리");
		}else {
			System.out.println("무음 해제");
		}
	}
		//4.정적메소드 : 선언O 구현O [객체없이 가능]
	static void changeBattery() {
		System.out.println("건전지 교체합니다.");
	}
	
}
