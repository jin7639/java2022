package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import dto.Roomlive;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;
    //���� ����
    public Server server;
    public Room selectroom;
    
    public void show() {
    	ObservableList<Room>roomlist = RoomDao.roomDao.roomlist();
    	
    	TableColumn tc = roomtable.getColumns().get(0);
    	tc.setCellValueFactory( new PropertyValueFactory<>("ronum"));
		
		tc = roomtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("roname"));
    
		tc = roomtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
    
		roomtable.setItems(roomlist);
		//�ش� ���̺�並 Ŭ������ ��
		roomtable.setOnMouseClicked(e -> {
			//Ŭ���� ��ü ��������
			selectroom = roomtable.getSelectionModel().getSelectedItem();
			//���̺� ǥ��
			lblselect.setText("���� ���õ� �� : " +selectroom.getRoname());
			//���� ��ư Ȱ��ȭ
			btnconnect.setDisable(false);
		});
    }
    
    
    @FXML
    void accadd(ActionEvent event) { //�� ���� ��ư�� ������
    	//1. ��Ʈ�ѿ� �Էµ� �� �̸� ��������
    	String roomname = txtroomname.getText();
    	if (roomname.length() < 4) {
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("���̸��� 5���� �̻�");
				alert.showAndWait();
				return;
		}
    	//2. �� ��ü
    	Room room = new Room ( 0, roomname, "127.0.0.1", 0);
    	//3. DBó��
    	RoomDao.roomDao.roomadd(room);
    	//4. �ش� �� ���� ����
    	server = new Server();
    	//���� ����
    	server.serverstart(room.getRoip(), RoomDao.roomDao.getroomnum());
    	txtroomname.setText(""); // ���� �� ���̸� �Է�â ���� ó��
    	show();
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("�� ������ �Ϸ� �Ǿ����ϴ�. ���ȣ : " + RoomDao.roomDao.getroomnum());
    	alert.showAndWait();
    }

    @FXML
    void accmsg(ActionEvent event) {
    	String msg = Login.member.getMid() + " : " + txtmsg.getText() + "\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus();
    }

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
    public void clientstart(String ip, int port) {
    	//��Ƽ������
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					socket = new Socket(ip, port); //���� ip�� port ��ȣ �ֱ�
					send(Login.member.getMid()+"�� �����߽��ϴ�.\n");
					receive(); //���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���� ����
				} catch (Exception e) {System.out.println(e);}
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
			System.out.println(e);
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
				} catch (Exception e) {System.out.println(e);}
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
			} catch (Exception e) {System.out.println(e);} //�Է½�Ʈ��
    	}
    }
    
    public void midshow() { // msg�޼ҵ�:�Է�â���� ���� ������ // send�޼ҵ� : ���۹�ư ��������
    	// 1. ���̺�信�� ���õ� �� ��ȣ�� ���ӵ� ȸ����� �������� 
    	ArrayList<Roomlive> roomlivelist 
			= RoomDao.roomDao.getRoomlivelist( selectroom.getRonum() );
		txtmidlist.setText(""); // 2.��� �ʱ�ȭ
		int i = 1; 
		for( Roomlive temp : roomlivelist ) { // 3.����Ʈ�� ��� ��ü�� �ϳ��� ��ܿ� �߰�
			txtmidlist.appendText( i +"�� "+ temp.getMid() +"\n");
			i++;
		}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if (btnconnect.getText().equals("ä�ù� ����")) {
    		
    		clientstart(selectroom.getRoip(), selectroom.getRonum());
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
		btnconnect.setDisable(true); //�����ư ������
		txtmidlist.setDisable(true); //������ȸ�� ��� ������
		
		
	}
}
