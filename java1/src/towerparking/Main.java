package towerparking;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tower = { "[    ]","[    ]","[    ]","[    ]",
	 			"[    ]","[    ]","[    ]","[    ]",
	 			"[    ]","[    ]","[    ]","[    ]"};
		
		while(true) {
			try {
				for(int i = 0; i < tower.length; i++) {
					 System.out.print(tower[i]);
					 if(i%4==3) {
						 if(i==3) {
							 System.out.println("1��");
						 }
						 if(i==7) {
							 System.out.println("2��");
						 }
						 if(i==11) {
							 System.out.println("3��");
						 }
					 }
				 }
				System.out.println("-----------------------------");
				System.out.println("1.���� 2.���� 3.����Ȯ�� 4.����Ȯ��");
				int ch =  scanner.nextInt();
				
				if (ch == 1) {//����
					System.out.println("������ ������ȣ 4�ڸ� : ");
					int carNum = scanner.nextInt();
					for (int i = 0; i < tower.length; i++) {
						if (tower[i].equals("[    ]")) {
							tower[i] = "["+carNum+"]";
							
							break;
						}
					}
					
				}else if (ch == 2) {//����
					
					System.out.println("������ ������ȣ 4�ڸ� : ");
					int outCarNum = scanner.nextInt();
					for (int i = 0; i < tower.length; i++) {
						if (tower[i].equals("["+outCarNum+"]")) {
							tower[i] = "[    ]";
							break;
						}
					}
				}else if (ch == 3) {//����Ȯ��
					
				}else if (ch ==4) {//����Ȯ��
					
				}else {
					System.out.println("�� �� ���� �Է��Դϴ�.");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}//catch end
		}//while end
		
	}//me
}//ce
