package Day14;

import java.awt.Toolkit;

public class BeepThread extends Thread {
					// ��� Thread [��Ƽ������ Ŭ����]
	//run�޼ҵ� �������̵�
	@Override
	public void run() { //Thread�� �ִ� run�޼ҵ� ������[�������̵�]
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //1.��ü����
		for (int i = 0; i < 5; i++) {	//2.5ȸ �ݺ�
			toolkit.beep();	//�Ҹ�����
			try {	//�Ϲݿ��ܰ� ������ �߻� -> ����ó�� ������
				Thread.sleep(500);	// 0.5�ʰ� �Ͻ�����
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	
	
	
	
}//ce
