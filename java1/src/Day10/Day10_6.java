package Day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day10_6 {

	//�ֱ����ġ : �޸� : RAM : ���α׷� ����ÿ��� �����ϴ� �޸� (�ܼ�)
	//���������ġ : C����̺�,USB,CD : (���α׷�) ���� ��������
	//����ó��[ �ڹ� �� �޸𸮸� --> ���������ġ �� �ű� ]
	//DBó��[ �ڹ� �� �޸𸮸� ---> DB ����[PC]�� �ű� ]
		//Stream : ���α׷��� �ܺ�[Ű����,����,��Ʈ��ũ��]���
		//FileOutputStream  :������� Ŭ����
			//��ü��.write(����Ʈ��);
		//FileInputStream : �����Է� Ŭ����	
			//��ü��.read(����Ʈ�迭);
		//String Ŭ����
			//���ڿ�.equals() : ���ڿ� �� �޼ҵ�
			//���ڿ�.getBytes() : ���ڿ� -> ����Ʈ�� ��ȯ
			//new String(����Ʈ�迭) : ����Ʈ�迭 -> ���ڿ� ��ȯ
	
	
	//����
	public static void main(String[] args) throws IOException {
		
		//2.���� ��� [ ���� -> �ڹ� ]
		FileOutputStream ������� = new FileOutputStream("D:/java/java1.txt");
		//FileOutputStream : ��������� Ŭ����
		//FileOutputStream ( ���ϰ��/���ϸ�. Ȯ����); 
		String ���� = "�ڹٿ��� �Էµ� ������";
		�������.write(����.getBytes());	//���� [����]
		
		//1.���� �Է� [ �ڹ� -> ���� ]
		FileInputStream �����Է� = new FileInputStream("D:/java/java1.txt");
		byte[] bytes = new byte [1000];
		�����Է�.read(bytes);
		System.out.println("���ϳ��� : " + new String(bytes));
		
		
		
	}//me
	
	
}//ce
