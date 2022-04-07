package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Server;

public class Client {
	//서버에 들어오는 클라이언트의 클래스
	
	//1. 필드 [ 소켓 ]
	public Socket socket;
	
	//2.생성자
	public Client (Socket socket) {
		this.socket = socket;
		receive(); //서버와 연결된 클라이언트 객체가 생성될때 받기 메소드 실행
	}
	
	//3. 서버로 메시지 받는 메소드 [ 서버와 클라이언트가 연결되었을때]
	public void receive() { //멀티스레드
		
		//멀티스레드 [Thread 클래스 vs Runnable 인터페이스 ]
			//run 메소드를 필수적으로 구현해야함
		//인터페이스는 추상메소드가 존재하기 때문에 구현필수 [ 클래스에서 implement]
		Runnable runnable = new Runnable() {
			@Override
			public void run() { //추상메소드 구현
				//계속적으로 메시지 받는 상태
				try { 
					while(true) {
						InputStream inputStream = socket.getInputStream();
						byte[] bytes = new byte[1000];
						inputStream.read(bytes);
						String msg = new String(bytes);
						// 서버가 받은 메시지를 현재 서버에 접속된 모든 클라이언트에게 보내기
						for ( Client client : Server.clientlist ) {
							client.send(msg); //받은 메시지를 서버에 접속된 [clientlist] 모든 클라이언트에게 보내기
						}
					}
				} catch (Exception e) {}
			}
		};//멀티스레드 구현 끝
		
		//해당 멀티스레드를 스레드풀에 넣어주기
		Server.threadpool.submit(runnable);
	}

	//4. 서버가 메세지 보내는 메소드 [서버가 메시지를 받았을때]
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
		// 멀티스레드  구현 끝 
		Server.threadpool.submit(runnable); // 해당 멀티스레드를 스레드풀에 넣어주기 
	}
	
}
