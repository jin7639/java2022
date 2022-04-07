package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Server;

public class Client {
	//������ ������ Ŭ���̾�Ʈ�� Ŭ����
	
	//1. �ʵ� [ ���� ]
	public Socket socket;
	
	//2.������
	public Client (Socket socket) {
		this.socket = socket;
		receive(); //������ ����� Ŭ���̾�Ʈ ��ü�� �����ɶ� �ޱ� �޼ҵ� ����
	}
	
	//3. ������ �޽��� �޴� �޼ҵ� [ ������ Ŭ���̾�Ʈ�� ����Ǿ�����]
	public void receive() { //��Ƽ������
		
		//��Ƽ������ [Thread Ŭ���� vs Runnable �������̽� ]
			//run �޼ҵ带 �ʼ������� �����ؾ���
		//�������̽��� �߻�޼ҵ尡 �����ϱ� ������ �����ʼ� [ Ŭ�������� implement]
		Runnable runnable = new Runnable() {
			@Override
			public void run() { //�߻�޼ҵ� ����
				//��������� �޽��� �޴� ����
				try { 
					while(true) {
						InputStream inputStream = socket.getInputStream();
						byte[] bytes = new byte[1000];
						inputStream.read(bytes);
						String msg = new String(bytes);
						// ������ ���� �޽����� ���� ������ ���ӵ� ��� Ŭ���̾�Ʈ���� ������
						for ( Client client : Server.clientlist ) {
							client.send(msg); //���� �޽����� ������ ���ӵ� [clientlist] ��� Ŭ���̾�Ʈ���� ������
						}
					}
				} catch (Exception e) {}
			}
		};//��Ƽ������ ���� ��
		
		//�ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
		Server.threadpool.submit(runnable);
	}

	//4. ������ �޼��� ������ �޼ҵ� [������ �޽����� �޾�����]
	public void send(String msg) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
				} catch (Exception e) {
					
				}
			}
		};
		// ��Ƽ������  ���� �� 
		Server.threadpool.submit(runnable); // �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ� 
	}
	
}
