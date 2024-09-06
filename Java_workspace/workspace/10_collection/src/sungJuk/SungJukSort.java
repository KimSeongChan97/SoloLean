package sungJuk; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import
import java.util.Collections; // Collections 유틸리티 클래스를 사용하기 위해 import
import java.util.Comparator; // Comparator 인터페이스를 사용하기 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위해 import

// SungJukSort 클래스 선언, SungJuk 인터페이스를 구현
public class SungJukSort implements SungJuk {
    // 성적 정렬 기능을 제공하는 클래스

    // 인터페이스에서 정의된 메서드를 구현
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        System.out.println();
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        int num; // 사용자가 입력한 메뉴 번호를 저장할 변수

        while (true) {
            // 메뉴 출력
            System.out.println();
            System.out.println("********************");
            System.out.println("  1. 총점으로 내림차순");
            System.out.println("  2. 이름으로 오름차순");
            System.out.println("  3. 이전 메뉴");
            System.out.println("********************");
            System.out.print("번호 입력 : ");
            num = scan.nextInt(); // 사용자가 입력한 번호를 변수 num에 저장

            if (num == 3) break; // 사용자가 3을 입력하면 반복 종료

            if (num == 1) {
                // 총점 기준 내림차순 정렬
                // 익명 Comparator 클래스를 사용하여 정렬
                Collections.sort(list, new Comparator<SungJukDTO>() {
                    @Override
                    public int compare(SungJukDTO o1, SungJukDTO o2) {
                        return o2.getTot() - o1.getTot(); // 총점을 비교하여 내림차순 정렬
                    }
                });

                // 정렬된 리스트 출력
                System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
                for (SungJukDTO sungJukDTO : list) {
                    System.out.println(sungJukDTO);
                }
            } else if (num == 2) {
                // 이름 기준 오름차순 정렬
                // 익명 Comparator 클래스를 사용하여 정렬
                Collections.sort(list, new Comparator<SungJukDTO>() {
                    @Override
                    public int compare(SungJukDTO o1, SungJukDTO o2) {
                        return o1.getName().compareTo(o2.getName()); // 이름을 비교하여 오름차순 정렬
                    }
                });

                // 정렬된 리스트 출력
                System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
                for (SungJukDTO sungJukDTO : list) {
                    System.out.println(sungJukDTO);
                }
            } else {
                // 잘못된 번호 입력 시 메시지 출력
                System.out.println("1~3중에 선택하세요");
            }
        } // while

        scan.close(); // Scanner 객체 닫기
    }
}


