package dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Member {//데이터모델

	//필드
	private int mnum; //회원번호
	private String mid; //회원아이디
	private String mpassword; //회원비밀번호
	private String memail; //이메일
	private String maddress; //주소
	private int mpoint; //포인트
	private String msince; //가입일
	
	// 생성자
	public static void sendmail( String 받는사람이메일, String 내용) {
		//1. 보내는 사람 정보
		String 보내는사람이메일 = "아이디@naver.com";
		String 보내는사람이메일비밀번호 = "비밀번호";
		
		//2. 호스트 설정
		 //포트:네트워크,DB에 접근하기 위한 길(번호)
		Properties properties = new Properties(); //컬렉션 프레임워크 [map컬렉션]
		properties.put("mail.smtp.host", "smtp.naver.com"); // 호스트 주소
		properties.put("mail.smtp.port", 587); //호스트(네이버) 포트번호
		properties.put("mail.smtp.auth", "true"); //보내는사람이메일 인증
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2" ); // 보안 연결 버전
		
		//3.인증처리
		Session session = Session.getDefaultInstance( properties , new Authenticator() {
		
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(보내는사람이메일, 보내는사람이메일비밀번호);
			}
		});
	
		//4.메일보내기
		 try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom( new InternetAddress(보내는사람이메일)); //보내는 사람
			message.addRecipient(Message.RecipientType.TO , new InternetAddress(받는사람이메일));
			
			//내용
			message.setSubject("안산지역 중고거래 회원님의 비밀번호 찾기");
			message.setText("회원님의 비밀번호 : " + 내용);
			//전송
			Transport.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("메일전송 실패 " + e);
		}
		
	}
	public Member() {
		super();
	}

	public Member(int mnum, String mid, String mpassword, String memail, String maddress, int mpoint, String msince) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.msince = msince;
	}

	
	//메소드
	
	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMsince() {
		return msince;
	}

	public void setMsince(String msince) {
		this.msince = msince;
	}
	
	
}
