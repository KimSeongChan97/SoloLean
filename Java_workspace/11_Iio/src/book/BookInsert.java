package book;

import java.util.List;
import java.util.Scanner;

public class BookInsert implements Book {

	@Override
	public void execute(List<BookDTO> list) {
		System.out.println();
		Scanner scan = new Scanner(System.in);

		System.out.print("코드 입력 : ");
		String code = scan.next();

		System.out.print("제목 입력 : ");
		String title = scan.next();

		System.out.print("저자 입력 : ");
		String author = scan.next();

		System.out.print("가격 입력 : ");
		int price = scan.nextInt();

		System.out.print("수량 입력 : ");
		int qty = scan.nextInt();

		int total = price * qty;

		BookDTO bookDTO = new BookDTO(code, title, author, price, qty);
		bookDTO.setTotal(total);

		list.add(bookDTO);

		System.out.println("항목을 추가하였습니다.");
	}

}











