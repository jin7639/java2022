package Day07;

import java.util.Iterator;

public class Car2 {

//	1. �ʵ�
	int speed;
//	2. ������
//		������ ������ �⺻ ������ �߰�
	
//	3. �޼ҵ�
	
//	1.���� �ʵ尪�� ��ȯ���ִ� ���ҵ�
	int getSpeed() { //�μ�X ��ȯ O
		return speed;
	}
	
//	2. ��� �޼ҵ�
	void keyTurnOn() {//�μ��� ��ȯ��
		System.out.println("Ű�� �����ϴ�.");
		
	}
//	3.
	void run() {
		for (int i =0; i<=50; i+=10) {
			speed = i;
			System.out.println("�޸��ϴ�. �ü� : " + speed +"km/s");
		}
	}
	
	
	
	
}
