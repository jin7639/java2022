package Team_Theater;

import java.util.Scanner;

public class Main {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Controller con = new Controller();
		
		while(true) {
			try {
				////상영영화목록////
				
				System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 선택: "); String ch = scanner.next();

				if(ch.equals("1") || ch.equals("회원가입")) {
					System.out.println("아이디: "); 		String id = scanner.next();
					System.out.println("비밀번호: "); 		String pw = scanner.next();
					System.out.println("이름: "); 		String name = scanner.next();
					System.out.println("전화번호: "); 		String phone = scanner.next();
					
					///저장
					String result = con.sign(id, pw,name,phone);
					
					if(result == "bad") {
						System.out.println("회원가입실패");
					}
					else if (result == "good") {
						System.out.println("회원가입성공");
					}
				}
				else if(ch.equals("2") || ch.equals("로그인")) {
					System.out.println("아이디: "); String id = scanner.next();
					System.out.println("비밀번호: "); String pw = scanner.next();
					
					String result = con.login(id, pw); // 리턴값 String이니깐 String 변수 result생성
					
					if(result.equals("admin")) {/////////////////////////////////////////////////////////관리자///////////////////
						System.out.println(">>>>>>>>>>관리자로 로그인");
						System.out.println("-----------------------------------");
						System.out.println("|  1.상영 영화 등록  |  2.영화 상영 취소  |");
						System.out.println("-----------------------------------");
						int ch_admin = scanner.nextInt();
						if (ch_admin == 1) {
							System.out.println("영화제목 : ");		String title = scanner.next();
							System.out.println("시작 시각 : (hh:mm)");	String intime = scanner.next();
							boolean moviest_admin = true;
							while(moviest_admin) {
								if (intime.length() != 5) {
									System.out.println("다시 입력해주세요.");
									System.out.println("시작 시각 : (hh:mm)");
									intime = scanner.next();
								}else {
									moviest_admin = false;
								}
							}//while end
							
							System.out.println("상영 시간 : (hh:mm)");		String runtime = scanner.next();
							Boolean movierun_admin = true;
							while(movierun_admin) {
								if (runtime.length() != 5) {
									System.out.println("다시 입력해주세요.");
									System.out.println("시작 시각 : (hh:mm)");
									runtime = scanner.next();
								}else {
									movierun_admin = false;
								}
							}//while end
							Controller.moive_register(title, intime, runtime);
							
						}else if (ch_admin == 2) {
							
							System.out.println("영화제목 : ");		String title = scanner.next();
							System.out.println("시작 시각 : ");	String intime = scanner.next();
							Controller.movie_remove(title, intime);
						}else {
							System.out.println("알 수 없는 입력입니다.");
						}
					}else { 
						System.out.println(result + "님 환영 합니다.");
					}

				}
				else if(ch.equals("3") || ch.equals("아이디찾기")) {
					System.out.println("이름: "); String name = scanner.next();
					System.out.println("전화번호: "); String phone = scanner.next();
					
					con.findid(name,phone);
					
				}
				else if(ch.equals("4") || ch.equals("비밀번호찾기")){
					System.out.println("아이디: "); String id = scanner.next();
					System.out.println("전화번호: "); String phone = scanner.next();
					
					con.findid(id,phone);
				}
				else {System.out.println("번호를 입력해주세요");}
			}
			catch(Exception e) {}
		}
	
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void membermenu() {
		System.out.println("1.예매 2.예매취소 3.예매확인   선택: "); String ch = scanner.next();
		
		if(ch.equals("1")||ch.equals("예매")) {
			System.out.println("영화제목: "); String title = scanner.nextLine();
			//////해당 영화의 상영시간 출력//
			System.out.println("영화시간: "); String intime = scanner.next();
			////선택한 영화의 상영관 좌석 선택///
			System.out.println("좌석선택: "); String seat = scanner.next();
		}
		else if(ch.equals("2")||ch.equals("예매취소")){
			System.out.println("영화제목: "); String title = scanner.nextLine();
			//////해당 영화의 상영시간 출력//
			System.out.println("영화시간: "); String intime = scanner.next();
			//////결제취소
		}
		else if(ch.equals("3")||ch.equals("예매확인")) {/////////////////////////////////////////////예매확인//////////////
			
			
			
			////////예매목록 자동생성
			////////////////
			System.out.println("1.예매취소 2.뒤로가기"); String confirm = scanner.next();
		}
		else {}
		
	}
	public void adminmenu() {
		System.out.println("1.영화등록 2.영화삭제 3.매출확인"); String ch =scanner.next();
		
		if(ch.equals("1")||ch.equals("영화등록")) {
			System.out.println("영화제목: "); String title = scanner.nextLine();
			System.out.println("상영관선택: "); String screen = scanner.next();
			System.out.println("영화시간: "); String intime = scanner.next();
		}
		else if(ch.equals("2")||ch.equals("영화삭제")){
			System.out.println("영화제목: "); String title = scanner.nextLine();
			System.out.println("상영관선택: "); String screen = scanner.next();
			System.out.println("영화시간: "); String intime = scanner.next();
		}
		else if(ch.equals("3")||ch.equals("매출확인")) {
			System.out.println("");
		}
		else {}
		
	}
	
}