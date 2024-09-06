package soloLean;

import java.util.Scanner;

// BookInsert 클래스는 도서를 추가하는 기능을 제공합니다.
public class BookInsert implements Book {
    private BookService bookService;

    // 생성자: BookService 객체를 초기화합니다.
    public BookInsert(BookService bookService) {
        this.bookService = bookService;
    }

    // 새로운 도서를 추가하는 메서드
    public void execute() {
        Scanner scan = new Scanner(System.in);

        // 사용자로부터 도서 정보를 입력받습니다.
        System.out.print("도서 코드: ");
        String code = scan.nextLine();
        
        System.out.print("도서 제목: ");
        String title = scan.nextLine();
        
        System.out.print("도서 저자: ");
        String author = scan.nextLine();
        
        System.out.print("도서 단가: ");
        int price = scan.nextInt();
        
        System.out.print("도서 개수: ");
        int qty = scan.nextInt();

        // 입력받은 정보를 사용하여 BookDTO 객체를 생성합니다.
        BookDTO book = new BookDTO(code, title, author, price, qty);
        // 생성된 BookDTO 객체를 BookService에 추가합니다.
        bookService.insertBook(book);

        // 도서 추가 완료 메시지를 출력합니다.
        System.out.println("도서 추가 완료");
    }
}
