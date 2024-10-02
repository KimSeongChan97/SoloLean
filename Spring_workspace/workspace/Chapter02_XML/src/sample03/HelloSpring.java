package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    public static void main(String[] args) {
        // Spring 설정 파일을 로드하여 ApplicationContext 생성
        // 추가 설명: ClassPathXmlApplicationContext는 지정된 Spring XML 설정 파일(applicationContext.xml)을 읽어들여 
        // Bean 설정과 의존성을 관리하는 Spring의 ApplicationContext를 생성합니다.
        // Spring은 이를 통해 Bean을 관리하고, 필요할 때마다 적절하게 주입합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 추가 설명: Spring의 ApplicationContext는 BeanFactory를 확장한 인터페이스로, 애플리케이션에서 필요한 Bean을
        // 생성, 관리, 주입해주는 역할을 합니다. 여기서는 XML 설정 파일(applicationContext.xml)을 기반으로 
        // Bean을 생성하고 관리합니다.

        // Bean을 가져옴
        // 추가 설명: applicationContext.xml에서 정의된 'sungJukImpl' Bean을 가져옵니다.
        // context.getBean() 메서드는 Spring 컨테이너에서 해당 Bean을 찾아 반환합니다.
        // 두 번째 인자로는 클래스 타입(SungJuk.class)을 지정하여, 반환된 객체가 SungJuk 인터페이스의 구현체임을 명시합니다.
        // 이 Bean은 sungJukImpl이라는 id로 등록된 SungJukImpl 객체를 반환합니다.
        // SungJuk sungJuk = context.getBean("sungJukImpl", SungJuk.class);
        SungJuk sungJuk = (SungJuk) context.getBean("sungJukImpl");
        // 추가 설명: getBean() 메서드를 사용하여 Bean을 가져올 때, 두 번째 인자로 클래스 타입을 명시하거나,
        // 형변환을 사용하여 명시적으로 타입을 변환할 수 있습니다. 여기서는 형변환을 사용하여 Bean을 가져왔습니다.

        System.out.println();
        // 총점 및 평균 계산 후 출력
        // 추가 설명: calcTot() 메서드는 총점을 계산하고, calcAvg() 메서드는 평균을 계산합니다.
        // display() 메서드는 이름, 국어, 영어, 수학 점수와 함께 총점과 평균을 출력하는 역할을 합니다.
        // 이 과정은 Spring이 관리하는 Bean을 사용하여 실행됩니다.
        sungJuk.calcTot();
        sungJuk.calcAvg();
        sungJuk.display();
        System.out.println("\n");
        // 추가 설명: calcTot(), calcAvg(), display() 메서드를 차례대로 호출하여, 성적 데이터를 계산하고 출력합니다.
        // 총점과 평균을 먼저 계산한 후, 결과를 콘솔에 출력하는 방식입니다.

        // modify를 통해 데이터 수정 및 재출력
        // 추가 설명: modify() 메서드는 사용자로부터 입력을 받아 기존 데이터를 수정합니다.
        // 사용자가 입력한 데이터를 바탕으로 총점과 평균을 다시 계산하고, display() 메서드를 호출하여 수정된 데이터를 출력합니다.
        // 이 부분은 프로그램 실행 중 데이터를 동적으로 수정하고, 그 결과를 즉시 확인할 수 있는 기능입니다.
        System.out.println("*** 수정 ***");
        sungJuk.modify();
        sungJuk.display();
        System.out.println();
        // 추가 설명: modify() 메서드는 사용자로부터 새 데이터를 입력받아 성적을 수정하고, 다시 계산된 총점과 평균을
        // display() 메서드를 통해 출력합니다. 이렇게 하면 프로그램 실행 중에 데이터를 동적으로 변경하고, 그 변경된 결과를
        // 바로 확인할 수 있습니다.

        // 추가 설명: 프로그램 실행 과정에서, Spring 컨테이너에서 관리하는 Bean을 가져와 필요에 따라 메서드를 호출하여
        // 성적 데이터를 처리합니다. 총점 및 평균을 계산하고, 수정된 데이터를 다시 계산하는 과정을 통해, Spring이 어떻게
        // 의존성을 관리하고 주입하는지를 보여줍니다.
    }
}
