package Day01;

import java.util.Scanner;

public class Day01_6 {//ms

	public static void main(String[] args) {//ms
		
		//����2 : �ϳ��� �湮��
		
		//1. �Է°�ü ����
		Scanner scanner = new Scanner(System.in);
		
		//2. �Է��� ��� �ȳ�
		System.out.println("���� : ");
		System.out.println("�ۼ��� : ");
		System.out.println("���� : ");
		System.out.println("��¥ : ");
		
		//3. �Է¹��� ������ �ٸ� ���� ����
		String num = scanner.next();
		String name = scanner.next();
		String comments = scanner.next();
		String date = scanner.next();
		
		//4.���
		System.out.println("----------����----------");
		System.out.println("|����|�ۼ���|����    |��¥  |");
		System.out.println("|"+ num +"  |" + name +"|"+ comments +"|"+ date +"|" );
		
		
		
	}//me
	
	
}//me
