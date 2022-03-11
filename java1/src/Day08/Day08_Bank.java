package Day08;

import java.util.Scanner;

import Day08.Bankbook;
import Day08.Member;

public class Day08_Bank {//cs

	//모바일 뱅크 프로그램
		// 요구사항
		// 회원 주요기능 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기
		// 계좌 주요기능 : 1.계좌생성/ 2.입금 3.출금 4.이체 /5.대출 6.계좌목록
				//회원이 계좌 만들어서 사용
				//관리자(은행원)이  대출상품을 등록하면 등록된 대출상품들을 회원이 선택해서 사용
		// 설계 : 통장, 대출상품, 회원
			//필드
			//메소드
	
	
	//초기 메뉴
		//1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기
			//1.회원가입
				//이름 아이디 비밀번호 연락처 입력받기
				//아이디 중복검사 해서 중복 X면 가입완료
			//2.로그인
				//1.계좌생성
					//계좌번호 입력받기
					//계좌 비밀번호 입력받기
				//2.입금 
					//계좌번호 , 금액 입력받기
					
				//3.출금 
					//계좌번호, 금액, 비밀번호 입력받기
				//4.이체 
					//보내는사람 계좌번호, 받는 사람 계좌번호/은행, 금액 입력받기
				//5.대출 
					
				//6.계좌목록
				
			//3.아이디찾기
	
			//4.비밀번호 찾기
		//관리자메뉴
			//1. 대출 상품 등록 
			//2. 로그아웃
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100]; //모든 클래스에서 사용하는 회원 목록
	static Bankbook[] bankbook = new Bankbook[1000];
	
	
	//0. 코드를 읽어주는 시작 메소드[스레드]
	public static void main(String[] args) {//ms
		Day08_Bank bank = new Day08_Bank();
		bank.menu();
		
	}//me
	
	//1.초기메뉴 메소드
	void menu () {
		while(true) {//무한루프
			System.out.println("------------------은행------------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기 : ");
			int ch = scanner.nextInt();
			Member member = new Member();
			if ( ch == 1 ) {
				//회원가입 메소드 호출
				Boolean result = member.회원가입();
				if( result ) {
					System.out.println("회원가입 성공");
				} else { 
					System.out.println("회원가입 실패");
					
				}
			}else if ( ch == 2 ) {
				//로그인 메소드 호출
				String result = member.로그인();
					//1.일반회원 메뉴 메소드 호출
				if (result == null) {
					System.out.println("동일한 회원정보가 없습니다.");
					
				} else if (result.equals("admin")) {
					//2.관리자 메뉴 메소드 호출
					adminmenu(); //내부 메소드 호출
				} else membermenu(result);
			}else if ( ch == 3 ) {
				
				
			}else if ( ch == 4) {
				
				
			}else {
				System.out.println("알 수 없는 번호입니다.");
			}
			
			
		}//while end
	}//menu end
	
	//2. 일반회원 메뉴 메소드
		void membermenu (String loginid) {
			System.out.println("-------------------회원 메뉴-------------------");
			System.out.println("1.계좌생성 2.입금 3.출금 4.이체 5.대출 6.계좌목록 선택 :");
			
			int ch2 = scanner.nextInt();
			Bankbook bankbook = new Bankbook();
			
			if ( ch2 == 1 ) { //계좌생성
				
				
			}else if ( ch2 == 2 ) {//입금
				
				bankbook.입금();
				
			}else if ( ch2 == 3 ) {//출금 
				
				bankbook.출금();
				
			}else if ( ch2 == 4 ) {//이체
				
				bankbook.이체();
				
			}else if ( ch2 == 5 ) {//대출 
				
				
			}else if ( ch2 == 6 ) {//계좌목록
				
				
			}else {
				System.out.println("알 수 없는 번호입니다.");
			}//if end
		}//membermenu end
	
	//관리자메뉴
	void adminmenu() {
		
	}
	
	
}//ce
