package Day05;

import java.util.Scanner;

public class Day05_2 {//cs
	
	// ȸ���� �湮�� ���α׷�
	//1. �ʱ�޴� [ 1.ȸ������ 2. �α��� (3.���̵�ã��)]
	//1.ȸ������ [���̵�, ��й�ȣ, �̸�]
	//2.�α��� [���̵�, ��й�ȣ �����ϸ� �α���ó��]
	//2. �α��ν� �޴� [1.�湮�Ͼ��� 2. �α׾ƿ�]
	//1. �湮�� ����[����, ����, �ۼ���(�α��εȾ��̵�)]
	//2. �α׾ƿ� [�ʱ�޴��� ���ư���]

	public static void main(String[] args) {//ms
	
		//�غ�
		Scanner scanner = new Scanner(System.in);
		//ȸ��100��[id,pw,name]�����ϴ� �迭
		String[][] memberlist = new String[100][3]; 
			//100�� 3�� -> [1��=id][2��=pw][3��=name]
		//�湮�� 100��[title, contents, writer]�����ϴ� �迭
		String[][] boardlist = new String[100][3]; //�Խù��� 1��
		
		
		while(true) {//while1 ���ѷ���[�������� X]
			System.out.println("---------------------------");
			System.out.println("--------[ȸ���� �湮��]--------");
			System.out.println("---------------------------");
			System.out.println("| 1.ȸ������ | 2.�α��� | ���� : "); int ch = scanner.nextInt();
			if ( ch == 1) {//if 1 ȸ������ 
				System.out.println("--------ȸ������ ������---------");
				System.out.println("Member ID : "); String id = scanner.next();
				System.out.println("Member Password : "); String password = scanner.next();
				System.out.println("Member Name : "); String name = scanner.next();
				//String 3�� ������ �Է¹پ� memberlist 2���� �迭�� ����
					//1. �����[����=0, ��ü(���ڿ�) = null] �� ã�Ƽ� ���� [���࿡ ������� ������ �˸� ���]
					//2. ���̵� �ߺ�üũ
				
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
							memberlist [i][2] =name;
							//i��° �� ���� ������ ����
							System.out.println(">>> ȸ������ �Ϸ�");
							break; //���������� ��
						}//if2 end
					}//for1 end
				}//if1 end
				
			}else if (ch == 2) {
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
						
						while(true) {//�α��ν� ���ѷ��� [�������� : �α׾ƿ�]
							System.out.println("---------------------------");
							System.out.println("---------�湮�� ������---------");
							System.out.println("|��ȣ\t�ۼ���\t����\t����");
							//��� �湮�� ���
							for(int j =0; j<boardlist.length; j++) {
								if(boardlist[j][0] != null) {
									
									System.out.printf("%d\t%s\t%s\t%s \n", j,boardlist[j][2], boardlist[j][0], boardlist[j][1]);
								}
							}
							System.out.println("|1.�湮�� �ۼ�|2.�α׾ƿ�|���� : "); int ch2 = scanner.nextInt();
							
							if( ch2 == 1) {
								System.out.println("---------�湮�� �ۼ�----------");
								System.out.println("---------------------------");
								System.out.println("title : "); String title = scanner.next();
								System.out.println("content : "); String content = scanner.next();
								
								//�迭 �� ���� ã�Ƽ� ����
								for(int j =0; j<boardlist.length; j++) {
									if(boardlist[j][0] == null ) {//null�� �ƴϸ� ���� �����Ͱ� �����
										boardlist[j][0] = title;
										boardlist[j][1] = content;
										boardlist[j][2] = id; //�α��ν� ���� id ����
										System.out.println(">>> �湮���� �ۼ��Ǿ����ϴ�.");
										break;
									}
								}
								
							}else if ( ch2 == 2) {
								System.err.println("�α׾ƿ�");
								break;
								
							}else {
								System.err.println(">>> �� �� ���� ��ȣ�Դϴ�.");
							}//if end
							
						}//ȸ���޴�(�α��ν�) while end
						
					}//if1 end [�α��� ����]
				}//for end
				
				//�α��� ���н�
				if(logincheck ==false) {
					System.err.println(">>> ȸ�������� �ٸ��ϴ�.");
				}
				
			}else {
				System.err.println(">>> �� �� ���� ��ȣ�Դϴ�.");
			}
			
			
			
		}//while1 end
		
		
		
		
		
		
		
		
	}//me

}//ce
