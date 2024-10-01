package sample03;

import java.util.Scanner;

public class SungJukImpl implements SungJuk {
    private String name;
    private int kor, eng, math, tot;
    private double avg;

    // 기본 생성자
    // 생성자 내부에서 사용자가 직접 입력하는 값을 받습니다.
    // 생성자를 통해 SungJukImpl 객체가 생성될 때, 자동으로 입력을 받아서 이름과 점수를 초기화합니다.
    public SungJukImpl() {
        // Scanner 객체를 사용하여 입력을 받을 준비를 합니다.
        // Scanner는 사용자가 콘솔에서 입력한 데이터를 프로그램에서 사용할 수 있게 해줍니다.
        Scanner sc = new Scanner(System.in);
        
        // 이름 입력 요청 및 입력 처리
        // 사용자에게 이름을 입력받아 name 변수에 저장합니다.
        // next() 메서드는 사용자가 입력한 문자열을 읽습니다.
        System.out.print("이름 입력 : ");
        name = sc.next();
        
        // 국어 점수 입력 요청 및 입력 처리
        // 사용자가 입력한 국어 점수를 kor 변수에 저장합니다.
        // nextInt() 메서드는 사용자가 입력한 정수를 읽습니다.
        System.out.print("국어 입력 : ");
        kor = sc.nextInt();
        
        // 영어 점수 입력 요청 및 입력 처리
        // 사용자가 입력한 영어 점수를 eng 변수에 저장합니다.
        System.out.print("영어 입력 : ");
        eng = sc.nextInt();
        
        // 수학 점수 입력 요청 및 입력 처리
        // 사용자가 입력한 수학 점수를 math 변수에 저장합니다.
        System.out.print("수학 입력 : ");
        math = sc.nextInt();
        
        // 이 생성자는 사용자가 직접 입력한 값을 바탕으로 객체를 생성합니다.
        // 즉, 이 객체는 사용자의 이름과 국어, 영어, 수학 점수를 가지고 있습니다.
        // 입력받은 값은 객체가 생성되는 동안 메모리에 저장되고, 이후 메서드에서 사용할 수 있습니다.
    }

    // calc 메서드: 총점 계산
    // calc()는 객체에 저장된 국어, 영어, 수학 점수를 모두 더해 총점을 구하고, 평균을 계산하는 메서드입니다.
    @Override
    public void calc() {
        // 국어, 영어, 수학 점수를 더해 총점을 계산합니다.
        // 국어, 영어, 수학 점수는 이미 생성자에서 입력받아 kor, eng, math 변수에 저장된 상태입니다.
        tot = kor + eng + math;
        // 평균은 총점을 3으로 나누어 계산하며, 실수 결과를 얻기 위해 double 타입으로 변환합니다.
        avg = (double) tot / 3.;
        // 평균을 계산할 때 (double)로 명시적 형변환을 해주는 이유는 정수끼리의 나눗셈이 자동으로 정수 결과를 내기 때문입니다.
        // 따라서 실수로 결과를 얻기 위해 형변환이 필요합니다.
    }

    // display 메서드: 결과 출력
    // 사용자가 입력한 이름과 국어, 영어, 수학 점수, 총점, 평균을 출력하는 메서드입니다.
    @Override
    public void display() {
        // 먼저 제목 부분을 출력합니다. "이름, 국어, 영어, 수학, 총점, 평균"이 각 컬럼에 해당됩니다.
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        // 이후 실제 데이터(입력받은 값과 계산된 결과)를 순서대로 출력합니다.
        // String.format을 이용하여 평균을 소수점 두 번째 자리까지 출력합니다.
        System.out.print(name + "\t"+ kor + "\t"+ eng + "\t" + math + "\t" + tot + "\t" + String.format("%2f", avg));
        // String.format("%2f", avg)는 평균 값을 소수점 둘째 자리까지 포맷팅하여 출력하는 역할을 합니다.
        // \t는 탭(tab)으로, 출력 값을 보기 좋게 정렬하는 데 사용됩니다.
    }

}
