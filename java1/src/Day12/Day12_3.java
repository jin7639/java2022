package Day12;

import java.io.IOException;
import java.util.Iterator;

public class Day12_3 {

	public static void main(String[] args) throws IOException {
		
		// ���� �˻� ���α׷�
					// [����]
					// 1. �Է¹ޱ� [ System.in.read() ]
					// 2. String �迭�� ���� ������ ���� 
						//		String[] ������� = {	
						//			"�ȴ�! ���̹� ��α�&����Ʈ",
						//			"������ ��Ʈ ���� Ȱ�� ������",
						//			"Tucker�� Go ��� ���α׷���",
						//			"ȥ�� �����ϴ� C ���"
						//};
					// 3. �˻���� , ������� 
						// �˻���� : Ư�� ���ڸ� �Է¹޾� ������ ���Ե� ���ڰ� ������ ��� ��� 
							// '���' �˻� ->  "Tucker�� Go ��� ���α׷���" / "ȥ�� �����ϴ� C ���"
						// ������� : ������ �������� �Ϻθ� �Է¹޾� ��µ� �������� ��ȣ�� ���� 
							// '����' ���� -> ���õ� �������� ������ ���ڿ� ���ο� ���� �Է¹޾� ->  ���� �Ϸ� 
		
		String[] books = {"�ȴ�! ���̹� ��α�&����Ʈ", "������ ��Ʈ ���� Ȱ�� ������" , "Tucker�� Go��� ���α׷���", "ȥ�� �����ϴ� C ���"};
		
		while(true) {
		System.out.println("1.���� �˻� 2.���� ����");
		byte[]bytes = new byte[100];
		//Ű����� ���� [��Ʈ��]����Ʈ�� �о���� // �Ϲݿ���!!
		int count = System.in.read(bytes); 	//����Ʈ�迭 -->���ڿ� ��ȯ [-2���� =\n\r]
		String ch = new String(bytes , 0 , count-2);
		
		if (ch.equals("1")) {
			System.out.println("*** �˻� ***");
			System.out.println("�˻� : ");
			count = System.in.read(bytes); 
			String search = new String (bytes , 0 , count-2);
			for(String temp : books) {
				if (temp.indexOf(search) != -1) {//�ε������� ���� ���̳ʽ����� ������ �ܾ� ���ٴ� ��
					System.out.println(temp);
					
				}
			}
			
//			//���2
//			if (temp.contains(search)) {//���ڿ�.contains("ã������")
//				System.out.println(temp);
//			}
			
			
		}else if(ch.equals("2")) {
			System.out.println("*** ���� ***");
			System.out.println("������ ���� �˻� : ");
			count = System.in.read(bytes);
			String search = new String(bytes, 0 , count-2);
			int i = 0;  
			for (String temp : books ) {
				if (temp.contains(search)) {
					System.out.println("������ȣ : "+i+"�� | ����� : "+ temp);
				}
				i++;
			}
			//������ȣ [�ε���] �Է¹޾� �����ϱ�
			System.out.println("������ȣ ���� : ");
			count = System.in.read(bytes);
			String ch2 = new String (bytes, 0 ,count -2);
			int index = Integer.parseInt(ch2);
			
			System.out.println("���� ���� : ");
				count = System.in.read(bytes);
				String oldstr = new String (bytes, 0 , count-2);
			System.out.println("���ο� ���� : ");
				count = System.in.read(bytes);
				String newstr = new String (bytes, 0 , count-2);

			books[index] = books[index].replace(oldstr, newstr);
			System.out.println("����Ǿ����ϴ�.");
		
		}else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		}//while end
	}//me
}//ce
