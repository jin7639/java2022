package Team_Theater;

import java.util.Scanner;

public class Main {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Controller con = new Controller();
		
		while(true) {
			try {
				////�󿵿�ȭ���////
				
				System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� ����: "); String ch = scanner.next();

				if(ch.equals("1") || ch.equals("ȸ������")) {
					System.out.println("���̵�: "); 		String id = scanner.next();
					System.out.println("��й�ȣ: "); 		String pw = scanner.next();
					System.out.println("�̸�: "); 		String name = scanner.next();
					System.out.println("��ȭ��ȣ: "); 		String phone = scanner.next();
					
					///����
					String result = con.sign(id, pw,name,phone);
					
					if(result == "bad") {
						System.out.println("ȸ�����Խ���");
					}
					else if (result == "good") {
						System.out.println("ȸ�����Լ���");
					}
				}
				else if(ch.equals("2") || ch.equals("�α���")) {
					System.out.println("���̵�: "); String id = scanner.next();
					System.out.println("��й�ȣ: "); String pw = scanner.next();
					
					String result = con.login(id, pw); // ���ϰ� String�̴ϱ� String ���� result����
					
					if(result.equals("admin")) {/////////////////////////////////////////////////////////������///////////////////
						System.out.println(">>>>>>>>>>�����ڷ� �α���");
						System.out.println("-----------------------------------");
						System.out.println("|  1.�� ��ȭ ���  |  2.��ȭ �� ���  |");
						System.out.println("-----------------------------------");
						int ch_admin = scanner.nextInt();
						if (ch_admin == 1) {
							System.out.println("��ȭ���� : ");		String title = scanner.next();
							System.out.println("���� �ð� : (hh:mm)");	String intime = scanner.next();
							boolean moviest_admin = true;
							while(moviest_admin) {
								if (intime.length() != 5) {
									System.out.println("�ٽ� �Է����ּ���.");
									System.out.println("���� �ð� : (hh:mm)");
									intime = scanner.next();
								}else {
									moviest_admin = false;
								}
							}//while end
							
							System.out.println("�� �ð� : (hh:mm)");		String runtime = scanner.next();
							Boolean movierun_admin = true;
							while(movierun_admin) {
								if (runtime.length() != 5) {
									System.out.println("�ٽ� �Է����ּ���.");
									System.out.println("���� �ð� : (hh:mm)");
									runtime = scanner.next();
								}else {
									movierun_admin = false;
								}
							}//while end
							Controller.moive_register(title, intime, runtime);
							
						}else if (ch_admin == 2) {
							
							System.out.println("��ȭ���� : ");		String title = scanner.next();
							System.out.println("���� �ð� : ");	String intime = scanner.next();
							Controller.movie_remove(title, intime);
						}else {
							System.out.println("�� �� ���� �Է��Դϴ�.");
						}
					}else { 
						System.out.println(result + "�� ȯ�� �մϴ�.");
					}

				}
				else if(ch.equals("3") || ch.equals("���̵�ã��")) {
					System.out.println("�̸�: "); String name = scanner.next();
					System.out.println("��ȭ��ȣ: "); String phone = scanner.next();
					
					con.findid(name,phone);
					
				}
				else if(ch.equals("4") || ch.equals("��й�ȣã��")){
					System.out.println("���̵�: "); String id = scanner.next();
					System.out.println("��ȭ��ȣ: "); String phone = scanner.next();
					
					con.findid(id,phone);
				}
				else {System.out.println("��ȣ�� �Է����ּ���");}
			}
			catch(Exception e) {}
		}
	
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void membermenu() {
		System.out.println("1.���� 2.������� 3.����Ȯ��   ����: "); String ch = scanner.next();
		
		if(ch.equals("1")||ch.equals("����")) {
			System.out.println("��ȭ����: "); String title = scanner.nextLine();
			//////�ش� ��ȭ�� �󿵽ð� ���//
			System.out.println("��ȭ�ð�: "); String intime = scanner.next();
			////������ ��ȭ�� �󿵰� �¼� ����///
			System.out.println("�¼�����: "); String seat = scanner.next();
		}
		else if(ch.equals("2")||ch.equals("�������")){
			System.out.println("��ȭ����: "); String title = scanner.nextLine();
			//////�ش� ��ȭ�� �󿵽ð� ���//
			System.out.println("��ȭ�ð�: "); String intime = scanner.next();
			//////�������
		}
		else if(ch.equals("3")||ch.equals("����Ȯ��")) {/////////////////////////////////////////////����Ȯ��//////////////
			
			
			
			////////���Ÿ�� �ڵ�����
			////////////////
			System.out.println("1.������� 2.�ڷΰ���"); String confirm = scanner.next();
		}
		else {}
		
	}
	public void adminmenu() {
		System.out.println("1.��ȭ��� 2.��ȭ���� 3.����Ȯ��"); String ch =scanner.next();
		
		if(ch.equals("1")||ch.equals("��ȭ���")) {
			System.out.println("��ȭ����: "); String title = scanner.nextLine();
			System.out.println("�󿵰�����: "); String screen = scanner.next();
			System.out.println("��ȭ�ð�: "); String intime = scanner.next();
		}
		else if(ch.equals("2")||ch.equals("��ȭ����")){
			System.out.println("��ȭ����: "); String title = scanner.nextLine();
			System.out.println("�󿵰�����: "); String screen = scanner.next();
			System.out.println("��ȭ�ð�: "); String intime = scanner.next();
		}
		else if(ch.equals("3")||ch.equals("����Ȯ��")) {
			System.out.println("");
		}
		else {}
		
	}
	
}