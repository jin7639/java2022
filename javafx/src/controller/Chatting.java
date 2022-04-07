package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Chatting implements Initializable{

	   @FXML
	    private Button btnconnect;

	    @FXML
	    private TextArea txtcontent;

	    @FXML
	    private Button btnsend;

	    @FXML
	    private TextField txtmsg;
	    
	    @FXML
	    private TextField txtname;

	    @FXML
	    private TextField txtport;

	    @FXML
	    void accport(ActionEvent event) {

	    }

	    @FXML
	    void accsend(ActionEvent event) { //���� ��ư�� ������ ��
	    	String msg = txtmsg.getText()+"\n"; //���� �޽���
	    	send(msg);
	    	txtmsg.setText(""); //������ �� �޽��� �Է�â �����
	    	txtmsg.requestFocus(); //������ �� �޽��� �Է�â���� Ŀ�� �̵�
	    }
	    
	    //1. Ŭ���̾�Ʈ ���� ����
	    Socket socket;
	    
	    //2.Ŭ���̾�Ʈ ���� �޼ҵ�
	    public void clientstart() {
	    	//��Ƽ������
	    	Thread thread = new Thread() {
	    		@Override
	    		public void run() {
	    			try {
						socket = new Socket("127.0.0.1",1234); //���� ip�� port ��ȣ �ֱ�
						send(Login.member.getMid()+"�� �����߽��ϴ�.");
						receive(); //���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���� ����
					} catch (Exception e) {}
	    		};
	    	}; // ��Ƽ������ ���� ��
	    	thread.start(); //��Ƽ������ ����
	    }
	    
	    //3.Ŭ���̾�Ʈ ���� �޼ҵ�
	    public void clientstop() {
	    	try {
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    }
	    
	    //4.�������� �޽��� ������ �޼ҵ�
	    public void send(String msg) {
	    	Thread thread = new Thread() {
	    		@Override
	    		public void run() {
	    			try {
						OutputStream outputStream = socket.getOutputStream(); //1. ��� ��Ʈ��
						outputStream.write(msg.getBytes());//2. ��������
						outputStream.flush(); //3. ��Ʈ�� �ʱ�ȭ
					} catch (Exception e) {}
	    		}
	    	}; //��Ƽ������ ���� ��
	    	thread.start(); //��Ƽ������ ����
	    }
	    
	    //5.�������� �޽��� �ޱ� �޼ҵ�
	    public void receive() {
	    	while(true) {
	    		InputStream inputStream;
				try {
					inputStream = socket.getInputStream();
		    		byte[] bytes = new byte[1000];
		    		inputStream.read(bytes);
		    		String msg = new String(bytes);
		    		txtcontent.appendText(msg); //�Է� ���� ������ ä��â�� �߰��ϱ�
				} catch (Exception e) {} //�Է½�Ʈ��
	    	}
	    }
	    
	    @FXML
	    void accconnect(ActionEvent event) {
	    	if (btnconnect.getText().equals("ä�ù� ����")) {
	    		
	    		clientstart();
	    		//Ŭ���̾�Ʈ ���� �޼ҵ�
	    		txtcontent.appendText("---[ä�ù� ����]---\n");
	    		btnconnect.setText("ä�ù� ����");
	    		txtmsg.setEditable(true); 		//ä���Է�â ���� ����
	    		txtcontent.setDisable(false); 	//ä��â ��� ������
	    		btnsend.setDisable(false); 		//���۹�ư ��� ����
	    		txtmsg.requestFocus(); 			//ä���Է�â���� ��Ŀ��[Ŀ��]�̵�
			}else {
				
				clientstop();
				txtcontent.appendText("---[ä�ù� ����]---\n");
				btnconnect.setText("ä�ù� ����");
				txtmsg.setEditable(false); //ä���Է�â ���� ����
				txtcontent.setDisable(true); //ä��â ��� ������
				btnsend.setDisable(true); //���۹�ư ��� ����
			}
	    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//ä��fxml ������ �� �ʱⰪ �޼ҵ�
			//ä�ù� ���� ���� �Ʒ�fxid ��� ����
		txtmsg.setEditable(false); //ä���Է�â ���� ����
		txtcontent.setDisable(true); //ä��â ��� ������
		btnsend.setDisable(true); //���۹�ư ��� ����
	}
}
