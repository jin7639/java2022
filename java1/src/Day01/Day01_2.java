package Day01;

public class Day01_2 { // c s
	 /* 1. ���
			1. print() ��¸�
			2. printf() ��¿� �ٹ̱�
				����
					%s ���ڿ� ��ü
					%d ����
					%f �Ǽ�
				�����
					\n �ٹٲ�
					\t �鿩���� tab
			3. printIn() ��� �� �ٹٲ�
			
		1.System : �ý��� Ŭ���� [����� ���� ������� �ڵ� ����]
		2.out : ��� ��Ʈ��
		3.print() : ��� �Լ�
		4. ; : ���� �ڵ� �� �˸�
	// * �ý��� Ŭ���� �� out �̶�� ��� ��Ʈ���� ����
	 *  print �Լ��� ����ؼ� console�� ���ϴ� ��� ����� �� �ִ�.
	 */
	public static void main(String[] args) { //m s
		// �⺻���
		System.out.print("���"); // ; �ڵ� ���� ����
		System.out.print("java_day_01"); // ����ó�� ""
		System.out.print(001); // ���ڴ� "" ó�� X
			//����� ���� ��� ���ڴ�  "" ó��

		//2. �ڵ��ϼ� ( syso + ctrl + �����̽���)
		System.out.println("001");
		System.out.println(001);
		
		//3. �������
		System.out.printf("%s", "���");
		System.out.printf("java %d����", 1);
		
		//����1 [�⼮��]
		System.out.println("\n\t\t[[�⼮��]]");
		System.out.println("----------------------------------------");
		System.out.println("�̸�\t1����\t2����\t3����\t���");
		System.out.println("��ȣ��\t�⼮\t�⼮\t�Ἦ");
		System.out.println("���缮\t�Ἦ\t�⼮\t�Ἦ");
		System.out.println("----------------------------------------");
		
		//����2 
		System.out.printf("\n\t\t%s", "[[�⼮��]]\n");
		System.out.printf("----------------------------------------\n");
		System.out.printf("%s \t%s \t%s \t%s \t%s \n", "�̸�","1����","2����","3����","���");
		System.out.printf("%s \t%s \t%s \t%s \t%s \n", "��ȣ��","�⼮","�⼮","�Ἦ"," ");
		
		//����1 : �����
		 	// \����Ϸ��� \\ �� �� �����
			// "����Ϸ��� \" �� �����
		System.out.println("\\    /\\");
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|");
		System.out.println("");
		
		//����2 : ������
		System.out.println("|\\_/|");
		System.out.println("|q p|    /)");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`");
		System.out.println("||_/=\\\\__|");
		
		
	}//me
	
	
} //c e
