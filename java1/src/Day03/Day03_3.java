package Day03;

import java.util.Scanner;

public class Day03_3 {//cs
	
	public static void main(String[] args) {//ms
		
		Scanner scanner = new Scanner(System.in);
		
		//문제6
		//점수를 입력받아 90점 이상이면 합격 아니면 불합격
		
//		System.out.println("문제6) 점수 : " ); int 문제6 = scanner.nextInt();
//		
//		if (문제6 >=90 ) {System.out.println("합격");}
//		else System.out.println("불합격");
//		
//		//문제7
//		//점수를 입력받아 점수가 90점 이상이면 A, 80 이상이면 B, 70 이상이면 C, 그 외 재시험
//		System.out.println("문제7) 점수 : " ); int 문제7 = scanner.nextInt();
//		
//		if (문제7 >= 90) {System.out.println("A");} 
//		else if (문제7 >= 80) {System.out.println("B");}
//		else if (문제7 >= 70) {System.out.println("C");}
//		else System.out.println("재시험");
//		
		//문제8 : 로그인 페이지
		//[입력] 아이디와 비밀번호
		//[조건] 회원아이디가 admin 이고 비밀번호가 1234일 경우에는 로그인 성공. 아니면 실패 출력
//		System.out.println("문제8) 아이디 : " ); String id = scanner.next();
			//char 자료형 [문자 1개 저장]
			//자료형으로 문자열을 저장할 수 없다
				//1.String 클래스 사용하면 문자열 저장가능
				//2.char 배열/리스 사용하면 가능
//		System.out.println("문제8) 비밀번호 : " ); int pw = scanner.nextInt();
			//안 되는데 왜 안되는지 모르겠음 --> 아하!
				// 객체는 연산불가
				// '자바' >= <= == > < != [불가능]
				// 자료형 사용하는 변수는 연산자 사용 가능
				// 클래스 사용하는 객체는 연산자 사용 불가 -> 메소드
					//문자열 비교시 .equals
					//문자열1.equals(문자열2)
		
//		if (id == "admin" && pw == 1234 ) { System.out.println("로그인 성공");}
//		else System.out.println("로그인 실패");
//		boolean 로그인성공 = false;
//			//boolean : 1비트 true 혹은 false 저장
//		if( id.equals("admin")) { //id는 객체이기 때문에 == 불가능 //객체비교시에는 .equals
//			if( pw == 1234) {
//				System.out.println("로그인 성공");
//				로그인성공 = true;
//			}
//			else {//pw 가 1234가 아니면
//				System.out.println("비밀번호가 틀렸습니다.");
//			}
//		}else {//id 가 admin이 아니면
//			System.out.println("아이디가 틀렸습니다.");
//			}
//		if (로그인성공 == false ) {System.out.println("로그인 실패");}
		//문제9
		//[입력] 국영수 점수입력받기
		//[조건] 평균이 90이상이면서 국어 100점이면 국어우수, 수학100이면 수학 우수, 영어100이면 영어 우수 출력
				
		System.out.println("문제9) 국어 : " ); int 국어 = scanner.nextInt();
		System.out.println("문제9) 영어 : " ); int 영어 = scanner.nextInt();
		System.out.println("문제9) 수학 : " ); int 수학 = scanner.nextInt();
		
		int 평균 = (국어 + 수학 + 영어)/3;
		if(평균 >= 90) {//평균이 90이상이면
			
			//if 중첩
			if ( 국어 == 100) System.out.println("국어우수");
			if ( 영어 == 100) System.out.println("영어우수");
			if ( 수학 == 100) System.out.println("수학우수");
			
		} else if (평균 >= 80) { //평균이 80이상이면
			
			if ( 국어 >=90 ) System.out.println("국어장려");
			if ( 영어 >=90 ) System.out.println("영어장려");
			if ( 수학 >=90 ) System.out.println("수학장려");
			
		}else {System.out.println("재시험");} //그외
		
		
		 scanner.close(); 
		
		
	}//me
	

}//cs
