package Day12;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class day12_1 {

	public static void main(String[] args) throws IOException {
		//496p
			//String ���ڿ� Ŭ����
				//1. java.lang ��Ű�� [import]�Ҽ�
				//2. ��ü�ε� �ڵ� ���ͷ� [��ü�� �ڵ�����]
		String ����1 = new String("���缮");
		String ����2 = "���缮";
				//3. 13���� ������[���ڿ�, ����Ʈ�� �� ]
				//4. �ܺ�[����,��Ʈ��ũ ��]�� ���� ���� �����ʹ� ���� ����Ʈ��
		
		//����Ʈ -> ���� ��ȯ ���� ����
			//����Ʈ �ڵ� : +-127ǥ�� ����
			//�ƽ�Ű�ڵ� : 0/1 ���յ� 7�ڸ�
			//�����ڵ� 
		
		
		
		
		//497p
		//	1.������ ����Ʈ�� ���� �� �� �ִ� ����Ʈ �迭 ����
		byte[] bytes = {72, 101,108, 108, 111 };
					//  H	e	l 	   l	o	
		//2.����Ʈ �迭 ->���ڿ� ��ȯ [new String(�迭��)]
		String str1 = new String(bytes); //String ����Ʈ -> �ƽ�Ű �ڵ� ��ȯ
		
		//3.Ȯ��
		System.out.println(str1);
		
		//4.Ư�� ��ġ���� ��ȯ		[new String (�迭��, �����ε���, ����)]
		String str2 = new String (bytes , 6 , 4);
		
		//5.Ȯ��
		System.out.println("����Ʈ �迭�� 6���ε��� ���� 4�� ��ȯ"+ str2);
		
		//p.498
			//System.out : �ý��� Ŭ���� �� ����ʵ�
			//System.In : �ý��� Ŭ���� �� �Է��ʵ�
		byte[] bytes2 = new byte[100];
		
		System.out.println("�Է� : "); 	//����ʵ峻 print �޼ҵ� ȣ��
		
		int readByteNo = System.in.read(bytes2);
		//�ܺ���� : �ڹ����α׷� ��[ Ű���� , ����, ��Ʈ��ũ ��] ����� �Ϲ� ����
		//Ű���� �Է� ---��Ʈ��[���:����Ʈ]----> ��ǻ��
		//a ->97		// a ���� - >97 13[\n:�ٹٲ�], 10[\r:Ŀ���� ������] 	
		String str = new String(bytes2);
		System.out.println("�Է¹��� ����Ʈ -> ���ڿ� ��ȯ : "+ Arrays.toString(bytes2));
		
		String str = new String (bytes2, 0 , readByteNo-2);
											//���� ����Ʈ �� -1
											// \n, \r
		System.out.println("�Է¹��� ����Ʈ -> ���ڿ� ��ȯ : " + str);
		//Scanner Ŭ���� [System.in ���κ��� �Է¹��� ����Ʈ�� ��ü�� ���� ]
		Scanner scanner = new Scanner(System.in);
		//Scanner Ŭ���� �޼ҵ�
		scanner.next(); //����Ʈ ->���ڿ� ��ȯ
		scanner.nextInt(); //����Ʈ -> ������ ��ȯ
		scanner.nextDouble(); //����Ʈ -> �Ǽ��� ��ȯ
		
		
		
		
	}//me
	
	
}//ce
