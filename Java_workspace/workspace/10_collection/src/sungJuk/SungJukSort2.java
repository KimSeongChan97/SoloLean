package sungJuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SungJukSort2 implements SungJuk {

    // 메뉴를 표시하고 정렬을 수행하는 메서드
    public void menu(ArrayList<SungJukDTO> list) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        int num = 0; // 사용자가 입력할 메뉴 번호를 저장할 변수

        while (true) { 
            // 1. 메뉴 입력 
            System.out.println("""
            				   ********************\n 
            		             1. 총점 기준 내림차순\n 
                                 2. 이름 기준 오름차순\n 
                                 3. 이전 메뉴\n" 
                               ********************\n 
                                 번호 : """);
            num = sc.nextInt(); // 사용자가 입력한 번호를 변수 num 에 저장

            // 2. 메뉴별 sort
            if (num == 1) {
                // 총점 기준 내림차순 정렬
                // Collections.sort(list, (o1, o2) -> o2.getTot() - o1.getTot()); // list , o1 o2 는 원소로 생각하여 비교함수
                // 위와 동일한 효과를 가지며, 더 명확하게 표현된 버전
                Collections.sort(list, (o1, o2) -> (o1.getTot() - o2.getTot()) * -1);
            } else if (num == 2) {
                // 이름 기준 오름차순 정렬
                Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
            } else if (num == 3) {
                // 이전 메뉴로 돌아가기
                break;
            } else {
                // 잘못된 번호 입력 시 메시지 출력
                System.out.println("1~3중에 선택하세요");
            }

            // 3. 정렬된 리스트 출력
            System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");

            // 리스트에 있는 모든 SungJukDTO 객체를 출력
            for (SungJukDTO dto : list) {
                System.out.println(dto);
            }
        }
    }

    // @Override
    // 실행 메서드: menu 메서드를 호출하여 정렬 메뉴를 실행
    public void execute(ArrayList<SungJukDTO> list) {
        new SungJukSort2().menu(list); // 새로운 SungJukSort2 객체를 생성하고 menu 메서드를 호출
    }
}

/*
 * Lambda 표현식 및 Comparator 설명
 * 
 * Lambda 표현식은 익명 함수를 간결하게 표현하기 위해 Java 8에 도입된 기능입니다.
 * 기본 형태는 (parameters) -> expression 또는 (parameters) -> { statements } 입니다.
 * 
 * 1. (o1, o2) -> o2.getTot() - o1.getTot() 은 두 개의 매개변수 o1과 o2를 받아서
 *    o2.getTot() - o1.getTot() 결과를 반환하는 람다 표현식입니다.
 *    이는 총점 기준 내림차순 정렬을 의미합니다.
 * 
 * 2. (o1, o2) -> o1.getName().compareTo(o2.getName()) 은 두 개의 매개변수 o1과 o2를 받아서
 *    o1.getName().compareTo(o2.getName()) 결과를 반환하는 람다 표현식입니다.
 *    이는 이름 기준 오름차순 정렬을 의미합니다.
 * 
 * 3. (o1, o2) -> (o1.getTot() - o2.getTot()) * -1 은 두 개의 매개변수 o1과 o2를 받아서
 *    o1.getTot() - o2.getTot() 결과에 -1을 곱한 값을 반환하는 람다 표현식입니다.
 *    이는 총점 기준 내림차순 정렬을 의미합니다.
 * 
 * 장점:
 * - 코드가 간결해집니다.
 * - 익명 클래스와 비교하여 코드가 더욱 읽기 쉬워집니다.
 * - 함수형 프로그래밍 스타일을 지원하여 보다 선언적인 코드를 작성할 수 있습니다.
 * 
 * 단점:
 * - 람다 표현식이 너무 복잡해지면 가독성이 떨어질 수 있습니다.
 * - 디버깅이 어려울 수 있습니다. 익명 함수의 호출 스택이 명확하지 않을 수 있기 때문입니다.
 * 
 * 예제 코드 분석:
 * Collections.sort(list, (o1, o2) -> (o1.getTot() - o2.getTot()) * -1);
 * - `Collections.sort` 메서드는 리스트를 정렬하는 메서드입니다.
 * - 첫 번째 매개변수는 정렬할 리스트입니다.
 * - 두 번째 매개변수는 Comparator로, 두 개의 객체를 비교하는 메서드입니다.
 * - 여기서 Comparator는 람다 표현식 `(o1, o2) -> (o1.getTot() - o2.getTot()) * -1`로 정의됩니다.
 *   이는 o1의 총점과 o2의 총점을 비교하여, 내림차순으로 정렬하기 위해 결과에 -1을 곱한 값을 반환합니다.
 */


