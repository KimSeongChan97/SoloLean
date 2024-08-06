package lmabda;

// Create01 인터페이스는 단일 매개변수를 받는 Person 객체를 생성하는 팩토리 메서드를 정의합니다.
@FunctionalInterface
interface Create01 {
    public Person create(String name);
}
//--------------------------
// Create02 인터페이스는 두 개의 매개변수를 받는 Person 객체를 생성하는 팩토리 메서드를 정의합니다.
@FunctionalInterface
interface Create02 {
    public Person create(String name, int age);
}
//--------------------------
// Person 클래스는 이름과 나이를 속성으로 가지며, 두 가지 생성자를 제공합니다.
class Person {
    private String name;
    private int age;
    
    // 이름을 매개변수로 받는 생성자입니다.
    public Person(String name) {
        this.name = name;
        System.out.println("Person(String name) 매개변수 생성자가 호출");
    }

    // 이름과 나이를 매개변수로 받는 생성자입니다.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String name, int age) 매개변수 생성자가 호출");
    }

    // 이름을 반환하는 getter 메서드입니다.
    public String getName() {
        return name;
    }

    // 나이를 반환하는 getter 메서드입니다.
    public int getAge() {
        return age;
    }
    
}
//-------------------------
// PersonTest 클래스는 Create01과 Create02 인터페이스를 사용하여 Person 객체를 생성하는 메서드를 포함합니다.
class PersonTest {
    // Create01 인터페이스를 사용하여 Person 객체를 생성합니다.
    public Person gerPerson01(Create01 create01) {
        String name = "none";
        // 생성자 호출을 통해 Person 객체를 생성합니다.
        Person person = new Person(name);
        return person;
    }
    
    // Create02 인터페이스를 사용하여 Person 객체를 생성합니다.
    public Person gerPerson02(Create02 create02) {
        String name = "홍길동";
        int age = 25;
        // 생성자 호출을 통해 Person 객체를 생성합니다.
        Person person = new Person(name, age);
        return person;
    }
}

//--------------------------
public class LambdaMain07 {

    public static void main(String[] args) {
        PersonTest personTest = new PersonTest();
        
        // Create01 인터페이스의 create 메서드를 Person 클래스의 생성자로 매핑하여 Person 객체를 생성합니다.
        Person one = personTest.gerPerson01(Person :: new); // 생성자를 참조하여 적용
        System.out.println(" 이름 : " + one.getName());
        System.out.println(" 나이 : " + one.getAge());
        System.out.println();
        
        // Create02 인터페이스의 create 메서드를 Person 클래스의 생성자로 매핑하여 Person 객체를 생성합니다.
        Person two = personTest.gerPerson02(Person :: new); // 생성자를 참조하여 적용
        System.out.println(" 이름 : " + two.getName());
        System.out.println(" 나이 : " + two.getAge());
        System.out.println();
        
    }
    
}


/*
생성장 참조
생성자를 참조한다는 것은 객체를 생성하는 것을 의미한다.
생성자 Overload 되어 여러 개가 있을 경우, 함수형 인터페이스의 추상메소드와 동일한 매개변수 타입과 개수를 가진 생성자를 찾아 실행한다.

(a, b) -> {
return new 클래스(a, b);
}
=> 생성자 참조  클래스 :: new

분석 내용 추가:
Create01 인터페이스:
단일 매개변수를 받는 Person 객체를 생성하는 팩토리 메서드를 정의합니다.
Create02 인터페이스:
두 개의 매개변수를 받는 Person 객체를 생성하는 팩토리 메서드를 정의합니다.
Person 클래스:
name 과 age 를 속성으로 가지며, 두 가지 생성자를 제공합니다.
Person(String name) 생성자: 이름을 매개변수로 받아 객체를 생성합니다.
Person(String name, int age) 생성자: 이름과 나이를 매개변수로 받아 객체를 생성합니다.
PersonTest 클래스:
gerPerson01(Create01 create01) 메서드: Create01 인터페이스를 사용하여 Person 객체를 생성합니다.
gerPerson02(Create02 create02) 메서드: Create02 인터페이스를 사용하여 Person 객체를 생성합니다.
LambdaMain07 클래스:
main 메서드: PersonTest 객체를 생성하고, 생성자 참조를 사용하여 Person 객체를 생성합니다.
첫 번째 Person 객체 생성: Create01 인터페이스의 create 메서드를 Person 클래스의 생성자로 매핑하여 Person 객체를 생성합니다.
두 번째 Person 객체 생성: Create02 인터페이스의 create 메서드를 Person 클래스의 생성자로 매핑하여 Person 객체를 생성합니다.

 */

