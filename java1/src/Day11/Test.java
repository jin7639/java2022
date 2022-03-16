package Day11;

import java.util.Scanner;

public class Test {//cs


	public static void main(String[] args) {//ms
		
		Scanner scanner = new Scanner(System.in);
		Students[] students = new Students[100];
		
		while (true) {//while start
			try {

				System.out.println("---------------------------------------------------------------");
				System.out.println("                         ��     ��      ǥ                       ");
				System.out.println("---------------------------------------------------------------");
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s \n","��ȣ","�̸�","����","����","����","����","���","����");
				for(int i = 0 ; i < students.length ; i++) {
					if(students[i] != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n", 
								students[i].getNo(), students[i].getName(), students[i].getKorea(), 
								students[i].getEnglish(), students[i].getMath(),students[i].getSum(),students[i].getAvg(),i+1);
					}else {
						break;
					}
					
				}	
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("1.�л����� ��� 2.�л����� ����");
				int ch = scanner.nextInt();
				
				
				if (ch == 1) {
					//1. ��ȣ �̸� ���� ���� ���� 
					System.out.println("----------�л����� ���-----------");
					System.out.println("��ȣ : "); int no = scanner.nextInt();
					System.out.println("�̸� : "); String name = scanner.next();
					System.out.println("�������� : "); int korea = scanner.nextInt();
					System.out.println("�������� : "); int english = scanner.nextInt();
					System.out.println("�������� : "); int math = scanner.nextInt();
					
					int sum = korea + english + math;
					double avg = (double)sum / 3 ;
					
					//2. ��ü ����
					Students students1 = new Students(no, name, korea, english, math, sum, avg);
					
					//3. ����
					for (int i = 0; i < students.length; i++) {
						if (students[i] == null) {
							students[i] = students1;
							break;
						}
					}
					//����
					if (students[1] != null) {
						for (int i = 0; i < students.length; i++) {
							
							for (int j = i + 1; j < students.length; j++) {
								if (students[i].getSum() < students[j].getSum()) {
									System.out.println(students[i].getSum()+ " , "+ students[j].getSum());
									Students temp = students[i];
									students[i] = students[j];
									students[j] = temp;
								}
							}
						}
					}
					
				}else if (ch == 2) {
					System.out.println("������ �л� ��ȣ: ");
					int st_del = scanner.nextInt();
					boolean delete = false;
					for (int i = 0 ; i < students.length; i++) {
						if(students[i].getNo() == st_del) {
							students[i] = null;
							for (int j = i; j < students.length; j++) {
								students[j] = students[j+1];
							}
							
							System.out.println("�����Ͽ����ϴ�.");
							delete = true;
							break;
						}
					}
					if (delete == false) {
						System.out.println("��ġ�ϴ� �л��� �����ϴ�.");
					}
					
				}else {
					System.out.println("�� �� ���� ��ȣ�Դϴ�.");
					
				}
				
				
			}//try end
			catch (Exception e) {
				System.out.println("����� �� ���� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}//catch end
			
		}//while end
		
	}//me

}//ce
