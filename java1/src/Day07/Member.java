package Day07;

import java.util.Scanner;

public class Member {//cs
	//1.필드
//		회원번호(자동번호, 중복불가)
	int mno;	
//		아이디(중복불가)
	String id;
//		비밀번호
	String password;
//		이름
	String name;
//		연락처
	String phone;
	
	//2.생성자 [생성자명 == 클래스명]
		//1. 빈생성자[기본생성자] : 메소드 호출용 객체 생성시
	public Member () {}
	
		//2. 모든 필드를 받는 생성자 : 회원가입용 객체 생성시
	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	//3.메소드
//		1. 회원가입 메소드 [인수x반환o : 가입성공 true 가입실패 false]
	boolean 회원가입() {
		System.out.println("--------------회원가입 페이지--------------");
		//1.입력받는다 [ id, pw, name, phone]
		System.out.println("아이디를 입력해주세요."); String id = Day07_5_BookApplication.scanner.next(); 
		//아이디 중복체크
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp !=null && temp.id.equals(id)) {
				//만약에 공백이 아니면서 배열내 id와 입력받은 id와 동일하면
				System.out.println("현재 사용중인 아이디입니다.");
				return false; //함수종료 --->아이디중복으로 회원가입 실패
			}
		}
		System.out.println("비밀번호를 입력해주세요."); String password =  Day07_5_BookApplication.scanner.next();
		System.out.println("이름을 입력해주세요."); String name =  Day07_5_BookApplication.scanner.next(); 
		System.out.println("연락처를 입력해주세요."); String phone =  Day07_5_BookApplication.scanner.next(); 
			//scanner 객체가 다른 클래스내 static선언되어있음
			
			//회원번호 자동주입 [마지막 회원번호 +1]
		int bno = 0; //회원번호 저장하는 변수
		int j = 0; //반복횟수 [인덱스]
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp == null ) { //null 찾기 [null 찾았을때 null-1하면 마지막 회원
				if ( j == 0 ) {
					bno =1; //첫번째 인덱스[0번 인덱스]가 null ->첫회원 ->첫회원 번호 = 1부여
					break;
				}else {
					bno = Day07_5_BookApplication.members[j-1].mno + 1;
							//null 앞 [마지막 회원]번호에 +1
					break;
				}
			}
			j++;//인덱스 증가
		}
		//2.4개변수 ->객체화 ->1개
		Member member = new Member(bno, id , password, name, phone);
		
		//3.배열내 빈공간을 찾아서 새로운 회원[객체]넣기
		int i = 0;
		for (Member temp : Day07_5_BookApplication.members) {
			if ( temp == null ) {//빈공간이면
				Day07_5_BookApplication.members[i] = member;//빈인덱스에 새로운 회원대입
				return true; //회원가입 메소드 종료 [반환 : true]
			}
			i++; //i증가
		}
		
		//4.가입 성공시 true 반환 실패시 false 반환
		
		return false; //회원가입 메소드 종료 
	}
//		2. 로그인 메소드 [인수 x 반환 o : 로그인 성공시 성공한 아이디 반환 / 실패시 null을 반환]
	String 로그인 () {
		//1.입력받기
		System.out.println("--------------로그인 페이지--------------");
		System.out.println("아이디를 입력해주세요."); String id = Day07_5_BookApplication.scanner.next(); 
		System.out.println("비밀번호를 입력해주세요."); String password =  Day07_5_BookApplication.scanner.next();

		//2.배열 내 객체 id와 pw가 입력값과 동일하면
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp != null&& temp.id.equals(id) && temp.password.equals(password)) {
				//공백이 아니면서 id와 password가 동일하면
				return temp.id; //성공한 id 반환
			}
		}
		//3. 로그인 성공시 입력한 id 변환 / 실패시 null
		return null;
	}
//		3. 아이디찾기 메소드 [인수 x 반환 x ] :이름, 연락처
	void 아이디찾기() {
		System.out.println("--------------아이디 찾기--------------");
		System.out.println("이름을 입력해주세요."); String name = Day07_5_BookApplication.scanner.next(); 
		System.out.println("연락처를 입력해주세요."); String phone =  Day07_5_BookApplication.scanner.next();
		
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp != null && temp.name.equals(name) && temp.phone.equals(phone) ) {
				//공백이 아니면서 해당 객체 내 name, phone이 입력받은 값과 동일하면
				System.out.println("회원님의 아이디 : " + temp.id);
				return; //찾기 성공한 id 반환 ->종료
			}
		}
		//못 찾았으면 찾은 id 출력하고 못 찾았으면 알림 출력
		System.out.println("일치하는 회원정보가 없습니다.");
		
		
	}
	
//		4. 비밀번호 메소드[인수 x 반환 x ] : 아이디, 연락처
	void 비밀번호찾기() {
		System.out.println("--------------비밀번호 찾기--------------");
		System.out.println("아이디을 입력해주세요."); String id = Day07_5_BookApplication.scanner.next(); 
		System.out.println("연락처를 입력해주세요."); String phone =  Day07_5_BookApplication.scanner.next();
		
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp != null && temp.id.equals(id) && temp.phone.equals(phone) ) {
				//공백이 아니면서 해당 객체 내 name, phone이 입력받은 값과 동일하면
				System.out.println("회원님의 비밀번호 : " + temp.password);
				return; //찾기 성공한 id 반환 ->종료
			}
		}
		System.out.println("일치하는 회원정보가 없습니다.");
	}
	
//		5. 회원탈퇴 메소드
	
	
	
}//ce
