package Day13;

import java.util.Random;

public class Day13_1 {//cs
	
	public static void main(String[] args) {//ms
		
		//p.534 :Math Ŭ���� (java.lang ��Ű��) [���� ���� �޼ҵ� ����] ��ü���� ��밡��
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("���밪 : " + v1);
		System.out.println("���밪 : " + v2);
		
		System.out.println("�ø��� : " + Math.ceil(5.3));	//�Ҽ��� ù° �ڸ����� �ø�
		System.out.println("�ø��� : " + Math.ceil(-5.3)); 	//����� ������ �ø�
		
		System.out.println("������ : " + Math.floor(5.3));
		System.out.println("������ : " + Math.floor(-5.3));
		
		System.out.println("�ִ� : " + Math.max(5, 9));
		System.out.println("�ִ� : " + Math.max(5.3, 2.5));

		System.out.println("�ּڰ� : " + Math.min(5, 9));
		System.out.println("�ּڰ� : " + Math.min(5.3, 2.5));
		
		System.out.println("���� : " + Math.random()); //0~1���� ����;
		//vs
		Random random = new Random();
		System.out.println("����� ������ �Ǽ��� ; " +  Math.rint(5.3));
		System.out.println("����� ������ �Ǽ��� ; " +  Math.rint(5.7));
		
		//
		System.out.println("����� ������ ������ : " + Math.round(5.3));
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								
		//
		
		
		//10. �ֻ���
		System.out.println("0~1 ������ �Ǽ��� : " + Math.random()); //0~1
		System.out.println(Math.random()*6); //0~6
		System.out.println(Math.random()*6 + 1); //0~6 +1 ->1~7
		int num = (int)(Math.random()*6)+1;
				//(�⺻�ڷ���) ��/���� = ��������ȯ(ū����->�������� :������ �ս�)
				//double ->int ��������ȯ�� -> �Ҽ��� �߸�
		System.out.println("1~6 ������ ���� : " + num);
		///////////////////////////////////////
		System.out.println(("1~6������ ���� : "+random.nextInt(6)+1) );
		
		
		
		
		
	}//me
}//ce
