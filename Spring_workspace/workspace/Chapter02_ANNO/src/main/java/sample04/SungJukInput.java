package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component 어노테이션은 이 클래스를 Spring의 Bean으로 등록하여 Spring이 관리할 수 있게 만듭니다.
// Spring의 Bean으로 등록되면, Spring 컨테이너에서 이 객체를 생성 및 관리하며, 필요 시 다른 클래스에 주입됩니다.

//@Scope("prototype")은 Spring에서 이 클래스의 Bean이 **프로토타입 스코프**로 동작하도록 지정합니다.
//기본적으로 Spring의 Bean은 "싱글톤"(singleton) 스코프를 가집니다. 싱글톤은 애플리케이션 컨텍스트당 하나의 인스턴스만 생성되며, 
//모든 요청에서 동일한 객체가 반환됩니다.
//반면, **프로토타입 스코프**는 요청할 때마다 **새로운 객체 인스턴스가 생성**됩니다. 즉, 각 요청마다 서로 다른 인스턴스가 주입됩니다.
//
//**프로토타입 스코프의 특징:**
//1. 매번 새로운 객체가 생성됩니다: @Scope("prototype")을 사용하면 Spring은 요청이 있을 때마다 이 클래스의 새로운 인스턴스를 생성합니다.
// 각 요청마다 별도의 객체가 생성되므로, 각 인스턴스는 서로 독립적인 상태를 가집니다. 예를 들어, 여러 사용자의 입력을 처리하는 데 적합합니다.
//2. Spring 컨테이너는 더 이상 이 객체의 생명주기를 관리하지 않습니다: 프로토타입 객체는 생성된 후, 그 객체의 생명주기나 제거는 개발자의 책임입니다. 
// 즉, Spring은 객체를 생성만 하고, 그 이후에는 관리하지 않습니다.
//3. 상태를 갖는 객체에 적합합니다: 프로토타입 스코프는 객체가 상태(값)를 가지며, 각 요청마다 독립적인 상태를 유지해야 하는 경우 적합합니다. 
// 예를 들어, 여러 사용자의 데이터를 동시에 처리해야 하는 상황에서 각 사용자가 독립적인 데이터를 가질 수 있도록 하기 위해 프로토타입 스코프를 사용할 수 있습니다.
//
//**프로토타입 스코프의 사용 예:**
//- 사용자가 입력한 데이터를 별도의 객체에 저장하고, 각 사용자가 다른 데이터를 입력할 때마다 새로운 객체가 생성되도록 하고 싶을 때 사용합니다.
//- 성적 입력 시스템과 같은 애플리케이션에서 각 학생의 성적을 관리하는 DTO(SungJukDTO2) 객체는 각 입력마다 새로운 객체가 필요하므로, 
//프로토타입 스코프가 유용합니다.
//
//**주의할 점:**
//- 프로토타입 스코프를 사용하면 메모리 관리가 중요해집니다. Spring이 객체를 생성한 후에는 관리하지 않으므로, 필요 없는 객체를 적절한 시점에 제거해 주어야 합니다.
//- 보통은 싱글톤이 더 자주 사용되지만, 프로토타입 스코프는 특정 상황에서 매우 유용합니다. 특히, 다중 사용자 시스템에서 상태가 각 사용자별로 달라야 할 때 적합합니다.
@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {

    // @Setter: Lombok 라이브러리의 어노테이션으로, 이 필드에 대해 자동으로 setter 메서드를 생성합니다.
    // 즉, 외부에서 이 클래스에 SungJukDTO2 객체를 주입할 수 있는 setter 메서드가 자동으로 만들어집니다.
    // Spring에서는 의존성 주입(Dependency Injection)을 통해 sungJukDTO2 객체가 주입될 수 있습니다.
    // @Autowired는 Spring에서 의존성을 주입할 때 사용하는 어노테이션으로, SungJukDTO2 타입의 Bean을 자동으로 주입받습니다.
    // 주입된 sungJukDTO2 객체는 성적 데이터를 저장하는 데 사용됩니다.
    @Autowired
    private SungJukDTO2 sungJukDTO2 = null;
    // 성적 데이터를 저장할 SungJukDTO2 객체입니다. 학생의 이름, 국어, 영어, 수학 점수를 여기에 저장하고,
    // 이후 리스트에 추가하는 방식으로 여러 학생의 성적을 관리하게 됩니다.
    // @Autowired는 Spring이 이 객체를 자동으로 생성하여 주입합니다. 즉, 개발자가 별도로 new 키워드를 사용하여 객체를 만들지 않아도 됩니다.
    // 'null'로 초기화된 이유는 Spring이 이 필드를 나중에 주입할 것이기 때문에 명시적으로 값을 할당할 필요가 없다는 뜻입니다.

    // @Setter: 이 필드(list)에 대해서도 setter 메서드가 Lombok에 의해 자동으로 생성됩니다.
    // List<SungJukDTO2>는 여러 학생의 성적 데이터를 저장하는 리스트로, Spring에서 주입될 수 있습니다.
    // Spring에서 관리하는 SungJukDTO2 객체들의 리스트가 자동으로 주입됩니다.
    @Autowired
    @Qualifier("arrayList")
    private List<SungJukDTO2> list;
    // SungJukDTO2 객체들이 저장된 리스트입니다. 이 리스트에 학생들의 성적 정보가 차례대로 저장됩니다.
    // Spring에서 이 리스트를 관리하며, 리스트는 성적 데이터를 입력할 때마다 여기에 추가됩니다.
    // @Qualifier("arrayList")는 스프링에서 주입할 때 어떤 Bean을 사용할지 명시적으로 지정하는 데 사용됩니다. 
    // 동일한 타입의 Bean이 여러 개 있을 때, 특정 이름의 Bean을 선택하여 주입합니다.
    // 여기서는 "arrayList"라는 이름으로 등록된 ArrayList 객체를 주입하게 됩니다.
    // list는 학생들의 성적 데이터를 담는 중요한 컬렉션입니다.

    /*
     * 1. 인터페이스와 구현체: List는 인터페이스이고, ArrayList는 List 인터페이스의 구현체입니다. Spring은 이러한 관계를
     * 잘 이해하고 있습니다. 2. Spring의 타입 매칭: Spring의 의존성 주입 시스템은 타입을 기반으로 매칭합니다. ArrayList는
     * List 인터페이스를 구현하므로, Spring은 ArrayList 타입의 빈을 List 타입으로 선언된 필드에 주입할 수 있습니다.
     * 구체적인 타입 사용: ArrayList로 변경함으로써, 더 구체적인 타입을 사용하게 되었습니다. 이는 Spring이 정확히 어떤 구현체를
     * 주입해야 하는지 명확하게 알려주는 것입니다. Bean 정의와의 일치: SpringConfiguration 클래스에서 Bean을 정의할 때
     * ArrayList를 반환하고 있습니다 5. 다형성 유지: ArrayList를 사용하더라도, List 인터페이스의 모든 메서드를 그대로
     * 사용할 수 있습니다. 따라서 기존 코드의 동작에는 영향을 주지 않습니다. 성능과 기능: ArrayList는 List 인터페이스의 가장
     * 일반적인 구현체 중 하나로, 대부분의 상황에서 좋은 성능을 제공합니다. 또한, ArrayList의 특정 메서드를 사용해야 할 경우 타입
     * 캐스팅 없이 바로 사용할 수 있는 장점이 있습니다. 결론적으로, List에서 ArrayList로 변경한 것은 Spring의 의존성 주입
     * 시스템과 잘 맞으며, Bean 정의와도 일치하기 때문에 정상적으로 작동합니다. 이 변경으로 인해 코드의 명확성이 증가하고, 필요한 경우
     * ArrayList의 특정 기능을 더 쉽게 사용할 수 있게 되었습니다.
     */
    // 위의 설명은 List와 ArrayList의 관계 및 Spring에서 이를 어떻게 주입하는지를 상세히 설명하고 있습니다.
    // List는 인터페이스이므로 다양한 구현체(ArrayList, LinkedList 등)를 사용할 수 있으며, 그 중에서 ArrayList를 사용하여 Bean으로 주입합니다.
    // 또한 ArrayList는 데이터를 저장하는 데 효율적이며, 빠른 검색과 추가, 삭제 작업이 가능합니다.

    //  public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
    //      this.sungJukDTO2 = sungJukDTO2;
    //  }
    // 위 코드는 setter 메서드를 수동으로 작성한 코드입니다.
    // 하지만 Lombok의 @Setter 어노테이션을 사용했기 때문에, 이 코드는 주석 처리되어 있습니다.
    // Lombok이 자동으로 setter 메서드를 생성해 주므로 직접 작성할 필요가 없습니다.

    //  public void setList(List<SungJukDTO2> list) {
    //      this.list = list;
    //  }
    // 마찬가지로, 리스트에 대한 setter 메서드도 Lombok @Setter로 대체되어 자동으로 생성됩니다.
    // 수동으로 작성된 setter는 주석 처리되었습니다.

    @Override
    public void execute() {
        System.out.println(); // 공백 줄 출력
        // 출력 시 보기 좋게 공백을 추가하여 화면 구성을 정리합니다.

        Scanner scan = new Scanner(System.in); // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        // Scanner 객체는 콘솔에서 사용자의 입력을 받기 위해 사용됩니다.
        // 각 입력 항목마다 사용자가 직접 값을 입력할 수 있습니다.

        System.out.print("이름 입력: ");
        String name = scan.next(); // 사용자가 입력한 이름을 저장
        // 사용자로부터 학생의 이름을 입력받아 name 변수에 저장합니다.

        System.out.print("국어점수 입력: ");
        int kor = scan.nextInt(); // 사용자가 입력한 국어 점수를 저장
        // 국어 점수를 입력받아 kor 변수에 저장합니다.

        System.out.print("영어점수 입력: ");
        int eng = scan.nextInt(); // 사용자가 입력한 영어 점수를 저장
        // 영어 점수를 입력받아 eng 변수에 저장합니다.

        System.out.print("수학점수 입력: ");
        int math = scan.nextInt(); // 사용자가 입력한 수학 점수를 저장
        // 수학 점수를 입력받아 math 변수에 저장합니다.

        // 국어, 영어, 수학 점수를 합산하여 총점을 계산
        int tot = kor + eng + math;
        // 입력된 국어, 영어, 수학 점수를 합산하여 tot 변수에 총점을 저장합니다.

        // 평균을 계산, 총점을 3.0으로 나누어 실수형 평균을 구함
        double avg = tot / 3.0;
        // 총점을 3으로 나누어 평균을 계산하고, avg 변수에 저장합니다.
        // 3으로 나누는 이유는 성적이 국어, 영어, 수학 세 과목이기 때문입니다.
        // 3.0으로 나누어 실수형(double) 값으로 평균을 구합니다.
        // 'double' 타입을 사용하면 소수점 아래 값까지 정확하게 계산할 수 있습니다.

        // 성적 데이터를 SungJukDTO2 객체에 설정
        sungJukDTO2.setName(name); // 이름 설정
        sungJukDTO2.setKor(kor); // 국어 점수 설정
        sungJukDTO2.setEng(eng); // 영어 점수 설정
        sungJukDTO2.setMath(math); // 수학 점수 설정
        sungJukDTO2.setTot(tot); // 총점 설정
        sungJukDTO2.setAvg(avg); // 평균 설정
        // 사용자가 입력한 성적 데이터를 sungJukDTO2 객체에 설정합니다.
        // setName(), setKor(), setEng(), setMath(), setTot(), setAvg() 메서드를 통해
        // 각 필드에 값을 설정하여 sungJukDTO2 객체에 성적 정보를 저장합니다.
        // 각 set 메서드는 해당 필드에 값을 설정하는 역할을 하며, 나중에 get 메서드를 통해 그 값을 확인할 수 있습니다.

        // SungJukDTO2 객체를 리스트에 추가
        list.add(sungJukDTO2);
        // 성적 데이터가 설정된 sungJukDTO2 객체를 리스트에 추가합니다.
        // 이렇게 추가된 데이터는 리스트를 통해 관리되며, 이후 출력, 수정, 삭제 등의 작업에 사용됩니다.
        // 리스트에 추가된 각 객체는 학생 한 명의 성적 데이터를 나타냅니다.

        // 입력 완료 메시지 출력
        System.out.println(name + "님의 데이터를 입력 하였습니다.");
        // 성적 데이터 입력이 완료되었음을 사용자에게 알리는 메시지를 출력합니다.
        // 여기서는 학생의 이름을 포함하여 메시지를 출력합니다.

        System.out.println(); // 공백 줄 출력
        // 화면 구성을 깔끔하게 하기 위해 공백을 추가로 출력합니다.
    }
}
