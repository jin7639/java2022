package application.Day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_client {
	
	public static void main(String[] args) {
		try {
			//1.���� �����
			Socket socket = new Socket();
			
			//2.���� �������� �����ϱ�
			while (true) {
				socket.connect(new InetSocketAddress("192.168.17.33", 5000));
				System.out.println("������ ���� ����");
				
				Scanner scanner = new Scanner(System.in);
				//3.������ ������ ������ : ��Ʈ���� �̿��� �ܺ� ��Ʈ��ũ ���
					//1. ������ �Է¹ޱ�
				System.out.print("�������� ���� �޽��� : "); String msg = scanner.nextLine();
					//2. ������ ��� ��Ʈ�� ��������
				OutputStream outputStream = socket.getOutputStream();
					//3. ��������
				outputStream.write(msg.getBytes());
				
				//4. �������� ������ �ޱ�
					//1.������ �Է� ��Ʈ��
				InputStream inputStream = socket.getInputStream();
					//2.����Ʈ �迭 ����
				byte[] bytes = new byte[1000];
					//3.�Է� ��Ʈ�����κ��� ����Ʈ ��������
					inputStream.read(bytes);
					System.out.println("������ ���� �޽��� : " + new String(bytes));
			}
			
		} catch (Exception e) {
//			System.out.println( "client " + e);
		}
	}
}
