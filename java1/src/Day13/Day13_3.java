package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3 {
	public static void main(String[] args) {//ms
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("연도 : "); int year = scanner.nextInt();
		System.out.println("월 : "); int month = scanner.nextInt();
		
		달력(year, month);
		
	}//me


		//1.달력 메소드
	public static void 달력 ( int year, int month) {
		Scanner scanner = new Scanner(System.in);
		while(true) {//무한루프 [종료조건 :4번]
			//1.캘린더 클래스 내 현재 시간/날짜 객체 호출
			Calendar calendar = Calendar.getInstance();
			
			//해당 월의 1일 요일 찾기
				//1.사용자 정의 캘린더 설정
			calendar.set(year, month-1, 1); //예)3월1일
				//2.3월 1일의 요일
				int sweek = calendar.get(Calendar.DAY_OF_WEEK);
				//3.3월의 마지막 일
				int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
			//3. 출력
			System.out.println("\n\n********************** "+year+"년" + month+"월 ******************");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
		
			//현재 월 1일의 위치 앞에 공백 채우기
			for (int i = 1; i < sweek; i++) {
				System.out.print("\t");
			}
			//1일부터 마지막 날까지 출력
			for(int i = 1; i<=eday ;i++) {
				//i = 일수 출력
				System.out.print(i+"\t");
				
				//토요일마다 줄바꿈처리 [ 토요일=7] 요일이 7배수마다
				if (sweek % 7 == 0) System.out.println();
				
				//하루씩 요일 증가
				sweek++;
				
			}
			
			//버튼 [1.이전달 2.다음달 3.다시검색 4.종료]
		try {	
			System.out.println();
			System.out.println("1.이전달 2.다음달 3.다시검색 4.종료");
			int ch = scanner.nextInt();
				
			if (ch == 1) {
				month -= 1;
				if (month == 0) {
					month =12;
					year -= 1;
				}
			}else if (ch == 2) {
				month += 1;
				if (month == 13) {
					month = 1;
					year +=1;
				}
			}else if (ch == 3) {
				System.out.println("연도 : ");  year = scanner.nextInt();
				System.out.println("월 : "); month = scanner.nextInt();
			}else if (ch == 4) {
				System.out.println("달력 종료");
				break;
			}
		}catch (Exception e) {//만약에 try 에서 예외[에러]가 발생하면 해당 코드 실행
			System.out.println("정상적인 입력이 아닙니다.");
		}
		
		}//while end
	}//달력 end	
		
}//ce