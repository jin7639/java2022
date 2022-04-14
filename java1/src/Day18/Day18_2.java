package Day18;

import java.util.Vector;

public class Day18_2 {

	public static void main(String[] args) {
		//p.730
			//	ArrayList 	vs 	Vector
		//동기화 		X				O
		//스레드	싱글스레드(main)	멀티스레드(Thread, Runnable)
		
		
		//Vector 클래스
		//1.Vector 리스트객체 선언
		Vector<Board> list= new Vector<>();
		//2.리스트객체내 추가
			//1.리스트내 객체 바로 추가 new : 객체 메모리할당
		//2.
		Board board = new Board("제목2","내용2","글쓴이2");
		list.add(board);
		list.add(new Board("제목3", "내용3", "작성자3"));
			
		System.out.println("확인 : " + list);
		//3.검색
		System.out.println("객체 검색 : " + list.contains(board));
		System.out.println("객체 검색 위치 : " + list.indexOf(board));
		//4.삭제
		list.remove(2); System.out.println("2번 인덱스 삭제 후 : "+ list);
		list.remove(2); System.out.println("2번 인덱스 삭제 후 : "+ list);
		//반복문 이용한 리스트 객체내 모든 객체 출력
		for (int i = 0; i < list.size(); i++) {
			Board temp = list.get(i);
			System.out.println(temp.제목+"\n"+temp.내용+"\n"+temp.작성자);
		}
		//반복문2
		System.out.println("--------------------------------");
		System.out.println("제목\t내용\t작성자");
		for (Board temp : list) {
			System.out.println(temp.제목+"\n"+temp.내용+"\n"+temp.작성자);
		}
	}
	
}
