package Day11;

public class Day11_2 {

	//422
		//��ǻ�� �ϵ���� ���� ���� [����Ұ���]
		//������� �߸��� ���� Ȥ�� �������� �߸��� �ڵ� ���� ���� ����
		//���� : 1.�Ϲݿ���	2.���࿹��
			//�Ϲݿ��� : ������[����]���� ���� �˻� [�����ڿ��� ���� ����ó��= �ܺ���� (������)]
			//���࿹�� : ������[����]�Ŀ� ���� �˻�	[�������� ���迡 �Ǵ��ؼ� ����ó��]
	//����ó�� 
		//���� : ������ �߻��ϸ� (�������� ������ �����)���α׷� ����
		//���࿡ ������ �߻��ϸ� ��ü �ڵ� ���� [���α׷��� ������� �ʰ���]
	
	
	public static void main(String[] args) {
		
		//423
		try {
			String data = null;
			System.out.println(data.toString());	//Object Ŭ���� �޼ҵ� : toString() : ��ü�������
				//���������� �������� ... �����Ŀ� [���࿹��]
			//���� �߻� ���� : null�� �޸��Ҵ��� ���� ������ ��ü ���� ��� �Ұ�
		}catch(NullPointerException ��ü��) {
			System.out.println("���ܹ߻� : "+��ü��);
		}
		
		
		//424
		try {
		String[] �迭 = new String[2];
		�迭[0] = "a"; �迭[1] = "b"; �迭[2] = "C";
		}catch (ArrayIndexOutOfBoundsException e) {
				//���ܹ߻��� ����Ŭ������ ��ü�� = ��ü�� ���� ������ �����
			//���� ���ܰ� �߻��Ѵٸ� ����Ǵ� �ڵ�
			System.out.println("���ܹ߻� : " + e);
		}
		
		//426
		try {
			String data1 = "100";
			String data2 = "a100";
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
							//���ڿ��� ������ �ٲ���
							//��, "100" ---> 100 [����] / "a100" --> a100 [�Ұ���] a�� ������ ǥ�� �Ұ�
			//���� �߻� ���� : ���ڿ� �� ���������� ��ȯ�� ���������� ���ڿ� �� �������� ��ȯ �Ұ���
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "="+ result );
			
		}catch (NumberFormatException e) {
			System.out.println("�����߻� : "+ e);
		}				
		
		//428
		try {
			String ���ڿ� = "���缮";	//�ڹ� Ŭ���� �� �ϳ�
			Object ���۰�ü ; 			//�ڹ� Ŭ������ �ֻ��� Ŭ����
			
			���۰�ü = ���ڿ�;
			���ڿ� = (String)���۰�ü;
				//��������ȯ
				//�����߿� ����ȯ
			//����ó�� �Ǵ�
				//�����(����� ����) ���õ� �ڵ� [������ �����ڵ�]
		}catch (Exception e) {
			System.out.println("���ܹ߻� : "+ e);
		}
	}//me
	
	
}//ce
