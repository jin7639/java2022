package Day05;

import java.util.Scanner;

public class Day05_4 {//cs
	//1.����� 2.����/�ڷ���/���� 3.����/�ݺ� 4.�迭
	
	//���� �뿩 ���α׷�
		//1.�迭
			//1.ȸ��[���̵�(�ߺ�X), ��й�ȣ]
			//2.����[������(�ߺ�X), �����뿩����(�뿩����/�뿩��), �뿩��(�α��νþ��̵�)]
		//2.�ʱ�޴�
			//1.ȸ������ 2. �α���
				//1.ȸ������ �� ���̵� �ߺ�üũ
				//2.�α��� ������ �α��� �޴�, ���н� �α��� ���� ���
		//3.�α��ν� �޴�
			//1.�����˻� 2.������� 3. �����뿩 4.�����ݳ� 5.�α׾ƿ�
				//1.�����˻��� �������� ��ġ�ϸ� ������� �����뿩���� ���
				//2.������Ͻ� ��� ������ ���
				//3.�����뿩�� �����뿩���ΰ� �����Ҷ� �����뿩 ó��
				//4.�����ݳ��� ������ �뿩�� ������ �ݳ�ó��
				//5.�α׾ƿ�
		//4.�α��ν� ���̵� admin�̸� �����ڸ޴�
			//1.������� 2.������� (3.��������) 3.�α׾ƿ�
				//1.������Ͻ� �������� �Է¹޾� ���� ���ó��
				//2.������Ͻ� ��� ������ ���
				//3.���������� ������ �������� �Է¹��� ������ ������ ���� [null]
				//4.�α׾ƿ�
	
