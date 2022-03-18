package Day13;

import java.util.Random;

public class Day13_1 {//cs
	
	public static void main(String[] args) {//ms
		
		//p.534 :Math 클래스 (java.lang 패키지) [수학 관련 메소드 제공] 객체없이 사용가능
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("절대값 : " + v1);
		System.out.println("절대값 : " + v2);
		
		System.out.println("올림값 : " + Math.ceil(5.3));	//소수점 첫째 자리에서 올림
		System.out.println("올림값 : " + Math.ceil(-5.3)); 	//가까운 정수로 올림
		
		System.out.println("버림값 : " + Math.floor(5.3));
		System.out.println("버림값 : " + Math.floor(-5.3));
		
		System.out.println("최댓값 : " + Math.max(5, 9));
		System.out.println("최댓값 : " + Math.max(5.3, 2.5));

		System.out.println("최솟값 : " + Math.min(5, 9));
		System.out.println("최솟값 : " + Math.min(5.3, 2.5));
		
		System.out.println("난수 : " + Math.random()); //0~1사이 난수;
		//vs
		Random random = new Random();
		System.out.println("가까운 정수의 실수값 ; " +  Math.rint(5.3));
		System.out.println("가까운 정수의 실수값 ; " +  Math.rint(5.7));
		
		//
		System.out.println("가까운 정수의 정수값 : " + Math.round(5.3));
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								
		//
		
		
		//10. 주사위
		System.out.println("0~1 사이의 실수형 : " + Math.random()); //0~1
		System.out.println(Math.random()*6); //0~6
		System.out.println(Math.random()*6 + 1); //0~6 +1 ->1~7
		int num = (int)(Math.random()*6)+1;
				//(기본자료형) 값/변수 = 강제형변환(큰상자->작은상자 :데이터 손실)
				//double ->int 강제형변환시 -> 소수점 잘림
		System.out.println("1~6 사이의 난수 : " + num);
		///////////////////////////////////////
		System.out.println(("1~6사이의 난수 : "+random.nextInt(6)+1) );
		
		
		
		
		
	}//me
}//ce
