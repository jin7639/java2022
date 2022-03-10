package Day07;

public class Book {//cs

	//1.필드
	String ISBN;	//isbn 
	String bname;	//도서명
	String bwriter;	//작가
	boolean brental;	//도서대여여부
	String mid;		//대여인 ID
	
	//2.생성자
		//1.빈 생성자
	public Book() {}
	
		//2.모든 필드 생성자
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	
	//3.메소드
		//1.도서검색
	void 도서검색() {
		System.out.println("--------------도서 검색-------------");
		System.out.println("검색 : "); String bname = Day07_5_BookApplication.scanner.next();
		
	}
		//2.도서목록
	void 도서목록() {
		System.out.println("--------------도서 목록-------------");
		System.out.println("ISBN\t도서명\t작가\t대여가능여부");
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null) {//도서가 존재하면
				if (temp.brental) {//도서 대여가 가능하면 [해당 도서의 도서 대여 여부가 true이면
					System.out.println( temp.ISBN +"\t" +temp.bname+"\t" +temp.bwriter+"\t" +"가능");
				}else //해당도서의 도서대여여부가 false이면
					System.out.println( temp.ISBN +"\t" +temp.bname+"\t" +temp.bwriter+"\t" +"대여중");
			}
		}
		
		
	}
		//3.도서대여
	void 도서대여(String loginid) {
		System.out.println("--------------도서 대여-------------");
		System.out.println("검색 : ");	String iSBN = Day07_5_BookApplication.scanner.next();
		for(Book temp : Day07_5_BookApplication.books) {
			if ( temp !=null && temp.ISBN.equals(iSBN)) {
				if (temp.brental) {
					System.out.println("대여 완료");
					temp.brental = false;
					temp.mid = loginid;
					return;
				}
			}else {
				System.out.println("다른 사람이 대여중인 도서입니다! [대여불가]");
			}
		}
		
	}
		//4.도서반납
	void 도서반납(String loginid) {
		System.out.println("--------------도서 반납-------------");
		대출목록(loginid);
		System.out.println("검색 : "); String ISBN = Day07_5_BookApplication.scanner.next();
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.ISBN.equals(iSBN)) {
				if (temp.mid) {
					
				}
			}
		}
	}
		
		//현재 로그인 한 회원이 대여중인 도서 목록
	void 대출목록(String loginid) {
		System.out.println("--------------대출 목록-------------");
		System.out.println("ISBN\t도서명\t작가\t대여가능여부");
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.mid.equals(loginid)) {//도서가 존재하면서 대여id와 현재 로그인된 id와 같으면
					System.out.println( temp.ISBN +"\t" +temp.bname+"\t" +temp.bwriter+"\t" +"가능");
				}
			}
		}
	
		//5.도서등록
	void 도서등록() {
		System.out.println("--------------도서 등록-------------");
		//1.입력받기
		System.out.println("ISBN : "); String iSBN = Day07_5_BookApplication.scanner.next();
		System.out.println("도서명 : "); String bname = Day07_5_BookApplication.scanner.next();
		System.out.println("작가 : "); String bwriter = Day07_5_BookApplication.scanner.next();
		
			//isbn중복체크
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp != null && temp.ISBN.equals(iSBN)) {
				System.out.println("이미 등록된 도서입니다. [등록실패]");
				return; //도서 등록 메소드 종료 ->등록 실패
			}
		}
		
		//2.객체화
		Book book = new Book(iSBN, bname, bwriter, true, null);
		
		//3.배열 대입
		int i = 0;
		for (Book temp : Day07_5_BookApplication.books) {
			if (temp == null) {
				Day07_5_BookApplication.books[i] = book;
				System.out.println("도서를 등록하였습니다!");
				return;
			}
			i++;
		}
		
	}
	
		//6.도서삭제
	void 도서삭제() {
		System.out.println("--------------도서 삭제-------------");
		
	}
	
	
}//ce
