package class__;

import java.util.Scanner;

public class StringBufferMain {
    private int dan; // 입력받은 단을 저장할 변수

    // 기본 생성자
    public StringBufferMain() {
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        System.out.print("원하는 단을 입력 : "); // 사용자에게 단 입력을 요청
        dan = scan.nextInt(); // 입력받은 단을 dan 변수에 저장
    }
    
    // 구구단을 출력하는 메서드
    public void output() {
        StringBuffer buffer = new StringBuffer(); // StringBuffer 객체 생성
        
        		//System.out.println(dan + " * " + i + " = " + dan*i);
		
    			// append 는 기존 문자열 마지막에 추가되는 것. (계속 이어줌)
        // 1부터 9까지 반복하여 구구단 출력
        for (int i = 1; i <= 9; i++) {
            // buffer에 구구단의 한 줄을 추가
            buffer.append(dan); // 입력받은 단을 추가
            buffer.append(" * "); // " * " 문자열을 추가
            buffer.append(i); // 현재 반복 횟수(i)를 추가
            buffer.append(" = "); // " = " 문자열을 추가
            buffer.append(dan * i); // 단과 현재 반복 횟수의 곱을 추가
            
            System.out.println(buffer); // buffer에 저장된 문자열을 출력
            
            // buffer의 내용을 삭제하여 다음 반복에서 재사용 가능하게 함
            buffer.delete(0, buffer.length()); // buffer의 모든 내용을 삭제
        }
    }
    
    public static void main(String[] args) {
        // StringBufferMain 객체를 생성하고 output 메서드를 호출하여 구구단 출력
        new StringBufferMain().output(); 
    }
}


/*
원하는 단을 입력해라

				
---------------
입력 : 2
---------------생성자 에서 만듦
2 * 1 = 2		output()으로 만듦
2 * 2 = 4
2 * 3 = 6
...
2 * 9 = 18

*/