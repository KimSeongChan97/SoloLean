package sample04;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component // @Component 어노테이션을 통해 Spring 컨테이너가 이 클래스를 관리하게 설정
public class HelloSpring {
    // List<SungJukDTO2> list = new ArrayList<SungJukDTO2>();
    // 이 코드는 성적 데이터를 저장할 ArrayList 객체를 생성하는 방식이지만, Spring을 사용함으로써
    // 의존성 주입(Dependency Injection)을 통해 리스트를 관리하게 되므로 필요가 없습니다.
    // Spring에서는 직접 객체를 생성하지 않고, Spring이 관리하는 Bean을 주입받아 사용합니다.
    
    public void menu(ApplicationContext context) {
        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        // 스캐너 객체를 통해 콘솔에서 입력받은 값을 처리할 수 있습니다.
        SungJuk sungJuk = null; // SungJuk 인터페이스를 통해 다양한 성적 처리 객체를 참조할 수 있게 함
        // 여기서 sungJuk은 SungJuk 인터페이스 타입으로 선언되어 있으며, 이후에 필요한 성적 처리 기능
        // (입력, 출력, 수정, 삭제 등)을 수행하는 Bean을 참조할 것입니다. Spring을 통해 의존성 주입을 받아
        // 해당 Bean이 필요할 때 context.getBean()을 통해 주입됩니다.

        int num; // 사용자가 메뉴에서 선택한 번호를 저장하는 변수
        // 이 변수는 사용자가 입력한 메뉴 번호(1~5)를 저장합니다. 번호에 따라 성적 입력, 출력, 수정, 삭제 등의
        // 작업이 수행됩니다.

        // 무한 반복문을 통해 프로그램이 메뉴를 계속해서 보여주고, 종료 명령이 입력되기 전까지 동작합니다.
        while (true) {
            System.out.println(); // 줄 간격을 위한 빈 줄 출력
            System.out.println("**************");
            System.out.println("	1. 성적 입력"); // 성적 입력을 위한 메뉴 항목
            System.out.println("	2. 성적 출력"); // 성적 출력을 위한 메뉴 항목
            System.out.println("	3. 성적 수정"); // 성적 수정을 위한 메뉴 항목
            System.out.println("	4. 성적 삭제"); // 성적 삭제를 위한 메뉴 항목
            System.out.println("	5. 종료"); // 프로그램 종료를 위한 메뉴 항목
            System.out.println("**************");
            System.out.print("번호 입력: ");
            num = scan.nextInt(); // 사용자가 입력한 메뉴 번호를 저장
            // 사용자가 콘솔에서 입력한 값을 num 변수에 저장합니다. 이 값에 따라 아래에서 작업이 달라집니다.

            // 종료 조건: 사용자가 5번을 입력하면 프로그램이 종료됨
            if (num == 5) break;
            // 5번이 입력되면 프로그램이 종료됩니다. break 문은 while 루프를 빠져나오는 역할을 합니다.

            // 메뉴 선택에 따라 적절한 Bean 객체를 가져와 실행
            if (num == 1) { 
                // 성적 입력: sungJukInput Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukInput"); 
                // 사용자가 1번(성적 입력)을 선택하면 Spring 컨테이너에서 "sungJukInput"이라는 이름의 Bean을
                // 가져옵니다. 이 Bean은 성적 입력을 처리하는 역할을 합니다.
            } else if (num == 2) { 
                // 성적 출력: sungJukOutput Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukOutput");
                // 사용자가 2번(성적 출력)을 선택하면 "sungJukOutput"이라는 Bean을 가져와 성적 출력을 처리합니다.
            } else if (num == 3) { 
                // 성적 수정: sungJukUpdate Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukUpdate");
                // 사용자가 3번(성적 수정)을 선택하면 "sungJukUpdate" Bean을 가져와 성적을 수정하는 작업을
                // 실행합니다.
            } else if (num == 4) { 
                // 성적 삭제: sungJukDelete Bean을 가져와 실행
                sungJuk = (SungJuk) context.getBean("sungJukDelete");
                // 사용자가 4번(성적 삭제)을 선택하면 "sungJukDelete" Bean을 가져와 성적 삭제 작업을 수행합니다.
            }

            // 선택한 작업을 수행
            sungJuk.execute(); 
            // 위에서 선택된 작업(성적 입력, 출력, 수정, 삭제 등)을 실행하기 위해 sungJuk 객체의 execute() 메서드를
            // 호출합니다. 각 작업은 해당 작업을 처리하는 구체적인 구현 클래스를 통해 실행됩니다.
        } // while
        // while 반복문이 종료되는 시점은 사용자가 5번을 입력하여 break문을 만나 프로그램을 종료할 때입니다.
    } // menu()
    
