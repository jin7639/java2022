package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4 {

	//������ȣ ���� ���α׷�
	//����
		//1.���� 0000~9999 ���� ���� 10�� �����ؼ� �迭�� ����
		//2.��� ���� ��ȣ�� �迭�� ����
		//3.���ڸ� ��ȣ�� Ȧ/¦ ����
		//4.���� ����ȣ�� Ȧ���� ���� ���
		//4.���� ����ȣ�� ¦���� ���� ���
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] carlist = new String[10];
		while(true) {
			
			//��� ���� ���
			for(String temp : carlist) {
				if (temp != null) {
					System.out.println(temp+" ");
				}
			}
			//¦������ ���
			System.out.println("¦������");
			for (int i = 0; i <carlist.length; i++) {
				if (carlist[i] != null && Integer.parseInt(carlist[i]) % 2 == 0) {
					System.out.println(carlist[i]);
				}
			}
			
			System.out.println("Ȧ������");
			//Ȧ������ ���
			for (int i = 0; i <carlist.length; i++) {
				if (carlist[i] != null && Integer.parseInt(carlist[i]) % 2 == 1) {
					System.out.println(carlist[i]);
				}
			}
			
			//���� ��ȣ �ο�
			System.out.println("1.��������");
			int ch = scanner.nextInt();
			if (ch == 1) {
				//������ȣ ���� ����
				Random random = new Random();	//������ü
				int intnum = random.nextInt(10000);
				String carnum = String.format("%4d", intnum);
										//����
											//%d ����
											//%����d : ���ڸ�ŭ �ڸ��� [���� �ش� �ڸ����� ������ ����]
											//%0����d : ���ڸ�ŭ �ڸ��� [���� �ش� �ڸ����� ������ 0�ֱ�]
				boolean save = false;
				for( int i = 0; i<carlist.length; i++) {
					if (carlist[i] == null) {
						carlist[i] = carnum;
						save = true;
						break;
					}
				}
				
				if (save == false) {
					System.out.println("����");
				}
			}
		}
		
	}//me
	
}//ce
