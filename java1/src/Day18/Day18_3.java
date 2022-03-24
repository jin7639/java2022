package Day18;

import java.util.ArrayList;
import java.util.LinkedList;

public class Day18_3 {

	public static void main(String[] args) {

		//p.731~732 : LinkedList 클래스
		//			ArrayList			vs	LinkedList
		//				배열				vs		링크
		//내부구조차이	인덱스기준으로 메모리연결[통]	서로 다른 메모리주소 연결
		//속도		
		//add[추가]		빠름				vs	
		//add[삽입=중간]							빠름
		//검색			빠름				vs		
		//삭제									빠름
		
		//1. ArrayList 객체 선언 [제네릭 : String]
		ArrayList<String> list1 = new ArrayList<>();
		
		//2.LinkedList 객체 선언 [ 제네릭 : String]
		LinkedList<String> list2 = new LinkedList<>();
		
		//3.
		Long starttime;	//시작시간
		Long endtime;	//끝나는 시간
		
		//4.arraylist 객체에 10000개 객체를 삽입하는데 걸리는 시간 체크
		starttime =  System.nanoTime();	//현재 시간을 나노시간으로 호출
		
		for (int i = 0; i < 100000; i++) {
			list1.add(0, i+"");	//정수->문자열 변환 : 1. String.valueOf(정수) 2.정수+""
								//문자열->정수 변환 : 1. Integer.parseInt(문자열)
		}
			endtime = System.nanoTime();
			System.out.println("ArrayList가 10000개 삽입하는데 걸리는 시간 : " + (endtime-starttime)+"ns");
		
		//5.LinkedList 객체에 10000개 객체를 삽입하는데 걸리는 시간 체크
			starttime = System.nanoTime();
			for (int i = 0; i < 100000; i++) {
				list2.add(0, i+"");	//정수->문자열 변환 : 1. String.valueOf(정수) 2.정수+""
									//문자열->정수 변환 : 1. Integer.parseInt(문자열)
			}
			endtime = System.nanoTime();
			System.out.println("LinkedList가 10000개 삽입하는데 걸리는 시간 : " + (endtime-starttime)+"ns");
			
		
	}
	
}
