package book;

public class BookMain {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		bookService.menu();
		System.out.println("프로그램을 종료합니다.");

	}

}

/*
[문제] 도서

[조건]
1. 필드는 코드, 책제목, 저자, 단가, 개수, 합계로 설정한다.
2. 입력할 때 개발자가 알아서 코드는 중복되지않게 입력한다.
   코드외의 다른 항목은 중복이 가능하다.
3. 파일입출력 할 때는 파일명 "book.txt" 한다.
4. 정렬할때는 Comparable, Comparator 둘 중에 하나를 쓴다.
5. 검색할때는 책 제목으로 검색한다.
   단, 한글자만 입력해도, 입력한 문자를 포함한 모든 책을 검색한다.
   같은 제목은 모두 검색하는데 대소문자 구별없이 모두 출력한다.
6. 합계 = 단가 * 개수

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
101		Java	김자바	35000		10
201		스프링	이봄		40000		5
301		HTML	이웹		25000		8
401		CSS		이웹		30000		2
501		JAVA	이자바	38000		7
601		html	최길도	32000		3
 */