	public static void main(String[] args) {//ms
		
		//�غ�
		Scanner scanner = new Scanner(System.in);
		String[][] memberlist = new String[100][2]; 
		String[][] booklist = new String[100][3];
		
		booklist[0][0] = "�����";
		booklist[1][0] = "���̵�"; booklist[1][1] = "������"; 
		booklist[2][0] = "���������"; 
		
		//�ʱ�޴�
		while(true) {//while1 �ʱ�޴�
			System.out.println("---------------------------");
			System.out.println("-----------���� �뿩----------");
			System.out.println("---------------------------");
			System.out.println("| 1.ȸ������ | 2.�α��� | ���� : "); int ch = scanner.nextInt();
			
			if (ch == 1) {
				//ȸ������������
				System.out.println("--------ȸ������ ������---------");
				System.out.println("Member ID : "); String id = scanner.next();
				System.out.println("Member Password : "); String password = scanner.next();
				
				//���̵� �ߺ�üũ [���� ȸ���� id�� �����ϸ� ȸ������ �Ұ�]
				boolean idcheck =true;
				for ( int i = 0; i<memberlist.length; i++ ) {
					if (memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						//i��° �࿡ �Ȱ��� id�� ������
						//i��° �� ���� ������ ���� �Ұ�
						System.err.println(">>> �̹� �����ϴ� ���̵��Դϴ�.");
						idcheck = false;
						break; 
					}//if end
				}//for end
				
				//����
				if(idcheck == true) {//if 1 -> idcheck�� true�� ���� ȸ������
					
					for ( int i = 0; i<memberlist.length; i++ ) {//for1 Ȯ��
						if (memberlist[i][0] == null) {//if2 ����
							//i��° �࿡ id�� ������ (������̸�) 
							memberlist [i][0] =id;
							memberlist [i][1] =password;
							//i��° �� ���� ������ ����
							System.out.println(">>> ȸ������ �Ϸ�");
							break; //���������� ��
						}//if2 end
					}//for1 end
				}//if1 end
			} else if ( ch == 2 ) {
				System.out.println("---------�α��� ������---------");
				System.out.println("Member ID : "); String id = scanner.next();
				System.out.println("Member Password : "); String password = scanner.next();
				
				boolean logincheck = false; //�α��� �ʱⰪ
				
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) && memberlist[i][1].equals(password)) {
						//1��° �࿡ id�� password�� �Է¹ٵ� ���� equals ������
							//null�� ��ü�� �ƴϱ⶧���� equals �Ұ���
						System.out.println(">>> �α��� ����");
						
						logincheck = true; //�α��� ���� �� ����
						
				////////////////////////////////�α��θ޴�/////////////////////////////////////
						System.out.println("--------------------------------------------");
						System.out.println("-------------------���� �뿩-------------------");
						System.out.println("--------------------------------------------");
						System.out.println("|1.�����˻�|2.�������|3.�����뿩|4.�����ݳ�|5.�α׾ƿ�| ���� : "); int ch_login = scanner.nextInt();
						
						if (ch_login == 1) {
							
							
						} else if (ch_login == 2) {//�������
							System.out.println("-------------------------------------------");
							System.out.println("-------------------�������-------------------");
							System.out.println("-------------------------------------------");
							System.out.println("|������\t\t\t����\t�뿩��|");
							
							//��� ���� ��� ���
							
							for(int j = 0; j<booklist.length; j++) {
								if(booklist[j][0] != null) {
									if (booklist[j][1] == null) {
										booklist[j][1] = "���Ⱑ��";
									}
									System.out.printf("|%s\t\t\t%s\t%s| \n", booklist[j][0], booklist[j][1], booklist[j][2]);
								}//if end
							}//for end
								
						} else if (ch_login == 3) {
							
						} else if (ch_login == 4) {
							
						} else if (ch_login == 5) {
							System.err.println(">>> �α׾ƿ�");
							break;
						} else {
							System.err.println(">>> �߸��� �����Դϴ�.");
							break;
						}
						
						
						
						
					}//if end
					
					
				}//for end
				
				
				
//////////////////////////////4.�α��ν� ���̵� admin�̸� �����ڸ޴�
				//1.������� 2.������� (3.��������) 3.�α׾ƿ�
				//1.������Ͻ� �������� �Է¹޾� ���� ���ó��  	//2.����[������(�ߺ�X), �����뿩����(�뿩����/�뿩��), �뿩��(�α��νþ��̵�)]
				//2.������Ͻ� ��� ������ ���
				//3.���������� ������ �������� �Է°��� ������ ������ ���� [null][
				//4.�α׾ƿ�
				if (id.equals("admin")) {//if admin 
					
					while(true) {
						System.out.println("--------------------------------------");
						System.out.println("---------------������ ������--------------");
						System.out.println("--------------------------------------");
						System.out.println("|1.�������|2.�������|3.��������|4.�α׾ƿ�|���� : "); int ch_admin = scanner.nextInt();
						
						if (ch_admin == 1) {
							System.out.println("-------------------------------------");
							System.out.println("----------------���� ���---------------");
							System.out.println("-------------------------------------");
						
							System.out.println("������ : "); String title = scanner.next();
							
							boolean titlecheck =true;
							for ( int i = 0; i<booklist.length; i++ ) {
								if (booklist[i][0] != null && booklist[i][0].equals(title)) {
									System.err.println(">>> �̹� �����ϴ� �����Դϴ�.");
									titlecheck = false;
									break; 
								}//if end
							}//for end
							
							if (titlecheck == true ) {
								//�迭 �� ���� ã�Ƽ� ����
								for(int i =0; i<booklist.length; i++) {//�������
									if(booklist[i][0] == null ) {//null�� �ƴϸ� ���� �����Ͱ� �����
										booklist[i][0] = title;
										System.out.println(">>> ������ ��ϵǾ����ϴ�.");
										break;
									}//if end
								}//for end
							}
							
						}else if (ch_admin == 2) { //�������
							System.out.println("--------------------------------------");
							System.out.println("----------------�������-----------------");
							System.out.println("--------------------------------------");
							System.out.println("|������\t\t\t����\t�뿩��|");
							
							//��� ���� ��� ���
							
							for(int j = 0; j<booklist.length; j++) {
								if(booklist[j][0] != null) {
									if (booklist[j][1] == null) {
										booklist[j][1] = "���Ⱑ��";
									}
									System.out.printf("|%s\t\t\t%s\t%s| \n", booklist[j][0], booklist[j][1], booklist[j][2]);
								}//if end
							}//for end
								
						}//if2 end
						else if (ch_admin == 3) {//��������
							System.out.println(">>> ������ �������� �Է����ּ���."); String book_del = scanner.next();
								for (int i = 0; i < booklist.length; i++) {
									if (book_del.equals(booklist[i][0])) {
										booklist[i] = null;
										for (int j = 0; j < booklist.length-1; j++) {
											booklist[j] = booklist[j+1];
										}
										System.err.println(">>> ������ �����Ͽ����ϴ�.");
										break;
									}else {
										System.err.println(">>> �������� �ʴ� �����Դϴ�.");
									}
								} 
							}else if (ch_admin == 4) {
								System.err.println(">>> �α׾ƿ�");
								break;
							}else {
								System.err.println(">>> �� �� ���� ��ȣ�Դϴ�.");
								break;
						}
					}
				}//if admin end
			} else {
				System.err.println(">>> �� �� ���� �Է��Դϴ�.");
				break;
			}
			
			
		}//while1 end
		
		
	}//me

}//ce