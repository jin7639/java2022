package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4 {

	//차량번호 구분 프로그램
	//조건
		//1.난수 0000~9999 상의 난수 10개 생성해서 배열에 저장
		//2.모든 차량 번호를 배열에 저장
		//3.끝자리 번호로 홀/짝 구분
		//4.차량 끝번호가 홀수인 차량 출력
		//4.차량 끝번호가 짝수인 차량 출력
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] carlist = new String[10];
		while(true) {
			
			//모든 차량 출력
			for(String temp : carlist) {
				if (temp != null) {
					System.out.println(temp+" ");
				}
			}
			//짝수차량 출력
			System.out.println("짝수차량");
			for (int i = 0; i <carlist.length; i++) {
				if (carlist[i] != null && Integer.parseInt(carlist[i]) % 2 == 0) {
					System.out.println(carlist[i]);
				}
			}
			
			System.out.println("홀수차량");
			//홀수차량 출력
			for (int i = 0; i <carlist.length; i++) {
				if (carlist[i] != null && Integer.parseInt(carlist[i]) % 2 == 1) {
					System.out.println(carlist[i]);
				}
			}
			
			//차량 번호 부여
			System.out.println("1.차량입차");
			int ch = scanner.nextInt();
			if (ch == 1) {
				//차량번호 난수 생성
				Random random = new Random();	//랜덤객체
				int intnum = random.nextInt(10000);
				String carnum = String.format("%4d", intnum);
										//형식
											//%d 정수
											//%숫자d : 숫자만큼 자릿수 [만일 해당 자릿수가 없으면 공백]
											//%0숫자d : 숫자만큼 자릿수 [만일 해당 자릿수가 없으면 0넣기]
				boolean save = false;
				for( int i = 0; i<carlist.length; i++) {
					if (carlist[i] == null) {
						carlist[i] = carnum;
						save = true;
						break;
					}
				}
				
				if (save == false) {
					System.out.println("만차");
				}
			}
		}
		
	}//me
	
}//ce
