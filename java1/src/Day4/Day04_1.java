package Day4;

import java.util.Scanner;

public class Day04_1 {//cs

	public static void main(String[] args) {//ms
		
		// ��� : if ,  switch
		// �ݺ��� : for , while
			//1.�ʱⰪ 2.���ǽ� 3.������ 4.���๮
		
		//for ��1)
		for (int i = 1; i<=10; i++) {
			// i�� 1���� 10���� ���� 1�� �����ϸ鼭 ���๮ �ݺ�ó�� -> 10�� ����
			System.out.print(i + " ");
		}
		System.out.println();
		
//		for ��2) 1~100 �����հ�
		int sum = 0;
		for (int j = 1; j<=100; j++) {
			sum += j; //sum = sum + j
		}
		System.out.println("for 1 ~ 100 ������ : "+ sum);
		//while ����
//			�ʱⰪ;
//			while( ���ǽ� ) {
//				���๮;
//				������;
//			}
		
		//while ��1)
		int i = 1; //�ʱⰪ
		while (i <= 10) { //���ǽ� [true�̸� ����, �ƴϸ� ���� X ]
			System.out.print(i + " "); //���๮
			i++; //������ :������ ���ѷ���
		}
		System.out.println();
		
		//while ��2)
		int j = 1;
		int sum2 = 0;
		while (j <= 100) {
			sum2 += j;
			j++;
		}// while end : j �� 101�϶� ����
		System.out.println("while 1 ~ 100 ������ : " + sum2);
		
		//while ��3) ���ѷ���
		while (true) {// ���ǽ��� true ���� // true ��� -> ���ѷ���
			System.out.println("���ѷ���");
			Scanner scanner = new Scanner(System.in);
			int exit = scanner.nextInt();
			if(exit == 3)
				break; //���� ����� �ݺ��� Ż�� [ if ���� ]
			scanner.close(); 
		}
		
		
	
		
		
	}//me
	
}//ce
