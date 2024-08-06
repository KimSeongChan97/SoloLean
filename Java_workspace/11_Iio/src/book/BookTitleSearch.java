package book;

import java.util.List;
import java.util.Scanner;

public class BookTitleSearch implements Book {

	@Override
	public void execute(List<BookDTO> list) {
		System.out.println();
		Scanner scan = new Scanner(System.in);

		System.out.print("검색 할 제목을 입력 : ");
		String title = scan.next().toLowerCase();

		int sw=0;
		for(BookDTO bookDTO : list) {
			if(bookDTO.getTitle().toLowerCase().contains(title)) {
				System.out.println(bookDTO);
				sw=1;
			}
		}//for

		if(sw == 0)
			System.out.println("검색한 책이 없습니다.");

	}

}











