package book;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class BookFileRead implements Book {

	@Override
	public void execute(List<BookDTO> list) {
		System.out.println();

		list.clear(); //List안의 항목을 지우기

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));

			//파일에서 List 꺼내오기
			List<BookDTO> loadList = (List<BookDTO>)ois.readObject();
			for(BookDTO bookDTO : loadList) {
				list.add(bookDTO);
			}

			//파일에서 BookDTO를 꺼내오기
			/*
			while(true) {
				try {
					BookDTO bookDTO = (BookDTO)ois.readObject();
					list.add(bookDTO);					

				}catch(EOFException e) {
					break;
				}

			}//while
			 */

			ois.close();

			System.out.println("파일에서 모든 항목을 로드하였습니다.");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}










