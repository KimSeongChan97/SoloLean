package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
	private List<BookDTO> list = new ArrayList<BookDTO>(); //부모 = 자식

	public void menu() {
		Scanner scan = new Scanner(System.in);
		Book book = null;
		int num;

		while(true) {
			System.out.println();
			System.out.println("*************************");
			System.out.println("   1. 등록");
			System.out.println("   2. 출력");
			System.out.println("   3. 파일 저장");
			System.out.println("   4. 파일 읽기");
			System.out.println("   5. 책 제목으로 오름차순");
			System.out.println("   6. 책 제목 검색");
			System.out.println("   7. 종료");
			System.out.println("*************************");
			System.out.print("   번호 선택 : ");
			num = scan.nextInt();

			if(num == 7) break;
			if(num == 1) 
				book = new BookInsert(); //부모 = 자식, 다형서
			else if(num == 2) 
				book = new BookPrint();
			else if(num == 3)
				book = new BookFileWrite();
			else if(num == 4)
				book = new BookFileRead();
			else if(num == 5)
				book = new BookTitleAsc();
			else if(num == 6)
				book = new BookTitleSearch();

			book.execute(list);//호출

		}//while
	}//menu()



}










