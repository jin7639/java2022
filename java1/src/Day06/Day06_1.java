package Day06;

import java.rmi.StubNotFoundException;
import java.util.Scanner;

public class Day06_1 {//cs
	
	//Ŭ����
		//1.Ŭ���� : ��{��
	  	//2.��ü(�ν��Ͻ�) :���赵 ������� �޸𸮸� �Ҵ���� ����
		//��) �ؾ Ʋ = Ŭ����
			//���, �а���,��, �� , ��ũ��->�ʵ�[�Ӽ�=����]
			//����, ������, -> �޼ҵ�[�ൿ]
			//�ؾ Ʋ�κ��� ������ �ؾ ����
				// ���� �ٸ� �ؾ ���� [�ؾ1, �ؾ2]
	
		//��2 ȸ�� = Ŭ����
			//���̵�, ��й�ȣ, �̸� ->�ʵ�
			//ȸ������, ���̵�ã��, ��й�ȣ ã�� ,ȸ��Ż��, �α���->�޼ҵ�
				//���� �ٸ� ȸ�� ����[ȸ��1 ȭ��2]
	public static void main(String[] args) {//ms
		
		
		//195p
		
		Student s1 = new Student();
		//1.Student : ���ǵ� Ŭ������
		//2.student : ��ü��[�ƹ��ų�] :��õ [Ŭ������ �ҹ���]
		//3.new ������ : �޸�(�������)����
		//4.Student() : �����ڸ�()
		//*��ü ������ 4���� �ʿ�!!
		
		System.out.println("s1������ Student ��ü�� �����մϴ�.");
		System.out.println(s1);
		
		Student s2 = new Student();
		System.out.println("s2 ������ �� �ٸ� Student ��ü�� �����մϴ�.");
		System.out.println(s2);
		
		
		
		
		
	}//me

	
	
	

}//ce