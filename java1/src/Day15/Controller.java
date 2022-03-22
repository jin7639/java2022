package Day15;

import java.util.ArrayList;

public class Controller {

	//1.배열
	public static Car[] carlist = new Car[100];
	//2.리스트
	public static ArrayList<Car> carlist2 = new ArrayList<>();
	
	
	//입차 메소드
	public static boolean 입차(String 차량번호) {
		
		//입차 코드 작성
			//1.입력받은 차량번호 (인수) 가져온다.
			//2. 입차날 짜 구한다
			//3. 입차 시간을 구한다
			//  출차시간 , 금액은 출차시에
			//4.차량번호, 입차날짜, 입차시간 -> 3개변수 -> 객체화
			//5.차량객체를 배열이나 리스트에 저장
			//6. 파일처리 or DB 처리
		
		return false;
	}
	//출차 메소드
	public static boolean 출차(String 차량번호) {
		
		//until
		//1. 입력받은 차량번호(인수)가져온다
		//2. 배열이나 리스트내 동일한 차량번호를 찾아서
		//3. 출차시간(현재시간)을 구한다
		//4. 계산 [출차시간 - 입차시간 -> (분-30)/10 *1000
		//    chronounit.min
		//5. [수정]찾은 객체내 출차시간과 금액을 대입한다.
		
		
		return false;
		
		
	}




}



