package Day01;

import java.util.Scanner;

public class Day01_5 {//cs

	public static void main(String[] args) {//ms
		
		// �Է� -> ���� -> ���
		// 1. �Է°�ü ����
		Scanner scanner = new Scanner(System.in);
		
		//2. �Է��� ��� �ȳ�
		System.out.println(" ���̵� : ");
		System.out.println(" ��й�ȣ : ");
		System.out.println(" ���� : ");
		System.out.println(" �̸��� : ");
		
		//3. �Է¹��� ������ �ٸ� ���� ����
		String id = scanner.next();
		String pw = scanner.next();
		String name = scanner.next();
		String email = scanner.next();
		
		//4. ���
		System.out.println(">>>>>ȸ������ �Ϸ� �Ʒ� ������ Ȯ�����ּ���<<<<<<");
		System.out.println("���̵�\t��й�ȣ\t����\t�̸���");
		System.out.println(id + "\t" + pw + "\t" + name + "\t" + email);
		
	}//me
	
	
	
}//ce
