package class__;

public class FruitSolo {
    private String pum; // 품명
    private int jan; // 1월 판매량
    private int feb; // 2월 판매량
    private int mar; // 3월 판매량
    private int tot; // 총 판매량

    private static int sumJan = 0; // 모든 인스턴스가 공유하는 1월의 총합
    private static int sumFeb = 0; // 모든 인스턴스가 공유하는 2월의 총합
    private static int sumMar = 0; // 모든 인스턴스가 공유하는 3월의 총합

    // 생성자: 각 필드를 초기화
    public FruitSolo(String pum, int jan, int feb, int mar) {
        this.pum = pum;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.tot = 0; // 총 판매량은 초기화 시 0으로 설정
    }

    // 총 판매량을 계산하는 메소드
    public void calcTot() {
        this.tot = this.jan + this.feb + this.mar; // 1월, 2월, 3월 판매량의 합을 계산하여 총 판매량에 저장
        sumJan += this.jan; // 1월의 총합에 현재 인스턴스의 1월 판매량을 더함
        sumFeb += this.feb; // 2월의 총합에 현재 인스턴스의 2월 판매량을 더함
        sumMar += this.mar; // 3월의 총합에 현재 인스턴스의 3월 판매량을 더함
    }

    // 개별 품목의 판매량을 출력하는 메소드
    public void display() {
        // 각 필드 값을 탭(\t)으로 구분하여 출력
        System.out.println(pum + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
    }

    // 전체 합계를 출력하는 클래스 메소드
    public static void output(FruitSolo[] fruits) {
        System.out.println("---------------------------------------");
        System.out.println("PUM\tJAN\tFEB\tMAR\tTOT"); // 각 열의 이름을 탭(\t)으로 구분하여 출력
        System.out.println("---------------------------------------");

        // 각 객체의 총 판매량 계산 및 출력
        for (FruitSolo fruit : fruits) {
            fruit.calcTot(); // 각 과일 객체의 총 판매량을 계산
            fruit.display(); // 각 과일 객체의 정보를 출력
        }

        System.out.println("---------------------------------------");
        // 총합을 탭(\t)으로 구분하여 출력
        System.out.println("\t" + sumJan + "\t" + sumFeb + "\t" + sumMar);
        System.out.println("---------------------------------------");
    }
}

