package Day06;

public class Korean {//cs

	//Korean Ŭ���� ����
//	
//	1.�ʵ�
	String nation = "���ѹα�";
		//���� ������ �̸� ���ѹα� ����
	String name;
		//�̸� �������� �ʱ�ȭ X [null]
	String ssn;
		//�ֹι�ȣ �������� �ʱ�ȭ X [null]
	
	
	
//	2.������
		//����1. �������̸� == Ŭ�����̸� -> ����
		//����2. �ܺηκ��� ������ �Ű���[����]����
		//����3. ������ ������ �̸� ���� �� ����.
			//�����ε� : ������ �̸��ϰ�� �ڵ带 ������
	
	//�ʵ� 0��
	Korean() {//�������
		//���빰 ����
	}
	//�ʵ� 1��
	Korean(String n) {
		name = n;
	}
	//�ʵ� 2��
	Korean(String n , String s) {
		name =n;
		ssn = s;
	}
	//3. �ʵ� 3
	Korean ( String nation, String name , String ssn ) {
		this.nation = nation;
		this.name = name;
		this.ssn = ssn;
		// ���κ���(���� Ŭ������ ����)
		// �Ű�����(�ܺηκ��� ���� ����)
		// ���κ��� == �Ű����� �̸��� �����ϸ� �浹
		// ���κ��� ǥ�� ���
			//this : ���� Ŭ���� ǥ��
	}
	
	
//	3.�޼ҵ�
//	
	
	
	
}//ce
