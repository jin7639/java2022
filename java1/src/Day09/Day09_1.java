package Day09;

public class Day09_1 {//cs

	public static void main(String[] args) {//ms
		//���
			//�θ𿡰� �����޴� ��
			//���� : �θ� ---> �ڽ� ����
			//���α׷��� : �ڽ� --->�θ� ����
			//extends : �����ϴ� [����ϴ�]
			//���� : ���� ���� [������ �ִ� Ŭ������ �����ؼ� ������ Ŭ������ ����
			//�θ�Ŭ���� ������ �ϳ��� ����
		
		//p.290
		//1.����Ŭ������ ��ü ����
		DmbCellPhone dmbCellPhone = new DmbCellPhone("�ڹ���", "����", 10);
		
		//CellPhone���κ��� ��ӹ��� �ʵ�
		System.out.println("�� : "+dmbCellPhone.model);
		System.out.println("���� : "+dmbCellPhone.color);
		
		System.out.println("ä�� : "+ dmbCellPhone.channel);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		
	}//me
	
	
	
}//ce
