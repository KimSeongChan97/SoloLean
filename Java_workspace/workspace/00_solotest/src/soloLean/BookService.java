package soloLean;

import java.util.ArrayList;

// BookService 클래스는 도서 관련 기능을 제공합니다.
public class BookService {
    private ArrayList<BookDTO> bookList = new ArrayList<>(); // 도서 목록을 저장할 리스트

    // 도서 목록을 설정하는 메서드
    public void setBookList(ArrayList<BookDTO> bookList) {
        this.bookList = bookList;
    }

    // 도서 목록을 가져오는 메서드
    public ArrayList<BookDTO> getBookList() {
        return bookList;
    }

    // 도서를 추가하는 메서드
    public void insertBook(BookDTO book) {
        bookList.add(book);
    }

    // 도서 제목을 기준으로 오름차순 정렬하는 메서드
    public void sortTitleAsc() {
        bookList.sort(new BookTitleAsc());
    }

    // 도서 제목을 검색하는 메서드
    public void searchByTitle(String title) {
        // 대소문자를 구분하지 않고 도서 제목을 검색하여 출력합니다.
        for (BookDTO book : bookList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
            }
        }
    }
}
