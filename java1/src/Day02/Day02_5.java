package Day02;

import java.util.Scanner;

public class Day02_5 {//cs
	
	public static void main(String[] args) {//ms
		Scanner scanner = new Scanner(System.in);
	
//		//����2 : ���� ����
//		
//		//�Է����� : �ݾ�
//	System.out.println("�ݾ� : "); 	int �ݾ� = scanner.nextInt();
//	
//		//���� : �ʸ��� ���� ��������� ���� ����
//	int �ʸ��� = �ݾ�/100000;
//	int ���� = (�ݾ� - �ʸ���*100000)/10000;
//	int õ�� = (�ݾ� - �ʸ���*100000 - ����*10000)/1000;
//	int ��� = (�ݾ� - �ʸ���*100000 - ����*10000 - õ��*1000)/100;
//
//		//������� :
//	System.out.println("�ʸ��� : " + �ʸ��� + " ��");
//	System.out.println("���� : " + ���� + " ��");
//	System.out.println("õ�� : " + õ�� + " ��");
//	System.out.println("��� : " + ��� + " ��");
//		
//	System.out.println("�ʸ��� : " + (�ݾ�/100000) + " ��");
//	
//	//�ݾ� = �ݾ�- (�ݾ�/100000)*100000;
//	�ݾ� -= (�ݾ�/100000)*100000;
//	System.out.println("���� : "+ (�ݾ�/10000)+ "��");
//	
//	�ݾ� -= (�ݾ�/10000)*10000;
//	System.out.println("õ�� : "+ (�ݾ�/1000)+ "��");
//	
//		
//	//����3
//		//������ �Է¹ޱ�
//	System.out.println("����3) ���� �Է� : "); int num1 = scanner.nextInt();
//		//������ 7�� ������� �Ǵ�
//			//��� ã��
//				// �� % �� ������ �������� 0 �̸� ���� �� ���� ���
//	//String ���7 = num1%7 == 0 ? "7�� ���" : "7�� ��� �ƴ�";
//		//���
//	System.out.println("7�� ��� Ȯ�� " + (num1%7==0));
//	
//
//	//���� 4
//		//Ȧ¦ ã��
//			//Ȧ�� : �� %2 ���� �� �������� 1
//			//¦�� : �� %2 ���� �� �������� 0
//	
//	System.out.println("����4) ���� �Է� : ");
//	int ����4 = scanner.nextInt();
//	System.out.println("�Է��� ���� Ȧ�� �Ǵ� : " + (����4%2==1));
//		
//	//����5
//	
//	System.out.println("����5) ���� �Է� : ");
//	int ����5 = scanner.nextInt();
//	System.out.println("7�� ����̸鼭 ¦������ Ȯ�� : " + (����5%7==0 && ����5%2==0) );
//	
//	
//	//����6 : �ΰ��� ������ �Է¹޾� �� ū�� ���  [ true , false ]
//	System.out.println("����6) ����1 �Է�");		int ����6_1 = scanner.nextInt();
//	System.out.println("����6) ����2 �Է�");		int ����6_2 = scanner.nextInt();
//	int ū�� = ����6_1 > ����6_2 ? ����6_1 : ����6_2 ;
//	System.out.println("�� ū ���� " + ū��);
//		
//	//����7 : �������� �Է¹޾� �� ���� ����ϱ�
//	
//	System.out.println("����7) ������ �Է�"); 	int ����7 = scanner.nextInt();
//	System.out.println("���� ���� : " + ����7*����7*3.14);
//	
//	//����8 :�� �Ǽ��� �Է¹޾� �� �Ǽ��� ���� ���� ���� �� %���� ����ϱ�
//	
//	System.out.println("����8)�Ǽ�1 �Է� : ");	double ����8_1 = scanner.nextDouble();
//	System.out.println("����8)�Ǽ�2 �Է� : "); 	double ����8_2 = scanner.nextDouble();
//	double ���� = ( ����8_1/����8_2)*100;
//	System.out.printf("���� : %.2f %%\n", ����);
//		// %f �Ǽ�ǥ��
//			//%.����f			//%.2f : �Ҽ� 2�ڸ� ���� ǥ��
//	
//	//����9 : ��ٸ��� ���� ���ϱ�[������ �غ� ���̸� �Է¹޾� ����ϱ�]
//		//��ٸ��� ���� = > (���� * �غ�) * ���� / 2
//	
//	System.out.println("����9) ���� : "); int ���� = scanner.nextInt();
//	System.out.println("����9) �غ� : "); int �غ� = scanner.nextInt();
//	System.out.println("����9) ���� : "); int ���� = scanner.nextInt();
//	
//	System.out.println("��ٸ��� ���̴� : " + (���� * �غ�)*����/2);
//	
//	//����10: Ű�� ������ �Է¹޾� ǥ��ü�� ����ϱ�
//		//ǥ��ü�� ���� = > (Ű - 100) * 0.9
//	System.out.println("����10) Ű �Է� : "); int ����10 = scanner.nextInt();
//	System.out.println("����10) ǥ��ü�� : "+ (����10 - 100) * 0.9);
//	
//	//����11 : Ű�� �����Ը� �Է¹޾� BMI ����ϱ�
//		//BMI ���� = > ������ / ((Ű / 100) * (Ű / 100))
//	System.out.println("����11) Ű �Է� : "); int Ű = scanner.nextInt();
//	System.out.println("����11) ������ �Է� : "); int ������ = scanner.nextInt();
//	System.out.println("BMI : " + (������ / ((Ű / 100.0) * (Ű / 100.0)));
//	
//	//����12: inch �� �Է¹޾� cm �� ��ȯ�ϱ� [ 1 inch -> 2.54cm ] 
//	System.out.println("����12) inch �Է� : "); int inch = scanner.nextInt();
//	
//	System.out.println(inch*2.54 + " cm");
//	
//	//����13:  �߰����, �⸻���, �����򰡸� �Է¹޾� �ݿ������� ����ϱ�
//			//�Ҽ� ��° �ڸ� ���� ���� ����ϱ�
//			//�߰���� �ݿ����� => 30 %
//			//�⸻��� �ݿ����� => 30 %
//			//������ �ݿ����� => 40 %
//	System.out.println("����13) �߰���� ���� : "); double �߰� = scanner.nextInt();
//	System.out.println("����13) �⸻��� ���� : "); double �⸻ = scanner.nextInt();
//	System.out.println("����13) ������ ���� : "); double ���� = scanner.nextInt();
//	
//	//System.out.println("���� : " + (�߰�*0.3 + �⸻*0.3 + ����*0.4) + " ��");
//	�߰� *= 0.3;
//	�⸻ *= 0.3;
//	���� *= 0.4;
//	System.out.println("���� : " + (�߰�+�⸻+����));
//	
//	
//	
//	//����14 :  ���� ���� ���� �ϰ� x�� y�� �����ϱ�
//		int x = 10;
//		int y = x-- + 5 + --x;
//		System.out.printf(" x�� �� : %d , y�ǰ� :  %d ", x, y);
//			// 1. x-- + 5 -> ���� ���� ���� + => 10+5
//			// 2. x-- -> x���� [x=9]
//			// 3. 15 + --x => [x=8]
//			// 4. 5 + 8 => y = 23
	
	//����15 : ���̸� �Է¹޾� ���̰� 10���̻��̸� �л� , 20���̻��̸� ���� , 40���̻��̸� �߳� ���� ����ϱ�
	System.out.println("���� : "); int ���� = scanner.nextInt();
	String ���ɴ� = ���� >=40 ? "�߳�" : ���� >=20 ? "����" : "�л�";
	
	System.out.println(���ɴ�);
	
	//����16 : 3���� ������ �Է¹޾� ������������ ���� 
	System.out.println("����16) ����1�Է�");		int ����1 = scanner.nextInt();
	System.out.println("����16) ����2�Է�");		int ����2 = scanner.nextInt();
	System.out.println("����16) ����3�Է�");		int ����3 = scanner.nextInt();
	

	
	//����17 : 4���� ������ �Է¹޾� ������������ ���� 
	
	
	// p. 102 Ȯ�ι���
		
		
	}//me
	
}//ce
