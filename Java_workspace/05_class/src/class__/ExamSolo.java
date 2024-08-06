package class__;

import java.util.Scanner;

public class ExamSolo {
    // 필드 선언
    private String name = null; // 학생 이름
    private String dap = null; // 학생이 제출한 답안
    private char[] ox = null; // 정답과 비교한 OX 결과
    private int score = 0; // 학생 점수
    private final String JUNG = "11111"; // 정답 상수

    // 기본 생성자
    public ExamSolo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("이름 입력: ");
        name = scan.next();
        System.out.print("답 입력: ");
        dap = scan.next();
        compare(); // 입력 받은 답안과 정답 비교
    }

    // 정답과 학생의 답안을 비교하는 메소드
    private void compare() {
        ox = new char[5]; // OX 배열 초기화
        for (int i = 0; i < 5; i++) {
            if (dap.charAt(i) == JUNG.charAt(i)) {
                ox[i] = 'O';
                score += 20; // 맞춘 개수당 20점 추가
            } else {
                ox[i] = 'X';
            }
        }
    }

    // 학생 이름을 반환하는 메소드
    public String getName() {
        return name;
    }

    // OX 결과를 반환하는 메소드
    public char[] getOx() {
        return ox;
    }

    // 점수를 반환하는 메소드
    public int getScore() {
        return score;
    }
}
