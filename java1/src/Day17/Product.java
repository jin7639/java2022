package Day17;

public class Product<제네릭타입1, 제네릭타입2> {
	//ㅇ외부로부터 받을ㅈ ㅏ료형 :ㅇㅏ무거나

	private 제네릭타입1 kind;
	private 제네릭타입2 model;
	
	public static <제네릭타입1> Box<제네릭타입1> boxing(제네릭타입1 kind) {
//메소드 선언부
	//접근 제한자 정적 	반환타입=<제네릭타입1> Box<제네릭타입1> boxing:메소드이름(제네릭타입)
		
		Box<제네릭타입1> box = new Box<>();
		box.set(kind);
		return box;
	}
	
	
	public 제네릭타입1 getKind() {
		return kind;
	}
	public void setKind(제네릭타입1 kind) {
		this.kind = kind;
	}
	public 제네릭타입2 getModel() {
		return model;
	}
	public void setModel(제네릭타입2 model) {
		this.model = model;
	}

	
	





}
