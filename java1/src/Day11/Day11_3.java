package Day11;

public class Day11_3 {

	//422 예외 던지기
		//목적 : 모든 메소드에서 try {} catch(){} 사용시 코드 복잡함 -> 한 곳으로 예외 이동
	
	public static void main(String[] args) {
		try {findclass();} 
		catch (Exception e) {}
		
		try {
			withdraw(30000);
		} catch (Exception e) {
			System.out.println( e );
		}
		
	}
//	1.try~catch
//	public static void findclass() {
//		try {//예외가 발생할 것 같은 코드 (실행예외) 혹은 일반예외[무조건]
//			Class clazz = Class.forName("java.lang.String2");
//		}catch (Exception e) {//예외가 발생하면 실행되는 코드
//				//모든 예외 저장가능
//			System.out.println(e);
//		}
//	}
	
//	2.예외 던지기 [메소드명() throws 예외 클래스명]
	public static void findclass() throws Exception{
		Class clazz = Class.forName("java.lang.String2");
		
	}
	
	
	//444~445 : 예외 만들기
	public static void withdraw (int money) throws Exception{
		if (20000 < money) {
			throw new Exception("잔고부족");
		}
	}
	
	
	
}
