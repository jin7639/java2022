package Day01;

import java.util.Scanner;

public class Day01_5 {//cs

	public static void main(String[] args) {//ms
		
		// 입력 -> 저장 -> 출력
		// 1. 입력객체 선언
		Scanner scanner = new Scanner(System.in);
		
		//2. 입력할 대상 안내
		System.out.println(" 아이디 : ");
		System.out.println(" 비밀번호 : ");
		System.out.println(" 성명 : ");
		System.out.println(" 이메일 : ");
		
		//3. 입력받은 데이터 다른 곳에 저장
		String id = scanner.next();
		String pw = scanner.next();
		String name = scanner.next();
		String email = scanner.next();
		
		//4. 출력
		System.out.println(">>>>>회원가입 완료 아래 정보를 확인해주세요<<<<<<");
		System.out.println("아이디\t비밀번호\t성명\t이메일");
		System.out.println(id + "\t" + pw + "\t" + name + "\t" + email);
		
	}//me
	
	
	
}//ce
