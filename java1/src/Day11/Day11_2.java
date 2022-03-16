package Day11;

public class Day11_2 {

	//422
		//컴퓨터 하드웨어 문제 에러 [실행불가능]
		//사용자의 잘못된 조작 혹은 개발자의 잘못된 코딩 등의 에러 예외
		//종료 : 1.일반예외	2.실행예외
			//일반예외 : 컴파일[실행]전에 예외 검사 [개발자에게 강제 예외처리= 외부통신 (실행전)]
			//실행예외 : 컴파일[실행]후에 예외 검사	[개발자의 경험에 판단해서 예외처리]
	//예외처리 
		//목적 : 에러가 발생하면 (안정성에 문제가 생기면)프로그램 종료
		//만약에 에러가 발생하면 대체 코드 실행 [프로그램이 종료되지 않게함]
	
	
	public static void main(String[] args) {
		
		//423
		try {
			String data = null;
			System.out.println(data.toString());	//Object 클래스 메소드 : toString() : 객체정보출력
				//실행전에는 에러없음 ... 실행후에 [실행예외]
			//에러 발생 이유 : null은 메모리할당이 없기 때문에 객체 정보 출력 불가
		}catch(NullPointerException 객체명) {
			System.out.println("예외발생 : "+객체명);
		}
		
		
		//424
		try {
		String[] 배열 = new String[2];
		배열[0] = "a"; 배열[1] = "b"; 배열[2] = "C";
		}catch (ArrayIndexOutOfBoundsException e) {
				//예외발생한 예외클래스명 객체명 = 객체에 예외 이유가 저장됨
			//만약 예외가 발생한다면 실행되는 코드
			System.out.println("예외발생 : " + e);
		}
		
		//426
		try {
			String data1 = "100";
			String data2 = "a100";
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
							//문자열을 정수로 바꿔줌
							//단, "100" ---> 100 [가능] / "a100" --> a100 [불가능] a는 정수로 표현 불가
			//에러 발생 이유 : 문자열 내 숫자형식은 변환이 가능하지만 문자열 내 문자형식 변환 불가능
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "="+ result );
			
		}catch (NumberFormatException e) {
			System.out.println("오류발생 : "+ e);
		}				
		
		//428
		try {
			String 문자열 = "유재석";	//자바 클래스 중 하나
			Object 슈퍼객체 ; 			//자바 클래스내 최상위 클래스
			
			슈퍼객체 = 문자열;
			문자열 = (String)슈퍼객체;
				//강제형변환
				//실행중에 형변환
			//예외처리 판단
				//입출력(사용자 입장) 관련된 코드 [무조건 예외코드]
		}catch (Exception e) {
			System.out.println("예외발생 : "+ e);
		}
	}//me
	
	
}//ce
