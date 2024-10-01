package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    public static void main(String[] args) {
        // Spring 설정 파일을 로드하여 ApplicationContext 생성
        // 추가 설명: ClassPathXmlApplicationContext는 applicationContext.xml 파일을 읽어들여 Spring Bean을 관리하는 
        // ApplicationContext를 생성합니다. 이 설정 파일에는 Bean의 정의와 의존성 주입에 대한 정보가 포함되어 있습니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Bean을 가져옴
        // 추가 설명: context.getBean() 메서드를 사용하여 applicationContext.xml에 정의된 "sungJukImpl"이라는 id의 Bean을 가져옵니다.
        // 이 메서드는 Spring 컨테이너가 관리하는 Bean을 반환하며, 여기서 반환된 객체는 SungJuk 인터페이스를 구현한 SungJukImpl 객체입니다.
        SungJuk sungJuk = (SungJuk) context.getBean("sungJukImpl");
        // 추가 설명: getBean() 메서드는 id를 기준으로 Bean을 찾으며, 반환되는 객체는 명시적으로 SungJuk 인터페이스로 캐스팅됩니다.
        // 이를 통해 Spring 컨테이너에서 해당 Bean을 관리하고, 필요할 때마다 가져와 사용할 수 있습니다.

        System.out.println();
        
        // 총점 및 평균 계산 후 출력
        // 추가 설명: calcTot() 메서드는 국어, 영어, 수학 점수를 더해 총점을 계산합니다. calcAvg() 메서드는 총점을 바탕으로 평균을 계산합니다.
        // display() 메서드는 계산된 총점과 평균을 포함한 성적 정보를 출력합니다.
        sungJuk.calcTot();  // 총점 계산
        sungJuk.calcAvg();  // 평균 계산
        sungJuk.display();  // 성적 정보 출력
        System.out.println("\n");
        // 추가 설명: 각 메서드는 SungJukImpl 클래스에서 정의된 비즈니스 로직을 실행하며, Spring 컨테이너가 관리하는 Bean을 통해 이 메서드들이 호출됩니다.
        
        // modify를 통해 데이터 수정 및 재출력
        // 추가 설명: modify() 메서드는 사용자로부터 새롭게 데이터를 입력받아 기존 성적 데이터를 수정하는 기능을 수행합니다.
        // 이후 display() 메서드를 호출하여 수정된 데이터를 다시 출력합니다.
        System.out.println("*** 수정 ***");
        sungJuk.modify();   // 사용자 입력을 통해 데이터를 수정
        sungJuk.display();  // 수정된 데이터를 출력
        System.out.println();
        // 추가 설명: modify() 메서드는 입력받은 데이터를 사용하여 필드를 업데이트한 후, 총점 및 평균을 다시 계산하여 display()로 그 결과를 출력합니다.
    }
}
