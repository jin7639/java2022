package Day07;

public class Book {//cs

	//1.�ʵ�
	String ISBN;	//isbn 
	String bname;	//������
	String bwriter;	//�۰�
	boolean brental;	//�����뿩����
	String mid;		//�뿩�� ID
	
	//2.������
		//1.�� ������
	public Book() {}
	
		//2.��� �ʵ� ������
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	
	//3.�޼ҵ�
		//1.�����˻�
	void �����˻�() {
		System.out.println("--------------���� �˻�-------------");
		System.out.println("�˻� : "); String bname = Day07_5_BookApplication.scanner.next();
		
	}
		//2.�������
	void �������() {
		System.out.println("--------------���� ���-------------");
		System.out.println("ISBN\t������\t�۰�\t�뿩���ɿ���");
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null) {//������ �����ϸ�
				if (temp.brental) {//���� �뿩�� �����ϸ� [�ش� ������ ���� �뿩 ���ΰ� true�̸�
					System.out.println( temp.ISBN +"\t" +temp.bname+"\t" +temp.bwriter+"\t" +"����");
				}else //�ش絵���� �����뿩���ΰ� false�̸�
					System.out.println( temp.ISBN +"\t" +temp.bname+"\t" +temp.bwriter+"\t" +"�뿩��");
			}
		}
		
		
	}
		//3.�����뿩
	void �����뿩(String loginid) {
		System.out.println("--------------���� �뿩-------------");
		System.out.println("�˻� : ");	String iSBN = Day07_5_BookApplication.scanner.next();
		for(Book temp : Day07_5_BookApplication.books) {
			if ( temp !=null && temp.ISBN.equals(iSBN)) {
				if (temp.brental) {
					System.out.println("�뿩 �Ϸ�");
					temp.brental = false;
					temp.mid = loginid;
					return;
				}
			}else {
				System.out.println("�ٸ� ����� �뿩���� �����Դϴ�! [�뿩�Ұ�]");
			}
		}
		
	}
		//4.�����ݳ�
	void �����ݳ�(String loginid) {
		System.out.println("--------------���� �ݳ�-------------");
		������(loginid);
		System.out.println("�˻� : "); String ISBN = Day07_5_BookApplication.scanner.next();
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.ISBN.equals(iSBN)) {
				if (temp.mid) {
					
				}
			}
		}
	}
		
		//���� �α��� �� ȸ���� �뿩���� ���� ���
	void ������(String loginid) {
		System.out.println("--------------���� ���-------------");
		System.out.println("ISBN\t������\t�۰�\t�뿩���ɿ���");
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.mid.equals(loginid)) {//������ �����ϸ鼭 �뿩id�� ���� �α��ε� id�� ������
					System.out.println( temp.ISBN +"\t" +temp.bname+"\t" +temp.bwriter+"\t" +"����");
				}
			}
		}
	
		//5.�������
	void �������() {
		System.out.println("--------------���� ���-------------");
		//1.�Է¹ޱ�
		System.out.println("ISBN : "); String iSBN = Day07_5_BookApplication.scanner.next();
		System.out.println("������ : "); String bname = Day07_5_BookApplication.scanner.next();
		System.out.println("�۰� : "); String bwriter = Day07_5_BookApplication.scanner.next();
		
			//isbn�ߺ�üũ
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.ISBN.equals(iSBN)) {
				System.out.println("�̹� ��ϵ� �����Դϴ�. [��Ͻ���]");
				return; //���� ��� �޼ҵ� ���� ->��� ����
			}
		}
		
		//2.��üȭ
		Book book = new Book(iSBN, bname, bwriter, true, null);
		
		//3.�迭 ����
		int i = 0;
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp == null) {
				Day07_5_BookApplication.books[i] = book;
				System.out.println("������ ����Ͽ����ϴ�!");
				return;
			}
			i++;
		}
		
	}
	
		//6.��������
	void ��������() {
		System.out.println("--------------���� ����-------------");
		
	}
	
	
}//ce
