package Day03;

import java.util.Scanner;

public class Day03_2 {//cs
	
	public static void main(String[] args) {//ms
		// �Է°�ü = { } �� 1�� ����
		Scanner scanner = new Scanner(System.in);
		
		//����1 : 2���� ������ �Է¹޾Ƽ� �� ū �� ���
		System.out.println("�����Է� : ");
		int ����1_1 = scanner.nextInt();
			//int�� ���� �����ϰ� �Է¹��� ���� ������ �����ͼ� ����
		System.out.println("����2�Է� : ");
		int ����1_2 = scanner.nextInt();
		
		//����
		if (����1_1 > ����1_2) 		System.out.println("�� ū �� : " + ����1_1);
			//���࿡ �Է¹��� ����1_1 ������ ����1_2���� ũ�� ����. �ƴϸ� ���� ����
		else if (����1_1 < ����1_2 ) 	System.out.println("�� ū �� : " + ����1_2);
			//���࿡ �Է¹��� ����1_2 ������ ����1_1���� ũ�� ����. �ƴϸ� �� ��
		else 						System.out.println("����");
			//������[�� ��] ����
		
		//����2 : 3���� ������ �Է¹޾Ƽ� ���� ū �� ���
		System.out.println("����1 �Է� : ");	int ����2_1 = scanner.nextInt();
		System.out.println("����2 �Է� : ");	int ����2_2 = scanner.nextInt();
		System.out.println("����3 �Է� : ");	int ����2_3 = scanner.nextInt();
		
		int max = ����2_1; //���� ū ���� �ӽ÷� ���� 
			//max�� ù��° �� �־�α�
		if ( max < ����2_2 ) {max = ����2_2;} //���࿡ max ���� ����2_2�� �� ũ�� ��ȯ
		if (max < ����2_3) {max = ����2_3;}	//���࿡ max ���� ����2_3�� �� ũ�� ��ȯ
		
		//����3 : 4���� ������ �Է¹޾Ƽ� ���� ū �� ���
		System.out.println("����1 �Է� : ");	int ����3_1 = scanner.nextInt();
		System.out.println("����2 �Է� : ");	int ����3_2 = scanner.nextInt();
		System.out.println("����3 �Է� : ");	int ����3_3 = scanner.nextInt();
		System.out.println("����4 �Է� : ");	int ����3_4 = scanner.nextInt();
		
		int max2 = ����3_1;
		if ( max2 < ����3_2) { max2 = ����3_2; }
		if ( max2 < ����3_3) { max2 = ����3_3; }
		if ( max2 < ����3_4) { max2 = ����3_4; }
		System.out.println("���� ū �� : " + max2);
		
		//����4 : 3���� ������ �Է¹޾Ƽ� �������� ����
		System.out.println("����1 �Է� : ");	int ����4_1 = scanner.nextInt();
		System.out.println("����2 �Է� : ");	int ����4_2 = scanner.nextInt();
		System.out.println("����3 �Է� : ");	int ����4_3 = scanner.nextInt();
		
		if ( ����4_1 > ����4_2 ) {
			//��ü [���� = �ΰ� ������ ������ ��ȯ���]
			int temp = ����4_1; 		//�ӽú��� = ����1;
			����4_1 = ����4_2;		//����1 = ����2;
			����4_2 = ����4_3;		//����2 = ����3;
		}
		if (����4_1 > ����4_3) { int temp = ����4_1; ����4_1 = ����4_3; ����4_3 = temp;}
		if (����4_2 > ����4_3) { int temp = ����4_2; ����4_2 = ����4_3; ����4_3 = temp;}
		
		System.out.printf("�Է��� �� �������� : %d %d %d " , ����4_1, ����4_2, ����4_3);
		System.out.println("�Է��� �� �������� : " + ����4_1 + ����4_2 + ����4_3);
		
		//���� 5 : 4���� ������ �Է¹޾Ƽ� �������� ����
		System.out.println("����5) ����1 �Է� : ");	int ����5_1 = scanner.nextInt();
		System.out.println("����5) ����2 �Է� : ");	int ����5_2 = scanner.nextInt();
		System.out.println("����5) ����3 �Է� : ");	int ����5_3 = scanner.nextInt();
		System.out.println("����5) ����4 �Է� : ");	int ����5_4 = scanner.nextInt();
		
		//ù ��° �� ����
		if(����5_1 > ����5_2) {
			int temp = ����5_1;	//temp�� ����2���� ŭ
			����5_1 = ����5_2;
			����5_2 = ����5_3;
			����5_3 = ����5_4;
		}
		if(����5_1 > ����5_3 ) {
			int temp = ����5_1; //temp�� ����1, ����1�� ����2�� ����3���� ŭ
			����5_1 = ����5_2;
			����5_2 = ����5_3;
			����5_3 = ����5_4;
		}
		if (����5_1 > ����5_4) {
			int temp = ����5_1; 
			����5_1 = ����5_2;
			����5_2 = ����5_3;
			����5_3 = ����5_4;
		}	
		
		//�ι�° �� ����
		if (����5_2 > ����5_3 ) { int temp = ����5_2; ����5_2 = ����5_3; ����5_3 = temp; }
		if (����5_2 > ����5_4 ) {	int temp = ����5_2; ����5_2 = ����5_3; ����5_3 = temp; }
		
		//����° �� ����
		if (����5_3 > ����5_4 ) {	int temp = ����5_3; ����5_3 = ����5_4; ����5_4 = temp; }
		
		
		
		
		
		
	}//me
	

}//ce
