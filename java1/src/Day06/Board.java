package Day06;

public class Board {//cs

	//Board 클래스 선언
		//main 메소드 X -> 코드 실행할 때 쓰는 메소드
		//자동 : 오른쪽클릭 -> source ->generate field
	//1. 필드
	String title;
	String content;
	String writer;
	String password;
	
	//2.생성자
		//1.빈생성자
	Board(){}
		//2.1개 필드를 받는 생성자
	Board(String title){//외부변수
		this.title = title;
		//this.필드명 -> 내부변수
		//외부로부터 들어온 제목을 내부변수에 저장
	}
		//3.2개 필드를 받는 생성자
	Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
		//4.3개 필드를 받는 생성자
	Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
		//5.4개 필드를 받는 생성자
	Board(String title, String content, String writer, String password) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
	}
	
	
	
	
	//3.메소드
	
	
}//ce
