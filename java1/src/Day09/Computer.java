package Day09;

public class Computer extends Calculator{

	//1.�ʵ�
	//2.������
	//3.�޼ҵ�
		//�������̵�[�θ�Ŭ������ �޼ҵ� ������(����)]
		//ctrl + �����̽���
	@Override //��ӹ��� �θ� ������ �ִ� �޼ҵ� ȣ��
	double areaCircle(double r) {
		System.out.println("computer ��ü�� areaCircle() ����");
		return Math.PI*r*r;
	}
}
