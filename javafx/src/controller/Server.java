package controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dto.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Server implements Initializable {

 	@FXML
    private Button btnserver;

    @FXML
    private TextArea txtserver;

    // ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ
    public static Vector<Client> clientlist = new Vector<>();
    	//Vector ����ϴ� ���� : ����ȭ(O) // ����ȭ : ���� �����尡 �ϳ��� �޼ҵ忡 ������ ��� ��� ���� ����� ��
    // ��Ƽ�����带 �������ִ� ������Ǯ
    public static ExecutorService threadpool;
    
    // 1. �������� ����
    ServerSocket serverSocket;
    // 2. �������� �޼ҵ�
    public void serverstart() {
    	try {

    		// 1. �������� �޸� �Ҵ�
    		serverSocket = new ServerSocket();
			// 2. �������� ���ε� [ ip �� port ���� ]
    		serverSocket.bind( new InetSocketAddress("127.0.0.1" , 1234));
    		
		} catch (Exception e) {
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
	    
    @FXML
    void accserver(ActionEvent event) {//���� ���� ��ư
    	if (btnserver.getText().equals("��������")) {
			//���࿡ ��ư�� �ؽ�Ʈ "���� ����"�̸�
    		txtserver.appendText("���� �����մϴ�.\n");
    		//��ư�� �ؽ�Ʈ ����
    		btnserver.setText("��������");
		}else { //��ư�� �ؽ�Ʈ�� "���� ����"�̸�
			txtserver.appendText("���� ����\n");
			btnserver.setText("���� ����");
		}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtserver.setDisable(true);
		
	}
}
