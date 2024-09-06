package soloLean;

import java.util.Scanner;

// BookTitleSearch 클래스는 도서 제목을 검색합니다.
public class BookTitleSearch implements Book {
    private BookService bookService;

    // 생성자: BookService 객체를 초기화합니다.
    public BookTitleSearch(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);

        // 검색할 도서 제목을 입력받습니다.
        System.out.print("검색할 책 제목: ");
        String title = scan.nextLine();

        // 입력받은 제목을 바탕으로 도서를 검색합니다.
        bookService.searchByTitle(title);
    }
}
