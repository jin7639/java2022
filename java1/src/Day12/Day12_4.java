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
		Scanner scanner = new Scanner(System.in);//입력객체
		String[] carlist = new String[10]; //문자열 10개 저장할 수 있는 배열 [차량번호 최대 10개 저장 가능]
		String[] evenlist = new String[10];//짝수차량 배열
		String[] oddlist = new String[10];//홀수차량 배열
		while(true) {//무한루프
			
			//모든 차량 출력
			System.out.println("***주차중인 모든 차량번호 ***");
			for(String temp : carlist) {
				if (temp != null) {
					if (Integer.parseInt(temp) % 2 == 0) {
						System.out.println(temp+"[짝] ");
					}else {	
						System.out.println(temp + "[홀] ");
					}
				}
			}
			//짝수차량 출력
			System.out.println("주차중인 짝수차량");
			for( String temp : evenlist) {
				if (temp != null) {
					System.out.println(temp + " ");
				}
			}
			
			//홀수차량 출력
			System.out.println("주차중인 홀수차량");
			for( String temp : oddlist) {
				if (temp != null) {
					System.out.println(temp + " ");
				}
			}
			
			//차량 번호 부여
			System.out.println("1.차량입차");
			int ch = scanner.nextInt();
			if (ch == 1) {
				//차량번호 난수 생성
				Random random = new Random();	//랜덤객체
				int intnum = random.nextInt(10000);
				String carnum = String.format("%04d", intnum);
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
				//짝수 홀수 차량 분배
				if (save == true) {
					//짝수 홀수 차량 분배
					if (Integer.parseInt(carnum) % 2 == 0 ) {
						//짝수차량배열에 저장
						for (int i = 0; i < evenlist.length; i++) {
							if (evenlist[i] == null) {
								evenlist[i] = carnum;
								break;
							}
						}
					}else {
						for (int i = 0; i < oddlist.length; i++) {
							if( oddlist[i] == null ) { 
								oddlist[i] = carnum; break; 
							}
						}
					}
				}
				
				
				
				
				if (save == false) {
					System.out.println("만차");
				}
			}
		}
		
	}//me
	
}//ce
