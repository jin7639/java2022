package Day10;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_7_Ű����ũ {
	//��� : ����
	//Ŭ���� : �Ե����� , ����ŷ
	//�������̽� : Ű����ũ
	//����ó�� : ��ǰ��� ����
	//Ŭ���� , ��� , �������̽� , ����ó�� �߰�
	//�Ե�����	 ����		Ű����ũ, 	 ��ǰ���
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);	//�Է°�ü
		//���� �Է�
		//1.���� �Է°�ü
		ArrayList<��ǰ> ��ǰ����Ʈ = new ArrayList<>();
		
		try {//try �ȿ� ���� �߻��� �� ���� �ڵ� �ֱ� (����)
			FileInputStream inputStream = new FileInputStream("D:/java/�Ե��������.txt");
			//2.���� �о���� [ ����-->��Ʈ��(����Ʈ��) --->�ڹ�]
			//1.����Ʈ�迭 ����
			byte[]bytes = new byte[1024];	// 8bit - 1024bite -kb - mb -gb
			//2.�о�ͼ� �迭�� ����
			inputStream.read(bytes);
			//3. [, : �ʵ屸�� \n : ��ü(��ǰ)����
			String ���ϳ��� = new String(bytes); //����Ʈ�� -> ���ڿ�
			//string ���� �޼ҵ� 	split("����");
			String[] ��ǰ��� = ���ϳ���.split("\n");
			
			for(String temp : ��ǰ���) {
				String [] �ʵ��� = temp.split(",");
				��ǰ ��ǰ = new ��ǰ(�ʵ���[0] , Integer.parseInt(�ʵ���[1])  , Integer.parseInt(�ʵ���[2]));
							//���ڿ� --> ������ ��ȯ [ Integer.parseInt("���ڿ�")]
				//����Ʈ ����
				��ǰ����Ʈ.add(��ǰ);
				
			} 
		}catch (Exception e) {//catch : ���� ��� -> ExceptionŬ������ ��ü�� ����
			
		}
		//���ְ� ���缮�� �Ե����� Ű����ũ ��ü ����
		Ű����ũ �Ե����� = new �Ե����� ("���缮", ��ǰ����Ʈ);
		
		while(true) {
			�Ե�����.��ǰ���();
			int ch = scanner.nextInt();
			if (ch == 1 ) {
				�Ե�����.��ǰ�߰�();
			}else {
			}
			
		}
		
	}//me
	
}//ce
