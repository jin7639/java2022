package Day06;

import java.util.Scanner;

public class Day06_6 {//cs
	
	//비회원제 게시판 [클래스 버전]
	
		//0.게시물 설계 -> 클래스 선언
			//필드 : 제목, 내용, 작성자, 비밀번호
			//생성자 : 사용유무 선택
	
		//1.첫화면 [모든 게시물 (번호, 작성자, 제목) 출력]
		//2.메뉴 [1.글쓰기 2.글보기]
			//1.글쓰기 [제목, 내용, 작성자, 비밀번호 ->4개 변서 -> 객체화]
			//2.글보기 [해당 글 번호를 입력받아 해당 글 상세페이지 (번호, 작성자, 제목, 내용) 표시 ]
				//글번호는 배열에 저장되는 순서 [인덱스]
				//글보기 메뉴
			//3.글보기 메뉴 [1.목록보기 2.삭제 3.수정]
				//1.삭제시 : 비밀번호 입력받아 동일하며 삭제
				//2.수정시 : 비밀번호 입력받아 동일하면 제목과 내용만 수정
	
	public static void main(String[] args) {//ms
		
		//준비 [모든 {}안에서 사용되는 변수 선언]
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
			//Board 객체를 100개를 저장할 수 있는 1차원 배열 선언
		
		//프로그램 실행
		while(true) {//프로그램 실행 무한루프
			System.out.println("-------커뮤니티---------");
			//////////////////////////////모든 게시물 조회/////////////////////////////////
			System.out.println("번호\t작성자\t제목");
				//배열내 모든 객체(게시물) 출력 반목문
			int index =0;
			for ( Board board : boardlist  ) {
				if(board != null) {
					System.out.printf("%3d\t%5s\t%5s \n", index , board.writer, board.title);
				}
				index++; //인덱스증가
			}
			////////////////////////////////////////////////////////////////////////	
			System.out.println("1.글쓰기 2.글보기");
			int ch = scanner.nextInt();			
			if (ch == 1) {//글쓰기
				///////////////////////글쓰기/////////////////////////////////////////
				System.out.println("------글쓰기페이지------");
				//1.4개 변수를 입력받는다.
				System.out.println("title : "); String title =  scanner.next();
				System.out.println("content : "); String content =  scanner.next();
				System.out.println("writer : "); String writer =  scanner.next();
				System.out.println("password : "); String password =  scanner.next();
				//2.4개 변수를 객체화 [객체를 만들어서 4개변수를 객체내 필드에 저장]
				Board board = new Board(title, content, writer, password);
					//4개 필드를 갖는 생성자 사용
				//3. 배열내 빈공간을 찾아서 빈공간에 객체 대입
				int i =0;
				for ( Board temp :  boardlist) {
					if (temp == null) {//빈 공간 찾았으면
						boardlist[i] = board;//해당 인덱스에 새로운 객체 저장
						break; //한번 저장했으면 끝 
					}
					i++;
				}
				
				
			}else if (ch ==2) {//글목록 -> 글보기
				//해당 글 번호를 입력받아 해당 글 상세페이지 (번호, 작성자, 제목, 내용) 표시
				//글번호는 배열에 저장되는 순서 [인덱스]
				//글보기 메뉴
				System.out.println("글 번호 : "); int bno = scanner.nextInt(); //현 게시물의 인덱스 번호
				
				//반복 X -> 출력할 위치를 입력받았기 때문에 반복 안 해도 됨
				System.out.printf("작성자 : %s    제목 : %s  \n",boardlist[bno].writer, boardlist[bno].title);
				System.out.printf("내용 : %s \n", boardlist[bno].content);
				
				System.out.println("------------------------");
				System.out.println("1.목록보기 2.글삭제 3.글수정");
				int ch2 = scanner.nextInt();
				
				if ( ch2 ==1 ) {//목록보기 (뒤로가기)
					//반복문 없으면 무조건 나가짐
					//알아서 코드 밑으로 진행
				} else if (ch2 == 2) {
					////////////////////////////글삭제//////////////////////////////////////////
					System.out.println("현재 게시물 비밀번호 : "); String password = scanner.next();
					//반복문X - >이미 누구를 삭제할지 정해져 있는 상태 (인덱스 번호 입력받음)
					if(boardlist[bno].password.equals(password)) {
						System.out.println("삭제 되었습니다."); ///해당 게시물 null로 변경
						boardlist[bno] = null;
						//삭제 후에 삭제된 인덱스 뒤로 한칸씩 앞으로 이동
						//만약 해당 코드가 없을 경우 배열 내 사이사이에 공백 발생
						for (int i =bno;  i<=boardlist.length ; i++) {
							//검색된 게시물의 인덱스 부터 마지막 인덱스 까지 1씩증가
							boardlist[bno] = boardlist[bno+1]; //삭제된 게시물 다음 게시물
							
							
							if (i == boardlist.length-1 ) {
								boardlist[boardlist.length-1] = null;
							}
						}
					} else {
						System.out.println("비밀번호가 다릅니다.");
					}
				} else if (ch2 == 3) {
					///////////////////////////글수정//////////////////////////////////
				System.out.println("현재 게시물 비밀번호 : "); String password = scanner.next();
				
					if (boardlist[bno].password.equals(password)) {
						System.out.println("수정할 제목 : ");	boardlist[bno].title = scanner.next();
						System.out.println("수정할 내용 : ");	boardlist[bno].content = scanner.next();
						
					}else {
						System.out.println("비밀번호가 다릅니다.");
					}
					
				} else {//그외
					System.err.println("알 수 없는 번호입니다.");
				}
				
			} else {
				System.err.println("알 수 없는 번호입니다.");
			}
			
		}//프로그램 실행 while end
		
		
		
		
		
	}//me
}//ce
