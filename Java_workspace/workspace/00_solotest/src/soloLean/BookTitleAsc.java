package soloLean;

import java.util.Comparator;

// BookTitleAsc 클래스는 도서 제목을 기준으로 오름차순 정렬하는 Comparator입니다.
public class BookTitleAsc implements Comparator<BookDTO> {
    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        // 대소문자 구별 없이 정렬합니다.
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}
