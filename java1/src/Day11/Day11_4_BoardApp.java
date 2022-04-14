package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {

	//게시판/댓글 프로그램 [ 예외처리 , 파일처리 , 리스트 ]
		//[m]게시물 클래스
			//번호=인덱스, 제목, 내용, 작성자, 작성일, 조회수
			//댓글리스트
		//[m]댓글 클래스
			//내용, 작성자, 작성일
		//[c]컨트롤러 클래스
			//1.목록 2.쓰기 3.보기 4.수정 5.삭제 6.댓글쓰기
			//7.게시물저장 8.게시물불러오기 9.댓글저장 10.저장
		//[v]Day11_4_BoardApp 클래스
			//입출력 [ 입력받아 컨트롤러에게 입력받은 값 전달 ]
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Controller.load(); // 2. 파일[ 모든 게시물] 불러오기 
	while(true) {
		try {//예외발생
			//모든 게시물 출력
			System.out.printf("%s\t%s\t%s\t%s\t   %s\t \n","번호","제목","작성자","작성일","조회수");
				
			int i = 0; //리스트내 인덱스
			for(Board board : Controller.boardlist) {
				System.out.printf("%s\t%s\t%s\t%s     %s\t \n", i, board.getTitle(),
						board.getWriter(),board.getDate(),board.getViewcount());
				i++;
			}
			
			System.out.print("1.쓰기 2.보기 선택 : ");
			int ch = scanner.nextInt();
			
			if (ch == 1) {
				System.out.println("*** 게시물 등록 ***"); scanner.nextLine();
				//nextLine() : 공백 포함 입력가능
				//nextLine 앞에 next 내용까지 하나로 취급
				//사이에 NextLine 추가해주면됨(분리역할. 의미 X)
				System.out.print("제목 : ");	String 제목 = scanner.nextLine();
				System.out.print("내용 : "); String 내용 = scanner.nextLine();
				System.out.print("작성자 : "); String 작성자 = scanner.next();
				System.out.print("비밀번호[수정/삭제시] : ");  String 비밀번호 = scanner.next();
				Controller.write(제목, 내용, 작성자, 비밀번호); //인수전달
			}else if (ch == 2) {
				//해당 게시물 번호[인덱스]를 입력받아 게시물정보 모두 출력
				System.out.println("게시물 번호 : "); int index = scanner.nextInt();
				Board temp = Controller.boardlist.get(index);	//해당 인덱스의 객체를 임시 객체로 담기 [코드 줄이기]
				System.out.println("제목 : "+ temp.getTitle());
				System.out.println("작성자 : " + temp.getWriter()+
						" 작성일 : " + temp.getDate()+ " 조회수 : "+ temp.getViewcount());
				System.out.println("내용 : "+ temp.getContents());
				
				
				//메뉴
				System.out.println("1.뒤로가기 2.수정 3.삭제 4.댓글쓰기 선택: ");
				int ch2 = scanner.nextInt();
				if (ch2 == 1) {
					
				}else if (ch2 == 2) {//수정할 인덱스 번호, 비밀번호 확인, 수정할 제목, 수정할 내용 -> 인수
					System.out.println("현재 게시물 비밀번호 : "); String password = scanner.next();
					scanner.nextLine();
					System.out.println("변경할 제목 : "); String title = scanner.nextLine();
					System.out.println("변경할 내용 : "); String content = scanner.nextLine();
					boolean result = Controller.update(index, password, title, content);	
					if (result) {
						System.err.println("수정 성공");
					}else {
						System.err.println("수정 실패");
					}
					
					
				}else if (ch2 == 3) {//삭제할 인덱스 번호, 비밀번호 -> 인수
					System.out.println("현재 게시물 비밀번호 : "); String password = scanner.next();
					Boolean result = Controller.delete(index, password);
					if (result) {
						System.out.println("삭제 성공");
					}else {
						System.out.println("비밀번호를 다시 확인해주세요");
					}
					
				}else if (ch2 == 4) {//인덱스 번호, 댓글 내용 , 댓글 비밀번호, 댓글 작성자
					Controller.replywriter();
				}else {
					
				}
			}else {
				
			}
		}catch (Exception e) {
			System.out.println("사용할 수 없는 입력입니다.");
			scanner = new Scanner(System.in);
		}
		
	}//while end
		
		
		
	}//me
	
}//ce
