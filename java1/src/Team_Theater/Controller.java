package Team_Theater;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Controller {
	
	// ȸ������Ʈ
	static ArrayList<Member> memberlist = new ArrayList<>();
	// ��ȭ����Ʈ
	static ArrayList<Movie> movielist = new ArrayList<>();
	// Ƽ�ϸ���Ʈ
	static ArrayList<Ticket> ticketlist = new ArrayList<>();
	
	Scanner scanner = new Scanner(System.in);
	
	//ȸ�� �ý��� ////////////////////////////////////////////////////////////////////////
	
	public String sign (String id, String pw,String name, String phone) {
		
		//���̵� �ߺ��˻�
		for(Member temp : memberlist) {
			if (temp !=null &&  temp.getId().equals(id)) {
				//���࿡ ������ �ƴϸ鼭 �迭�� id�� �Է¹��� id�� �����ϸ�
				System.out.println("���� ������� ���̵��Դϴ�.");
				return "bad"; //�Լ����� --->���̵��ߺ����� ȸ������ ����
			}
		}
		//ȸ������ �Է¹ޱ�
		
		//��üȭ
		Member member = new Member( id, pw, name, phone,false);
		//ȸ������ ����
		
		memberlist.add(member);
		return "good";
	}
	
	public String login(String id,String pw) {
		
		//�α��� �ߺ�üũ
		for(Member temp : memberlist) {
			if(temp!=null) {
				if(id.equals("admin") && temp.getPw().equals(pw)) {
					return "admin";
				}
				else if(temp.getId().equals(id)&&temp.getPw().equals(pw)) {
					return temp.getId(); //�α��μ��� ����Ʈ���ִ� ���̵� ����
				}
				
			}
			
		}
		return "ȸ��";
	}
	
	
	public void findid (String name, String phone) {//���̵�ã��

		for(Member temp : Controller.memberlist) {
			if(temp!=null&&temp.getName().equals(name)&&temp.getPhone().equals(phone)) {
				System.out.println("ȸ������ ���̵�: "+ temp.getId());
			}else {
				System.out.println("�ش� ���̵� ã�� �� �����ϴ�.");
			}
		}///for
	}
	
	public void findpw (String id,String phone) {
		for(Member temp : Controller.memberlist) {
			if(temp!=null&&temp.getId().equals(id)&&temp.getPhone().equals(phone)) {
				System.out.println("ȸ������ ��й�ȣ: "+ temp.getPw());
			}
			else {
				System.out.println("�ش� ��й�ȣ�� ã�� �� �����ϴ�.");
			}
		}///for
	}
	
	public void changepw() {
		
	}
	
	//��ȭ�ý���///////////////////////////////////////////////////////////////////////////
	
	public void reserve() {}
	
	public void myreserve() {
		
		System.out.println("--------------------------------------------------");
		System.out.println("��ȭ ����\t\t�� �ð�\t\t�¼���ȣ\t���Ź�ȣ\tƼ�� �ݾ�");
		for (int i = 0; i < ticketlist.size(); i++) {
			if (memberlist.get(i).getId() == ticketlist.get(i).getT_id()) {
				//��ȭ ������ �ð� ���
				String [] startTime = ticketlist.get(0).getT_intime().split(":");
				int startHour = Integer.parseInt(startTime[0]); // 08:00 -> 8
					int movieStartHour = startHour*60;			// 8*60 = 480
				int startMin = Integer.parseInt(startTime[1]);	// 0
					int movieTime = movieStartHour + startMin;	// 480 + 0 = 480
					
				int endTime = movieTime + Integer.parseInt(movielist.get(0).getRuntime());	//��ȭ ������ �ð� ������ ���
					
				int endHour = endTime / 60 ;	//��ȭ ������ �ð�
				int endMin = endTime % 60;		//��ȭ ������ ��
				
				//��ȭ ������ �ð� ���ڿ��� ��ȯ --> ����
				ticketlist.get(0).setT_outtime(endHour+ ":"+endMin);
				
				System.out.printf("%s\t\t%s ~ %s\t\t%s\t%s\t%d", 
					ticketlist.get(i).getT_title(), ticketlist.get(i).getT_intime(), "��ȭ ������ �ð�",
					ticketlist.get(i).getT_seat(),ticketlist.get(i).getT_num(),ticketlist.get(i).getT_money());
				
			}
		}
		 
	}
	
	public void cancle() {}
	
	//������ �ý���/////////////////////////////////////////////////////////////////////////
	
	public static void moive_register (String title, String intime, String runtime) {//��ȭ���
		
		
		
		//��ȭƼ�ϰ��� ���
		String [] startTime = intime.split(":");
		
		int startHour = Integer.parseInt(startTime[0]);

		int money = 0;
		
		if (startHour <= 10) {
			money = 5000;
		}else {
			money = 7000;
		}
		
		Movie movie = new Movie(title, intime, runtime, money );
		//����Ʈ�� ����
		movielist.add(movie);
		
		//����ó��
		try {//���ܰ� �߻��� �� ���� �ڵ� ����					
			FileOutputStream outputStream = new FileOutputStream("D:/movie/�����ο�ȭ.txt", true);
			String movieRecord = title + "," + intime+ "," +runtime+  ","+ money + "\n"; //, : ����
			outputStream.write(movieRecord.getBytes());	//���ڿ� ->����Ʈ��
		}catch (Exception e) {//����[����] ó��[���] : Exception Ŭ����
				
		}
		System.out.println("��ȭ ���� �Ϸ�");
		
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
