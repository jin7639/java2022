package application.Day26;

import java.net.InetAddress;

public class Day26_1 {

	//네트워크 : 두 대 이상의 컴퓨터들을 연결하고 통신할 수 있는 것
		//통신망 : 전자신호를 통해 통신하는 모든 기기가 서로 통신하기 위한 하나의 망
		//프로토콜 : 컴퓨터내부/컴퓨터사이 데이터 교환 방식을 정의하는 규칙[체계] 오호 이거 진짜 쓰이는 거구나
			//SMTP : 메일 전송 프로토콜  --->이제 이거 틀리면 진짜 어이없어지는거지
			//IP : 인터넷 프로토콜		--->이거 한 다섯번은 틀린듯
	//TCP/IP
		//TCP : Transmission control Protocol 통신 제어
		//IP : Internet Protocol address 통신 인식 번호[주소-pc주소-집주소] 0.0.0.0 ~ 255.255.255.255
			// 우리집 <---------우편----------> 친구집
			//								친구집 주소
			// 집컴퓨터<--------------------->네이버 컴퓨터[홈페이지]
			//								www.naver.com [도메인주소 : 문자이기 때문에 사람이 외우기 쉬움]
	
	public static void main(String[] args) {
		//1. 현재 pc의 ip 주소 확인
		//윈도우 버튼 ->cmd 검색 -> 명령프롬프트
		//ipconfig 입력시 네트워크(ip) 정보를 알 수 있다.
		//2. 자바에서 ip 주소 확인
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
				//InetAddress 클래스 : 네트워크 정보를 저장
					//.getLocalHost() : 로컬pc =현재pc 정보 호출
			System.out.println("현재 pc의 네트워크 객체 : "+ inetAddress);
			System.out.println("현재 pc이름 : "+ inetAddress.getHostName());
			System.out.println("현재 pc ip주소 : "+ inetAddress.getHostAddress());
		//3. 네이버회사 ip 주소 확인
			InetAddress inetAddress2 = InetAddress.getByName("www.naver.com");
			System.out.println("네이버 pc정보객체 : " + inetAddress2);
			System.out.println("네이버 pc 이름 : " + inetAddress2.getHostName());
			System.out.println("네이버 pc ip주소 : "+ inetAddress2.getHostAddress());
		//4. 페이스북 ip 주소 확인
			InetAddress inetAddress3 = InetAddress.getByName("www.facebook.com");
			System.out.println("페이스북 pc정보객체 : " + inetAddress3);
			System.out.println("페이스북 pc 이름 : " + inetAddress3.getHostName());
			System.out.println("페이스북 pc ip주소 : "+ inetAddress3.getHostAddress());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
