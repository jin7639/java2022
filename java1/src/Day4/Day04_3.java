package Day4;

import java.util.Random;
import java.util.Scanner;

public class Day04_3 {//cs
	public static void main(String[] args) {//ms
		
		// ����������
		
		Scanner scanner = new Scanner(System.in);
		
		// ���� ���� �غ�
		int �÷��̾�; //����ڰ� ������ ��
		int ��ǻ��; //��ǻ�Ͱ� ������ ����
		int ���Ӽ� = 0; //�� ���ӽ��� �� 
		int �÷��̾�¸��� = 0; //�÷��̾ �¸��� Ƚ��
		int ��ǻ�ͽ¸��� = 0; //��ǻ�Ͱ� �¸��� Ƚ��
		
		//���α׷� ����
		while(true) { // ���α׷� ���� [ ���ѷ��� ���� ���� : 3�� �Է½ÿ� ����]
			System.out.println("---------���������� ����---------");
			System.out.println("����(0) ����(1) ��(2)    ����(3)");
			�÷��̾� = scanner.nextInt(); //�Է��� �� ����
			
			
			//��������
			if (�÷��̾� == 3) {
				System.out.println("������ �����մϴ�.");
				System.out.println("�÷��̾� �¸� : " + �÷��̾�¸���);
				System.out.println("��ǻ�� �¸� : " + ��ǻ�ͽ¸���);
				System.out.println("�� ���� �� : " + ���Ӽ�);
				if(�÷��̾�¸��� > ��ǻ�ͽ¸���) {
					System.out.println("���� �¸� : �÷��̾� �¸�");
					
				} else if (�÷��̾�¸��� < ��ǻ�ͽ¸���) {
					System.out.println("���� �¸� : ��ǻ�� �¸�");
				} else {
					System.out.println("���� �¸� : ���º�");
					break;
				}
			} else if (�÷��̾�>=0 || �÷��̾� <3) {
				System.out.println("�÷��̾ �� �� : " + �÷��̾� );
				
				Random random = new Random(); //���� ��ü ����
				
				//random.nexInt(); int�� ǥ���� �� �ִ� ���� ������ ���� ����
				//random.nextInt(��); 0~�� ������ ������ ���� ����
					///random.nextInt(10); 0���� 9���� �� ���� ����
					//random.nextInt(11)+10; 10~20�� ���� �߻�
				
				��ǻ�� = random.nextInt(3); //������ ����int�� ��������
				System.out.println("��ǻ�Ͱ� �� �� : " + ��ǻ��);
				//�¸��� �Ǵ�
				if ( (�÷��̾� == 0 && ��ǻ�� ==2) || (�÷��̾� == 1 && ��ǻ�� == 0 ) || (�÷��̾� == 2 && ��ǻ��==1)) {
					System.out.println("�÷��̾� �¸�");
					�÷��̾�¸���++;
					
				} else if ((�÷��̾� == 0 && ��ǻ�� ==0) || (�÷��̾� == 1 && ��ǻ�� == 1 ) || (�÷��̾� == 2 && ��ǻ��==2)) {
					System.out.println("���º�");
				} else {
					System.out.println("��ǻ�ͽ¸�");
					��ǻ�ͽ¸���++;
				}
				���Ӽ�++;
			} else {
				System.err.println("�� �� ���� �ൿ�Դϴ�.");
			}
			
			
		}//while end
		
		
		
		scanner.close(); 
	}//me

}//ce
