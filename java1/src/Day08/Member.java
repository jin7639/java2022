package Day08;

import Day08.Bankbook;
import Day08.Day08_Bank;

public class Member {//cs

	//1.필드
	String name; 		//이름
	String id;			//아이디
	String password;	//비밀번호
	String phone;		//연락처
	//2.생성자
		//1.빈 생성자
	public Member() {}
	//2.모든 필드 생성자
	public Member(String name, String id, String password, String phone) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
	}
	
	//3.메소드
	 	//1.회원가입 
	boolean 회원가입() {
		System.out.println("--------------회원가입 페이지--------------");
		//1.입력받는다 [ id, pw, name, phone]
		System.out.println("아이디를 입력해주세요."); String id = Day08_Bank.scanner.next();
		//아이디 중복체크
		for(Member temp : Day08_Bank.members) {
			if (temp !=null && temp.id.equals(id)) {
				//만약에 공백이 아니면서 배열내 id와 입력받은 id와 동일하면
				System.out.println("현재 사용중인 아이디입니다.");
				return false; //함수종료 --->아이디중복으로 회원가입 실패
			}
		}
		
		System.out.println("비밀번호를 입력해주세요."); String password = Day08_Bank.scanner.next();
		System.out.println("이름을 입력해주세요."); String name =  Day08_Bank.scanner.next();
		System.out.println("연락처를 입력해주세요."); String phone =  Day08_Bank.scanner.next(); 
			
		//2.4개변수 ->객체화 ->1개
		Member member = new Member( name, id,password, phone);
		
		//3.배열내 빈공간을 찾아서 새로운 회원[객체]넣기
		int i = 0;
		for (Member temp :  Day08_Bank.members) {
			if ( temp == null ) {//빈공간이면
				 Day08_Bank.members[i] = member;//빈인덱스에 새로운 회원대입
				return true; //회원가입 메소드 종료 [반환 : true]
			}
			i++; //i증가
		}
		//4.가입 성공시 true 반환 실패시 false 반환
		return false; //회원가입 메소드 종료 
	}
		//2.로그인 
	String 로그인 () {
		//1.입력받기
		System.out.println("--------------로그인 페이지--------------");
		System.out.println("아이디를 입력해주세요."); String id = Day08_Bank.scanner.next();
		System.out.println("비밀번호를 입력해주세요."); String password = Day08_Bank.scanner.next();

		//2.배열 내 객체 id와 pw가 입력값과 동일하면
		for(Member temp : Day08_Bank.members) {
			if (temp != null&& temp.id.equals(id) && temp.password.equals(password)) {
				//공백이 아니면서 id와 password가 동일하면
				return temp.id; //성공한 id 반환
			}
		}
		//3. 로그인 성공시 입력한 id 변환 / 실패시 null
		return null;
	}
//		3
	
		//3.아이디 찾기 
	void 아이디찾기() {
		System.out.println("--------------아이디 찾기--------------");
		System.out.println("이름을 입력해주세요."); String name = Day08_Bank.scanner.next();
		System.out.println("연락처를 입력해주세요."); String phone = Day08_Bank.scanner.next();
		
		for(Member temp :Day08_Bank.members) {
			if (temp != null && temp.name.equals(name) && temp.phone.equals(phone) ) {
				//공백이 아니면서 해당 객체 내 name, phone이 입력받은 값과 동일하면
				System.out.println("회원님의 아이디 : " + temp.id);
				return; //찾기 성공한 id 반환 ->종료
			}
		}
		//못 찾았으면 찾은 id 출력하고 못 찾았으면 알림 출력
		System.out.println("일치하는 회원정보가 없습니다.");
	}
	
		//4.비밀번호 찾기
	void 비밀번호찾기() {
		System.out.println("--------------비밀번호 찾기--------------");
		System.out.println("아이디을 입력해주세요."); String id = Day08_Bank.scanner.next();
		System.out.println("연락처를 입력해주세요."); String phone = Day08_Bank.scanner.next();
		
		for(Member temp : Day08_Bank.members) {
			if (temp != null && temp.id.equals(id) && temp.phone.equals(phone) ) {
				//공백이 아니면서 해당 객체 내 name, phone이 입력받은 값과 동일하면
				System.out.println("회원님의 비밀번호 : " + temp.password);
				return; //찾기 성공한 id 반환 ->종료
			}
		}
		System.out.println("일치하는 회원정보가 없습니다.");
	}
	
	
}//ce
