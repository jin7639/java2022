package Day08_3;

public class A {//������ Ŭ���� �� ���� ������ ����ǹ� X

	//������ Ŭ���� ���� A
		//1.�ʵ�
	A a1 = new A(true);		//�� Ŭ���� ���� public ȣ�� ����
	A a2 = new A(1); 		//�� Ŭ�������� default ȣ�� ����
	A a3 = new A("���ڿ�"); 	//�� Ŭ�������� private ȣ�� ����
	
	public int field;
	int field2;
	private int field3;
	
	
	
	
		//2.������
	
	public A(boolean b ) {
		field1 = 1;
		field2 = 2;
		field3 = 3;
	}
	
	
	
	
	
	public A(boolean b) {}	//�� ����
	A (int b) {}			//�� ��Ű�� ��
	private A (String s) {}	//�� Ŭ���� ��
	
		//3. �޼ҵ� 
	
}
