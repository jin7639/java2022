package Day05;

import java.util.Scanner;

public class Day05_4 {//cs
	//1.입출력 2.변수/자료형/연산 3.제어/반복 4.배열
	
	//도서 대여 프로그램
		//1.배열
			//1.회원[아이디(중복X), 비밀번호]
			//2.도서[도서명(중복X), 도서대여여부(대여가능/대여중), 대여인(로그인시아이디)]
		//2.초기메뉴
			//1.회원가입 2. 로그인
				//1.회원가입 시 아이디 중복체크
				//2.로그인 성공시 로그인 메뉴, 실패시 로그인 실패 출력
		//3.로그인시 메뉴
			//1.도서검색 2.도서목록 3. 도서대여 4.도서반납 5.로그아웃
				//1.도서검색시 도서명이 일치하면 도서명과 도서대여여부 출력
				//2.도서목록시 모든 도서명 출력
				//3.도서대여시 도서대여여부가 가능할때 도서대여 처리
				//4.도서반납시 본인이 대여한 도서만 반납처리
				//5.로그아웃
		//4.로그인시 아이디가 admin이면 관리자메뉴
			//1.도서등록 2.도서목록 (3.도서삭제) 3.로그아웃
				//1.도서등록시 도서명을 입력받아 도서 등록처리
				//2.도서목록시 모든 도서명 출력
				//3.도서삭제시 삭제할 도서명을 입력받이 동일한 도서명 삭제 [null]
				//4.로그아웃
	
