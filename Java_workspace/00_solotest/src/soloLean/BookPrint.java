package soloLean;

// BookPrint 클래스는 도서 목록을 출력합니다.
public class BookPrint implements Book {
    private BookService bookService;

    // 생성자: BookService 객체를 초기화합니다.
    public BookPrint(BookService bookService) {
        this.bookService = bookService;
    }

    // 도서 목록을 출력하는 메서드
    public void execute() {
        // 도서 목록을 순회하며 각 도서 정보를 출력합니다.
        for (BookDTO book : bookService.getBookList()) {
            System.out.println(book);
        }
    }
}
