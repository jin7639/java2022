package Day14;

import java.util.Scanner;

public class Day14_�÷��̾� {

	//���� [ 1.�Ҹ����/���� 2. �������/���� ]
		
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean soundsw = true;
		boolean moviesw = true;
		
		while(true) {
			System.out.println("1.�Ҹ� ��� 2. ������� | ���� :");
			int ch = scanner.nextInt();
			
			if (ch == 1) {
				Sound sound = new Sound(); //��ü ����
				
				
				if (soundsw ) {
					sound.soundstop(true);	//�Ҹ� ����
					sound.start();	//������ ����
					//sound.stop = false; //�Ҹ� ����
						//stop �ʵ忡 ���� ����� -> �ٷ� ����
					soundsw = false; //������ ���
				}else {
					sound.soundstop(false); //�Ҹ� ����
					//sound.stop = true;
					soundsw = true;	//�������� ���
				}
			}else if (ch == 2) {
				
				Movie movie = new Movie(); //���� ����
				if (moviesw) {
					movie.Moviestop(true); //���� ����
					movie.start(); //������ ����
					moviesw = false;
				}else {
					movie.Moviestop(false); //�����
					moviesw = true; //���º���
				}
				
				
				
			}
		}
		
		
	}
	
}
