package Day09;

public class Day09_4 {

	//p.296
	//@Override : ������
	//������ �μ��� ������ �޼ҵ�� �Ұ���
	//���� : ������ �޼ҵ带 ������[����]
		//��� �޾Ҵ��� �޼ҵ尡 ���� �ȵ��...�ٲ� �� �ִ�!
	public static void main(String[] args) {
		
		int r = 10; 
		//1.����Ŭ������ ��ü ����
		Calculator calculator = new Calculator();
		//2.����Ŭ������ ���� ��ü�� �޼ҵ� ȣ��
		System.out.println("������ : " + calculator.areaCircle(r));
		System.out.println();
		
		//1.����Ŭ������ ��ü ����
		Computer computer = new Computer();
		//2.����Ŭ������ ���� ��ü�� �޼ҵ� ȣ��
		System.out.println("������ : " +computer.areaCircle(r));
		//����Ŭ������ ����Ŭ������ �޼ҵ�� �ٸ���
		
	}
	
}
