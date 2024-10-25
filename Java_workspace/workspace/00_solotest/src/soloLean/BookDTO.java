package soloLean;

import java.io.Serializable;

// BookDTO 클래스는 도서 정보를 저장하는 데이터 전송 객체(Data Transfer Object)입니다.
public class BookDTO implements Serializable {
    private String code; // 도서 코드
    private String title; // 도서 제목
    private String author; // 도서 저자
    private int price; // 도서 가격
    private int qty; // 도서 수량
    private int total; // 도서 총 가격 (가격 * 수량)

    // 기본 생성자
    public BookDTO() {} 

    // 변수 생성자: 도서의 세부 정보를 초기화합니다.
    public BookDTO(String code, String title, String author, int price, int qty) {
        this.code = code;
        this.title = title;
        this.author = author; 
        this.price = price;
        this.qty = qty; 
        this.total = price * qty; // 총 가격 계산
    }

    // getter와 setter 메서드들: 각 필드의 값을 읽거나 설정합니다.
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // 도서 정보를 문자열로 변환하는 toString 메서드
    @Override
    public String toString() {
        return code + "\t" + title + "\t" + author + "\t" + price + "\t" + qty + "\t" + total;
    }
}

