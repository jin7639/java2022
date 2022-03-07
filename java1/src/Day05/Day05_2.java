package Day05;

import java.util.Scanner;

public class Day05_2 {//cs
	
	// 회원제 방문록 프로그램
	//1. 초기메뉴 [ 1.회원가입 2. 로그인 (3.아이디찾기)]
	//1.회원가입 [아이디, 비밀번호, 이름]
	//2.로그인 [아이디, 비밀번호 동일하면 로그인처리]
	//2. 로그인시 메뉴 [1.방문록쓰기 2. 로그아웃]
	//1. 방문록 쓰기[제목, 내용, 작성자(로그인된아이디)]
	//2. 로그아웃 [초기메뉴로 돌아가기]

	public static void main(String[] args) {//ms
	
		//준비
		Scanner scanner = new Scanner(System.in);
		//회원100명[id,pw,name]저장하는 배열
		String[][] memberlist = new String[100][3]; 
			//100행 3열 -> [1열=id][2열=pw][3열=name]
		//방문록 100개[title, contents, writer]저장하는 배열
		String[][] boardlist = new String[100][3]; //게시물당 1행
		
		
		while(true) {//while1 무한루프[종료조건 X]
			System.out.println("---------------------------");
			System.out.println("--------[회원제 방문록]--------");
			System.out.println("---------------------------");
			System.out.println("| 1.회원가입 | 2.로그인 | 선택 : "); int ch = scanner.nextInt();
			if ( ch == 1) {//if 1 회원가입 
				System.out.println("--------회원가입 페이지---------");
				System.out.println("Member ID : "); String id = scanner.next();
				System.out.println("Member Password : "); String password = scanner.next();
				System.out.println("Member Name : "); String name = scanner.next();
				//String 3개 변수를 입력바아 memberlist 2차원 배열에 저장
					//1. 빈공간[정수=0, 객체(문자열) = null] 을 찾아서 저장 [만약에 빈공간이 없으면 알림 출력]
					//2. 아이디 중복체크
				
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
							memberlist [i][2] =name;
							//i번째 각 열에 데이터 저장
							System.out.println(">>> 회원가입 완료");
							break; //저장했으면 끝
						}//if2 end
					}//for1 end
				}//if1 end
				
			}else if (ch == 2) {
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
						
						while(true) {//로그인시 무한루프 [종료조건 : 로그아웃]
							System.out.println("---------------------------");
							System.out.println("---------방문록 페이지---------");
							System.out.println("|번호\t작성자\t제목\t내용");
							//모든 방문록 출력
							for(int j =0; j<boardlist.length; j++) {
								if(boardlist[j][0] != null) {
									
									System.out.printf("%d\t%s\t%s\t%s \n", j,boardlist[j][2], boardlist[j][0], boardlist[j][1]);
								}
							}
							System.out.println("|1.방문록 작성|2.로그아웃|선택 : "); int ch2 = scanner.nextInt();
							
							if( ch2 == 1) {
								System.out.println("---------방문록 작성----------");
								System.out.println("---------------------------");
								System.out.println("title : "); String title = scanner.next();
								System.out.println("content : "); String content = scanner.next();
								
								//배열 내 공백 찾아서 저장
								for(int j =0; j<boardlist.length; j++) {
									if(boardlist[j][0] == null ) {//null이 아니면 기존 데이터가 사라짐
										boardlist[j][0] = title;
										boardlist[j][1] = content;
										boardlist[j][2] = id; //로그인시 사용된 id 대입
										System.out.println(">>> 방문록이 작성되었습니다.");
										break;
									}
								}
								
							}else if ( ch2 == 2) {
								System.err.println("로그아웃");
								break;
								
							}else {
								System.err.println(">>> 알 수 없는 번호입니다.");
							}//if end
							
						}//회원메뉴(로그인시) while end
						
					}//if1 end [로그인 성공]
				}//for end
				
				//로그인 실패시
				if(logincheck ==false) {
					System.err.println(">>> 회원정보가 다릅니다.");
				}
				
			}else {
				System.err.println(">>> 알 수 없는 번호입니다.");
			}
			
			
			
		}//while1 end
		
		
		
		
		
		
		
		
	}//me

}//ce
