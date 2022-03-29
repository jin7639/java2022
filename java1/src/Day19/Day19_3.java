package Day19;

import java.util.HashMap;

public class Day19_3 {
	public static void main(String[] args) {
	
		//1. Map �÷��� = json
			// * Ű(��ü) , ��(��ü) = ��Ʈ��
			//Ű : set �÷���	| �� : list �÷��� (�ߺ�����)
			//HashMap Ŭ����
				//1.map��ü��.put(Ű��ü, ����ü) : ��Ʈ��(Ű=��) �߰�
				//2.map��ü��.size() :��Ʈ�� ����
				//3.map��ü��.get(Ű��ü) : �ش� Ű�� �� ȣ��
				//4.map��ü��.keySet() : map ��ü�� ��� Ű ȣ��
				//5.map��ü��.values() : map ��ü�� ��� �� ȣ��
					//Ű(�ߺ�x)�� �˰� ������ ���� �� �� �ִ�.
					//for (�ӽð�ü�� : map��ü��.keySet()){}
				//6.map��ü��.remove(Ű��ü) : �ش� Ű�� ��Ʈ�� ����
				//7.map.��ü��.clear() : ��� ��Ʈ�� ����
		
		//List �÷��� : ����(�ε���) ���� = �迭 ����
		//Set �÷��� : �������� ���� = �ߺ��Ұ���
		//Map �÷��� : Ű Set�� �� List���� �̷���� ��Ʈ���� ������ ���� [ ���� X]
		
		//1.HashMap Ŭ������ ��ü ����
		HashMap<String, Integer> map = new HashMap<>();
		//HashMap : �÷��� ������ ��ũ map Ŭ����
			//<���׸�,  ���׸�> : key, value�� ������ ���׸�
				//map : map ��ü��(�ƹ��ų�)
					//new : ��ü ������ �޸��Ҵ�
						//HashMap<>() : ������
		//2.map ��ü�� �߰�
		map.put("�ſ��", 85);	System.out.println("Ȯ�� : " + map);
			//����Ʈ = [��ü, ��ü, ��ü]
			//��Ʈ = [��ü, ��ü, ��ü]
			//�� = {Ű, ��}
		map.put("ȫ�浿", 90);	System.out.println("Ȯ�� : " + map);
		map.put("���屺", 80);	System.out.println("Ȯ�� : " + map);
		//key �� �ߺ� �Ұ���
		map.put("ȫ�浿", 95);	System.out.println("Ȯ�� : " + map);
		//value�� �ߺ�����
		map.put("���缮", 95);
		
		//3. map��ü��.size() : map��ü�� ��Ʈ��(Ű+��)����
		System.out.println("map ��ü �� ��Ʈ�� ��  : " + map.size());
		
		//4.map��ü��.get(Ű) : map��ü�� Ű->��ȣ��
		System.out.println("map ��ü �� �� ȣ�� (Űȣ���->��ȣ��)" + map.get("���缮"));
		
		//5.��� key ȣ��
		System.out.println("map ��ü�� ��� Ű ȣ�� : " + map.keySet());
		//6.��� value ȣ��
		System.out.println("map ��ü�� ��� �� ȣ�� : " + map.values());
		
		//7. �ݺ��� [ key �ݺ��� �̿��ؼ� ��� value ȣ�� ����]
		for (String temp : map.keySet()) {
			System.out.println(temp +" : " +map.get(temp));
		}
		
		//8. ����
		map.remove("ȫ�浿"); System.out.println("Ȯ�� : " + map);
		//9.��� ����
		map.clear(); System.out.println("Ȯ�� : " + map);
		
		
		
	}//me
}//ce
