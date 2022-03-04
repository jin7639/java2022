package Day4;

import java.util.Random;
import java.util.Scanner;

public class Day04_5 {//cs
	
	public static void main(String[] args) {//ms
		
		/*
		 * 로또 판별기 
		 * 사용자 6개 수 입력받기 -> 배열저장 
		 * 		1~45사이 수 만 입력 가능 아니면 재입력 
		 * 		중복 불가 중복이면 재입력 
		 * 추첨번호 :컴퓨터 난수 6개 발생 -> 배열 저장 
		 * 		1~45사이 
		 * 		중복불가 
		 * 사용자 번호와 컴퓨터 추첨번호 동일 수 개수
		 */
		
		//준비		
		int[] 사용자번호 = new int[6]; //사용자가 선택한 번호 목록
		int[] 추첨번호 = new int[6]; //컴퓨터 난수 번호 목록
		Scanner scanner = new Scanner(System.in);
		
		//사용자에게 입력받기
		for(int i = 0; i < 6; i++) {
			//i는 1부터 6까지 1씩 증가 반복 -> 6회반복
			System.out.println("1~45 사이 입력");
			int 번호 = scanner.nextInt();
			
			boolean 통과 = true;
			
			if(번호 < 1 || 번호 > 45) {
				
				//조건1 : 유효성검사
				System.out.println("선택할 수 없는 번호 입니다.");
				//1보다 작거나 45보다 크면 선택할 수 없는 번호 입력시 재입력
				i--; // 횟수 반환 (현재 i는 정상입력이 아니기 때문)
				통과 = false;
			}// if end
			
			//조건2 : 중복체크
			
			for( int j = 0; j < 6; j++) {
				//배열내 모든 인덱스 호출
				if(번호 == 사용자번호[j]) {
					//입력받은 값과 j번째 인덱스 값이 같은지 비교
					System.out.println("이미 선택한 번호입니다. [재입력]");
					i--; //횟수 반환 (현재 i는 정상입력이 아니기 때문)
					통과 = false;
				} //if end
			}//for2 end
			
			//정상입력 이면 배열에 저장하기
			if (통과) {
				사용자번호[i] = 번호;
			}
			
		}//for end
		
		System.out.print("\n선택한 번호 : ");
		
		// 사용자 배열 내 모든 인덱스 출력
		for ( int temp : 사용자번호) {
			System.out.print( temp + "\t");
		}
//		
//		//컴퓨터가 난수생성
//		
		for(int i = 1; i < 6; i++) {
			//i는 1부터 6까지 1씩 증가 반복 -> 6회반복
			Random random = new Random(); //난수객체
			int 추첨 = random.nextInt(45)+1; //난수를 int형으로 가져오기
								//random.nextInt() : +- 20억 사이 중 난수 발생
								//

			boolean 통과 = true;
			
//			for( int j = 0; j < 6; j++) {				
//				//조건 : 중복체크
//				//배열내 모든 인덱스 호출
//				if(컴퓨터 == 추첨번호[j]) {
//					//입력받은 값과 j번째 인덱스 값이 같은지 비교
//					System.out.println("이미 선택한 번호입니다. [재입력]");
//					i--; //횟수 반환 (현재 i는 정상입력이 아니기 때문)
//					통과 = false;
			for(int temp :추첨번호) {
				if(추첨 == temp) {
					i--;
					통과 = false;
				}
					
			} //for end
			
			if (통과) 추첨번호[i] = 추첨;
			
		}
		System.out.print("\n추첨 번호 : ");
		//배열 내 모든 인덱스 출력
		for (int temp : 추첨번호) {
			System.out.print(temp + "\t");
		}
		
		
		//비교 = 두 배열간 동일한 수 찾기
		
		//방법1
		int 동일한수 = 0;
		for( int i =0; i<사용자번호.length; i++ ) {
			//i비교 기준점
			for(int j=0; j<추첨번호.length; j++ ) {
				//j 비교 대상
				if (사용자번호[i] == 추첨번호 [j]) {
					동일한수++;
				}
			}
		}
		System.out.println("동일한 수 : " + 동일한수);
		
		//방법2
//		for(int 비교기준 : 사용자번호 ) {
//			//사용자번호 배열내 하나씩 비교기준 대입
//			for( int 비교기준 : 추첨번호) {
//				//추첨번호 배열 내 하나씩 배교대상 대입
//				if (비교기준 == 비교대상) 동일한수++;
//			}
//		}
		
		
		
	}//me

}//ce
