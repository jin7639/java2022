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
	    void accsend(ActionEvent event) { //전송 버튼을 눌렀을 때
	    	String msg = txtmsg.getText()+"\n"; //보낼 메시진
	    	send(msg);
	    	txtmsg.setText(""); //보내기 후 메시지 입력창 지우기
	    	txtmsg.requestFocus(); //보내기 후 메시지 입력창으로 커서 이동
	    }
	    
	    //1. 클라이언트 소켓 선언
	    Socket socket;
	    
	    //2.클라이언트 실행 메소드
	    public void clientstart() {
	    	//멀티스레드
	    	Thread thread = new Thread() {
	    		@Override
	    		public void run() {
	    			try {
						socket = new Socket("127.0.0.1",1234); //서버 ip와 port 번호 넣기
						send(Login.member.getMid()+"님 입장했습니다.");
						receive(); //접속과 동시에 받기 메소드는 무한 루프
					} catch (Exception e) {}
	    		};
	    	}; // 멀티스레드 구현 끝
	    	thread.start(); //멀티스레드 실행
	    }
	    
	    //3.클라이언트 종료 메소드
	    public void clientstop() {
	    	try {
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    }
	    
	    //4.서버에게 메시지 보내기 메소드
	    public void send(String msg) {
	    	Thread thread = new Thread() {
	    		@Override
	    		public void run() {
	    			try {
						OutputStream outputStream = socket.getOutputStream(); //1. 출력 스트림
						outputStream.write(msg.getBytes());//2. 내보내기
						outputStream.flush(); //3. 스트림 초기화
					} catch (Exception e) {}
	    		}
	    	}; //멀티스레드 구현 끝
	    	thread.start(); //멀티스레드 실행
	    }
	    
	    //5.서버에게 메시지 받기 메소드
	    public void receive() {
	    	while(true) {
	    		InputStream inputStream;
				try {
					inputStream = socket.getInputStream();
		    		byte[] bytes = new byte[1000];
		    		inputStream.read(bytes);
		    		String msg = new String(bytes);
		    		txtcontent.appendText(msg); //입력 받은 내용을 채팅창에 추가하기
				} catch (Exception e) {} //입력스트림
	    	}
	    }
	    
	    @FXML
	    void accconnect(ActionEvent event) {
	    	if (btnconnect.getText().equals("채팅방 입장")) {
	    		
	    		clientstart();
	    		//클라이언트 실행 메소드
	    		txtcontent.appendText("---[채팅방 입장]---\n");
	    		btnconnect.setText("채팅방 퇴장");
	    		txtmsg.setEditable(true); 		//채팅입력창 수정 금지
	    		txtcontent.setDisable(false); 	//채팅창 목록 사용금지
	    		btnsend.setDisable(false); 		//전송버튼 사용 금지
	    		txtmsg.requestFocus(); 			//채팅입력창으로 포커스[커서]이동
			}else {
				
				clientstop();
				txtcontent.appendText("---[채팅방 퇴장]---\n");
				btnconnect.setText("채팅방 입장");
				txtmsg.setEditable(false); //채팅입력창 수정 금지
				txtcontent.setDisable(true); //채팅창 목록 사용금지
				btnsend.setDisable(true); //전송버튼 사용 금지
			}
	    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//채팅fxml 열렸을 때 초기값 메소드
			//채팅방 입장 전엔 아래fxid 사용 금지
		txtmsg.setEditable(false); //채팅입력창 수정 금지
		txtcontent.setDisable(true); //채팅창 목록 사용금지
		btnsend.setDisable(true); //전송버튼 사용 금지
	}
}
