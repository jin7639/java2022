package Day10;

public class Television implements RemoteControl , Searchable{
		//클래스명 implements 인터페이스명
	
	private int volume;
	
	
	
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			//리모콘의 최대소음보다 크면 소음을 10으로 대입 [제한]
			this.volume = RemoteControl.MAX_VOLUME;
					
		}else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}

	@Override
	public void search(String url) {
	// TODO Auto-generated method stub
	
	}

}



