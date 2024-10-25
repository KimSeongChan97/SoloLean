package abstract_;

import java.util.Calendar; // Calendar 클래스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

// CalendarEx 클래스 선언 - 달력을 생성하는 역할
class CalendarEx1 {
    private int year, month, startDay, lastDay; // 연도, 월, 1일의 요일, 해당 월의 마지막 날짜를 저장할 변수들

    // 생성자 - 연도와 월을 입력받아 초기화
    public CalendarEx1(int year, int month) {
        this.year = year; // 입력받은 연도로 초기화
        this.month = month; // 입력받은 월로 초기화
        calc(); // 1일의 요일과 마지막 날짜를 계산하는 메서드 호출
    }

    // 1일의 요일과 마지막 날짜를 계산하는 메서드
    private void calc() {
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간 정보를 가진 Calendar 인스턴스 생성
        cal.set(year, month - 1, 1); // 입력받은 연도와 월의 1일로 설정 (월은 0부터 시작하므로 1을 빼줌)

        startDay = cal.get(Calendar.DAY_OF_WEEK); // 해당 월의 1일의 요일을 가져옴
        lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 월의 마지막 날짜를 가져옴
    }

    // 달력을 출력하는 메서드
    public void display() {
        System.out.println("년도 입력 : " + year + "\n월 입력 : " + month + "\n\n일   월   화   수   목   금   토"); // 연도와 월, 요일 헤더 출력

        // 1일 이전의 빈 공간 출력
        for (int i = 1; i < startDay; i++) {
            System.out.print("    "); // 1일의 요일에 맞추어 앞에 빈 공간을 출력
        }

        // 날짜 출력
        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%3d ", day); // 각 날짜를 출력
            if ((day + startDay - 1) % 7 == 0) System.out.println(); // 한 주가 끝날 때마다 줄 바꿈
        }
        System.out.println(); // 마지막 줄 바꿈
    }
}

// CalendarMainSolo 클래스 선언 - 메인 클래스
public class CalendarMainSolo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성하여 사용자 입력 받기 준비

        // 두 번 반복하여 두 개의 달력을 출력
        for (int i = 0; i < 2; i++) { 
            System.out.print("년도 입력 : "); // 사용자에게 연도 입력 요청
            int year = scanner.nextInt(); // 연도 입력 받기
            System.out.print("월 입력 : "); // 사용자에게 월 입력 요청
            int month = scanner.nextInt(); // 월 입력 받기
            new CalendarEx1(year, month).display(); // 입력받은 연도와 월로 CalendarEx 객체 생성 및 출력
        }

        scanner.close(); // Scanner 객체 닫기
    }
}




/*

[문제] 만년달력

[클래스]
CalendarEx
[필드]
필드는 원하는 것으로 직접 잡기 
[메소드]
생성자 : 년도, 월을 입력
- 기본생성자 : 입력
- 메소드 : calc() -> 매달 1일의 요일이 무엇인지? (Calendar에 메소드를 찾아서 수행)
                -> 매달 마지막이 28, 29, 30, 31 무엇인지? (Calendar에 메소드를 찾아서 수행)
         display() -> 출력
         
[클래스]
CalendarMainSolo         

[실행결과]
년도 입력 : 2024                  			년도 입력 : 2000
월 입력 : 1                     			월 입력 : 2

일   월   화   수   목   금   토         일   월   화   수   목   금   토
   1   2   3   4   5   6            1   2   3   4   5
7   8   9   10   11   12   13       6   7   8   9   10   11   12
14   15   16   17   18   19   20    13   14   15   16   17   18   19
21   22   23   24   25   26   27    20   21   22   23   24   25   26
28   29   30   31                  	27   28   29

*/