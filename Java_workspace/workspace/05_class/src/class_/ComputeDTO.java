package class_;

public class ComputeDTO {
    
    // 필드 변수 선언
    private int x, y, sum, sub, mul;
    private double div;
    
    // x 값을 설정하는 메서드
    public void setX(int x) {
        // System.out.println("this = " + this);
        this.x = x; // 현재 객체의 x 필드에 입력된 x 값을 설정
    }
    
    // y 값을 설정하는 메서드
    public void setY(int y) {
        // System.out.println("this = " + this);
        this.y = y; // 현재 객체의 y 필드에 입력된 y 값을 설정
    }
    
    // x 값을 반환하는 메서드
    public int getX() {
        return this.x; // 현재 객체의 x 값을 반환
    }
    
    // y 값을 반환하는 메서드
    public int getY() {
        return this.y; // 현재 객체의 y 값을 반환
    }
    
    // 합계를 반환하는 메서드
    public int getSum() {
        return this.sum; 
    }
    
    // 차를 반환하는 메서드
    public int getSub() {
        return this.sub; 
    }
    
    // 곱을 반환하는 메서드
    public int getMul() {
        return this.mul; 
    }
    
    // 나눗셈 결과를 반환하는 메서드
    public double getDiv() {
        return this.div; 
    }
    
    // 합계, 차, 곱, 나눗셈 결과를 계산하는 메서드 가 설정하여 set 은 불필요
    public void calc() {
        this.sum = this.x + this.y; // 합계를 계산하여 sum 필드에 저장
        this.sub = this.x - this.y; // 차를 계산하여 sub 필드에 저장
        this.mul = this.x * this.y; // 곱을 계산하여 mul 필드에 저장
        this.div = (double)this.x / this.y; // 나눗셈 결과를 계산하여 div 필드에 저장
    }
}
