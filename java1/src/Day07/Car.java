package Day07;

public class Car {

	//Ŭ���� ����
	
	//1. �ʵ�
	int gas; //��������
	
	//2. ������
		//������ ������ �⺻������
	
	//3. �޼ҵ�
		//1.gas�� �ܺηκ��� �޾Ƽ� ���ο� �����ϴ� �޼ҵ�
	void setGas (int gas) {
		//�μ� O ��ȯ X
		//���� X �޼ҵ�� (�μ�1) {�׳��κ��� ,�ܺκ���
		this.gas = gas;
	}
	
	//2.���� gas�� ������ Ȯ�� [0=��������][1=�����ִ�]
	boolean isLeftGas() {//�μ� X ��ȯ O
		//����ȯ �޼ҵ��()
		if (gas == 0) {
			System.out.println("gas �����ϴ�.");
			return false; //���� ������ gas �� 0�̸� false ��ȯ
		}else {
			System.out.println("gas �ֽ��ϴ�.");
			return true; //���� ������ gas �� 1�̸� true ��ȯ
					
		}
		
	}
	
	//3. gas�� 0�϶����� �����ϴµ� �����Ҷ����� ����1 �� ����
	//gas 0�̸� �Լ�����
	
	void run() {
		
		if (gas > 0) {
			System.out.println("�޸��ϴ�. ( gas�ܷ� : " + gas);
			gas--;
		} else {
			System.out.println("�޸��ϴ�. ( gas�ܷ� : " + gas);
			return;
		}
	}
	
}
