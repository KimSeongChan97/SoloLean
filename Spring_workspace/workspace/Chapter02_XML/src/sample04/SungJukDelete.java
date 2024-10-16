package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukDelete implements SungJuk {
    @Setter
    // @Setter: Lombok을 사용하여 list 필드에 대한 setter 메서드를 자동으로 생성합니다.
    // 이 list는 Spring에서 주입될 수 있는 의존성입니다. 
    // 성적 데이터를 저장한 SungJukDTO2 객체들이 포함된 리스트가 이 필드에 주입됩니다.
    private List<SungJukDTO2> list;

    @Override
    public void execute() {
        System.out.println(); // 화면 간격을 위해 공백 줄 출력
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        
        System.out.print("삭제할 이름 입력: ");
        String name = scan.next(); // 삭제할 학생의 이름을 사용자로부터 입력받음
        
        System.out.println(); // 화면 간격을 위해 공백 줄 출력
        int sw = 0; // 학생의 이름을 찾았는지 여부를 확인하는 변수 (0: 찾지 못함, 1: 찾음)
        
        // 리스트를 순회하기 위해 Iterator 객체를 생성
        Iterator<SungJukDTO2> it = list.iterator(); 
        
        while(it.hasNext()) { // 리스트에 다음 항목이 있으면 true, 없으면 false
            // it 가 가리키는 항목을 가져와 sungJukDTO2에 저장하고, it는 다음 항목으로 이동
            SungJukDTO2 sungJukDTO2 = it.next();
            if (sungJukDTO2.getName().equals(name)) { 
                // 입력된 이름과 리스트에 있는 학생의 이름이 같은지 비교 (equals 메서드를 사용하여 문자열 비교)
                sw = 1; // 이름을 찾았으므로 sw 값을 1로 설정
                System.out.println("이름\t국어\t영어\t수학\t총점\t평균"); 
                // 성적 정보를 보기 좋게 출력하기 위한 헤더 출력
                System.out.println(sungJukDTO2); 
                // 학생의 성적 데이터를 출력 (SungJukDTO2 객체의 toString() 메서드가 호출됨)

                // 현재 위치의 항목을 리스트에서 삭제 (Iterator의 remove 메서드를 사용)
                it.remove();  // it.next 로 저장한 항목을 제거
                System.out.println(name + "님의 데이터를 삭제하였습니다."); 
                // 삭제 완료 메시지 출력
                System.out.println(); 
                break; // 삭제가 완료되었으므로 반복문 종료
            } 
        } // while
        
        if (sw == 0) // sw가 0인 경우, 즉 입력된 이름을 찾지 못한 경우
            System.out.println("찾고자 하는 이름이 없습니다."); // 이름을 찾지 못했음을 출력
        	System.out.println(); 
    }
}
