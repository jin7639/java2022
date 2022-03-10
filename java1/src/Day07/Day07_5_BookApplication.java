package Day07;

import java.util.Scanner;

public class Day07_5_BookApplication {//cs

	//BookApplication 클래스 : 입출력 관련코드
	//Book 클래스 : 도서 관련코드
	//Member 클래스 : 회원 관련코드
	
	//도서 대여 console 프로그램 [ 클래스버전 ]
		//1. 클래스
			//1. book
				//필드 : ISBN(중복불가), 도서명, 작가, 도서대여여부, 대여회원
				//메소드 : 1.도서검색 2.도서목록 3.도서대여 4.도서반납 (//관리자 메소드 : 1.도서등록 2.도서삭제)
			//2. member
				//필드 : 번호, 아이디, 비밀번호, 이름, 연락처
				//메소드 : 1.회원가입, 2.로그인, 3. 아이디찾기 4. 비밀번호 찾기 5.로그아웃
				
	//2. 화면설계
			//1.초기 메뉴 [1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기]
			//2.일반회원 메뉴 [1.도서검색 2. 도서목록 3.도서대여 4.도서반납 5.로그아웃]
			//3.관리자 메뉴 [1.도서등록 2.도서목록 3.도서삭제 (4.순위) 5.로그아웃]
	
	
	//main 밖에 변수를 선언하는 이유 : 모든 메소드에서 사용하기 위해서
		//지역변수 : {변수선언} 괄호내에서 선언된 변수는 { }밖을 못 나감
			//서로 다른 { } 괄호 내에서 사용시 ->전역변수
		//static 전역변수
			//프로그램 시작시 메모리 할당 / 프로그램 종료시 메모리 초기화
			//안 쓸때도 계속 메모리를 할당하고 있음
			//프로그램 전반적으로 모든 곳에 사용되는 메모리 [변수]
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100]; //모든 클래스에서 사용하는 회원 목록
	static Book[] books = new Book[1000];
	
	//0. 코드를 읽어주는 시작 메소드[스레드]
	public static void main(String[] args) {//ms
		//메소드 호출
			// menu();	
			//내부호출 불가능
				//static : 메모리 우선할당이기때문에 static 외 메소드, 필드를 못 읽음
				//main 메소드 static 메소드 이기 때문에 static메소드만 호출가능
			//외부호출
				//1.객체 생성(메모리할당) ->메모리 호출
		Day07_5_BookApplication application = new Day07_5_BookApplication();
		application.menu();
	}//me
	
	//1. 초기메뉴 메소드
		void menu () {
			while (true) {//무한루프 [종료조건 없음]
				
				System.out.println("---------------도서 대여 프로그램----------------");
				System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
				int ch = scanner.nextInt();
				Member member = new Member();	//1~4번 { }안에서 모두 사용
				if (ch == 1) {
					//회원가입 메소드 호출
					Boolean result = member.회원가입();
					if( result ) {
						System.out.println("회원가입 성공");
					} else { 
						System.out.println("회원가입 실패");
						
					}
				}else if (ch == 2) {
					//로그인 메소드 호출
					String result = member.로그인();
						//1.일반회원 메뉴 메소드 호출
					if (result == null) {
						System.out.println("동일한 회원정보가 없습니다.");
						
					} else if (result.equals("admin")) {
						//2.관리자 메뉴 메소드 호출
						adminmenu(); //내부 메소드 호출
						
					} else {
						//일반회원 메뉴
						System.out.println(result + " 님, 반갑습니다!");
						membermenu(result); //
						
					}
					
				}else if (ch == 3) {
					//아이디 찾기 메소드 호출
					member.아이디찾기();
				}else if (ch == 4) {
					//비밀번호 찾기 메소드 호출
					member.비밀번호찾기();
					
				}else {
					System.err.println("알 수 없는 번호입니다.");
				}//if end
			}//while end
		}//menu end
	
	
	//2. 일반회원 메뉴 메소드
	void membermenu (String loginid) {
		System.out.println("-----------------회원 메뉴-------------------");
		System.out.println("1.도서검색 2.도서목록 3.도서대여4.도서반납 5.로그아웃");
		
		int ch = scanner.nextInt();
		
		Book book = new Book(); //빈 생성자로 객체 ->메소드 호출용
		
		if ( ch == 1 ) { 
			
			book.도서검색();
			
		}else if ( ch == 2 ) {
			
			book.도서목록();
			
		}else if ( ch == 3 ) { 
			
			book.도서대여(loginid);
			
		}else if ( ch == 4 ) { 
			
			book.도서반납(loginid);
			
		}else if ( ch == 5 ) { 
			
			
		}else { 
			System.out.println("알 수 없는 번호입니다.");
		}
	}
	
	
	//3. 관리자 메뉴 메소드
	void adminmenu () {
		System.out.println("-------------------관리자 메뉴-----------------");
		System.out.println("1.도서등록 2.도서목록 3.도서삭제 4.로그아웃");
		
		int ch = scanner.nextInt();
		
		Book book = new Book();
	
		if (ch == 1) {
			
			book.도서등록();
			
		} else if (ch == 2 ) {
			
			book.도서목록();
			
		} else if (ch == 3 ) {
			
			book.도서삭제();
			
		} else if (ch == 4 ) {
		
			
		} else {
			System.out.println("알 수 없는 번호입니다.");
			
		}
	}
	
	
	
	
	
	
	
	
}//ce
