package Test2;

import java.util.Scanner;

public class Parking {

	//1. ������Ȳǥ�� �׻� ��� : ��¥ ������ȣ �����ð� �����ð� �ݾ�
		//������ �����ð��� ������ -> ������ ���� �ð� ǥ��
		//�ݾ� : ������ �̸� ������ ���� �Ŀ��� �ݾ� ǥ��
	//2. �޴����� 1�� ���ý� ����
		//������ȣ �Է¹ޱ�
	//3. �޴����� 2�� ���ý� ����
		//������ȣ �Է¹ޱ�
		//���� ��ȯǥ�� �����ð� �����ϰ� �ݾ� ����Ͽ� ǥ��
	//4. ���� ��ü -> �迭/����Ʈ�� ����
	//5. �ݾ�
		//���� 30�� ���� -> 10�д� 1000��
	//6.����ó�� X
	//7.���ܹ߻� ��Ȳ ó��
	
	public static void main(String[] args) {//ms
		
		Scanner scanner = new Scanner(System.in);
		while(true) { //���ѷ��� [�������� : ����]
			try {
				System.out.println("-------------���� ��Ȳ ǥ--------------");
				System.out.println("��¥\t������ȣ\t�����ð�\t�����ð�\t�ݾ�");
				System.out.printf("%s\t%s\t%s\t%s\t%d \n", "��¥", "������ȣ","�����ð�","�����ð�","�ݾ�");
				
				System.out.println("------------------------------------");
				System.out.println("1.���� 2. ���� | ���� : ");
				int ch = scanner.nextInt();
				
				if (ch == 1) {//����
					System.out.println("������ȣ : ");
					String carNum = scanner.next();
					Controller.carIn(carNum);
				}else if (ch == 2) {//����
					
				}else {
					System.out.println("�� �� ���� �Է��Դϴ�.");
				}
			} catch (Exception e) {
				System.out.println("�� �� ���� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
		
		
		
		}//while end
	}//me
	
}//ce
