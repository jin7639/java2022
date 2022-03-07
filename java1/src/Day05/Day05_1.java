package Day05;

public class Day05_1 {//cs
	
	public static void main(String[] args) {//ms
		
		//변수 : 하나의 데이터 저장
		//배열 : 동일한 자료형 데이터 특정기준[인덱스]으로 나열
		//1차원 배열 : 길이
			//형태 : 자료형 [] 배열명 = new 자료형[길이]
			// int[] arr = new int[3];
			// int int int
			//int 형 변수 3개 저장할 수 있는 배열
		//2차원 배열 : 가로길이 세로길이
			//형태 : 자료형[][] new 자료형[가로=행][세로=열]
			//int[][] arr2 = new[4][3];
			//int int int
			//int int int
			//int int int
			//int int int
			//int형 변수 12개 저장할 수 있는 배열
		//3차원 배열 : 가로 세로 높이
			//형태 : 자료형[][][] = new 자료형[행][열][높이]
		
		
		//예제1
		int[] 배열 = new int[3]; //int : 4바이트 -> 12바이트 배열
		배열[0] = 80; //0번 인덱스에 80 데이터 대입
		배열[1] = 90; 배열[2] = 100;
		
		int[][] 배열2 = new int[2][3]; //[행][열] 4바이트*2*3 => 24바이트 배열
			배열2[0][0] = 80; 배열2[0][1] = 90; 배열2[0][2] = 100;
			배열2[1][0] = 40; 배열2[1][1] = 50; 배열2[1][2] = 60;
		
		System.out.println("1차원 배열 : " + 배열);
		System.out.println("2차원 배열 : " + 배열2);
		
		System.out.println("1차원 배열 길이 : " + 배열.length);
		System.out.println("2차원 배열 행 길이 : " + 배열2.length);
		System.out.println("2차원 배열 열 길이 : " + 배열2[0].length);
		
		//예2) 반복문을 이용한 0~45까지 첫번째 행에 저장	
				//50~99까지 두번재 행에 저장하는 2차원 배열 선언
		int[][] 배열3 = new int[2][50]; //400바이트 배열
		
		for
		( int i = 0; i<100; i++) {
			//i는 0부터 100미만까지 1씩 증가 실행 반복처리 -> 총 100회
			if (i<50) 배열3[0][i] = i;
			//첫번째 행 값 넣기
			// i가 50미만이면 첫행
			else 배열3[1][i-50] = i;
			//i가 50 이상이면 두번째 행
		}
				
		//출력
		for (int i = 0; i < 100 ; i++) {
			//첫번째 행 출력
			if (i<50)System.out.printf("%d", 배열3[0][i]);
			//%d : 정수	//%2d : 두칸 차지. 단 데이터 없으면 공백
			else System.out.printf("%d", 배열3[1][i-50]);
			if (i==49) System.out.println();
		}
	
	}//me

}//ce
