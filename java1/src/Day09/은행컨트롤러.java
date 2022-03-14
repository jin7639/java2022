package Day09;

import java.security.PublicKey;
import java.text.Format;
import java.util.Random;

public class 은행컨트롤러 {
	//해당 클래스는 은행 관련 컨트롤러
	//M : 모델 [ 데이터 ] (은행)
	//V : 뷰 [ 입출력 ] (은행계좌프로그램)
	//C : 모델 [M]과 뷰[V] 연결 역할 (은행컨트롤러)
	//v--->c
	//뷰에서 요청하는 서비스[기능] 제공
		//1.계좌생성 [c]
	public String 계좌생성(String 비밀번호, String 계좌주, int 은행번호)	{
		String 계좌번호 = null;
			//1.입력받은 값을 가져온다
		while(true) {
				//계좌번호 자동생성
			Random random = new Random(); //랜덤
			//4자리 생성
			int 난수 =random.nextInt(10000);
			계좌번호 = String.format("%04d",난수);
							//문자 형식 변경 
								//%d 정수
								//%4d 정수4자리 [만일 자릿수 없으면 공백처리]
									//15 -> 15
								//%04d 정수 4자리 [만약 자릿수 없으면 0처리]
									//15 -> 0015
			//중복체크
			boolean 계좌번호중복 = false;
			for (은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
				if( temp2 != null && temp2.get계좌번호().equals(계좌번호)) { //기존 배열내 계좌번호와 동일하면
					계좌번호중복 = true;
				}
			}
			//만일 중복이 없으면
			if (계좌번호중복 == false ) break;
		
		}
		//2.객체화[다수의 변수를 하나의 객체로 만들기]
			은행 temp = null;
			if (은행번호 == 1) {
				temp = new 국민은행(계좌번호, 비밀번호, 계좌주, 0);
			}else if (은행번호 == 2) {
				temp = new 신한은행(계좌번호, 비밀번호, 계좌주, 0);
			}else if(은행번호 == 3) {
				temp = new 하나은행(계좌번호, 비밀번호, 계좌주, 0);
			}
		//3.배열에 저장 
		int i =0;
		for (은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
			if (temp2 == null) {
				Day09_6_은행계좌프로그램.계좌리스트[i] = temp;
				System.out.println("*** 계좌등록 ***");
				return 계좌번호;
			}
			i++; //인덱스 증가
		}
		return null;	//null이면 실패했다는 의미
	}
	
		//2.입금 [u]
	public boolean 입금(String 계좌번호, int 입금액)	{
		//1.동일한 계좌번호 찾기
		int i = 0;
		for (은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if (temp != null && temp.get계좌번호().equals(계좌번호)) {
				//해당 계좌가 공백이 아니고 입력한 인수와 같으면
				//2.동일한 계좌번호가 있으면 입금 처리
				Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()+입금액);
				return true;
			}
			i++;
		}
		
		return false;
	}
		//3.출금 [u]
	public int 출금(String 계좌번호 , String 비밀번호 , int 출금액 )	{
		//1.동일한 계좌번호를 찾아서
		//2.해당 계좌번호와 비밀번호가 일치 확인
		int i = 0;
		for (은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp != null && temp.get계좌번호().equals(계좌번호) && temp.get비밀번호().equals(비밀번호)) {
				if (temp.get예금액() < 출금액) {
					return 1; //잔액부족 의미 반환
				} else {
					Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()-출금액);
					return 2; //출금 성공 의미 반환
				}
			}
			i++;
		}
		return 3;
		//3.비밀번호가 일치하면 출금처리
		//	아니면 출금실패
		//만일 예금액보다 출금액이 더 크면 잔액부족 [출금실패]
		
		
		}
		//4.이체 [u]
	public int 이체(String 계좌번호, String 비밀번호, int 이체금액, String 받는계좌)	{
		int i = 0; //본인 인덱스 위치 변수
		for (은행 temp : Day09_6_은행계좌프로그램.계좌리스트) { //본인(보내는 사람) 계좌는 temp
			if (temp != null && temp.get계좌번호().equals(계좌번호) && temp.get비밀번호().equals(비밀번호) ) {
				int j = 0; //받는 사람 계좌 인덱스 위치 변수
				for (은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {//받는 사람 계좌는 temp2
					if (temp2 != null & temp.get계좌번호().equals(받는계좌)) {
						if (temp.get예금액() < 이체금액) {
							return 1; //잔액부족
						}else {
							Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액() - 이체금액);
							Day09_6_은행계좌프로그램.계좌리스트[j].set예금액(temp.get예금액() + 이체금액);
							return 2;	//성공
						}
					}
					j++;
				}
			}
			i++;
		}
		//본인계좌 정보 없을 경우
		return 4;
		}
		//5.내계좌목록 [r]
	public 은행[] 계좌목록(String 계좌주)	{
		//입력받은 계좌주의 계좌목록 만들어서 반환
		//동일한 계좌주의 계좌를 찾아서 배열에 담아서 넘기기
		은행[] 내계좌목록 = new 은행 [100]; //배열 생성
		for (은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if ( temp != null && temp.get계좌주().equals(계좌주)) {
				//해당 계좌내 계좌주와 인수의 계좌주가 동일하면
				//내계좌목록 배열내 빈공간을 찾아서 내계좌 목록에 넣기 
				int i = 0;
				for (은행 temp2 : 내계좌목록) {
					if (temp2 == null) {
						 내계좌목록[i] = temp; 
						 break; //한번 저장했으면 끝
					}
					i++;
				}
			}
		}
		
		return 내계좌목록;
		}
		//6.대출 [u]
	public boolean 대출()	{
		
		return false;
		}
	
}
