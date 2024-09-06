package If;

import java.util.Scanner;

public class If02test {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);

        System.out.print("a의 값: ");
        int a = scanner.nextInt(); 
        System.out.print("b의 값: ");
        int b = scanner.nextInt();
        System.out.print("c의 값: ");
        int c = scanner.nextInt();
        double avg = (a + b + c) / 3.0;// 세 과목 점수의 평균을 계산합니다. 평균은 실수형(double)로 저장하여 소수점 이하의 값을 유지
        
        if(avg >= 60)
        	if(a>=40 && b>=40 && c>=40)
        		System.out.println("합격");
        	else
        		System.out.println("과락으로 불합격");
        else
        	System.out.println("불합격");
        
    }
}


/*
[문제] 3과목(a,b,c)의 점수를 입력받아서 합격인지 불합격인지 출력하시오
합격은 평균이 60점 이상이어야 하고 각 과목이 40점 이상이어야 한다

[실행결과]
a의 값 : 98
b의 값 : 90
c의 값 : 85
합격

a의 값 : 98
b의 값 : 90
c의 값 : 35
과락으로 불합격

a의 값 : 68
b의 값 : 50
c의 값 : 45
불합격

*/