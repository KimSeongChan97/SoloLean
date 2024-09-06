package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukService {
	// 성적 정보를 저장하는 리스트
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	private Scanner scan = new Scanner(System.in); 
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num;
		SungJuk sungJuk = null; // 리모트 
		
		while (true) {
			 System.out.println("\n********************");
	            System.out.println("  1. 입력");
	            System.out.println("  2. 출력");
	            System.out.println("  3. 수정");
	            System.out.println("  4. 삭제");
	            System.out.println("  5. 정렬");
	            System.out.println("  6. 끝");
	            System.out.println("********************");
	            System.out.print("번호: ");
	            num = scan.nextInt();
	            
	            if (num==6) break;
	            else if (num==1) {
	            	sungJuk = new SungJukInsert();
	              	//System.out.println(list); 디버깅
	            }
	            else if (num==2) {
	            	sungJuk = new SungJukPrint();
	            }
	            else if (num==3) {
	            	sungJuk = new SungJukUpdate();
	            }
	            else if (num==4) {
	            	sungJuk = new SungJukDelete();
	            }
	            else if (num==5) {
	            	sungJuk = new SungJukSort2();
	            }
	            else { System.out.println(" 1~6 중에 선택하세요.");
	            		continue;
	            }
	            sungJuk.execute(list);
		} // while
		
	}// menu
	
}
