package collection;

// PersonDTO 클래스는 데이터를 저장하고 전달하기 위한 Data Transfer Object (DTO)입니다.
public class PersonDTO extends Object implements Comparable<PersonDTO> {
    // private 접근 제한자를 가진 인스턴스 변수 (멤버 변수) 선언
    private String name; // 사람의 이름을 저장
    private int age;     // 사람의 나이를 저장

    // 기본 생성자
    public PersonDTO() {
    }

    // 매개변수가 있는 생성자
    public PersonDTO(String name, int age) {
        super(); // Object 클래스의 생성자를 명시적으로 호출 (사실상 생략 가능)
        this.name = name; // 매개변수로 전달된 name 값을 인스턴스 변수 name에 할당
        this.age = age;   // 매개변수로 전달된 age 값을 인스턴스 변수 age에 할당
    }

    // 이름을 설정하는 setter 메서드
    public void setName(String name) {
        this.name = name; // 매개변수로 전달된 name 값을 인스턴스 변수 name에 할당
    }

    // 나이를 설정하는 setter 메서드
    public void setAge(int age) {
        this.age = age; // 매개변수로 전달된 age 값을 인스턴스 변수 age에 할당
    }

    // 이름을 반환하는 getter 메서드
    public String getName() {
        return name; // 인스턴스 변수 name의 값을 반환
    }

    // 나이를 반환하는 getter 메서드
    public int getAge() {
        return age; // 인스턴스 변수 age의 값을 반환
    }

    // 객체의 문자열 표현을 반환하는 toString 메서드 (Object 클래스의 toString 메서드를 오버라이딩)
    @Override
    public String toString() {
        return "이름 = " + name + "\t 나이 = " + age; // 객체의 이름과 나이를 포함한 문자열을 반환
    }

    // compareTo 메서드 구현 (Comparable 인터페이스의 메서드)
    @Override
    public int compareTo(PersonDTO p) {
     // 이름으로 내림차순 정렬
     return this.name.compareTo(p.name) * -1; // 이름을 비교하여 결과를 반환 (-1, 0, 1)
     
     
    }
}














