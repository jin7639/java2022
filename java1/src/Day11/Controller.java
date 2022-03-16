package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

	//��� �޼ҵ�� static
	//0. �Խù� ����Ʈ [��� �Խù��� ��� ����Ʈ]
	static ArrayList<Board> boardlist =
			new ArrayList<>();
	
	//2.���� �޼ҵ�
	public static void write(String ����, String ����, String �ۼ���, String ��й�ȣ) {
		//1.��üȭ
		Board board = new Board(����, ����, ��й�ȣ, �ۼ���);
		//2.����Ʈ�� ���� [�޸�]
		boardlist.add(board);
		//3.���Ͽ�����
		save();
	}
	
	//4.���� �޼ҵ�
	Scanner scanner = new Scanner(System.in);
	public static boolean update(int index, String password, String title, String content) {
		if (password.equals(boardlist.get(index).getPassword())) {
			//����ó��
			boardlist.get(index).setTitle(title);
			boardlist.get(index).setContents(content);
			save();
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	//5.���� �޼ҵ�				//���� �Խù� ��ȣ[�ε���] ���� �Խù� ��й�ȣ
	public static boolean delete(int index, String password) {
		if (password.equals(boardlist.get(index).getPassword())) {
			//�Է¹��� ��й�ȣ�� �ش� �ε��� �Խù� ��ȣ�� ��й�ȣ�� �����ϸ�
			boardlist.remove(index);
			save();
			return true;
		}else {
			return false;
		}
	}
	
	//6.��۾��� �޼ҵ�
	public static void replywriter() {
		
	}
	
	//7.�Խù� ���� �޼ҵ�
	public static void save() {
		//����Ʈ �� ��� �Խù��� ���Ͽ� ����
		try {
			//1.������� Ŭ����
			FileOutputStream outputStream = new FileOutputStream("D:/java/�Խù�����.txt");
			//2.���Ͽ� �ۼ��� ���� [���پ� = �Խù� 1���� = ��ü 1����]
			for (Board board : boardlist ) {
				String �ۼ����� = board.getTitle()+","+board.getContents()+","+board.getPassword()+","+
						board.getWriter()+","+board.getViewcount()+","+board.getDate()+"\n";
				//3.����[���ڿ�] -> ����Ʈ�� ��ȯ
				//4.�������� [write()]
				outputStream.write(�ۼ�����.getBytes());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("�������� ����");
		}
	}
	
	//8.�Խù� �ҷ����� �޼ҵ� 
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/�Խù�����.txt");
			
			//2.����Ʈ �迭 ����
			byte[]bytes = new byte[1000];
			//3.��� ����Ʈ �о�ͼ� ����Ʈ�� ����
			inputStream.read( bytes );
			//4.����Ʈ -> ���ڿ� ��ȯ
			String file = new String(bytes);
			//5.���ڿ� �ڸ��� [���پ� [\n] -> 1�� ��ü]
			String[] boards = file.split("\n");
			int i = 0;//�ε��� ��
			for(String temp : boards) {//�迭�� ���ڿ��� �ϳ��� ��������
				//6.���ڿ� �ڸ��� [����[,] ->���ʵ�]
				if(i+1 == boards.length) break;
				String[] field = temp.split(",");
				Board board = new Board( field[0], field[1], field[2], field[3], 
						Integer.parseInt(field[4]),field[5],null ); 
			//7.��üȭ
			
			//8.����Ʈ ���
				boardlist.add(board);
				i++;
			}
			
		} catch (Exception e) {
			System.err.println("���Ϸε� ����");
		}
		
	}
	
}
