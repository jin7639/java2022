package Day12;

import java.io.IOException;
import java.util.Iterator;

public class Day12_3 {

	public static void main(String[] args) throws IOException {
		
		// 도서 검색 프로그램
					// [조건]
					// 1. 입력받기 [ System.in.read() ]
					// 2. String 배열내 여러 도서가 저장 
						//		String[] 도서목록 = {	
						//			"된다! 네이버 블로그&포스트",
						//			"스프링 부트 실전 활용 마스터",
						//			"Tucker의 Go 언어 프로그래밍",
						//			"혼자 공부하는 C 언어"
						//};
					// 3. 검색기능 , 수정기능 
						// 검색기능 : 특정 문자를 입력받아 도서내 포함된 문자가 있으면 모두 출력 
							// '언어' 검색 ->  "Tucker의 Go 언어 프로그래밍" / "혼자 공부하는 C 언어"
						// 수정기능 : 수정할 도서명의 일부를 입력받아 출력된 도서명중 번호를 선택 
							// '수정' 수정 -> 선택된 도서명의 수정할 문자와 새로운 문자 입력받아 ->  수정 완료 
		
		String[] books = {"된다! 네이버 블로그&포스트", "스프링 부트 실전 활용 마스터" , "Tucker의 Go언어 프로그래밍", "혼자 공부하는 C 언어"};
		
		while(true) {
		System.out.println("1.도서 검색 2.도서 수정");
		byte[]bytes = new byte[100];
		//키보드로 부터 [스트림]바이트를 읽어오기 // 일반예외!!
		int count = System.in.read(bytes); 	//바이트배열 -->문자열 변환 [-2차감 =\n\r]
		String ch = new String(bytes , 0 , count-2);
		
		if (ch.equals("1")) {
			System.out.println("*** 검색 ***");
			System.out.println("검색 : ");
			count = System.in.read(bytes); 
			String search = new String (bytes , 0 , count-2);
			for(String temp : books) {
				if (temp.indexOf(search) != -1) {//인덱스오브 에서 마이너스일은 동일한 단어 없다는 뜻
					System.out.println(temp);
					
				}
			}
			
//			//방법2
//			if (temp.contains(search)) {//문자열.contains("찾을문자")
//				System.out.println(temp);
//			}
			
			
		}else if(ch.equals("2")) {
			System.out.println("*** 수정 ***");
			System.out.println("수정할 도서 검색 : ");
			count = System.in.read(bytes);
			String search = new String(bytes, 0 , count-2);
			int i = 0;  
			for (String temp : books ) {
				if (temp.contains(search)) {
					System.out.println("도서번호 : "+i+"번 | 교재명 : "+ temp);
				}
				i++;
			}
			//도서번호 [인덱스] 입력받아 수정하기
			System.out.println("도서번호 선택 : ");
			count = System.in.read(bytes);
			String ch2 = new String (bytes, 0 ,count -2);
			int index = Integer.parseInt(ch2);
			
			System.out.println("기존 문자 : ");
				count = System.in.read(bytes);
				String oldstr = new String (bytes, 0 , count-2);
			System.out.println("새로운 문자 : ");
				count = System.in.read(bytes);
				String newstr = new String (bytes, 0 , count-2);

			books[index] = books[index].replace(oldstr, newstr);
			System.out.println("변경되었습니다.");
		
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		
		}//while end
	}//me
}//ce
