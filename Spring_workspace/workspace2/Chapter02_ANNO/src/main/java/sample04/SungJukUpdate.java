package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukUpdate implements SungJuk {
    
    // @Setter: Lombok의 어노테이션으로, 이 필드(list)에 대한 setter 메서드를 자동으로 생성합니다.
    // Spring에서 의존성 주입을 통해 이 리스트에 SungJukDTO2 객체들이 주입될 수 있습니다.
    // @Autowired는 Spring이 이 필드에 의존성을 자동으로 주입해 주는 어노테이션입니다.
    // 이 리스트에는 여러 학생의 성적 데이터가 저장되어 있으며, 이를 사용해 특정 학생의 데이터를 수정할 수 있습니다.
	@Autowired
    private List<SungJukDTO2> list;
    // 학생들의 성적 데이터를 저장하는 리스트입니다.
    // Spring에서 관리하는 이 리스트는 다른 클래스에서 입력된 성적 데이터를 포함하고 있으며, 
    // 여기에 저장된 데이터를 수정, 삭제, 출력할 수 있습니다.

    @Override
    public void execute() {
        System.out.println(); // 공백 줄을 출력하여 UI 간격을 조정합니다.
        // 출력되는 화면의 가독성을 높이기 위해 공백을 추가합니다.
        
        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        // 콘솔에서 사용자의 입력을 받을 수 있도록 Scanner 객체를 생성합니다.
        
        System.out.print("수정할 이름 입력: ");
        String name = scan.next(); // 수정할 학생의 이름을 입력받음
        // 사용자로부터 수정하려는 학생의 이름을 입력받아 name 변수에 저장합니다.
        
        System.out.println();
        int sw = 0; // 이름을 찾았는지 여부를 나타내는 switch 역할을 하는 변수. 0은 찾지 못함, 1은 찾음.
        // sw는 학생의 이름을 찾았는지 여부를 나타내는 변수입니다. 기본값은 0(찾지 못함)으로 설정되어 있으며,
        // 학생의 이름을 찾으면 sw는 1로 변경됩니다.
        
        for (SungJukDTO2 sungJukDTO2 : list) {
            // 리스트에 저장된 각 SungJukDTO2 객체의 이름과 입력된 이름을 비교하여 찾습니다.
            // for-each 루프를 사용하여 리스트에서 각 학생의 성적 데이터를 하나씩 확인합니다.
            
            if (sungJukDTO2.getName().equals(name)) {
            	// 입력된 이름과 현재 성적 데이터에 있는 학생의 이름이 일치하는지 확인합니다.
                sw = 1; // 이름을 찾았으므로 sw 값을 1로 설정
                // 학생의 이름을 찾았을 경우, sw 값을 1로 변경하여 이름을 찾았음을 표시합니다.
                
                System.out.println("이름\t국어\t영어\t수학\t총점\t평균"); 
                // 학생의 성적 정보를 출력할 헤더를 출력함.
                // 성적 데이터를 보기 좋게 출력하기 위해 헤더 부분을 출력합니다.
                
                System.out.println(sungJukDTO2); 
                // 해당 학생의 성적 정보를 출력. SungJukDTO2의 toString() 메서드를 사용하여 출력.
                // 학생의 이름, 국어, 영어, 수학 점수와 함께 총점, 평균을 출력합니다.
                
                System.out.println();
                // 국어, 영어, 수학 점수를 새로 입력받아 수정할 준비를 함.
                // 성적을 수정하기 위해 국어, 영어, 수학 점수를 새로 입력받을 준비를 합니다.
                
                System.out.print("수정할 국어 점수 입력: ");
                int kor = scan.nextInt(); // 국어 점수를 새로 입력받음
                System.out.print("수정할 영어 점수 입력: ");
                int eng = scan.nextInt(); // 영어 점수를 새로 입력받음
                System.out.print("수정할 수학 점수 입력: ");
                int math = scan.nextInt(); // 수학 점수를 새로 입력받음
                // 각각의 성적(국어, 영어, 수학)을 사용자로부터 입력받아 수정할 준비를 합니다.
                
                // 새롭게 입력된 국어, 영어, 수학 점수를 바탕으로 총점과 평균을 다시 계산
                int tot = kor + eng + math;
                // 새로 입력받은 국어, 영어, 수학 점수를 합산하여 총점을 계산합니다.
                
                double avg = tot / 3.0; // 평균은 실수로 계산되기 때문에 3.0으로 나눕니다.
                // 평균을 계산할 때는 총점을 3으로 나누어 실수형(double) 값으로 평균을 구합니다.
                // 이는 성적이 3개의 과목으로 구성되어 있기 때문입니다.

                // 계산된 값들을 해당 학생의 SungJukDTO2 객체에 설정
                sungJukDTO2.setName(name); // 이름은 그대로 유지
                sungJukDTO2.setKor(kor); // 새로운 국어 점수 설정
                sungJukDTO2.setEng(eng); // 새로운 영어 점수 설정
                sungJukDTO2.setMath(math); // 새로운 수학 점수 설정
                sungJukDTO2.setTot(tot); // 새로 계산된 총점 설정
                sungJukDTO2.setAvg(avg); // 새로 계산된 평균 설정
                // 수정된 성적 데이터를 해당 학생의 SungJukDTO2 객체에 설정합니다.
                // 이름은 수정되지 않으며, 새로 입력된 국어, 영어, 수학 점수와 계산된 총점, 평균을 설정합니다.
                
                System.out.println(name + "님의 데이터를 수정하였습니다."); 
                // 학생의 성적 정보가 성공적으로 수정되었음을 출력
                // 성적이 성공적으로 수정되었음을 사용자에게 알리는 메시지를 출력합니다.
                
                System.out.println();
                break; // 데이터 수정 후 반복문을 종료
                // 학생의 성적을 수정한 후 더 이상 반복할 필요가 없으므로 반복문을 종료합니다.
            } // if
        } // for
        if (sw == 0) // 이름을 찾지 못한 경우
            System.out.println("찾고자 하는 이름이 없습니다."); // 찾고자 하는 이름이 없을 때 출력
        // 리스트를 모두 순회했음에도 불구하고 해당 이름을 찾지 못했을 경우 출력되는 메시지입니다.
        
        System.out.println(); // 공백 줄 출력
        // 출력 형식을 깔끔하게 하기 위해 마지막에 공백을 출력합니다.
    }
}
