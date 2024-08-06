package book;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BookDTO implements Serializable {
	@NonNull
	private String code;    // 코드
	@NonNull
	private String title;   // 제목
	@NonNull
	private String author;  // 저자
	@NonNull
	private int price;      // 가격
	@NonNull
	private int qty; 	    // 수량
	private int total;      // 총합

	@Override
	public String toString() {
		return code + "\t"
				+ title + "\t"
				+ author + "\t"
				+ price + "\t"
				+ qty + "\t"
				+ total;
	}

}