	public static void main(String[] args) {//ms
		
		//준비
		Scanner scanner = new Scanner(System.in);
		String[][] memberlist = new String[100][2]; 
		String[][] booklist = new String[100][3];
		
		booklist[0][0] = "어린왕자";
		booklist[1][0] = "하이디"; booklist[1][1] = "대출중"; 
		booklist[2][0] = "오만과편견"; 
		
		//초기메뉴
		while(true) {//while1 초기메뉴
			System.out.println("---------------------------");
			System.out.println("-----------도서 대여----------");
			System.out.println("---------------------------");
			System.out.println("| 1.회원가입 | 2.로그인 | 선택 : "); int ch = scanner.nextInt();
			
			if (ch == 1) {
				//회원가입페이지
				System.out.println("--------회원가입 페이지---------");
				System.out.println("Member ID : "); String id = scanner.next();
				System.out.println("Member Password : "); String password = scanner.next();
				
				//아이디 중복체크 [기존 회원의 id와 동일하면 회원가입 불가]
				boolean idcheck =true;
				for ( int i = 0; i<memberlist.length; i++ ) {
					if (memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						//i번째 행에 똑같은 id가 있으면
						//i번째 각 열에 데이터 저장 불가
						System.err.println(">>> 이미 존재하는 아이디입니다.");
						idcheck = false;
						break; 
					}//if end
				}//for end
				
				//저장
				if(idcheck == true) {//if 1 -> idcheck가 true일 때만 회원가입
					
					for ( int i = 0; i<memberlist.length; i++ ) {//for1 확인
						if (memberlist[i][0] == null) {//if2 저장
							//i번째 행에 id가 없으면 (빈공간이면) 
							memberlist [i][0] =id;
							memberlist [i][1] =password;
							//i번째 각 열에 데이터 저장
							System.out.println(">>> 회원가입 완료");
							break; //저장했으면 끝
						}//if2 end
					}//for1 end
				}//if1 end
			} else if ( ch == 2 ) {
				System.out.println("---------로그인 페이지---------");
				System.out.println("Member ID : "); String id = scanner.next();
				System.out.println("Member Password : "); String password = scanner.next();
				
				boolean logincheck = false; //로그인 초기값
				
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) && memberlist[i][1].equals(password)) {
						//1번째 행에 id와 password가 입력바든 값과 equals 같으면
							//null은 객체가 아니기때문에 equals 불가능
						System.out.println(">>> 로그인 성공");
						
						logincheck = true; //로그인 성공 값 저장
						
				////////////////////////////////로그인메뉴/////////////////////////////////////
						System.out.println("--------------------------------------------");
						System.out.println("-------------------도서 대여-------------------");
						System.out.println("--------------------------------------------");
						System.out.println("|1.도서검색|2.도서목록|3.도서대여|4.도서반납|5.로그아웃| 선택 : "); int ch_login = scanner.nextInt();
						
						if (ch_login == 1) {
							
							
						} else if (ch_login == 2) {//도서목록
							System.out.println("-------------------------------------------");
							System.out.println("-------------------도서목록-------------------");
							System.out.println("-------------------------------------------");
							System.out.println("|도서명\t\t\t상태\t대여인|");
							
							//모든 도서 목록 출력
							
							for(int j = 0; j<booklist.length; j++) {
								if(booklist[j][0] != null) {
									if (booklist[j][1] == null) {
										booklist[j][1] = "대출가능";
									}
									System.out.printf("|%s\t\t\t%s\t%s| \n", booklist[j][0], booklist[j][1], booklist[j][2]);
								}//if end
							}//for end
								
						} else if (ch_login == 3) {
							
						} else if (ch_login == 4) {
							
						} else if (ch_login == 5) {
							System.err.println(">>> 로그아웃");
							break;
						} else {
							System.err.println(">>> 잘못된 접근입니다.");
							break;
						}
						
						
						
						
					}//if end
					
					
				}//for end
				
				
				
//////////////////////////////4.로그인시 아이디가 admin이면 관리자메뉴
				//1.도서등록 2.도서목록 (3.도서삭제) 3.로그아웃
				//1.도서등록시 도서명을 입력받아 도서 등록처리  	//2.도서[도서명(중복X), 도서대여여부(대여가능/대여중), 대여인(로그인시아이디)]
				//2.도서목록시 모든 도서명 출력
				//3.도서삭제시 삭제할 도서명을 입력값이 동일한 도서명 삭제 [null][
				//4.로그아웃
				if (id.equals("admin")) {//if admin 
					
					while(true) {
						System.out.println("--------------------------------------");
						System.out.println("---------------관리자 페이지--------------");
						System.out.println("--------------------------------------");
						System.out.println("|1.도서등록|2.도서목록|3.도서삭제|4.로그아웃|선택 : "); int ch_admin = scanner.nextInt();
						
						if (ch_admin == 1) {
							System.out.println("-------------------------------------");
							System.out.println("----------------도서 등록---------------");
							System.out.println("-------------------------------------");
						
							System.out.println("도서명 : "); String title = scanner.next();
							
							boolean titlecheck =true;
							for ( int i = 0; i<booklist.length; i++ ) {
								if (booklist[i][0] != null && booklist[i][0].equals(title)) {
									System.err.println(">>> 이미 존재하는 도서입니다.");
									titlecheck = false;
									break; 
								}//if end
							}//for end
							
							if (titlecheck == true ) {
								//배열 내 공백 찾아서 저장
								for(int i =0; i<booklist.length; i++) {//도서등록
									if(booklist[i][0] == null ) {//null이 아니면 기존 데이터가 사라짐
										booklist[i][0] = title;
										System.out.println(">>> 도서가 등록되었습니다.");
										break;
									}//if end
								}//for end
							}
							
						}else if (ch_admin == 2) { //도서목록
							System.out.println("--------------------------------------");
							System.out.println("----------------도서목록-----------------");
							System.out.println("--------------------------------------");
							System.out.println("|도서명\t\t\t상태\t대여인|");
							
							//모든 도서 목록 출력
							
							for(int j = 0; j<booklist.length; j++) {
								if(booklist[j][0] != null) {
									if (booklist[j][1] == null) {
										booklist[j][1] = "대출가능";
									}
									System.out.printf("|%s\t\t\t%s\t%s| \n", booklist[j][0], booklist[j][1], booklist[j][2]);
								}//if end
							}//for end
								
						}//if2 end
						else if (ch_admin == 3) {//도서삭제
							System.out.println(">>> 삭제할 도서명을 입력해주세요."); String book_del = scanner.next();
								for (int i = 0; i < booklist.length; i++) {
									if (book_del.equals(booklist[i][0])) {
										booklist[i] = null;
										for (int j = 0; j < booklist.length-1; j++) {
											booklist[j] = booklist[j+1];
										}
										System.err.println(">>> 도서를 삭제하였습니다.");
										break;
									}else {
										System.err.println(">>> 존재하지 않는 도서입니다.");
									}
								} 
							}else if (ch_admin == 4) {
								System.err.println(">>> 로그아웃");
								break;
							}else {
								System.err.println(">>> 알 수 없는 번호입니다.");
								break;
						}
					}
				}//if admin end
			} else {
				System.err.println(">>> 알 수 없는 입력입니다.");
				break;
			}
			
			
		}//while1 end
		
		
	}//me

}//ce