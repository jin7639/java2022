package Day14;

import java.awt.Toolkit;

public class Day14_4 {

	public static void main(String[] args) {
	//p.576  ��Ƽ������ ����
		//���μ��� : �ü�������� ���� ���� �ϳ��� ���ø����̼�
		//�ü���� ���μ������� �ʿ��� �޸𸮸� �Ҵ��� �� [�ڹٿ��� �޸� ����X, �ü��(������)�� ��o]
		//�̱� ������ : �ڵ� �о��ִ� �帧 1�� = main �޼ҵ�
		//��Ƽ ������ : �ڵ带 �о��ִ� �帧 ������ = main �޼ҵ� �� ������
		//���� : ����� �����帧������ �����尡 �ϳ��� ������(�켱���� �ü���� �Ҵ�) ó��
			//������� : �ڵ�1 -> �ڵ�2 -> �ڵ�3 -> �ڵ�4 -> �ڵ�5
		//Thread Ŭ����(���ο� ������) vs Main �޼ҵ� (���ν����尡 ����)
			//1. Tread Ŭ����
				//1. ����Ŭ������ extends Thread
				//2. run () �޼ҵ� �������̵� [������]
				//3. ��ü ����
				//4. ��ü.start()
				// start() �޼ҵ� ȣ��� run �޼ҵ� ����
			//2. Runnable �������̽� [������]
				//1. ���� Ŭ������ implements Runnable
				//2. run �޼ҵ� ���� �Ѵ�.
				//3. Thread Ŭ���� ��ü ������ �����ڿ� ���� ��ü �־��ش�.
				//4. thread Ŭ���� ��ü �� start()�޼ҵ� ����
				//* .start() �޼ҵ�� run() �޼ҵ� ȣ��
				//* round() �޼ҵ�� main������ ������ ���ο� ������ �����
			//3. �͸�ü
		//	�ڵ�1
		
		//	�ڵ�2		�ڵ�3
		
		//	�ڵ�4		�ڵ�5
		
		//(�۾�������1) (�۾�������2)
		
		
		//p.581 ����1
			//�̱۽����� (main������)
			//0.5�� �������� �Ҹ� ���
			//0.5�� �������� �� ���
		System.out.println("-------------�̱� ������-----------------");
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //�Ҹ� ���� �޼ҵ� ���� Ŭ����
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep(); //�Ҹ� �޼ҵ�
			try {
				Thread.sleep(500); //���� ������(main������)�� 0.5�ʰ� ����
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		for (int i = 0; i <5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(500); //���� ������(main������)�� 0.5�ʰ� ����
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("-----------��Ƽ ������ - �������̽�-------------------");
		
		//p.582 ����2
			//��Ƽ������
		//1. �������̽��� ������ü
		Runnable beepTask = new BeepTask();
		//2. Thread Ŭ���� ��ü ������ �����ڿ� ���� ��ü �ֱ�
		Thread thread = new Thread(beepTask);
		//3. thread ��ü�� start() �޼ҵ� ȣ��
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(500); //���� ������(main������)�� 0.5�ʰ� ����
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("----------��Ƽ������ - Ŭ����--------------------");
		//p.584 : Thread Ŭ������ �̿��� ��Ƽ������
		Thread thread2 = new BeepThread();
		//����Ŭ����	   = �ڽ�Ŭ������ ������
		//		�θ� <------ �ڽ� [�ڵ�����ȯ]
		//		�θ� ------> �ڽ� [��������ȯ]
		//2.������ ��ü �� start() ȣ��
			//1. run�޼ҵ� ȣ�� ���� [��Ƽ������ ����]
		thread2.start();	
		
		for (int i = 0; i < 5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(500); //���� ������(main������)�� 0.5�ʰ� ����
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("----------��ƼŬ���� - �͸�ü--------------------");
		
		//�������̽� �����
			//1.Ŭ�������� implements �� �Ŀ� ���� -> ������ü
			//2. �������̽��� new �����ڸ� ���� �߻�޼ҵ� ���� -> �͸� ��ü 
		
		// �͸� ������ ��ü
	Runnable runnable = new Runnable() {
				//�������̽��� new(�޸��Ҵ�0
				//�޸� �Ҵ��ϱ� ���ؼ� �߻�޼ҵ带 ���� ����
				//�߻�޼ҵ带 ���� �� �ϸ� �͸�ü ���� �Ұ�
		@Override
		public void run() {
			// ����
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
						Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	};
	Thread thread3 = new Thread(runnable);
	thread3.start();

	for( int i = 0 ; i<5 ; i++ ) {
		System.out.println("��");
		try { 
			Thread.sleep(500); 
			}
		catch( Exception e ) {
			
		}
	}
	
	System.out.println("----------��ƼŬ���� - �� ��������� �̸�--------------------");
		System.out.println("Main�޼ҵ� �ȿ� �ִ� ������ �̸� : " + Thread.currentThread().getName());
			//Thread.currentThread() : �� �ڵ带 �о��ִ� ������ ȣ��
							//.getName() : ������ �̸� ȣ��
		System.out.println("�۾� ������1 �̸� : "+thread.getName());
		System.out.println("�۾� ������2 �̸� : "+thread2.getName());
		System.out.println("�۾� ������3 �̸� : "+thread3.getName());
		
		//p.590
		for (int i = 0; i <= 10; i++) {
						//10ȸ �ݺ�ó��
			//i�� 1�϶� ���� ���������� ��ü ���� = thread
			// ���� �����Ǿ ��ȯ�Ҵ�[�ü���� �����ٸ�]�̹Ƿ� ���� ���� ��������� ����
			
			
			//1. i��° ������ ��ü ����
			Thread thread4 = new CalcThread("thread"+i);
			
			//�켱����
				//���࿡ 10�� �ƴϸ� �켱���� ���� 10�̸� �켱���� 10
			if (i != 10) {
				thread4.setPriority(Thread.MIN_PRIORITY);
			}else {
				thread4.setPriority(Thread.MAX_PRIORITY);
			}
			
			//2. i��° ������ ����
			thread4.start();
		}
		
		
		
	}//me
	
}//ce
