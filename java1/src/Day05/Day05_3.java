package Day05;

import java.util.Scanner;

public class Day05_3 {//cs
	
	public static void main(String[] args) {//ms
		
//		//182p 7)무슨말인지...
//		
//		//8)
//		int[][] array = {
//				{95, 86},
//				{83, 92, 96},
//				{78, 83, 93, 87, 88}
//		};
//		
//		int sum = 0 ;
//		double avg = 0.0;
//		
//		int count = 0; //점수의 개수
//		
//		//풀이
//		//2차원 배열 내 모든 데이터 호출
//		for (int i = 0; i < array.length; i++) {
//			//i = 행. 행은 0부터 배열의 행길이[3]미만까지 1씩증가
//			for (int j = 0; j < array[i].length; j++) {
//				//j = 열. 열은 0부터 배열의 열길이[2,3,5]까지 1씩 증가
//				sum += array[i][j]; //누적합계
//			}
//			count += array[i].length; //열길이 누적합계ㄴ
//		}
//		
//		avg = (double)sum / count ;
//		
//		System.out.println("sum : " + sum);
//		System.out.println("avg : " + avg);
		
		//9)
		
		boolean run = true; //while문 스위치 변수
		int studentNum = 0; //학생수 변수
		int[] scores = null; //점수 배열
		Scanner scanner = new Scanner(System.in);
		
		while(run) {//무한루프 [종료조건 : 5번 종료]
			System.out.println("------------------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("------------------------------------");
			System.out.println("선택 : ");
			
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				System.out.println("학생수>"); studentNum = scanner.nextInt();
				//입력받은 학생수 만큼 배열길이 변경
				scores = new int[studentNum];
			} else if (selectNo == 2) {//학생 점수 입력받기
				for (int i = 0; i < scores.length; i++) {
					System.out.printf(" scores[%d] : " , i ); 
					scores[i] = scanner.nextInt();
				}
			} else if (selectNo == 3) {//학생 점수 출력하기
				for (int i = 0; i < scores.length; i++) {
				System.out.printf("score[%d] : %d \n", i, scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				int sum = 0 ;
				double avg = 0.0;
				
				int count = 0; //점수의 개수
				
				for (int i = 0; i < scores.length; i++) {
					//최고점수 구하기
					if ( max < scores[i]) {
						max = scores[i];
					//누적합계
						sum += scores[i];
					}
					//평균점수 구하기
					avg = (double)sum / scores.length;
				}
				
				avg = (double)sum / count ;
				System.out.println("총 합계 : " + max);
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
			
			
			
		}
		
		
		
		
	}//me
	

}//ce
