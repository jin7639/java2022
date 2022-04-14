package Day06;

import java.util.Scanner;

public class Day06_3 {//cs
	//회원제 방문록 프로그램 [클래스]
	
		//0. 회원 설계 -> 회원 클래스 만들기
			//1. 필드
				//1. 아이디 2. 비밀번호 3. 이름 4. 전화번호
	
		//1. 초기메뉴 [1. 회원가입 2. 로그인 3.아이디찾기 4.비밀번호찾기]
			//1. 회원가입시 입력받아 저장
			//2. 로그인시 아이디와 비밀번호가 동일하면 로그인처리
			//3. 아이디찾기는 이름과 전화번호가 동일하면 아이디 출력
			//4. 비밀번호 찾기는 아이디와 전화번호가 동일하면 비밀번호 출력
	public static void main(String[] args) {//ms
		
		//위에 선언하는 이유 : main 메소드 모든 곳에서 사용하기 위해서(전역변수)
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		//Member 클래스로 만들어진 객체(id, pw, name, phone) 100개 저장할 수 있는 배열 선언
		
		
		//클래스가 없었다면
			//String[][] memberlist = new Member[100][4];
		
		while(true) {//프로그램 실행 while 무한루프 [종료조건 X]
			
			System.out.println("------회원제[클래스버전]-------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.println("선택 : "); int ch = scanner.nextInt();
			
			if ( ch == 1) { //회원가입
				//1. id, pw, name, phone 입력받기 -> 변수 4개
				System.out.println("----------회원가입 페이지-----------");
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
			
				//2. 객체 생성
				Member member = new Member();
			
				//3. 입력받은 변수 4개를 객체 내 필드에 저장
					//객체 내 필드 = 입력받은 값
				member.id = id;
				member.pw = pw;
				member.name = name;
				member.phone = phone;
				
				//아이디 중복체크
					//1.배열내 객체 중 입력한 아이디와 동일한 아이디 찾기
				boolean idcheck = false;
				for( Member temp : memberlist ) {
					// memberlist 배열 내 객체들을 하나씩 temp에 대입 반복
					if(temp !=null && temp.id.equals(id)) {
						//만약에 해당 객체 내 id가 입력받은 id와 같으면
						System.out.println("사용중인 아이디 입니다.");
						idcheck = true; //중복이면 true
						break;
					}
				}
					if ( idcheck ==false) {//아이디가 중복이 없을 경우 저장
						
						//4. 여러개 객체를 저장하는 배열에 저장
						//1. 공백 인덱스 찾아서 [ 공백 아닌 곳에 저장하면 기존 정보 사라짐]
						int i = 0; //인덱스 위치 변수;
						for( Member temp : memberlist ) {
							//memberlist 배열 내 member 객체 하나씩 꺼내와서 temp 저장 반복
							//2. 공백 인덱스에 객체 저장
							if ( temp == null ) {//만약 해당 객체가 공백이면
								memberlist[i] = member; //해당 인덱스에 새로 만들어진 객체 저장
								System.out.println("회원가입 성공");
								break;//for 나가기 [안 나가면 모든 공백에 동일한 객체 저장되기 때문에
							}
							i++; //인덱스 증가
						}//for end
					} 
				}else if (ch == 2) {//로그인
				
				//1. 입력받기
				System.out.println("----------로그인 페이지-----------");
				System.out.println("아이디 : "); String loginid = scanner.next();
				System.out.println("비밀번호 : "); String loginpw = scanner.next();
				
				//2. 기존 배열[회원리스트] 내 입력받은 값과 비교
				boolean logincheck = false; //true 로그인 성공
				for( Member temp : memberlist ) {
					//memberlist 내 0번 인덱스부터 끝 인덱스 까지 하나씩 temp에 대입
					if ( temp !=null && temp.id.equals(loginid) && temp.pw.equals(loginpw)) {
						//객체가 null일때는 equals 불가 [null 아닐때만 equals 실행]
						System.out.println("로그인 성공");
						logincheck = true;
					}//if end
				}//for end
				//로그인 성공 유무
				if (logincheck == false) {
					System.err.println("존재하지 않는 회원정보입니다.");
				}
				
			}//로그인 end
			else if (ch == 3) {//아이디찾기
				//1.이름과 연락처를 입력받는다.
				System.out.println("---------아이디찾기 페이지----------");
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("연락처 : "); String phone = scanner.next();
				
				//2.배열내 동일한 이름과 연락처가 있는지 확인한다.
				boolean findcheck = false;
				for ( Member temp : memberlist) {
					
					if( temp !=null && temp.name.equals(name) && temp.phone.equals(phone) ) {
						//3.동일한 객체가 있으면 해당 아이디 출력
						System.out.println("아이디찾기 성공");
						System.out.println("회원 ID : " + temp.id);
						findcheck = true; // 아이디 찾았다는 기록
						break;
					}
				}
				//4.없으면 없다고 출력
				if( findcheck == false){
					System.out.println("일치하는 회원정보가 없습니다.");
				}
			} else if (ch == 4) {//비밀번호찾기
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				
				boolean findcheck = false;
				for (Member temp : memberlist) {
					if(temp != null && temp.id.equals(id) && temp.id.equals(phone)) {
						System.out.println("비밀번호 찾기 성공");
						System.out.println("회원 비밀번호 : " + temp.pw);
						findcheck =true;
						break;
					}
				}
				if ( findcheck == false ) {
					System.out.println("동일한 회원정보가 없습니다.");
				}
				
			} else {//그 외
				System.err.println("알 수 없는 번호입니다.");
			}
			
			
		}//프로그램 실행 while end
		
	}//me
	
}//ce
