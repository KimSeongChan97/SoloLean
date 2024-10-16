package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // @Component 어노테이션을 통해 Spring이 이 클래스를 Bean으로 등록하여 관리하게 됩니다.
public class SungJukDelete implements SungJuk {
    // @Setter: Lombok을 사용하여 list 필드에 대한 setter 메서드를 자동으로 생성합니다.
    // 이 list는 Spring에서 주입될 수 있는 의존성입니다. 
    // 성적 데이터를 저장한 SungJukDTO2 객체들이 포함된 리스트가 이 필드에 주입됩니다.
    // @Autowired는 Spring의 의존성 주입(Dependency Injection)을 위한 어노테이션으로, 
    // list 필드에 자동으로 Bean이 주입되도록 합니다. 여기서는 SungJukDTO2 객체들의 리스트가 주입됩니다.
	
	@Autowired
	@Qualifier("arrayList")
    private List<SungJukDTO2> list; 
    // 이 필드는 SungJukDTO2 객체들이 저장된 List로, 성적 정보가 담겨 있습니다.
    // Spring에서 이 리스트를 관리하며, 리스트의 내용은 성적 입력 등의 과정에서 추가되었을 것입니다.
    // SungJukDelete 클래스는 이 리스트를 사용하여 특정 학생의 성적 데이터를 삭제하는 역할을 합니다.

    @Override
    public void execute() {
        System.out.println(); // 화면 간격을 위해 공백 줄 출력
        // 출력 시 보기 좋게 화면을 정리하기 위한 빈 줄을 추가합니다.
        
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        // 사용자로부터 삭제할 학생의 이름을 입력받기 위해 Scanner 객체를 생성합니다.
        
        System.out.print("삭제할 이름 입력: ");
        String name = scan.next(); // 삭제할 학생의 이름을 사용자로부터 입력받음
        // 사용자에게 삭제할 학생의 이름을 입력하도록 요청하고, 입력받은 이름을 name 변수에 저장합니다.
        
        System.out.println(); // 화면 간격을 위해 공백 줄 출력
        int sw = 0; // 학생의 이름을 찾았는지 여부를 확인하는 변수 (0: 찾지 못함, 1: 찾음)
        // sw는 학생을 찾았는지 여부를 확인하는 플래그로, 기본값은 0(찾지 못함)으로 설정되어 있습니다.
        // 학생의 이름을 찾으면 sw가 1로 변경됩니다.
        
        // 리스트를 순회하기 위해 Iterator 객체를 생성
        Iterator<SungJukDTO2> it = list.iterator(); 
        // 리스트를 반복하기 위해 Iterator 객체를 사용합니다. Iterator는 리스트의 요소를 하나씩 순차적으로
        // 접근할 수 있도록 해주며, 목록의 요소를 삭제할 때도 유용합니다.
        
        while(it.hasNext()) { // 리스트에 다음 항목이 있으면 true, 없으면 false
            // 리스트에 있는 다음 항목이 있는지 확인하고, 있으면 true를 반환합니다.
            // 반복문을 통해 리스트에 있는 모든 성적 데이터를 순차적으로 조회하게 됩니다.
            
            // it 가 가리키는 항목을 가져와 sungJukDTO2에 저장하고, it는 다음 항목으로 이동
            SungJukDTO2 sungJukDTO2 = it.next(); 
            // 현재 Iterator가 가리키는 성적 데이터를 SungJukDTO2 타입의 sungJukDTO2 변수에 저장합니다.
            // 이후 이 객체의 정보를 통해 이름을 비교하고, 일치하는 데이터를 찾습니다.
            
            if (sungJukDTO2.getName().equals(name)) { 
                // 입력된 이름과 리스트에 있는 학생의 이름이 같은지 비교 (equals 메서드를 사용하여 문자열 비교)
                // sungJukDTO2 객체의 이름과 사용자가 입력한 이름을 비교합니다.
                // equals() 메서드를 사용하여 문자열의 내용을 비교합니다.
                
                sw = 1; // 이름을 찾았으므로 sw 값을 1로 설정
                // 학생의 이름을 찾았기 때문에 sw 값을 1로 변경합니다. 이는 아래에서 조건문을 통해
                // 학생의 이름을 찾았다는 것을 확인하는 데 사용됩니다.
                
                System.out.println("이름\t국어\t영어\t수학\t총점\t평균"); 
                // 성적 정보를 보기 좋게 출력하기 위한 헤더 출력
                // 학생의 성적 데이터를 출력하기 전, 출력 형식에 맞게 각 항목의 제목(이름, 국어, 영어, 수학 등)을 출력합니다.
                
                System.out.println(sungJukDTO2); 
                // 학생의 성적 데이터를 출력 (SungJukDTO2 객체의 toString() 메서드가 호출됨)
                // SungJukDTO2 클래스에서 정의된 toString() 메서드를 통해 성적 데이터를 출력합니다.
                // toString() 메서드는 각 성적 데이터를 보기 쉽게 출력하는 역할을 합니다.
                
                // 현재 위치의 항목을 리스트에서 삭제 (Iterator의 remove 메서드를 사용)
                it.remove();  // it.next 로 저장한 항목을 제거
                // 찾은 성적 데이터를 리스트에서 삭제합니다. Iterator의 remove() 메서드는
                // 현재 위치의 항목을 삭제하는 역할을 하며, 리스트에서 데이터를 안전하게 제거할 수 있게 합니다.
                
                System.out.println(name + "님의 데이터를 삭제하였습니다."); 
                // 삭제 완료 메시지 출력
                // 해당 학생의 데이터를 삭제했다는 메시지를 출력합니다. 삭제된 학생의 이름도 함께 출력됩니다.
                
                System.out.println(); 
                // 출력 형식 유지를 위한 공백 줄 추가
                break; // 삭제가 완료되었으므로 반복문 종료
                // 학생 데이터를 삭제한 후에는 더 이상 반복할 필요가 없으므로 반복문을 종료합니다.
            } 
        } // while
        
        if (sw == 0) // sw가 0인 경우, 즉 입력된 이름을 찾지 못한 경우
            System.out.println("찾고자 하는 이름이 없습니다."); // 이름을 찾지 못했음을 출력
        	System.out.println(); 
        // 만약 리스트를 모두 탐색했음에도 불구하고 입력된 이름을 찾지 못한 경우, sw는 여전히 0입니다.
        // 이때 사용자에게 해당 이름을 찾지 못했음을 알리는 메시지를 출력합니다.
    }
}
