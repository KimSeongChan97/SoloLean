package multiFor_;

public class MultiFor03 {

    public static void main(String[] args) {
        int dan, i;
        
        for (i = 1; i <= 9; i++) { // 각 구구단의 곱하는 수
            for (dan = 2; dan <= 9; dan += 2) { // 2단부터 9단까지 두 개씩 출력
                if (dan < 9) { // 9단까지 출력하고 이후 줄바꿈을 위해
                    System.out.print(dan + " * " + i + " = " + (dan * i) + "\t");
                    System.out.print((dan + 1) + " * " + i + " = " + ((dan + 1) * i) + "\t");
                } else {
                    System.out.print(dan + " * " + i + " = " + (dan * i) + "\t");
                }
            }
            System.out.println(); // 한 줄 끝나면 줄바꿈
        }
    }
}



/*

2단~9단

2*1=2	3*1=3   ...
2*2=4	3*2=6
~~		~~
2*9=18	3*9=27	


*/