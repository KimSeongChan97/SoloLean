package sample04;

import java.util.List;
import java.util.Scanner;
import lombok.Setter;

public class SungJukUpdate implements SungJuk {
    @Setter
    // @Setter: Lombok의 어노테이션으로, 이 필드(list)에 대한 setter 메서드를 자동으로 생성합니다.
    // Spring에서 의존성 주입을 통해 이 리스트에 SungJukDTO2 객체들이 주입될 수 있습니다.
    private List<SungJukDTO2> list;

    @Override
    public void execute() {
        System.out.println(); // 공백 줄을 출력하여 UI 간격을 조정합니다.
        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        
        System.out.print("수정할 이름 입력: ");
        String name = scan.next(); // 수정할 학생의 이름을 입력받음
        
        System.out.println();
        int sw = 0; // 이름을 찾았는지 여부를 나타내는 switch 역할을 하는 변수. 0은 찾지 못함, 1은 찾음.
        for (SungJukDTO2 sungJukDTO2 : list) {
            if (sungJukDTO2.getName().equals(name)) {
            	sw = 1; // 이름을 찾았으므로 sw 값을 1로 설정
                System.out.println("이름\t국어\t영어\t수학\t총점\t평균"); 
                // 학생의 성적 정보를 출력할 헤더를 출력함.
                System.out.println(sungJukDTO2); 
                // 해당 학생의 성적 정보를 출력. SungJukDTO2의 toString() 메서드를 사용하여 출력.
                
                System.out.println();
                // 국어, 영어, 수학 점수를 새로 입력받아 수정할 준비를 함.
                System.out.print("수정할 국어 점수 입력: ");
                int kor = scan.nextInt();
                System.out.print("수정할 영어 점수 입력: ");
                int eng = scan.nextInt();
                System.out.print("수정할 수학 점수 입력: ");
                int math = scan.nextInt();

                // 새롭게 입력된 국어, 영어, 수학 점수를 바탕으로 총점과 평균을 다시 계산
                int tot = kor + eng + math;
                double avg = tot / 3.0; // 평균은 실수로 계산되기 때문에 3.0으로 나눕니다.
                
                // 계산된 값들을 해당 학생의 SungJukDTO2 객체에 설정
                sungJukDTO2.setName(name); // 이름은 그대로 유지
                sungJukDTO2.setKor(kor); // 새로운 국어 점수 설정
                sungJukDTO2.setEng(eng); // 새로운 영어 점수 설정
                sungJukDTO2.setMath(math); // 새로운 수학 점수 설정
                sungJukDTO2.setTot(tot); // 새로 계산된 총점 설정
                sungJukDTO2.setAvg(avg); // 새로 계산된 평균 설정
                
                System.out.println(name + "님의 데이터를 수정하였습니다."); 
                // 학생의 성적 정보가 성공적으로 수정되었음을 출력
                System.out.println();
                break; // 데이터 수정 후 반복문을 종료
            } // if
        } // for
        if (sw == 0) // 이름을 찾지 못한 경우
        System.out.println("찾고자 하는 이름이 없습니다."); // 찾고자 하는 이름이 없을 때 출력
        System.out.println(); // 공백 줄 출력
    }
}
