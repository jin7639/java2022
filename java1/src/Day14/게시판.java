package Day14;

import java.util.ArrayList;

public class 게시판 {

	//1. 필드
		private String title;
		private String contents;
		private String writer;
		private int point;
		private 게시판 게시판 = new 게시판();
		private ArrayList<String> list = new ArrayList<>();
		private 게시판[] 게시물목록 = new 게시판[100];	
		//저장하는 목록 [객체 생성시 초기값 = 처음값]
			//1. 빈생성자
		public 게시판() {}
			//2. 모든필드 생성자
		public 게시판(String title, String contents, String writer, int point, 게시판 게시판, ArrayList<String> list,
				게시판[] 게시물목록) {
			super();
			this.title = title;
			this.contents = contents;
			this.writer = writer;
			this.point = point;
			this.게시판 = 게시판;
			this.list = list;
			this.게시물목록 = 게시물목록;
		}
		
		
		
		

}//ce
