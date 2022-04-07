package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Day26_server {
	
	//통신용 서버 만들기
		//1.서버소켓 만들기
			// 서버 : 클라이언트에게 정보나 서비스를 제공해주는 컴퓨터
			// 소켓 : PC간의 통신 종착점
		//2. 서버소켓 바인딩
			//서버의 IP주소와 PORT번호 설정
				//ip : 통신 인식 번호 [ pc 식별 번호 ]
				//port : pc내 프로세스(프로그램)를 식별하는 번호
					//ip당 6만개 정도의 port 사용 가능
						//port 3306 : mysql 프로그램으로 연결
	
	public static void main(String[] args) {
		
		try {
			
			//1.서버소켓 만들기
			ServerSocket serverSocket = new ServerSocket();
			//2. 서버소켓 바인딩
			serverSocket.bind(new InetSocketAddress("192.168.17.33", 5000));
			
			//3.클라잉언트의 요청 대기
			while(true) {
				System.out.println("서버 연결 대기중");
				
				//4. 요청이 있을 경우 수락
				Socket socket = serverSocket.accept(); //서버소켓
				
				//5.수락된 소켓의 정보 확인
				InetSocketAddress socketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("클라이언트와 연결이 되었습니다. 연결된 클라이언트 : " + socketAddress.getHostName());
				
				//6.클라이언트 데이터 받기
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				System.out.println("클라이언트가 보낸 메시지 : " + new String(bytes));
			
				//7.클라이언트에게 데이터 보내기
					//1.데이터 입력받기
				Scanner scanner = new Scanner(System.in);
				System.out.print("클라이언트에게 보낼 메시지 : " );
				String msg = scanner.nextLine();
					//2. 소켓의 출력 스트림
				OutputStream outputStream = socket.getOutputStream();
					//3. 내보내기
				outputStream.write(msg.getBytes());
			
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println( "server" + e);
		}
	}
}
