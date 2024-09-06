package soloLean;

import java.util.Scanner;

// BookMain 클래스는 프로그램의 메인 진입점입니다.
public class BookMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookService bookService = new BookService();

        while (true) {
            // 사용자에게 메뉴를 출력합니다.
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 목록 보기");
            System.out.println("3. 도서 파일 저장");
            System.out.println("4. 도서 파일 읽기");
            System.out.println("5. 도서 제목 검색");
            System.out.println("6. 도서 제목 정렬");
            System.out.println("7. 종료");
            System.out.print("선택: ");
            int choice = scan.nextInt();

            Book book = null;

            // 사용자의 선택에 따라 적절한 Book 객체를 생성합니다.
            switch (choice) {
                case 1:
                    book = new BookInsert(bookService);
                    break;
                case 2:
                    book = new BookPrint(bookService);
                    break;
                case 3:
                    book = new BookFileWrite(bookService);
                    break;
                case 4:
                    book = new BookFileRead(bookService);
                    break;
                case 5:
                    book = new BookTitleSearch(bookService);
                    break;
                case 6:
                    bookService.sortTitleAsc();
                    break;
                case 7:
                    System.exit(0);
            }

            // 생성된 Book 객체가 null이 아니면 execute 메서드를 호출합니다.
            if (book != null) {
                book.execute();
            }
        }
    }
}


/*

[문제] 도서

- 필드는 코드, 책제목, 저자, 단가, 개수, 합계로 설정한다.
- 코드는 중복되지않게 입력한다.
  코드외의 다른 항목은 중복이 가능하다.
- 파일입출력 할 때는 파일명 "book.txt" 한다.
- 정렬할때는 Comparable, Comparator 둘 중에 하나를 쓴다.
- 검색할때는 책 제목으로 검색한다.
  단, 한글자만 입력해도, 입력한 문자를 포함한 모든 책을 검색한다.
  같은 제목은 모두 검색하는데 대소문자 구별없이 모두 출력한다.
- 합계 = 단가 * 개수

Package : book

Interface : Book.java

Class     : BookMain.java
            BookService.java
            BookDTO.java
            BookInsert.java
            BookPrint.java
            BookFileWrite.java
            BookFileRead.java
            BookTitleAsc.java
			BookTitleSearch.java

필드
code, title, author, price, qty, total

메뉴
1. 등록
2. 출력
3. 파일 저장
4. 파일 읽기
5. 책 제목으로 오름차순
6. 책 제목 검색
7. 끝

번호 선택 : 

조건
1. 입력
101 Java 김자바 35000 10
201 스프링 이봄 40000 5
301 HTML 이웹 25000 8
401 CSS 이웹 30000 2
501 JAVA 이자바 38000 7
601 html 최길도 32000 3


 */