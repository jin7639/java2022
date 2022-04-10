package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {// fxml ������� �ʴ� ���� ��Ʈ�� Ŭ����

	//��øŬ���� [ Ŭ���� �ȿ� Ŭ���� ���� ]
	public class Client {//������ ���ӵ� Ŭ���̾�Ʈ�� Ŭ����
	
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
							for ( Client client : clientlist ) {
								client.send(msg); //���� �޽����� ������ ���ӵ� [clientlist] ��� Ŭ���̾�Ʈ���� ������
							}
						}
					} catch (Exception e) {}
				}
			};//��Ƽ������ ���� ��
			
			//�ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
			threadpool.submit(runnable);
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
						System.out.println("������ �޽��� �����⿡ �����߽��ϴ�. " + e);
					}
				}
			};
			// ��Ƽ������  ���� �� 
			threadpool.submit(runnable); // �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ� 
		}
	}

    // ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ
    public Vector<Client> clientlist = new Vector<>();
    	//Vector ����ϴ� ���� : ����ȭ(O) // ����ȭ : ���� �����尡 �ϳ��� �޼ҵ忡 ������ ��� ��� ���� ����� ��
    // ��Ƽ�����带 �������ִ� ������Ǯ
    public ExecutorService threadpool;
    
    // 1. �������� ����
    ServerSocket serverSocket;
    // 2. �������� �޼ҵ� [ip�� port�޾Ƽ� �������� ���ε�(����)]
    public void serverstart(String ip, int port) {
    	try {

    		// 1. �������� �޸� �Ҵ�
    		serverSocket = new ServerSocket();
			// 2. �������� ���ε� [ ip �� port ���� ]
    		serverSocket.bind( new InetSocketAddress(ip, port));
    		
		} catch (Exception e) {System.out.println("���� ���� ���� "+e);
		}
			// 3. Ŭ���̾�Ʈ�� ��û ��� [ ��Ƽ������ ����ϴ� ���� : 1. ���� 2.������ 3.�ޱ� ���� ó��]
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						while(true) {
							Socket socket;
								socket = serverSocket.accept(); //1. ��û �����Ŀ� ������ ������ ����
							clientlist.add(new Client(socket)); //2. ����� Ŭ���̾�Ʈ (����� ����) �����Ŀ� ����Ʈ�� �ֱ�
						}
					} catch ( Exception e) {
						System.out.println("���� Ŭ���̾�Ʈ ���� ���� "+ e);
					} //��û 
				}
			};
			threadpool = Executors.newCachedThreadPool(); //������Ǯ�� �޸� �ʱ�ȭ [�Ҵ�]
			threadpool.submit(runnable); //������ ������ ��Ƽ�����带 ������Ǯ�� �־��ֱ�
    }
    
    // 3. �������� �޼ҵ�
    public void serverstop() {
    	try {
	    	//1. ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ�
	    	for ( Client client : clientlist ) {
	    		client.socket.close();
	    	}
	    	//2. �������� �ݱ�
	    	serverSocket.close();
	    	//3. ������Ǯ �ݱ�
	    	threadpool.shutdown();
    	} catch (Exception e) {
    		// TODO: handle exception
    	}
    }
}
