package Day12;

public class Day12_2 {//cs
	
	public static void main(String[] args) {//ms
		
		//String �޼ҵ�
		//p.499 charAt() : ���ڿ����� Ư������ ����
		String ssn = "010624-1230123";	//�ֹε�Ϲ�ȣ
		char sex = ssn.charAt(7);	//7�� �ε����� ���ڸ� ����
		
		switch (sex) {//switch ��� [switch(�˻���)]
		case '1':	//sex �������� ���� 1, 3�̸�
		case '3': System.out.println("����");
			break;
		case '2'://sex ���� ���� ���� '2','4'��
		case '4': System.out.println("����");
			break;
		}//switch end
		
		System.out.println("------------------------");
		
		//p.501 equals() : ���ڿ���
			//�⺻�ڷ��� ����ϴ� ������ ������ ��밡�� [==]
			//String Ŭ���� ����ϴ� ��ü�� == ������ ���Ұ���[equals]

		//�ڹ� �޸� [JVM]
			//���� �޸� : ��������
			//�� �޸� : ��ü
			//�޼ҵ� �޸�
		
		//1.���ڿ� ����
		String strVar1 = new String("�Ź�ö");
		String strVar2 = "�Ź�ö";	//��ü�� new ������ �ʼ� ������ String Ŭ������ �ڵ����� ����
		
		//2.���ڿ� ��
		if (strVar1 == strVar2) {//���ڿ� == �Ұ��� [== �� �ּ� ��]
			System.out.println("���� String ��ü�� ����");
		}else {
			System.out.println("�ٸ� String ��ü�� ����");
		}
		//3.
		if (strVar1.equals(strVar2)) {// [equals �� ���빰 ��]
			System.out.println("���� ���ڿ��� ����");
		}else {
			System.out.println("�ٸ� ���ڿ��� ����");
		}
		System.out.println("------------------------");
		//p.502 .getBytes():���ڿ� -> ����Ʈ�� ��ȯ
		String str= "�ȳ��ϼ���"; //���� 1 ����Ʈ �ѱ� 2����Ʈ
		//���ڿ�->����Ʈ�� ��ȯ
		byte[]bytes1 =  str.getBytes();
		System.out.println("����1byte �ѱ�2byte : " + bytes1.length);//�迭��.length
		
		//����Ʈ�� ->���ڿ� ��ȯ
		String str1 = new String(bytes1);
		System.out.println("����Ʈ�� -> ���ڿ� : "+ str1);
		
		try {
			//1.���ڵ�Ÿ�� [���ڵ�/���ڵ� : ��ȯ ���]
			
			//1.EUC-KR[�ѱ�/���� : 2����Ʈ��]
			byte[]bytes2 = str.getBytes("EUC-KR");//�Ϲݿ��� �߻�
			System.out.println("EUC-KR ���� : " + bytes2.length);
			String str2 =new String( bytes2, "EUC-KR");
			System.out.println("����Ʈ�� -> ���ڿ� : " + str2);
			
			//2.UTF-8 [��������:�ѱ� 3����Ʈ]
			byte[]bytes3 = str.getBytes("UTF-8");//�Ϲݿ��� �߻�
			System.out.println("UTF-8 ���� : " + bytes3.length);
			String str3 =new String( bytes3, "UTF-8");
			System.out.println("����Ʈ�� -> ���ڿ� : " + str3);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
//		//504
//			String subject = "�ڹ� ���α׷���";
//			int location = subject.indexOf("���α׷���");
//			System.out.println("location");
//			
//			//���ڿ� �� Ư�����ڿ� ��ġ[�ε���]ã�� /���࿡ ������ -[����]
//			if(subject.indexOf("�ڹ�") != -1 ) {//�ε����� 0�� ����
//				System.out.println("�ڹ� ���� å");
//			}else {
//				System.out.println("�ڹٿ� ���� ����");
//			}
//			
//			//505
//			
//			String ssn2 = "754861515485";
//			int length = ssn2.length(); //
//			if (length == 13 ) {
//				System.out.println("�ֹι�ȣ �ڸ����� �½��ϴ�.");
//			}else {
//				System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�.");
//			}
			
		System.out.println("-----------------------------------");	
			//p.506 replace ("��������","���ο� ����")
		String oldStr = ("�ڹٴ� ��ü������ �Դϴ�. �ڹٴ� ǳ���� API�� �����մϴ�.");
		String newSrt = oldStr.replace("�ڹ�", "JAVA");
						//���ڿ�.replace("��������","���ο� ����");
			
		System.out.println(oldStr);
		System.out.println(newSrt);
		
		//507 Substring(�ε�������) vs split(���ڱ���) :���ڿ��ڸ���
			String ssn3 = "880815-1234567";
			String firstNum = ssn3.substring(0,6);	//�����ε���, ������ �ε��� ��
			System.out.println(firstNum);
			
			String secondNum = ssn3.substring(7);	//�ε��� [~ ����������]
			System.out.println(secondNum);
			//split
			System.out.println("�պκ� : "+ ssn3.split("-")[0]);
			System.out.println("�޺κ� : "+ ssn3.split("-")[1]);
//			[0] = 880815 [1] = 1234567
			//508
				//�������ڿ�.toLowerCase("����") -> ���� [�ҹ��ڷ� ��ȯ]
				//�������ڿ�.toUpperCase()-> ���� [�빮�ڷ� ��ȯ]
			//509
				//���ڿ�.trim() : �յ� ��������
			//510 valueOF() : �⺻Ÿ�� [int,double ��] ->���ڿ� ��ȯ
			String str2 = String.valueOf(10);	//int �� 10 ->String 10���� ��ȯ
			String str3 = String.valueOf(10.5);
			String str4 = String.valueOf(true);
			String str5 = 10+"";	//int ���� String ������ ����[�Ұ���]
			
			
			
		
		
		
		
		
		
		
	}//me

}//ce
