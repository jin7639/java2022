package Day03;

public class Day03_1 {//cs

	public static void main(String[] args) {//ms
		
//	 ���
//		 ��ǻ���� �Ǵܷ��� ���� --> ����� �� 
//		 ��ǻ�͸� 5���̶�� �����ϼ���
//		 ����
//			1. IF( ����[true/false] ) ���๮;
//			2. IF( ���ǽ� ) ���๮[��];
//					ELSE ���๮ [����];
//			3. ���๮�� 2�� �̻�( ;�� �ΰ� �̻�)�̸� {}����
//			4. IF (���� 1) {���๮ [��1];}
//					ELSE IF ( ����2 ) { ���๮[��2]; }
//					ELSE IF ( ����3 ) { ���๮[��3]; }
//					ELSE IF ( ����4 ) { ���๮[��4]; }
//					ELSE IF ( ����5 ) { ���๮[��5]; }
//					ELSE IF { ���๮[����]; }
//			5. if ��ø
//				 IF (���ǽ�) {
//					IF(���ǽ�) {���๮;}
//					ELSE {���๮;}
//					}ELSE {
//						IF(���ǽ�) {���๮;}
//						ELSE { ���๮;}
//					}
					
		
		
		//����1
			if(3>1) System.out.println("��) 3�� 1���� ũ��.");
			//���࿡ 3�� 1���� ũ�� ��� O, �ƴϸ� ��� X
		//����2
			if(3>5) System.out.println("��) 3�� 5���� ũ��.");
			//���࿡ 3�� 5���� ũ�� ��� O, �ƴϸ� ��� X
		
			//���ǽ��� true �̸� ���๮ ó��
			
		//����3
			if (3>1)System.out.println("��3_1) 3�� 1���� ũ��");
			else System.out.println("��3_2) 3�� 1���� �۴�");
			// ���࿡ 3�� 1���� ũ�� ��3_1���
			//�ƴϸ� (3�� 1���� ������) ��3_2���
			
		//����4
			if(3>2) {//true ���๮ ����
				System.out.println("true"); 
				System.out.println("3�� 2���� ũ��");
			}//true ���๮ ��
			else { //false ���๮ ����
				System.out.println("3�� 2���� �۴�");
			}//false ���๮ ��
			
		//����5
			if(3>5) System.out.println("��5)3�� 5���� ũ��");  //����X
			else if (3>4) System.out.println("��5)3�� 4���� ũ��");  //����X
			else if (3>3) System.out.println("��5)3�� 3���� ũ��");  //����X
			else if (3>2) System.out.println("��5)3�� 2���� ũ��");  //����O
			else System.out.println("true ����"); //����X
			//1���� ->��� 1��
			
		//����6
			if (3>5) System.out.println("��5)3�� 5���� ũ��");  //����X
			if (3>4) System.out.println("��5)3�� 4���� ũ��");  //����X
			if (3>3) System.out.println("��5)3�� 3���� ũ��");  //����X
			if (3>2) System.out.println("��5)3�� 2���� ũ��");  //����O
			if (3<2) System.out.println("true ����"); //����X
			//5�� ���� ->��� 5��
			
			
			
	}//me
	
	
}//ce
