package Day09;

public class Tire {//cs
	
	//1.�ʵ�
	public int maxRotation; //�ִ� ȸ����
	public int accumulatedRotation; ///���� ȸ����
	public String location; //Ÿ�̾��� ��ġ
		
	//2.������
	public Tire (String location,  int maxRotation) {
				//Ÿ�̾� ��ġ, �ִ�ȸ����
		this.location = location; //�ܺη� ���� ���޹��� �μ��� ���κ����� ����
		this.maxRotation = maxRotation;
	}
	//3.�޼ҵ�
	public boolean roll() {
		++accumulatedRotation; //����ȸ���� 1����
		if (accumulatedRotation < maxRotation) {
			//���� ����ȸ������ �ִ� ȸ�������� ������ [���� ����]
			System.out.println(location + "Tire ���� : "+ (maxRotation-accumulatedRotation)+"ȸ");
			return true;
		}else {//�ƴϸ� [���� ����]
			System.out.println("***"+location + "Tire ��ũ ***");
			return false;
		}
	}
	
	
	
}//ce
