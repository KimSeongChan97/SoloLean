package soloLean;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// BookFileRead 클래스는 파일에서 도서 데이터를 읽어옵니다.
public class BookFileRead implements Book {
    private BookService bookService;

    // 생성자: BookService 객체를 초기화합니다.
    public BookFileRead(BookService bookService) {
        this.bookService = bookService;
    }

    // 파일에서 도서 목록을 읽어오는 메서드
    public void execute() {
        ArrayList<BookDTO> bookList = new ArrayList<>(); // 읽어온 도서 목록을 저장할 리스트
        try {
            // 파일 입력 스트림과 객체 입력 스트림을 생성합니다.
            FileInputStream fileInputStream = new FileInputStream("bookData.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // 파일에서 객체를 읽어와 도서 리스트에 추가합니다.
            while (true) {
                BookDTO book = (BookDTO) objectInputStream.readObject();
                if (book != null) {
                    bookList.add(book);
                }
            }
        } catch (Exception e) {
            // 예외가 발생할 경우 스택 트레이스를 출력합니다.
            e.printStackTrace();
        }
        // 읽어온 도서 목록을 BookService에 설정합니다.
        bookService.setBookList(bookList);
    }
}
