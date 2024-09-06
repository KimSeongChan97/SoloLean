package array;

import java.util.Random;
import java.util.Scanner;

public class LottoSolo {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        // 현금입력 받기
        while (true) {
            System.out.print("현금 입력 : ");
            int money = scan.nextInt();
            int linesToGenerate = money / 1000; // 입력된 돈으로 생성할 줄 수 계산
            
            for (int line = 0; line < linesToGenerate; line++) {
                generateLottoNumbers(lotto, random); // 로또 번호 생성 및 배열 lotto에 저장

                // 포맷에 맞게 번호 출력
                for (int i = 0; i < lotto.length; i++) {
                    System.out.printf("%5d", lotto[i]);
                }
                System.out.println();

                // 5줄마다 줄바꿈
                if ((line + 1) % 5 == 0 && line != linesToGenerate - 1) {
                    System.out.println();
                }
            }

            System.out.println();
            System.out.print("계속 하시겠습니까? (Y/N): ");
            String answer = scan.next();
            if (!answer.equalsIgnoreCase("Y")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        scan.close();
    }

    // 중복되지 않는 로또 번호 생성 및 정렬
    private static void generateLottoNumbers(int[] lotto, Random random) {
        // 로또 번호 배열 초기화
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = -1; // 초기값 -1로 설정
        }

	        int index = 0;
	        while (index < lotto.length) {
	            int num = random.nextInt(45) + 1; // 1부터 45까지의 난수 생성
	
	            // 중복 체크
	            boolean isDuplicate = false;
	            for (int i = 0; i < index; i++) {
	                if (lotto[i] == num) {
	                    isDuplicate = true;
	                    break;
	                }
	            }

	            // 배열에 중복되지 않는 숫자 추가
	            if (!isDuplicate) {
	                lotto[index] = num;
	                index++;
	            }
	        }

			        // 오름차순 정렬 (버블 정렬 사용)
			        for (int i = 0; i < lotto.length - 1; i++) {
			            for (int j = 0; j < lotto.length - 1 - i; j++) {
			                if (lotto[j] > lotto[j + 1]) {
			                    // Swap
			                    int temp = lotto[j];
			                    lotto[j] = lotto[j + 1];
			                    lotto[j + 1] = temp;
			                }
			            }
        }
    }
}



/*
[문제] 로또 프로그램 - 자동 번호
1. 1~45까지의 정수형 값을 가진 6개인 배열이다.
2. 중복된 숫자를 가지면 안된다.
3. 오름차순으로 정렬한다.
4. 1줄당 1000원이다.
5. 출력시 5자리로 맞춘다.
6. 5줄마다 줄바꿈을 한다.

[실행결과]
현금 입력 : 3200
    2    4   19   39   43   44
   22   26   33   38   39   42
    5    6    8   25   35   45
    
현금 입력 : 7000    
    2    4   19   39   43   44
   22   26   33   38   39   42
    5    6    8   25   35   45
    3   14   23   30   34   35
   18   20   25   27   32   37

    1   16   32   34   41   42
    5    6   18   30   33   44


*/