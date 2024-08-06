package abstract_;

// java.text 패키지에서 NumberFormat과 DecimalFormat 클래스를 임포트
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

// NumberMain 클래스 선언
public class NumberMain {

    // main 메서드 - 프로그램의 시작점
    public static void main(String[] args) {
        // NumberFormat 클래스를 직접 인스턴스화하려고 하면 에러가 발생합니다.
        // NumberFormat nf = new NumberFormat(); // error - 추상 클래스이므로 직접 생성 불가
        
        // 대신 NumberFormat의 서브 클래스인 DecimalFormat을 사용하여 인스턴스를 생성합니다.
        NumberFormat nf = new DecimalFormat(); // 서브 클래스인 DecimalFormat을 사용
        // DecimalFormat df = new DecimalFormat(); // 위와 동일한 결과
        
        // 숫자를 포맷팅하여 3자리마다 쉼표(,)를 찍고 소수점 이하 3자리까지 표시합니다.
        System.out.println(nf.format(12345678.456789)); // 결과: 12,345,678.457
        System.out.println(nf.format(12345678));        // 결과: 12,345,678
        System.out.println(); // 빈 줄 출력
        
        // 다른 형식의 NumberFormat 인스턴스를 생성합니다.
        // 이 포맷은 숫자를 "#,###.##원" 형식으로 변환합니다.
        // 유효 숫자가 아닌 소수점 이하는 표시하지 않습니다.
        NumberFormat nf2 = new DecimalFormat("#,###.##원");
        System.out.println(nf2.format(12345678.456789)); // 결과: 12,345,678.46원
        System.out.println(nf2.format(12345678));        // 결과: 12,345,678원
        System.out.println(); // 빈 줄 출력
        
        // 또 다른 형식의 NumberFormat 인스턴스를 생성합니다.
        // 이 포맷은 숫자를 "#,###.00원" 형식으로 변환합니다.
        // 소수점 이하가 없는 경우에도 0을 강제로 표시합니다.
        NumberFormat nf3 = new DecimalFormat("#,###.00원");
        System.out.println(nf3.format(12345678.456789)); // 결과: 12,345,678.46원
        System.out.println(nf3.format(12345678));        // 결과: 12,345,678.00원
        System.out.println(); // 빈 줄 출력
        
        // NumberFormat.getInstance() 메서드를 사용하여 NumberFormat 인스턴스를 생성합니다.
        // 이 인스턴스는 숫자를 3자리마다 쉼표를 찍고 소수 이하 2자리까지 표시합니다.
        //NumberFormat nf4 = NumberFormat.getInstance(); // new NumberFormat 의 역할을 한 것.
        NumberFormat nf4 = NumberFormat.getCurrencyInstance(); // 메소드 이용하여 생성, 돈 표시
        nf4.setMaximumFractionDigits(2); // 소수 이하 최대 2자리까지 표시
        nf4.setMinimumFractionDigits(2); // 소수 이하 최소 2자리까지 표시 (0을 강제로 표시)
        System.out.println(nf4.format(12345678.456789)); // 결과: 12,345,678.46
        System.out.println(nf4.format(12345678));        // 결과: 12,345,678.00
        System.out.println(); // 빈 줄 출력

        // NumberFormat.getCurrencyInstance(Locale.US) 메서드를 사용하여 미국 달러 통화 형식의 NumberFormat 인스턴스를 생성합니다.
        NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US); // 메소드 이용하여 생성
        System.out.println(nf5.format(12345678.456789)); // 결과: $12,345,678.46
        System.out.println(nf5.format(12345678));        // 결과: $12,345,678.00
        System.out.println(); // 빈 줄 출력
    }
}


// Oracle 에서는 # -> 9
  
