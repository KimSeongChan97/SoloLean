package class_;

import java.util.Scanner;

public class ComputeMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        
        System.out.print("횟수 입력 : "); // 횟수 입력 안내 메시지 출력
        int size = scan.nextInt(); // 사용자가 입력한 횟수를 size 변수에 저장
        
        ComputeDTO[] ar = new ComputeDTO[size]; // size 만큼의 ComputeDTO 객체 배열을 생성
        
        // 각 배열 요소에 ComputeDTO 객체를 생성하여 할당
        for (int i = 0; i < size; i++) {
            ar[i] = new ComputeDTO(); // 배열의 각 요소에 새로운 ComputeDTO 객체를 할당
        }
        
        // 사용자로부터 입력받아 각 객체에 데이터 설정
        for (int i = 0; i < size; i++) {
            System.out.print("X 입력 : "); // X값 입력 안내 메시지 출력
            int x = scan.nextInt(); // 사용자가 입력한 X값을 변수 x에 저장
            System.out.print("Y 입력 : "); // Y값 입력 안내 메시지 출력
            int y = scan.nextInt(); // 사용자가 입력한 Y값을 변수 y에 저장
            
            ar[i].setX(x); // 객체의 x 값 설정
            ar[i].setY(y); // 객체의 y 값 설정
        }
        System.out.println(); // 줄바꿈
        
        // 각 객체에 대해 계산 수행
        for (ComputeDTO dto : ar) {
            dto.calc(); // 각 객체의 계산 메서드를 호출하여 계산 수행
        }
        
        // 결과 출력
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



/*
[문제] 합, 차, 곱, 몫 구하시오

[실행결과]
횟수 입력 : 3

x 입력 : 320
y 입력 : 258

x 입력 : 256
y 입력 : 125

x 입력 : 452
y 입력 : 365


X Y SUM SUB MUL DIV
320 258
256 125
452 365


*/