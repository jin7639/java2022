package Day02;

public class Day02_2 {//cs
	public static void main(String[] args) {//ms
		
		//; : ���� ���� ����
		//������ �������� ����� �� ����. [�̸��� �ߺ��Ǹ� ����(���кҰ�)]
		
		//2. �޸𸮸� ȿ�������� ����
		// p.40 byte : 1����Ʈ ���� +-128
		byte var1 = -128;
		System.out.println(var1);
		byte var2 = -30;
		System.out.println(var2);
		byte var3 = 30;
		System.out.println(var3);
		//byte var4 = 300;
		//System.out.println(var4);
			//���� �߻� : 128 �̻��� ������ �� ����.
		byte var4 = 'j'; System.out.println(var4);
		 // ���� -> ���� ��ȯ [�ƽ�Ű �ڵ� ��Ģ]
		
		//p.43 char : 2����Ʈ [1����] : �����ڵ�(java,2����Ʈ,�� ���� ��� ����) vs �ƽ�Ű�ڵ�(c)
		char c1 = 'a'; System.out.println(c1);
		char c2 = 97; System.out.println(c2); 		//10���� ǥ�� : 0~9
		//���� -> ���� ��ȯ
		char c3 = '\u0041'; System.out.println(c3);		//16���� ǥ��
		char c4 ='��'; System.out.println(c4);
		char c5 = 44032; System.out.println(c5);
		char c6 = '\uac00'; System.out.println(c6);
		//���� [2������ ����ϸ� ǥ�������� ���� --> ǥ������ �پ缺 ]
			//2���� : 0 , 1 / ����(2���ڵ�) / �뷮(1��Ʈ)
			//8���� : 0 ~ 7
			//10���� : 0 ~ 9
			//16���� : 0 ~ 9 a b c d e f
		// p.44 short : 2����Ʈ ���� +-3������
		short num1 = 10000; System.out.println(num1);
		//short num2 = 40000; System.out.println(num2); //���� �߻�
		
		//p.45 int : 4����Ʈ ���� +-20�� (���� �⺻Ÿ��)
		int num2 = 10; System.out.println(num2); //10����
		int num3 = 012; System.out.println(num3); //8������ �տ� 0 ���̱�
		int num4 = 0xA; System.out.println(num4); //16������ �տ� 0x ���̱�
		
		//p.46 long : 8����Ʈ ���� +- 20�� �̻�
		long num5 = 10000000000L;	System.out.println(num5);
			//int�� -> long��
		
		//.47 float [������ �ڿ� f] : 4����Ʈ / double(�Ǽ� �⺻Ÿ��) : 8����Ʈ
		double num6 = 3.14; System.out.println(num6);
		float num7 = 3.14f; System.out.println(num7);
		
		double num8 = 0.123456789123456789; System.out.println(num8);
		float num9 = 0.123456789456123456789123f; System.out.println(num9);
		
		//p.48 boolean : 1��Ʈ [t/f]
			//����ġ : on/off
		boolean bo1 = true; System.out.println(bo1);
		
		//p.49
			//			----->>>>>---------�ڵ�����ȯ ����------------->>>>
			// *ũ�� ���� : byte -> short -> int ->long -> float ->double
			//1.�ڵ� ����ȯ :
				//���� ���ڿ��� ū ���ڷ� �̵� ����
				//ū ���ڿ��� ���� ���ڷ� �̵� �Ұ�
			byte ����Ʈ = 10;
			int ��Ʈ = ����Ʈ; //�ڵ� ����ȯ O
			//short ��Ʈ = ��Ʈ; //�ڵ� ����ȯ X ���� �߻�
			
			//2. ���� ����ȯ (ĳ��Ʈ)
				//ū ���ڿ��� ���� ���ڷ� �̵� ����. ��, ������ �ս� �߻�
				//(������ �ڷ���) ������
			short ��Ʈ = (short)��Ʈ; // int�� ������ short�� ��ȯ�ϴµ� ������ �߸�
	
			//�⺻ �ڷ���(���� Ŭ����) ����� �޸𸮴� ���� -> new X
			//Ŭ������ ����� �޸𸮴� ��ü -> new O
			
			//�ڷ��� ����� �⺻Ÿ������ ��ȯ
			//1. byte + byte = int
			//2. int + byte = int
			//3. int + float = int
			//4. int + double = int
			
			
			
	}//me
	
}//ce

