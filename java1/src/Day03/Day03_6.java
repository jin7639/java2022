package Day03;

import java.util.Scanner;

public class Day03_6 {//cs

	public static void main(String[] args) {//ms
		Scanner scanner = new Scanner(System.in);
		
		//����1 : �Է¹��� �� ��ŭ * ���
//		System.out.println("����1) ������ : ");	int s1 = scanner.nextInt();
//		for(int i = 1; i<=s1; i++) {
//			System.out.print("*");
//		}
//		System.out.println();
		
		//����2
//		System.out.println("����2) ������ : ");	int s2 = scanner.nextInt();
//		for ( int i =1 ; i<=s2; i++) {
//			System.out.print("*");
//			if(i%5 == 0) System.out.println();
//		}
		
		//����3
//		System.out.println("����3) �� �� : ");	int line3 = scanner.nextInt();
//		for ( int i = 1; i <= line3; i++) {
//			// i�� 1���� �Է¹��� �� �� ���� 1�� ����
//			
//			//1. �����
//			for (int s = 1 ; s<=i ; s++) {
//				System.out.print("*");
//			}
//			//2. �ٹٲ� ó��
//			System.out.println();
//		}
		//������
			//����ڰ� 3�� �Է�
			//i = 1 	i <= 3 [true]
				//s = 1	s <= 1 [true] -> * -> s++
				//s = 2 s <= 1 [false] ->�ݺ��� ����
			//�ٹٲ�
			//i=2 i<=3 [true]	
				//s = 1 s<=2 [true] -> * -> s++
				//s = 2 s<=2 [true] -> * -> s++
				//s = 3 s<=2 [false] -> �ݺ��� ����
			//�ٹٲ�
			// i = 3 	i <= 3 [true]
				//s = 1 s<=3 [true] -> * -> s++
				//s = 2 s<=3 [true] -> * -> s++
				//s = 3 s<=3 [true] -> * -> s++
				//s = 4 s<=3 [false] -> �ݺ��� ����
			//�ٹٲ�
			//i = 4 	i <=3 [false] for1 �ݺ��� ����
		
		//����4
		
//		System.out.println("����4) �� �� : ");		int line4 = scanner.nextInt();
//		
//		for( int i = 1; i <= line4; i++) {
//			
//			for (int s = 1; s <= line4-i+1; s++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
//		
//		
//		//����5
//		
//		System.out.println("����5) �� �� : ");		int line5 = scanner.nextInt();
//		// ���� b�� �Է¹�����-�����ټ� ���� 1������->�������
//		for ( int i = 1; i <= line5; i++) {
//			//1. �������
//			for (int b = 1; b<=line5-i; b++) {
//				System.out.print(" ");
//			}
//			//2. �����
//			for (int s = 1 ; s<=i ; s++) {
//				System.out.print("*");
//			}
//			
//			//3. �ٹٲ� ó��
//			System.out.println();
//		} 
		
		
		//����6
		
//		i = 1	b = 0			s = 1 2 3 4 5
//		i = 2	b = 1			s = 1 2 3 4
//		i = 3	b = 1 2			s = 1 2 3
//		i = 4	b = 1 2 3		s = 1 2
//		i = 5	b = 1 2 3 4		s = 1
//		b�� 1���� ���� �� �� -1 ���� 1�� ���� ���� ���
//		s�� 1���� �Է¹��� �� - ���� �� ��+1 ����
//		System.out.println("����6) �� �� : ");		int line6 = scanner.nextInt();
//		
//		for( int i = 1; i <= line6; i++) {
//			
//			for (int b = 1; b<=i-1 ; b++) {
//				System.out.print(" ");
//			}
//			
//			for (int s = 1 ; s <= line6 - i + 1 ; s++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
//		
//		
//		//����7
//		
//		System.out.println("����7) �� �� : ");		int line7 = scanner.nextInt();
//		// ���� b�� �Է¹�����-�����ټ� ���� 1������->�������
//		for ( int i = 1; i <= line7; i++) {
//			//1. �������
//			for (int b = 1; b<=line7-i; b++) {
//				System.out.print(" ");
//			}
//			//2. �����
//			for (int s = 1 ; s<=i+i-1 ; s++) {
//				System.out.print("*");
//			}
//			
//			//3. �ٹٲ� ó��
//			System.out.println();
//		} 
//		
//		//����8
//		System.out.println("����8) �� �� : ");		int line8 = scanner.nextInt();
//		// ���� b�� �Է¹�����-�����ټ� ���� 1������->�������
//		for ( int i = 1; i <= line8; i++) {
//			//1. �������
//			for (int b = 1; b<=line8-i; b++) {
//				System.out.print(" ");
//			}
//			//2. �����
//			for (int s = 1 ; s<=i+i-1 ; s++) {
//				System.out.print(i);
//			}
//			
//			//3. �ٹٲ� ó��
//			System.out.println();
//		} 
//		
		//����9
		System.out.println("����9) �� �� : ");		int line9 = scanner.nextInt();
		// ���� b�� �Է¹�����-�����ټ� ���� 1������->�������
		for ( int i = 1; i <= line9; i++) {
			//1. �������
			for (int b = 1; b<=i; b++) {
				System.out.print(" ");
			}
			//2. �����
			for (int s = 1 ; s<=line9+i ; s++) {
				System.out.print("*");
			}
			
			//3. �ٹٲ� ó��
			System.out.println();
		} 
		
		

		
		
		
		 scanner.close(); 
	}//me
	
}//ce
