package Day08;

public class Day08_1 {//cs
	public static void main(String[] args) {//ms
		
		//p.238 : static
			//��������
			//���� ������ = ���α׷� ���������� ���Ǵ� �޸�
		
		//1.Ŭ���� �� �ʵ�, �޼ҵ� (���) ���� ���
			
			//(static ����� �ƴҶ�) 1.��ü ���� -> ��ü.���
				//��ü�� ������ �� new�����ڷ� ��ü(�� �������) �޸� �Ҵ�
		Calculator calculator = new Calculator();
			System.out.println("��ü�� �̿��� ������� : " + calculator.pi);
			// (static ��� �϶�) 1.Ŭ������.���
				//Ŭ���� �ε��ǰ� �޼ҵ� ������ static ���� ����
		System.out.println("��ü���� ������� : " + Calculator.pi);
			
		double result = 10 * 10 * Calculator.pi;
		
		int result2 = calculator.plus(0, 0)
		int result3 = calculator.minus(10, 5);
			
	}//me
	
}//ce
