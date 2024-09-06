package book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookTitleAsc implements Book {

	@Override
	public void execute(List<BookDTO> list) {
		System.out.println();

		Comparator<BookDTO> com = new Comparator<BookDTO>() {
			@Override
			public int compare(BookDTO b1, BookDTO b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		};

		Collections.sort(list, com);
		System.out.println();

		System.out.println("코드\t제목\t저자\t가격\t수량\t합계");
		for(BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}//for

	}

}