    public static void main(String[] args) {
        // Spring 설정 파일(applicationContext.xml)을 로드하여 ApplicationContext 생성
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Spring의 설정 파일인 applicationContext.xml을 로드하여 ApplicationContext 객체를 생성합니다.
        // ApplicationContext는 Spring에서 Bean을 관리하고 제공하는 컨테이너 역할을 합니다.
        
        // Spring 컨테이너에서 helloSpring Bean을 가져옴
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        // ApplicationContext를 통해 "helloSpring"이라는 이름의 Bean을 가져옵니다. 이 Bean은 HelloSpring
        // 클래스의 객체로, Spring이 관리하는 객체입니다.
        
        // menu() 호출
        helloSpring.menu(context);
        // 프로그램이 메뉴를 통해 성적 입력, 출력, 수정, 삭제 기능을 수행
        // helloSpring 객체의 menu() 메서드를 호출하여 사용자에게 메뉴를 보여주고 입력을 받아 해당 작업을
        // 실행하는 역할을 합니다.

        System.out.println("프로그램을 종료합니다.");
        // 프로그램 종료 메시지 출력
        // 사용자가 5번을 입력해 프로그램을 종료할 때 출력되는 메시지입니다.
    }
}

/*

@Component란?

@Component는 Spring 프레임워크에서 사용되는 어노테이션으로, 해당 클래스를 Spring 컨테이너에서 관리하는 Bean으로 등록하기 위한 어노테이션입니다. 
이를 통해 Spring이 해당 클래스를 자동으로 인식하고, 필요할 때 의존성 주입(Dependency Injection)을 통해 다른 클래스에서 사용할 수 있게 됩니다.
주로 개발자가 명시적으로 관리할 필요 없이, Spring이 자동으로 객체의 생성과 관리, 소멸을 책임지는 경우에 사용됩니다.

1. 역할
   - @Component는 Spring 컨테이너에 등록되어야 하는 일반적인 클래스를 정의할 때 사용됩니다. 
     이 어노테이션이 선언된 클래스는 Spring의 관리 대상이 되어, 필요할 때 의존성을 주입받을 수 있는 Bean으로 동작하게 됩니다.
   - Spring 컨테이너는 이 어노테이션이 붙은 클래스를 스캔하여 자동으로 인스턴스를 생성하고, 다른 곳에서 사용할 수 있도록 관리합니다.
   
2. 사용 시기
   - @Component는 특정한 역할이 없는 일반적인 Bean을 등록할 때 사용됩니다. 예를 들어, 다음과 같은 경우에 사용됩니다:
     1) 로직을 처리하는 일반적인 서비스 클래스
     2) 데이터 액세스를 위한 DAO(Data Access Object) 클래스
     3) 다른 계층과의 연관성이 없고, 별도로 관리될 필요가 없는 유틸리티 클래스 등
   - Spring에서 좀 더 구체적인 역할을 가진 클래스는 @Component 대신 @Service, @Repository, @Controller 같은 어노테이션을 사용할 수 있습니다.
     이러한 어노테이션들은 각 계층의 역할을 명확하게 나타내기 위한 @Component의 구체적인 형태입니다.
   
3. 작동 원리
   - Spring 애플리케이션이 실행될 때, Spring은 설정 파일이나 클래스 경로에 정의된 패키지를 스캔합니다.
     이때, @Component 어노테이션이 붙어있는 클래스를 발견하면, 이를 관리 대상 Bean으로 자동으로 등록합니다.
   - 등록된 Bean은 Spring의 IoC(제어의 역전) 컨테이너에서 관리되며, 필요 시 다른 클래스에 주입됩니다.
     즉, 개발자가 객체를 직접 생성하거나 관리할 필요 없이, Spring이 객체의 생명 주기를 관리해줍니다.
   - Bean을 주입할 때는 @Autowired를 사용하여 해당 Bean을 자동으로 의존성 주입할 수 있습니다.
   ***
   -> Inversion of Control
   프로그램의 흐름을 직접 제어하지 않고, 프레임워크나 외부 시스템이 흐름을 제어하도록 맡기는 설계 원칙
   제어권이 개발자 코드에서 프레임워크나 라이브러리로 넘어가는 것을 말합니다.
   일반적으로 객체 생성이나 메서드 호출 흐름을 개발자가 직접 제어하지만, IoC에서는 이 제어권이 프레임워크에 의해 역전되어, 
   프레임워크가 필요한 객체를 대신 생성하고 관리하며, 개발자는 이를 이용하는 방식으로 코드를 작성
   IoC의 대표적인 구현 방식:
   	1) 의존성 주입(Dependency Injection, DI):
	객체가 필요한 의존성을 프레임워크가 자동으로 주입해주는 방식입니다. 
	개발자는 객체를 직접 생성하지 않고, 프레임워크가 주입한 객체를 사용합니다.
	2) 이벤트 기반 제어:
	프로그램의 흐름이 이벤트에 따라 결정되는 방식으로, 개발자가 이벤트를 발생시키면 프레임워크가 해당 이벤트에 반응하여 제어를 이어받습니다.
	
	Spring Framework 에서 IOC는 대표적인 구현체 중 하나로,
	객체의 생성과 의존성 관리를 프레임워크가 담당한다.
	
4. 관련 어노테이션
   - @Component 외에도 Spring에서는 역할에 따라 구체적인 의미를 부여하는 여러 어노테이션이 존재합니다:
     - @Service: 비즈니스 로직을 처리하는 서비스 계층을 나타낼 때 사용됩니다.
     - @Repository: 데이터베이스 작업을 처리하는 DAO 클래스에 사용되며, 데이터 액세스 관련 예외를 Spring의 예외로 변환하는 기능을 추가로 제공합니다.
     - @Controller: 웹 애플리케이션에서 사용자의 요청을 처리하고, 응답을 생성하는 컨트롤러 클래스에 사용됩니다.
   - 이 어노테이션들은 @Component와 동일한 방식으로 Bean으로 등록되지만, 각 계층에 따른 명확한 역할을 부여하여 가독성과 구조를 향상시킵니다.

5. @ComponentScan과 함께 사용
   - @ComponentScan 어노테이션은 Spring이 @Component 어노테이션이 붙은 클래스를 찾아서 등록할 수 있게 합니다.
   - @ComponentScan은 주로 Spring 설정 클래스나 XML 설정 파일에서 사용되며, 스캔할 패키지를 지정하여 해당 패키지 내에서 @Component가 붙은 클래스를 찾아 관리합니다.
   - 예시:
     ```
     @Configuration
     @ComponentScan(basePackages = "com.example.service")
     public class AppConfig {
     }
     ```
     위 예시에서 Spring은 `com.example.service` 패키지 내에서 @Component 어노테이션이 붙은 클래스를 모두 찾아 Bean으로 등록합니다.

6. 예시
   - 예를 들어, 다음과 같이 @Component 어노테이션을 사용하면 해당 클래스는 Spring에서 자동으로 Bean으로 등록되어, 다른 클래스에서 주입받아 사용할 수 있습니다.
     ```
     @Component
     public class MyService {
         public void doSomething() {
             System.out.println("Service logic executed");
         }
     }
     
     @Component
     public class MyController {
         @Autowired
         private MyService myService;
         
         public void handleRequest() {
             myService.doSomething();
         }
     }
     ```
     위 코드에서 `MyService` 클래스는 @Component 어노테이션으로 Spring 컨테이너에 등록되며, `MyController` 클래스는 `MyService` Bean을 주입받아 사용할 수 있게 됩니다.

-- ------------------------------------

@Autowired란?

@Autowired는 Spring에서 제공하는 의존성 주입(Dependency Injection) 어노테이션입니다. 
Spring 컨테이너가 관리하는 Bean들 사이의 의존성을 자동으로 주입하는 역할을 합니다. 
즉, 클래스의 필드, 생성자, 또는 메서드에 @Autowired를 붙이면, Spring이 해당 객체(Bean)를 자동으로 찾아 주입해 줍니다.

1. 의존성 주입이란?
의존성 주입(Dependency Injection, DI)은 객체 간의 의존 관계를 외부에서 설정해주는 방식입니다. 
객체는 스스로 필요한 의존 객체를 생성하는 대신, Spring 같은 컨테이너가 필요한 객체를 생성하여 제공해 줍니다. 
이를 통해 객체 간의 결합도가 낮아져, 유지보수가 쉬워지고 테스트가 용이해집니다.

2. @Autowired의 동작 방식
@Autowired는 해당 필드나 메서드에 대해 Spring이 자동으로 Bean을 주입하도록 지시합니다. 
이를 통해 개발자는 명시적으로 객체를 생성하지 않고도 필요한 Bean을 주입받아 사용할 수 있습니다.

3. 사용되는 위치
- 필드: 클래스의 멤버 변수에 @Autowired를 붙이면, Spring이 해당 타입의 Bean을 자동으로 찾아 주입합니다.
- 생성자: 생성자에 @Autowired를 붙이면, 객체 생성 시점에 필요한 의존 객체들이 주입됩니다.
- 메서드: 메서드에 @Autowired를 붙이면, 메서드 호출 시점에 해당 메서드에 필요한 Bean이 주입됩니다.

4. 주입 방식
- 타입 기반 주입: @Autowired는 기본적으로 타입을 기준으로 Bean을 주입합니다. 
  즉, 같은 타입의 Bean이 여러 개 있는 경우, 해당 타입에 맞는 Bean을 자동으로 찾아 주입합니다.
  
5. 예외 상황
- 만약 주입할 Bean이 없거나 여러 개 있을 때, Spring은 NoSuchBeanDefinitionException 또는 
  NoUniqueBeanDefinitionException을 발생시킵니다. 이를 방지하기 위해 @Autowired(required = false)로 설정하면,
  주입할 Bean이 없더라도 오류를 발생시키지 않고 넘어가게 할 수 있습니다.

*/
