package class_;

import java.util.Scanner;

public class ComputeMainSolo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        
        System.out.print("횟수 입력 : "); // 횟수 입력 안내 메시지 출력
        int size = scan.nextInt(); // 사용자가 입력한 횟수를 size 변수에 저장
        
        ComputeDTO[] ar = new ComputeDTO[size]; // size 만큼의 ComputeDTO 객체 배열을 생성
        
        //입력
        
        for(int i=0; i<ar.length; i++) {
        	ar[i] = new ComputeDTO(); // 객체 생성
        	System.out.println("ar[" + i + "] = " + ar[i]);
        	
        	System.out.print("X 입력 :");
        	ar[i].setX(scan.nextInt());
        	System.out.println("Y 입력 : ");
        	ar[i].setY(scan.nextInt());
        	
        	ar[i].calc();
        	System.out.println();
        }
        
        System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV"); // 결과 표 헤더 출력
        for (int i = 0; i < ar.length; i++) {
            // 각 객체의 계산 결과를 출력
            System.out.println(ar[i].getX() + "\t"
                    + ar[i].getY() + "\t"
                    + ar[i].getSum() + "\t"
                    + ar[i].getSub() + "\t"
                    + ar[i].getMul() + "\t"
                    + ar[i].getDiv());
        }
        
        
        scan.close();
	}

}
