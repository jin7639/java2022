package Day05;

import java.util.Scanner;

public class Day05_3 {//cs
	
	public static void main(String[] args) {//ms
		
//		//182p 7)����������...
//		
//		//8)
//		int[][] array = {
//				{95, 86},
//				{83, 92, 96},
//				{78, 83, 93, 87, 88}
//		};
//		
//		int sum = 0 ;
//		double avg = 0.0;
//		
//		int count = 0; //������ ����
//		
//		//Ǯ��
//		//2���� �迭 �� ��� ������ ȣ��
//		for (int i = 0; i < array.length; i++) {
//			//i = ��. ���� 0���� �迭�� �����[3]�̸����� 1������
//			for (int j = 0; j < array[i].length; j++) {
//				//j = ��. ���� 0���� �迭�� ������[2,3,5]���� 1�� ����
//				sum += array[i][j]; //�����հ�
//			}
//			count += array[i].length; //������ �����հ褤
//		}
//		
//		avg = (double)sum / count ;
//		
//		System.out.println("sum : " + sum);
//		System.out.println("avg : " + avg);
		
		//9)
		
		boolean run = true; //while�� ����ġ ����
		int studentNum = 0; //�л��� ����
		int[] scores = null; //���� �迭
		Scanner scanner = new Scanner(System.in);
		
		while(run) {//���ѷ��� [�������� : 5�� ����]
			System.out.println("------------------------------------");
			System.out.println("1.�л��� 2.�����Է� 3.��������Ʈ 4.�м� 5.����");
			System.out.println("------------------------------------");
			System.out.println("���� : ");
			
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				System.out.println("�л���>"); studentNum = scanner.nextInt();
				//�Է¹��� �л��� ��ŭ �迭���� ����
				scores = new int[studentNum];
			} else if (selectNo == 2) {//�л� ���� �Է¹ޱ�
				for (int i = 0; i < scores.length; i++) {
					System.out.printf(" scores[%d] : " , i ); 
					scores[i] = scanner.nextInt();
				}
			} else if (selectNo == 3) {//�л� ���� ����ϱ�
				for (int i = 0; i < scores.length; i++) {
				System.out.printf("score[%d] : %d \n", i, scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				int sum = 0 ;
				double avg = 0.0;
				
				int count = 0; //������ ����
				
				for (int i = 0; i < scores.length; i++) {
					//�ְ����� ���ϱ�
					if ( max < scores[i]) {
						max = scores[i];
					//�����հ�
						sum += scores[i];
					}
					//������� ���ϱ�
					avg = (double)sum / scores.length;
				}
				
				avg = (double)sum / count ;
				System.out.println("�� �հ� : " + max);
				System.out.println("�ְ� ���� : " + max);
				System.out.println("��� ���� : " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
			
			
			
		}
		
		
		
		
	}//me
	

}//ce
