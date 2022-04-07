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

    // 서버에 연결된 클라이언트를 저장하는 리스트
    public static Vector<Client> clientlist = new Vector<>();
    	//Vector 사용하는 이유 : 동기화(O) // 동기화 : 여러 스레드가 하나의 메소드에 접근할 경우 대기 상태 만드는 것
    // 멀티스레드를 관리해주는 스레드풀
    public static ExecutorService threadpool;
    
    // 1. 서버소켓 선언
    ServerSocket serverSocket;
    // 2. 서버실행 메소드
    public void serverstart() {
    	try {

    		// 1. 서버소켓 메모리 할당
    		serverSocket = new ServerSocket();
			// 2. 서버소켓 바인딩 [ ip 와 port 설정 ]
    		serverSocket.bind( new InetSocketAddress("127.0.0.1" , 1234));
    		
		} catch (Exception e) {
		}
			// 3. 클라이언트의 요청 대기 [ 멀티스레드 사용하는 이유 : 1. 연결 2.보내기 3.받기 동시 처리]
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						while(true) {
							Socket socket;
								socket = serverSocket.accept(); //1. 요청 수락후에 수락된 소켓을 저장
							clientlist.add(new Client(socket)); //2. 연결된 클라이언트 (연결된 소켓) 생성후에 리스트에 넣기
						}
					} catch ( Exception e) {
						
					} //요청 
				}
			};
			threadpool = Executors.newCachedThreadPool(); //스레드풀에 메모리 초기화 [할당]
			threadpool.submit(runnable); //위에서 구현된 멀티스레드를 스레드풀에 넣어주기
    }
    
    // 3. 서버종료 메소드
    public void serverstop() {
    	try {
	    	//1. 접속된 모든 클라이언트들의 소켓 닫기
	    	for ( Client client : clientlist ) {
	    		client.socket.close();
	    	}
	    	//2. 서버소켓 닫기
	    	serverSocket.close();
	    	//3. 스레드풀 닫기
	    	threadpool.shutdown();
    	} catch (Exception e) {
    		// TODO: handle exception
    	}
    }
	    
    @FXML
    void accserver(ActionEvent event) {//서버 실행 버튼
    	if (btnserver.getText().equals("서버실행")) {
			//만약에 버튼의 텍스트 "서버 실행"이면
    		txtserver.appendText("서버 실행합니다.\n");
    		//버튼의 텍스트 변경
    		btnserver.setText("서버중지");
		}else { //버튼의 텍스트가 "서버 중지"이면
			txtserver.appendText("서버 중지\n");
			btnserver.setText("서버 실행");
		}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtserver.setDisable(true);
		
	}
}
