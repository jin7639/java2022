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
		Scanner scanner = new Scanner(System.in);//�Է°�ü
		String[] carlist = new String[10]; //���ڿ� 10�� ������ �� �ִ� �迭 [������ȣ �ִ� 10�� ���� ����]
		String[] evenlist = new String[10];//¦������ �迭
		String[] oddlist = new String[10];//Ȧ������ �迭
		while(true) {//���ѷ���
			
			//��� ���� ���
			System.out.println("***�������� ��� ������ȣ ***");
			for(String temp : carlist) {
				if (temp != null) {
					if (Integer.parseInt(temp) % 2 == 0) {
						System.out.println(temp+"[¦] ");
					}else {	
						System.out.println(temp + "[Ȧ] ");
					}
				}
			}
			//¦������ ���
			System.out.println("�������� ¦������");
			for( String temp : evenlist) {
				if (temp != null) {
					System.out.println(temp + " ");
				}
			}
			
			//Ȧ������ ���
			System.out.println("�������� Ȧ������");
			for( String temp : oddlist) {
				if (temp != null) {
					System.out.println(temp + " ");
				}
			}
			
			//���� ��ȣ �ο�
			System.out.println("1.��������");
			int ch = scanner.nextInt();
			if (ch == 1) {
				//������ȣ ���� ����
				Random random = new Random();	//������ü
				int intnum = random.nextInt(10000);
				String carnum = String.format("%04d", intnum);
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
				//¦�� Ȧ�� ���� �й�
				if (save == true) {
					//¦�� Ȧ�� ���� �й�
					if (Integer.parseInt(carnum) % 2 == 0 ) {
						//¦�������迭�� ����
						for (int i = 0; i < evenlist.length; i++) {
							if (evenlist[i] == null) {
								evenlist[i] = carnum;
								break;
							}
						}
					}else {
						for (int i = 0; i < oddlist.length; i++) {
							if( oddlist[i] == null ) { 
								oddlist[i] = carnum; break; 
							}
						}
					}
				}
				
				
				
				
				if (save == false) {
					System.out.println("����");
				}
			}
		}
		
	}//me
	
}//ce
