package application.Day26;

import java.net.InetAddress;

public class Day26_1 {

	//��Ʈ��ũ : �� �� �̻��� ��ǻ�͵��� �����ϰ� ����� �� �ִ� ��
		//��Ÿ� : ���ڽ�ȣ�� ���� ����ϴ� ��� ��Ⱑ ���� ����ϱ� ���� �ϳ��� ��
		//�������� : ��ǻ�ͳ���/��ǻ�ͻ��� ������ ��ȯ ����� �����ϴ� ��Ģ[ü��] ��ȣ �̰� ��¥ ���̴� �ű���
			//SMTP : ���� ���� ��������  --->���� �̰� Ʋ���� ��¥ ���̾������°���
			//IP : ���ͳ� ��������		--->�̰� �� �ټ����� Ʋ����
	//TCP/IP
		//TCP : Transmission control Protocol ��� ����
		//IP : Internet Protocol address ��� �ν� ��ȣ[�ּ�-pc�ּ�-���ּ�] 0.0.0.0 ~ 255.255.255.255
			// �츮�� <---------����----------> ģ����
			//								ģ���� �ּ�
			// ����ǻ��<--------------------->���̹� ��ǻ��[Ȩ������]
			//								www.naver.com [�������ּ� : �����̱� ������ ����� �ܿ�� ����]
	
	public static void main(String[] args) {
		//1. ���� pc�� ip �ּ� Ȯ��
		//������ ��ư ->cmd �˻� -> ���������Ʈ
		//ipconfig �Է½� ��Ʈ��ũ(ip) ������ �� �� �ִ�.
		//2. �ڹٿ��� ip �ּ� Ȯ��
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
				//InetAddress Ŭ���� : ��Ʈ��ũ ������ ����
					//.getLocalHost() : ����pc =����pc ���� ȣ��
			System.out.println("���� pc�� ��Ʈ��ũ ��ü : "+ inetAddress);
			System.out.println("���� pc�̸� : "+ inetAddress.getHostName());
			System.out.println("���� pc ip�ּ� : "+ inetAddress.getHostAddress());
		//3. ���̹�ȸ�� ip �ּ� Ȯ��
			InetAddress inetAddress2 = InetAddress.getByName("www.naver.com");
			System.out.println("���̹� pc������ü : " + inetAddress2);
			System.out.println("���̹� pc �̸� : " + inetAddress2.getHostName());
			System.out.println("���̹� pc ip�ּ� : "+ inetAddress2.getHostAddress());
		//4. ���̽��� ip �ּ� Ȯ��
			InetAddress inetAddress3 = InetAddress.getByName("www.facebook.com");
			System.out.println("���̽��� pc������ü : " + inetAddress3);
			System.out.println("���̽��� pc �̸� : " + inetAddress3.getHostName());
			System.out.println("���̽��� pc ip�ּ� : "+ inetAddress3.getHostAddress());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
