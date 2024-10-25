package book;

import java.util.List;

public class BookPrint implements Book {

	@Override
	public void execute(List<BookDTO> list) {
		System.out.println();

		System.out.println("코드\t제목\t저자\t가격\t수량\t합계");
		for(BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}//for

	}

}
