package Day03;

import java.util.Scanner;

public class Day03_4 {//cs
	
	public static void main(String[] args) {//ms
		
//		��� : 1. if�� 2. switch��
//			if : ���˻�( true Ȥ�� false)	/����� ���� ���������� ���� ��� ���
//				>= <= < > == !=
//			switch : �����Ͱ˻�				/����� ���� ������ �ִ� ��� ���
//				������ case�̸� ���๮ ó�� �� -> ���� case�� �̵�
//				����
//					switch(�˻���) {
//						case '��' : ���๮; 
//						case '��' : ���๮; 
//						case '��' : ���๮; 
//						default : ���๮;
//					}
//				break; : ���� ����� �ݺ��� Ż��
		//����1 : ������ 90�� �̸� A, 80�̸� B, 70�̸� C, �׿ܴ� Ż��
		int ���� = 80;
		if (���� == 90) System.out.println("A");
		else if (���� == 80) System.out.println("B");
		else if (���� == 70) System.out.println("C");
		else System.out.println("Ż��");
		
		switch (����) {
		case 90 : System.out.println("A"); break;
		case 80 : System.out.println("B"); break;
		case 70 : System.out.println("C"); break;
		default : System.out.println("Ż��"); break;
		}
		
		
		//����2
		int ��ư = 3;
		switch (��ư) {
		case 1: System.out.println("1������ �̵�");	break;
		case 2: System.out.println("2������ �̵�");	break;
		case 3: System.out.println("3������ �̵�");	break;
		case 4: System.out.println("4������ �̵�");	break;
		default:System.out.println("����");	break;
		}
		
		//����3
		char ��� = 'B';
		switch (���){
		case 'A' : 
		case 'B' : System.out.println("���ȸ��"); break;
		case 'C' : 
		case 'D' : System.out.println("�Ϲ�ȸ��"); break;
		default:System.out.println("�մ�"); break;
		}
		
		//����4
		String ���� = "����";
		switch (����) {
		case "����":System.out.println("700����");	break;
		case "����":System.out.println("500����");	break;

		default: System.out.println("300����");
			break;
		}
		
		//����1 : �� �� �� ������ �Է¹޾� ����� 90�̻��̸� A,80�̻��̸� B, ������ Ż�� [switch]
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� : "); int ���� = scanner.nextInt();
		System.out.println("���� : "); int ���� = scanner.nextInt();
		System.out.println("���� : "); int ���� = scanner.nextInt();
		 
		int ��� = (���� + ���� + ����)/3;
		
		switch (���/10) { //��� ���� ���� �ڸ� ���ϱ�
			case 9 : System.out.println("A"); break;
			case 8 : System.out.println("B"); break;
			default: System.out.println("Ż��"); break;
		}
		
		 scanner.close(); 
		
		
		
		
		
		
		
		
	}//me
	

}//ce
