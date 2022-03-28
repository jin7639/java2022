package Day19;

import java.util.HashSet;
import java.util.Scanner;

public class Day19_2 {
	
	// set 중복 불가능
		//객체내 모든 필드가 동일하면 중복 불가능
		
	
	
	public static void main(String[] args) {
	
		//로또 프로그램
			//set 컬렉션
			//Day4 - > 배열 
		Scanner scanner = new Scanner(System.in);	//1.입력객체
		HashSet<Integer> set = new HashSet<>();		//2.set컬렉션 HashSet 클래스 객체 선언
		
		
		while(true) {	//무한루프 [종료조건 : set 객체내 객체수가 6이면 break]
			System.out.println("1~45 숫자 선택(중복불가) : ");
			int num = scanner.nextInt(); //3. 입력받기
			
			if(num < 1 || num > 45) { //4. 1~45 사이가 아니면 다시 입력받기
				System.out.println("선택할 수 없는 번호입니다.");
			}else {
				set.add(num); //5.1~45 사이면 set객체에 저장
				System.out.println("확인 : " + set);
			}
			
			if (set.size() == 6) { //set 객체내 객체수가 6이면 종료
				break;
			}
			
		}//while end
		
		
		
		
		
		
	}//me
}//ce
