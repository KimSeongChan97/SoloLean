package class_;

// Person 클래스를 정의합니다.
class Person {
    // 필드 변수를 private으로 선언하여 클래스 외부에서 접근을 막습니다.
    private String name; // 이름을 저장하는 필드
    private int age; // 나이를 저장하는 필드
    
    // name 필드의 값을 설정하는 메서드입니다.
    public void setName(String n) { // name 값을 설정하는 메서드
        name = n;
    }
    
    // age 필드의 값을 설정하는 메서드입니다.
    public void setAge(int a) { // age 값을 설정하는 메서드
        age = a;
    }
    
    // name과 age 필드의 값을 동시에 설정하는 메서드입니다.
    public void setData(String n, int a) {
        name = n;
        age = a;
    }
    
    // 아무 값도 설정하지 않는 메서드로, 오버로딩된 메서드입니다.
    public void setData() { // 오버로딩: 같은 이름의 메서드를 여러 번 정의함
        // 비어 있는 메서드, 아무 동작도 하지 않음
    }
    
    // name 필드의 값을 반환하는 메서드입니다.
    public String getName() { // name 값을 반환하는 메서드
        return name;
    }
    
    // age 필드의 값을 반환하는 메서드입니다.
    public int getAge() { // age 값을 반환하는 메서드
        return age;
    }
} // Person 클래스 정의 끝

// PersonMain 클래스를 정의합니다. 이는 프로그램의 실행 진입점입니다.
public class PersonMain {

    // 메인 메서드: 프로그램이 시작되는 곳입니다.
    public static void main(String[] args) {
        // Person 클래스 타입의 변수 aa를 선언합니다.
        Person aa; 
        
        // Person 클래스의 인스턴스를 생성하고 aa에 할당합니다.
        aa = new Person();
        
        // aa 변수에 저장된 객체의 참조 값을 출력합니다.
        System.out.println("객체 aa = " + aa);
        
        // aa 객체의 setName 메서드를 호출하여 name 필드의 값을 설정합니다.
        aa.setName(" 홍길동 "); // 메서드를 호출하여 name 값을 설정
        
        // aa 객체의 setAge 메서드를 호출하여 age 필드의 값을 설정합니다.
        aa.setAge(25); // 메서드를 호출하여 age 값을 설정
        
        // aa 객체의 getName 메서드를 호출하여 name 필드의 값을 출력합니다.
        // aa 객체의 getAge 메서드를 호출하여 age 필드의 값을 출력합니다.
        System.out.println(" 이름 = " + aa.getName() + "  나이 = " + aa.getAge());
        System.out.println(); // 줄바꿈을 위한 빈 출력
        
        // 새로운 Person 객체 bb를 생성합니다.
        Person bb = new Person();
        System.out.println("객체 bb = " + bb); // 새로운 객체의 참조 값 출력
        
        // bb 객체의 name과 age 값을 설정합니다.
        bb.setName("코난");
        bb.setAge(13);
        
        // bb 객체의 name과 age 값을 출력합니다.
        System.out.println(" 이름 = " + bb.getName() + "  나이 = " + bb.getAge());
        System.out.println(); // 줄바꿈을 위한 빈 출력
        
        // 새로운 Person 객체 cc를 생성합니다.
        Person cc = new Person();
        System.out.println("객체 cc = " + cc); // 새로운 객체의 참조 값 출력
        
        // cc 객체의 name과 age 값을 동시에 설정합니다.
        cc.setData("또치", 50);
        
        // cc 객체의 name과 age 값을 출력합니다.
        System.out.println(" 이름 = " + cc.getName() + "  나이 = " + cc.getAge());
        System.out.println(); // 줄바꿈을 위한 빈 출력
        
        // 새로운 Person 객체 dd를 생성합니다.
        Person dd = new Person();
        System.out.println("객체 dd = " + dd); // 새로운 객체의 참조 값 출력
        
        // dd 객체의 setData() 메서드를 호출합니다. (아무 값도 설정되지 않음)
        dd.setData();
        
        // dd 객체의 name과 age 값을 출력합니다. (초기 값: null, 0)
        System.out.println(" 이름 = " + dd.getName() + "  나이 = " + dd.getAge());
        System.out.println(); // 줄바꿈을 위한 빈 출력
    }
}


/*
class 는
캡슐화 
확장성 이 용이하다.

[실행결과]
객체 aa = class_.Person@2f92e0f4
 이름 =  홍길동   나이 = 25

객체 bb = class_.Person@1fb3ebeb
 이름 = 코난  나이 = 13

객체 cc = class_.Person@548c4f57
 이름 = 또치  나이 = 50

객체 dd = class_.Person@1218025c
 이름 = null  나이 = 0


*/