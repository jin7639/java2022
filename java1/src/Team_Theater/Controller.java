package Team_Theater;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Controller {
	
	// 회원리스트
	static ArrayList<Member> memberlist = new ArrayList<>();
	// 영화리스트
	static ArrayList<Movie> movielist = new ArrayList<>();
	// 티켓리스트
	static ArrayList<Ticket> ticketlist = new ArrayList<>();
	
	Scanner scanner = new Scanner(System.in);
	
	//회원 시스템 ////////////////////////////////////////////////////////////////////////
	
	public String sign (String id, String pw,String name, String phone) {
		
		//아이디 중복검사
		for(Member temp : memberlist) {
			if (temp !=null &&  temp.getId().equals(id)) {
				//만약에 공백이 아니면서 배열내 id와 입력받은 id와 동일하면
				System.out.println("현재 사용중인 아이디입니다.");
				return "bad"; //함수종료 --->아이디중복으로 회원가입 실패
			}
		}
		//회원정보 입력받기
		
		//객체화
		Member member = new Member( id, pw, name, phone,false);
		//회원정보 저장
		
		memberlist.add(member);
		return "good";
	}
	
	public String login(String id,String pw) {
		
		//로그인 중복체크
		for(Member temp : memberlist) {
			if(temp!=null) {
				if(id.equals("admin") && temp.getPw().equals(pw)) {
					return "admin";
				}
				else if(temp.getId().equals(id)&&temp.getPw().equals(pw)) {
					return temp.getId(); //로그인성공 리스트에있는 아이디 리턴
				}
				
			}
			
		}
		return "회원";
	}
	
	
	public void findid (String name, String phone) {//아이디찾기

		for(Member temp : Controller.memberlist) {
			if(temp!=null&&temp.getName().equals(name)&&temp.getPhone().equals(phone)) {
				System.out.println("회원님의 아이디: "+ temp.getId());
			}else {
				System.out.println("해당 아이디를 찾을 수 없습니다.");
			}
		}///for
	}
	
	public void findpw (String id,String phone) {
		for(Member temp : Controller.memberlist) {
			if(temp!=null&&temp.getId().equals(id)&&temp.getPhone().equals(phone)) {
				System.out.println("회원님의 비밀번호: "+ temp.getPw());
			}
			else {
				System.out.println("해당 비밀번호를 찾을 수 없습니다.");
			}
		}///for
	}
	
	public void changepw() {
		
	}
	
	//영화시스템///////////////////////////////////////////////////////////////////////////
	
	public void reserve() {}
	
	public void myreserve() {
		
		System.out.println("--------------------------------------------------");
		System.out.println("영화 제목\t\t상영 시간\t\t좌석번호\t예매번호\t티켓 금액");
		for (int i = 0; i < ticketlist.size(); i++) {
			if (memberlist.get(i).getId() == ticketlist.get(i).getT_id()) {
				//영화 끝나는 시간 계산
				String [] startTime = ticketlist.get(0).getT_intime().split(":");
				int startHour = Integer.parseInt(startTime[0]); // 08:00 -> 8
					int movieStartHour = startHour*60;			// 8*60 = 480
				int startMin = Integer.parseInt(startTime[1]);	// 0
					int movieTime = movieStartHour + startMin;	// 480 + 0 = 480
					
				int endTime = movieTime + Integer.parseInt(movielist.get(0).getRuntime());	//영화 끝나는 시간 분으로 계산
					
				int endHour = endTime / 60 ;	//영화 끝나는 시각
				int endMin = endTime % 60;		//영화 끝나는 분
				
				//영화 끝나는 시간 문자열로 변환 --> 저장
				ticketlist.get(0).setT_outtime(endHour+ ":"+endMin);
				
				System.out.printf("%s\t\t%s ~ %s\t\t%s\t%s\t%d", 
					ticketlist.get(i).getT_title(), ticketlist.get(i).getT_intime(), "영화 끝나는 시간",
					ticketlist.get(i).getT_seat(),ticketlist.get(i).getT_num(),ticketlist.get(i).getT_money());
				
			}
		}
		 
	}
	
	public void cancle() {}
	
	//관리자 시스템/////////////////////////////////////////////////////////////////////////
	
	public static void moive_register (String title, String intime, String runtime) {//영화등록
		
		
		
		//영화티켓가격 계산
		String [] startTime = intime.split(":");
		
		int startHour = Integer.parseInt(startTime[0]);

		int money = 0;
		
		if (startHour <= 10) {
			money = 5000;
		}else {
			money = 7000;
		}
		
		Movie movie = new Movie(title, intime, runtime, money );
		//리스트에 저장
		movielist.add(movie);
		
		//파일처리
		try {//예외가 발생할 것 같은 코드 묶음					
			FileOutputStream outputStream = new FileOutputStream("D:/movie/상영중인영화.txt", true);
			String movieRecord = title + "," + intime+ "," +runtime+  ","+ money + "\n"; //, : 구분
			outputStream.write(movieRecord.getBytes());	//문자열 ->바이트열
		}catch (Exception e) {//예외[오류] 처리[잡기] : Exception 클래스
				
		}
		System.out.println("영화 저장 완료");
		
	}

	public static void movie_remove (String title, String intime) {
		for (int i = 0; i < movielist.size(); i++) {
			if (title == movielist.get(i).getTitle() && intime == movielist.get(i).getIntime()) {
				movielist.remove(i);
				
			}// if end
		}//for end
	}//movie_remove end
	
	public void sale() {}
	
	
	
}
