package Day19;

import java.util.TreeSet;

public class Day_19_5 {
	public static void main(String[] args) {
		
		//p.753 : TreeSet Ŭ����
			//1. �ϳ��� ��ü = ���
			//2. �� ���� �ִ� 2���� �ڽ� ��带 ���� �� �ִ�.
			//3. �θ𺸴� ������ ���� �ڽ� �θ𺸴� ũ�� ������ �ڽ� ���
			//4. Ʈ���������� ���� ���ʿ� ���� -> ���� ���� ��
			//			  ���� �����ʿ� ���� -> ���� ū ��
			//5. TreeSet<�����ڷ��� Ŭ����>
			//6. TreeSet<��������� Ŭ����> : Comparable , Comparator ���
		
		//1. TreeSet Ŭ������ ��ü ����
		TreeSet<Integer> scores = new TreeSet<>();
		//2. TreeSet ��ü�� ��ü(���) �߰�
		System.out.println("-----�ڵ� ����-----");
		scores.add(87);	System.out.println("Ȯ�� : " + scores);
		scores.add(98);	System.out.println("Ȯ�� : " + scores);
		scores.add(75);	System.out.println("Ȯ�� : " + scores);
		scores.add(95);	System.out.println("Ȯ�� : " + scores);
		scores.add(80);	System.out.println("Ȯ�� : " + scores);
		//3. ��� ȣ��
		System.out.println(scores.first()); //75 -> ���� ���� ��� ȣ��
		System.out.println( scores.last()); //98 -> ���� ������ ��� ȣ��
		System.out.println( scores.lower(95)); //87 ->95 ���� ���� ��� ȣ��
		System.out.println( scores.higher(95)); //98 -> 95���� ������ ���
		//4.����
		System.out.println(scores.pollFirst()); //���� ���ʳ�� [ ���� ū] ����
		System.out.println(scores.pollLast());	//���� ������ ���[���� ����] ����
		System.out.println("Ȯ�� : " + scores);
		//5.�������� vs ��������
		//*��������[x:�⺻�� : �������� ]
		System.out.println("�⺻[��������] : " + scores);
		
		//*�������� [ .descendingSet() : �������� ]
		System.out.println("����[��������] : " + scores.descendingIterator());
		
		//������������ �ϳ��� ���
		System.out.println("---��������---");
		for (Integer temp :  scores) {
			System.out.println(temp);
		}
		//������������ �ϳ��� ���
		System.out.println("---��������---");
		for(Integer temp : scores.descendingSet() ) {
			System.out.println(temp);
		}
		
		
		
	}//me
}//ce
