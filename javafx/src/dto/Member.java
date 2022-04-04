package dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Member {//�����͸�

	//�ʵ�
	private int mnum; //ȸ����ȣ
	private String mid; //ȸ�����̵�
	private String mpassword; //ȸ����й�ȣ
	private String memail; //�̸���
	private String maddress; //�ּ�
	private int mpoint; //����Ʈ
	private String msince; //������
	
	// ������
	public static void sendmail( String �޴»���̸���, String ����) {
		//1. ������ ��� ����
		String �����»���̸��� = "���̵�@naver.com";
		String �����»���̸��Ϻ�й�ȣ = "��й�ȣ";
		
		//2. ȣ��Ʈ ����
		 //��Ʈ:��Ʈ��ũ,DB�� �����ϱ� ���� ��(��ȣ)
		Properties properties = new Properties(); //�÷��� �����ӿ�ũ [map�÷���]
		properties.put("mail.smtp.host", "smtp.naver.com"); // ȣ��Ʈ �ּ�
		properties.put("mail.smtp.port", 587); //ȣ��Ʈ(���̹�) ��Ʈ��ȣ
		properties.put("mail.smtp.auth", "true"); //�����»���̸��� ����
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2" ); // ���� ���� ����
		
		//3.����ó��
		Session session = Session.getDefaultInstance( properties , new Authenticator() {
		
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(�����»���̸���, �����»���̸��Ϻ�й�ȣ);
			}
		});
	
		//4.���Ϻ�����
		 try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom( new InternetAddress(�����»���̸���)); //������ ���
			message.addRecipient(Message.RecipientType.TO , new InternetAddress(�޴»���̸���));
			
			//����
			message.setSubject("�Ȼ����� �߰�ŷ� ȸ������ ��й�ȣ ã��");
			message.setText("ȸ������ ��й�ȣ : " + ����);
			//����
			Transport.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������� ���� " + e);
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

	
	//�޼ҵ�
	
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
