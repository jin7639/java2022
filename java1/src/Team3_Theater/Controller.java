package Team3_Theater;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Controller {
	
	// ȸ������Ʈ
	static ArrayList<Member> memberlist = new ArrayList<>();
	// ��ȭ����Ʈ
	static ArrayList<Movie> movielist = new ArrayList<>();
	// Ƽ�ϸ���Ʈ
	static ArrayList<Ticket> ticketlist = new ArrayList<>();
	// ������Ʈ 

	
	Scanner scanner = new Scanner(System.in);
	DB db = new DB();
	//ȸ�� �ý��� ////////////////////////////////////////////////////////////////////////
	
	public int sign (String id, String pw,String name, String phone) {
		
		Member member = new Member( id, pw, name, phone,false);
		memberlist.add(member);
		db.memberSave();
		return 1;
	}
	
	public String login(String id,String pw) {
		

		for(Member temp : memberlist) {
			if(temp!=null) {
				if(id.equals("admin") && temp.getPw().equals(pw)) {
					return "admin";
				}
				else if(temp.getId().equals(id)&&temp.getPw().equals(pw)) {
					return temp.getId();
				}
				
			}
			
		}
		return "false";
	}
	
	
	public String findid(String name, String phone) {//���̵�ã��

		for(Member temp : memberlist) {
			if(temp!=null && temp.getName().equals(name) && temp.getPhone().equals(phone)) {
				return temp.getId();
			}
		}
		return "false";
	}
	
	public String findpw(String id,String phone) {
		for(Member temp : memberlist) {
			if(temp!=null && temp.getId().equals(id) && temp.getPhone().equals(phone)) {
				return temp.getPw();
			}
		}
		return "false";
	}
	
	public void memberInfo(String id) {
		System.out.println("ȸ�� ����))");
		for(Member temp : memberlist) {
			if(temp.getId().equals(id)) {
				System.out.println("-------------------------------");
				System.out.println("���̵� : " + temp.getId());
				System.out.println("�̸�  : " + temp.getName());
				System.out.println("��ȣ  : " + temp.getPhone());
				System.out.println("-------------------------------");
				System.out.println("1)��й�ȣ ����  2)ȸ��Ż��  3)�ڷΰ���");
				String work = scanner.next();
				
				if(work.equals("1")) {
					boolean result = changepw(id);
					if(result) {
						System.out.println("�޼���)) ��й�ȣ ����Ϸ�");
					}
					else {
						System.out.println("�޼���)) ��к�ȣ �������");
					}
				}
				else if(work.equals("2")) {
					singOut(id);
				}
				else if(work.equals("3")) {
					System.out.println("�޼���)) �������� ���ư��ϴ�.");
				}
				
			}
				
		}
		
		
	}
	
	public boolean changepw(String id) {
		
		System.out.println("��й�ȣ ����)) ");
		System.out.println("��й�ȣ : ");
		String pw = scanner.next();
		String new_pw = null;
		
		for(Member temp : memberlist) {
			if(temp.getId().equals(id) && temp.getPw().equals(pw)) {
				while(true) {
					int pass = 0;
					System.out.println("������ ��й�ȣ �Է� : "); 
					new_pw = scanner.next();
					if(new_pw.length() < 7) {
						System.out.println("�޼���)) ��й�ȣ�� ���̴� 8�ڸ� �̻��̿��� �մϴ�.");
						pass = 0;
					}
					else if(new_pw.equals(temp.getPw())) {
						System.out.println("�޼���)) ���� ��й�ȣ�� �����մϴ�.");
						pass = 0;
					}
					else {
						pass = 1;
					}
					if(pass == 1) {
						break;
					}
				}
				temp.setPw(new_pw);
				db.memberSave();
				return true;
			}
		}
		return false;
	}

	public void singOut(String id)  {
		System.out.println("ȸ�� Ż��))");
		System.out.println("��й�ȣ �Է� : ");
		String pw = scanner.next();
		
		for(Member temp : memberlist) {
	
			if(temp.getId().equals(id) && temp.getPw().equals(pw)) {
				System.out.println("�޼���)) ���� Ż���Ͻðڽ��ϱ�?");
				System.out.println("1)��     2)�ƴϿ�");
				String work = scanner.next();
				if(work.equals("1") || work.equals("��")) {
					memberlist.remove(temp);
					break;
				}
				else if (work.equals("2") || work.equals("�ƴϿ�")) {
					System.out.println("���� �޴��� ���ư��ϴ�.");
					break;
				}
				
			}
		}
		db.memberSave();
		return ;
	}
	
	//��ȭ�ý���///////////////////////////////////////////////////////////////////////////
	
	public void reserve(String id,String title,String intime,String runtime,int money,int seat,int Th_num) {
		Random random = new Random();
		int ticket_number = random.nextInt(99999999)+10000000;
		DecimalFormat df2 = new DecimalFormat("#,##0��");
		String new_money = df2.format(money);
		System.out.println("-----------���� ����----------");
		System.out.println("�����id : " +id);
		System.out.println("��ȭ���� : "+title);
		System.out.println("�󿵰�  : " + Th_num);
		System.out.println("���۽ð� : "+intime);
		System.out.println("����Ÿ�� : "+runtime);
		System.out.println("�ݾ� : " +new_money);
		System.out.println("�ڸ� : "+seat);
		System.out.println("���Ź�ȣ : "+ticket_number);
		System.out.println("----------------------------");
		String[] new_intime = intime.split(":");
		String[] new_runtime = runtime.split(":");
		int intime_hour = Integer.parseInt(new_intime[0]);
		int intime_min = Integer.parseInt(new_intime[1]);
		int runtime_hour = Integer.parseInt(new_runtime[0]);
		int runtime_min = Integer.parseInt(new_runtime[1]);
		int outhour = (intime_hour+runtime_hour);
		int outmin = (intime_min+runtime_min);
		DecimalFormat df = new DecimalFormat("00");
		String out1 = df.format(outhour);
		String out2 = df.format(outmin);
		String outtime = out1+":"+out2;

		Ticket ticket = new Ticket(id, title, intime, outtime, ticket_number,money,Th_num,seat);
		

		ticketlist.add(ticket);
		
		db.ticketSave();
	}
	
	public void myreserve(int num) {
		
		ticketlist.remove(num);
		db.ticketSave();
		return;
	}
	//������ �ý���/////////////////////////////////////////////////////////////////////////
	
	public void moive_register (String title, String intime, String runtime, int num) {

		String [] startTime = intime.split(":");
		
		int startHour = Integer.parseInt(startTime[0]);

		int money = 0;
		
		if (startHour <= 10) {
			System.out.println(startHour);
			money = 5000;
		}else {
			money = 7000;
		}
		Movie movie = new Movie(title, intime, runtime , money, num , true);
		
		movielist.add(movie);
		db.movieSave();
		System.out.println("��ȭ ���� �Ϸ�");
		
	}

	
	public void movie_remove (int num) {
		
		System.out.println("�޼���)) ���� �����Ͻðڽ��ϱ�?");
		System.out.println("1)��  2)�ƴϿ�");
		String work = scanner.next();
		
		if(work.equals("1") || work.equals("��")) {
			num -= 1;
			movielist.remove(num);
			db.movieSave();
		}
		else if(work.equals("2") || work.equals("�ƴϿ�")) {
			
		}
		
	}
	
	public void sale() {
	
		try {
			//����� ���
			System.out.println("--------------------�����----------------------");
			//��ȭ�� ����� ǥ��
			Hashtable <String, Integer> map = new Hashtable<>();
			DecimalFormat df2 = new DecimalFormat("#,##0��");
			
			for (int i = 0; i < ticketlist.size(); i++) {
				int ticketfee = 0; 
				for (int j = 0; j < ticketlist.size(); j++) {
					if (ticketlist.get(i).getT_title().equals(ticketlist.get(j).getT_title())) {
						ticketfee += ticketlist.get(i).getT_money();
					}
				}
				map.put(ticketlist.get(i).getT_title(), ticketfee);
			}
			
			for(String temp : map.keySet()) {
				String new_money = df2.format(map.get(temp));
				System.out.println("��ȭ "+temp+ " " + new_money);
			}
			//�� ����� ǥ��
			int totalsales = 0;
			for (int i = 0; i < ticketlist.size(); i++) {
				 totalsales += ticketlist.get(i).getT_money();
			}
			String new_money = df2.format(totalsales);
			System.out.println("�� ����� : " + new_money);
			System.out.println("---------------------------------------------");
			
		}//try end
		catch(Exception e) {
			
		}
	}

}