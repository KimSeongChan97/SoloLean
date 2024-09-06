// abstract_ 패키지 선언
package abstract_;

import java.util.Calendar; // Calendar 클래스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

// CalendarEx 클래스 선언 - 달력을 생성하는 역할
class CalendarEx {
    private int year, month, week, lastDay; // 연도, 월, 주, 해당 월의 마지막 날짜를 저장할 변수들

    // 생성자 - 연도와 월을 입력받아 초기화
    public CalendarEx() {
        Scanner scan = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성
        System.out.print("년도 입력 : ");
        year = scan.nextInt(); // 사용자가 입력한 연도를 year 변수에 저장
        System.out.print("월 입력 : ");
        month = scan.nextInt(); // 사용자가 입력한 월을 month 변수에 저장
    }

    // 1일의 요일과 마지막 날짜를 계산하는 메서드
    public void calc() {
        // 시스템 날짜를 기준으로 Calendar 객체를 생성
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 기준으로 Calendar 객체 생성
        /*
        cal.set(Calendar.YEAR, year); // year 변수의 값을 Calendar 객체에 설정
        cal.set(Calendar.MONTH, month-1); // month 변수를 설정 (Calendar 클래스의 월은 0부터 시작하므로 -1 필요)
        cal.set(Calendar.DAY_OF_MONTH, 1); // 해당 월의 1일로 설정
        */
        // 위 코드를 한 줄로 줄여서 설정
        cal.set(year, month-1, 1); // 연도, 월(-1 적용), 일자를 설정

        // 1일의 요일을 계산
        week = cal.get(Calendar.DAY_OF_WEEK); // 해당 월의 1일이 무슨 요일인지 구함 (1: 일요일, 2: 월요일, ... 7: 토요일)
        System.out.println("첫째 주의 빼는 날짜 세기 : " + week); // 디버깅을 위한 출력문
        // 해당 월의 마지막 날짜를 계산
        lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 월의 마지막 날(일)을 구함
    }

    // 달력을 출력하는 메서드
    public void display() {
        System.out.println("일\t월\t화\t수\t목\t금\t토"); // 요일 헤더 출력

        // 1일의 요일까지 공백을 출력하여 달력의 첫 번째 주를 맞춤
        for (int i=1; i<week; i++) {
            System.out.print("\t"); // 요일 앞에 빈 칸을 추가
        }
        // 1일부터 마지막 날짜까지 출력
        for (int i=1; i<=lastDay; i++) {
            System.out.print(i + "\t"); // 날짜 출력

            // 요일이 토요일(7)일 경우 줄바꿈
            if (week % 7 == 0) System.out.println(); // 한 주의 끝마다 줄바꿈
            week++; // 요일 증가
        }
    }
}

// CalendarMain 클래스 선언
public class CalendarMain {

    // main 메서드 - 자바 애플리케이션의 시작점
    public static void main(String[] args) {
        // CalendarEx 클래스의 인스턴스를 생성하고 calc()와 display() 메서드를 호출
        CalendarEx calendarEx = new CalendarEx(); // CalendarEx 객체 생성
        calendarEx.calc(); // 1일의 요일과 마지막 날짜를 계산
        calendarEx.display(); // 달력을 출력
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
CalendarMain         

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