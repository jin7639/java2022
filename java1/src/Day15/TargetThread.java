package Day15;

import java.util.Iterator;

public class TargetThread extends Thread{

	//����ó��
	@Override
	public void run() {	//������ ���� : NEW : ��ü�����ǰ� ��Ƽ������ ������
		for (int i = 0; i < 1000000000; i++) {//������ ���� : RUNNABLE :��Ƽ������ ������
						//10�� �ݺ�
	}//for end
		
	//1.5�ʰ� ��� [�и��� = 1000/1��]
	try {
		Thread.sleep(1500); //������ ���� : WAITING : ��Ƽ������ �Ͻ�����
	} catch (Exception e) {}	
		
	for (int i = 0; i < 1000000000; i++) {//������ ���� : RUNNABLE :��Ƽ������ ������
					//10�� �ݺ�
	}//for end	
		
	}//run�޼ҵ尡 ����Ǹ� ������ ���� : TERMINATED : ��Ƽ������ ����
}//ce
