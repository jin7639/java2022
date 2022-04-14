package Day14;

import java.util.Scanner;

public class Day14_플레이어 {

	//예제 [ 1.소리재생/중지 2. 영상재생/중지 ]
		
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean soundsw = true;
		boolean moviesw = true;
		
		while(true) {
			System.out.println("1.소리 재생 2. 영상재생 | 선택 :");
			int ch = scanner.nextInt();
			
			if (ch == 1) {
				Sound sound = new Sound(); //빈객체 생성
				
				
				if (soundsw ) {
					sound.soundstop(true);	//소리 실행
					sound.start();	//스레드 실행
					//sound.stop = false; //소리 종료
						//stop 필드에 직접 변경시 -> 바로 종료
					soundsw = false; //실행중 기록
				}else {
					sound.soundstop(false); //소리 중지
					//sound.stop = true;
					soundsw = true;	//실행종료 기록
				}
			}else if (ch == 2) {
				
				Movie movie = new Movie(); //제어 변경
				if (moviesw) {
					movie.Moviestop(true); //제어 변경
					movie.start(); //스레드 실행
					moviesw = false;
				}else {
					movie.Moviestop(false); //제어변경
					moviesw = true; //상태변경
				}
				
				
				
			}
		}
		
		
	}
	
}
