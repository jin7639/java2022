package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

	//모든 메소드는 static
	//0. 게시물 리스트 [모든 게시물을 담는 리스트]
	static ArrayList<Board> boardlist =
			new ArrayList<>();
	
	//2.쓰기 메소드
	public static void write(String 제목, String 내용, String 작성자, String 비밀번호) {
		//1.객체화
		Board board = new Board(제목, 내용, 비밀번호, 작성자);
		//2.리스트에 저장 [메모리]
		boardlist.add(board);
		//3.파일에저장
		save();
	}
	
	//4.수정 메소드
	Scanner scanner = new Scanner(System.in);
	public static boolean update(int index, String password, String title, String content) {
		if (password.equals(boardlist.get(index).getPassword())) {
			//수정처리
			boardlist.get(index).setTitle(title);
			boardlist.get(index).setContents(content);
			save();
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	//5.삭제 메소드				//현재 게시물 번호[인덱스] 현재 게시물 비밀번호
	public static boolean delete(int index, String password) {
		if (password.equals(boardlist.get(index).getPassword())) {
			//입력받은 비밀번호와 해당 인덱스 게시물 번호의 비밀번호가 동일하면
			boardlist.remove(index);
			save();
			return true;
		}else {
			return false;
		}
	}
	
	//6.댓글쓰기 메소드
	public static void replywriter() {
		
	}
	
	//7.게시물 저장 메소드
	public static void save() {
		//리스트 내 모든 게시물을 파일에 저장
		try {
			//1.파일출력 클래스
			FileOutputStream outputStream = new FileOutputStream("D:/java/게시물파일.txt");
			//2.파일에 작석할 내용 [한줄씩 = 게시물 1개씩 = 객체 1개씩]
			for (Board board : boardlist ) {
				String 작성내용 = board.getTitle()+","+board.getContents()+","+board.getPassword()+","+
						board.getWriter()+","+board.getViewcount()+","+board.getDate()+"\n";
				//3.내용[문자열] -> 바이트열 변환
				//4.내보내기 [write()]
				outputStream.write(작성내용.getBytes());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("파일저장 실패");
		}
	}
	
	//8.게시물 불러오기 메소드 
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/게시물파일.txt");
			
			//2.바이트 배열 선언
			byte[]bytes = new byte[1000];
			//3.모든 바이트 읽어와서 바이트에 저장
			inputStream.read( bytes );
			//4.바이트 -> 문자열 변환
			String file = new String(bytes);
			//5.문자열 자르기 [한줄씩 [\n] -> 1개 객체]
			String[] boards = file.split("\n");
			int i = 0;//인덱스 용
			for(String temp : boards) {//배열내 문자열을 하나씩 꺼내오기
				//6.문자열 자르기 [한줄[,] ->각필드]
				if(i+1 == boards.length) break;
				String[] field = temp.split(",");
				Board board = new Board( field[0], field[1], field[2], field[3], 
						Integer.parseInt(field[4]),field[5],null ); 
			//7.객체화
			
			//8.리스트 담기
				boardlist.add(board);
				i++;
			}
			
		} catch (Exception e) {
			System.err.println("파일로드 실패");
		}
		
	}
	
}
