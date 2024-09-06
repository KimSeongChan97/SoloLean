package homework;

import java.util.Scanner;

public class If03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("a의 값 : ");
        int a = scanner.nextInt();
        System.out.print("b의 값 : ");
        int b = scanner.nextInt();
        System.out.print("c의 값 : ");
        int c = scanner.nextInt();
        
        /*
        //가상, a가 가장 작다면? ,, 강사님 정답
         if(a<b %% a<c) { //a가 가장 작다면
        	 if(b<c) System.out.println(a + ", " + b + ", " + c);
        	 else System.out.println( a + " , " + c + " , " + b);
        	 } else if(b<c) { // b가 가장 작다면
        		 if(a<c) System.out.println(b + ", " + a + ", " + c);
            	 else System.out.println( b + " , " + c + " , " + a);
        } else { //c가 가장 작다면
        	if(a<b) System.out.println(c + ", " + a + ", " + b);
       	 else System.out.println( c + " , " + b + " , " + a);
       }
        */

        // 첫 번째 조건: a와 b 비교하여 작은 값을 a에 할당, 큰 값을 b에 할당
        if (a > b) {
            a = a + b; // a와 b를 더해서 a에 임시로 저장
            b = a - b; // a와 b를 더한 값에서 b를 빼서 b에 할당 (이 때 a가 들어감)
            a = a - b; // a와 b를 더한 값에서 b를 빼서 a에 할당 (이 때 b가 들어감)
        }

        // 두 번째 조건: b와 c 비교하여 작은 값을 b에 할당, 큰 값을 c에 할당
        if (b > c) {
            b = b + c; // b와 c를 더해서 b에 임시로 저장
            c = b - c; // b와 c를 더한 값에서 c를 빼서 c에 할당 (이 때 b가 들어감)
            b = b - c; // b와 c를 더한 값에서 c를 빼서 b에 할당 (이 때 c가 들어감)
        }

        // 세 번째 조건: 다시 a와 b 비교하여 작은 값을 a에 할당, 큰 값을 b에 할당
        if (a > b) {
            a = a + b; // a와 b를 더해서 a에 임시로 저장
            b = a - b; // a와 b를 더한 값에서 b를 빼서 b에 할당 (이 때 a가 들어감)
            a = a - b; // a와 b를 더한 값에서 b를 빼서 a에 할당 (이 때 b가 들어감)
        }
        
        // 정렬된 결과 출력
        System.out.println();
        System.out.println(a + " " + b + " " + c);
        
        scanner.close();
       
    }
}

/*
3개의 숫자(a,b,c)를 입력받아서 순서대로 출력하시오 (if 문 사용하시오)
(Scanner, if 만 사용)
[실행결과]
a의 값 : 98
b의 값 : 90
c의 값 : 85

85 90 98

a의 값 : 75
b의 값 : 25
c의 값 : 36

25 36 75

*/
