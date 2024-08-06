package abstract_;

import java.text.ParseException; // 문자열을 Date 객체로 변환할 때 발생할 수 있는 예외를 처리하기 위해 import
import java.text.SimpleDateFormat; // 날짜 및 시간의 형식을 지정하기 위해 import
import java.util.Calendar; // Calendar 클래스를 사용하기 위해 import
import java.util.Date; // Date 클래스를 사용하기 위해 import
import java.util.GregorianCalendar; // GregorianCalendar 클래스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

public class Today {

    public static void main(String[] args) throws InterruptedException, ParseException {
        // Date 객체를 생성하여 현재 날짜와 시간을 가져옴
        Date date = new Date();
        System.out.println("오늘 날짜 : " + date); // 기본 Date 객체의 toString() 메서드를 사용하여 현재 날짜와 시간을 출력
        
        // SimpleDateFormat 객체를 생성하여 날짜와 시간을 원하는 형식으로 포맷팅
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        System.out.println("오늘 날짜 : " + sdf.format(date)); // 포맷팅된 날짜와 시간을 출력
        System.out.println(); // 빈 줄 출력
        
        // 사용자로부터 생일 입력을 받기 위한 포맷을 지정 (연도, 월, 일, 시간)
        SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHH");
        Scanner scan = new Scanner(System.in); // Scanner 객체를 생성하여 사용자 입력을 받을 준비를 함
        System.out.print("생일 날짜 입력 (yyyyMMddHH) : "); // 사용자에게 생일 입력을 요청
        String birth = scan.next(); // 사용자가 입력한 생일을 문자열로 받음
        Date birth_date = input.parse(birth); // 문자열을 Date 객체로 변환 (예외가 발생할 수 있음)
        
        // 변환된 Date 객체를 기본 형식으로 출력
        System.out.println("내 생일 : " + birth_date);
        // 변환된 Date 객체를 지정된 포맷으로 출력
        System.out.println("내 생일 : " + sdf.format(birth_date));
        System.out.println(); // 빈 줄 출력
        
        // Calendar 객체를 생성하기 위한 여러 방법
        // Calendar cal = new Calendar(); // 추상 class이므로 직접 인스턴스화할 수 없음
        // Calendar cal = new GregorianCalendar(); // GregorianCalendar 클래스 사용하여 인스턴스 생성
        Calendar cal = Calendar.getInstance(); // Calendar의 정적 메소드 getInstance()를 사용하여 인스턴스 생성
        
        // Calendar 객체에서 연도, 월, 일 정보를 가져옴
        // int year = cal.get(Calendar.YEAR);
        int year = cal.get(1); // Calendar.YEAR의 상수 값이 1이므로, 이를 직접 사용하여 연도를 가져옴
        //int month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH는 0부터 시작하므로 1을 더해줌, "상수화" 하였다.
        int month = cal.get(2) + 1; // Calendar.MONTH의 상수 값이 2이므로, 이를 사용하여 월을 가져옴
        int day = cal.get(Calendar.DAY_OF_MONTH); // 일(day)을 가져옴
        int week = cal.get(Calendar.DAY_OF_WEEK); // 요일을 가져옴, 일요일(1)부터 시작함 
        
        // week 값을 요일 문자열로 변환하기 위한 switch 문
        String weekOfDay = null; // 요일을 저장할 문자열 변수 선언
        switch (week) {
            case Calendar.SUNDAY: weekOfDay = "일"; break; // 일요일
            case Calendar.MONDAY: weekOfDay = "월"; break; // 월요일
            case Calendar.TUESDAY: weekOfDay = "화"; break; // 화요일
            case Calendar.WEDNESDAY: weekOfDay = "수"; break; // 수요일
            case Calendar.THURSDAY: weekOfDay = "목"; break; // 목요일
            case Calendar.FRIDAY: weekOfDay = "금"; break; // 금요일
            case Calendar.SATURDAY: weekOfDay = "토"; break; // 토요일
            default: weekOfDay = ""; break; // 기본 값 (예외 처리)
        } // weekOfDay
        
        // Calendar 객체에서 시, 분, 초 정보를 가져옴
        int hour = cal.get(cal.HOUR); // 시(hour)를 가져옴
        int minute = cal.get(cal.MINUTE); // 분(minute)을 가져옴
        int second = cal.get(cal.SECOND); // 초(second)를 가져옴
				        
        // 현재 연도, 월, 일, 요일, 시, 분, 초를 출력
        System.out.println(year + "년 " 
        					+ month + "월 " 
        					+ day + "일 " 
        					+ weekOfDay + "요일 "
        					+ hour + ":"
        					+ minute + ":"
        					+ second);
    }
}


