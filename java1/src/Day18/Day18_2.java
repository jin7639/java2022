package Day18;

import java.util.Vector;

public class Day18_2 {

	public static void main(String[] args) {
		//p.730
			//	ArrayList 	vs 	Vector
		//����ȭ 		X				O
		//������	�̱۽�����(main)	��Ƽ������(Thread, Runnable)
		
		
		//Vector Ŭ����
		//1.Vector ����Ʈ��ü ����
		Vector<Board> list= new Vector<>();
		//2.����Ʈ��ü�� �߰�
			//1.����Ʈ�� ��ü �ٷ� �߰� new : ��ü �޸��Ҵ�
		//2.
		Board board = new Board("����2","����2","�۾���2");
		list.add(board);
		list.add(new Board("����3", "����3", "�ۼ���3"));
			
		System.out.println("Ȯ�� : " + list);
		//3.�˻�
		System.out.println("��ü �˻� : " + list.contains(board));
		System.out.println("��ü �˻� ��ġ : " + list.indexOf(board));
		//4.����
		list.remove(2); System.out.println("2�� �ε��� ���� �� : "+ list);
		list.remove(2); System.out.println("2�� �ε��� ���� �� : "+ list);
		//�ݺ��� �̿��� ����Ʈ ��ü�� ��� ��ü ���
		for (int i = 0; i < list.size(); i++) {
			Board temp = list.get(i);
			System.out.println(temp.����+"\n"+temp.����+"\n"+temp.�ۼ���);
		}
		//�ݺ���2
		System.out.println("--------------------------------");
		System.out.println("����\t����\t�ۼ���");
		for (Board temp : list) {
			System.out.println(temp.����+"\n"+temp.����+"\n"+temp.�ۼ���);
		}
	}
	
}
