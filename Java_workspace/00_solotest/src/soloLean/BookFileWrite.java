package soloLean;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// BookFileWrite 클래스는 도서 데이터를 파일에 저장합니다.
public class BookFileWrite implements Book {
    private BookService bookService;

    // 생성자: BookService 객체를 초기화합니다.
    public BookFileWrite(BookService bookService) {
        this.bookService = bookService;
    }

    // 도서 데이터를 파일에 저장하는 메서드
    public void execute() {
        ArrayList<BookDTO> bookList = bookService.getBookList(); // 저장할 도서 목록을 가져옵니다.
        try {
            // 파일 출력 스트림과 객체 출력 스트림을 생성합니다.
            FileOutputStream fileOutputStream = new FileOutputStream("bookData.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // 도서 리스트의 각 객체를 파일에 씁니다.
            for (BookDTO book : bookList) {
                objectOutputStream.writeObject(book);
            }
            // 출력 스트림을 닫습니다.
            objectOutputStream.close();
        } catch (Exception e) {
            // 예외가 발생할 경우 스택 트레이스를 출력합니다.
            e.printStackTrace();
        }
    }
}
