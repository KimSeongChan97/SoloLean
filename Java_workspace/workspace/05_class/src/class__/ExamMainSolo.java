package class__; // 해당 클래스가 'class__' 패키지에 속함을 나타냄

import java.util.Scanner; // Scanner 클래스를 임포트하여 사용자 입력을 받기 위함

public class ExamMainSolo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        
        // 인원수 입력 받기
        System.out.print("인원수 입력: ");
        int size = scan.nextInt(); // 사용자로부터 인원수를 입력받아 num 변수에 저장
        
        // Exam 객체 배열 생성
        Exam[] ar = new Exam[size]; // 입력받은 인원수 크기의 Exam 객체 배열 생성, class 생성은 아님
        
        // 각 학생의 Exam 객체 생성 및 초기화
        for (int i = 0; i < size; i++) {
        	ar[i] = new Exam(); // Exam 객체를 생성하여 배열의 각 요소에 할당
        	ar[i].compare();
        }
        
        // 결과 출력
        System.out.println();
        System.out.println("\n이름\t1\t2\t3\t4\t5\t점수"); // 결과 표의 헤더를 출력
        for(int i=0; i<size; i++) {
        	System.out.print(ar[i].getName() + "\t");
        	for (int j=0; j<ar[i].getOx().length; j++) {
        		System.out.print(ar[i].getOx()[j] + "\t");
        	} // for j
        	System.out.println("\t" + ar[i].getScore() + "\t");
        	
        } // for i
        /*
        for (Exam student : ar) { // 학생 배열을 순회하며 각 학생의 정보를 출력
            System.out.print(student.getName() + "\t"); // 학생의 이름 출력
            for (char ch : student.getOx()) { // 학생의 OX 결과 배열을 순회하며 출력
                System.out.print(ch + "\t"); // 각 결과를 출력
            }
            System.out.println(student.getScore()); // 학생의 점수를 출력하고 줄바꿈
        }
        */
        scan.close();
    }
}

/*

[문제] 사지선다형
- 문제수는 총 5문제를 제공한다.
- 1문제당 20점씩 처리한다.
- 정답은 "11111" 으로 고정한다. (명칭은 "JUNGDAP" 으로 한다.)
- Main 메소드 에서 인원수 입력 : 만 입력받는다.
- Scanner 이하의 메소드는 메인 이전에 클래스에서 적용한다.

클래스명 : Exam
* 필드
private String name = null;
private String dap = null;
private char[] ox = null;
private int score = 0;
private final String JUNG = "11111"; //상수화

* 메소드
생성자 - Scanner 써서 이름, 답을 입력 받는다.
compare() - 비교
getName()
getOx()
getScore()

클래스명 : ExamMain

[실행결과]
인원수 입력 : 3

이름 입력 : 홍길동
답 입력 : 12311

이름 입력 : 김태리
답 입력 : 12341 

이름 입력 : 유연석
답 입력 : 12111 

이름      1 2 3 4 5   점수
홍길동     O X X O O   60
김태리     O X X X O   40
유연석     O X O O O   80



*/