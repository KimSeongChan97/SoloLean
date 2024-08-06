package class__;

public class Fruit {
    private String pum; // 품명
    private int jan, feb, mar; // 1~3월 판매량, 총 판매량
	private static int tot;
 
    private static int sumJan = 0;
	private static int sumFeb = 0;
	private static int sumMar = 0; 
    
    // 생성자: 각 필드를 초기화
    public Fruit(String pum, int jan, int feb, int mar) {
        this.pum = pum;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
    }
    // 총 판매량을 계산하는 메소드
    public void calcTot() {
        this.tot = this.jan + this.feb + this.mar; // 1월, 2월, 3월 판매량의 합을 계산하여 총 판매량에 저장
        sumJan = sumJan + this.jan; // 1월의 총합에 현재 인스턴스의 1월 판매량을 더함
        sumFeb += this.feb; // 2월의 총합에 현재 인스턴스의 2월 판매량을 더함
        sumMar += this.mar; // 3월의 총합에 현재 인스턴스의 3월 판매량을 더함
    }
    // 개별 품목의 판매량을 출력하는 메소드
    public void display() {
        // 각 필드 값을 탭(\t)으로 구분하여 출력
        System.out.println(pum + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
    }
    // 전체 합계를 출력하는 클래스 메소드
    public static void output() {
    	System.out.println("\t" + sumJan + "\t" + sumFeb + "\t" + sumMar + "\t" + tot);
        
    }
}
