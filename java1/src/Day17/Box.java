package Day17;

public class Box<T> {
			// <제네릭타입>
			// <아무거나 : 자료형 이름>
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t = t;
	}
}
