package io; // 패키지 선언: 이 클래스가 속한 패키지를 정의합니다. 이 경우 'io' 패키지입니다.

import java.io.Serializable; // Serializable 인터페이스 임포트: 객체를 직렬화하기 위해 필요합니다.

/*
 * PersonDTO 클래스: 데이터 전송 객체(Data Transfer Object)로, 
 * 직렬화를 통해 객체를 파일로 저장하거나 네트워크를 통해 전송할 수 있게 합니다.
 */
public class PersonDTO implements Serializable { // Serializable 인터페이스를 구현하여 객체를 직렬화할 수 있게 합니다.

    // 멤버 변수 선언: private 접근 제어자로 선언되어 클래스 외부에서 직접 접근할 수 없습니다.
    private String name; // 이름을 저장하는 변수
    private int age; // 나이를 저장하는 변수
    private double height; // 키를 저장하는 변수

    // 기본 생성자: 매개변수가 없는 생성자로, 객체 생성 시 기본값으로 초기화합니다.
    public PersonDTO() {}

    // 매개변수가 있는 생성자: 이름, 나이, 키를 매개변수로 받아 객체를 초기화합니다.
    public PersonDTO(String name, int age, double height) {
        this.name = name; // this.name은 현재 객체의 name 변수, name은 매개변수
        this.age = age; // this.age는 현재 객체의 age 변수, age는 매개변수
        this.height = height; // this.height는 현재 객체의 height 변수, height는 매개변수
    }

    // getter 메서드: name 변수를 반환합니다.
    public String getName() {
        return name;
    }

    // setter 메서드: name 변수를 설정합니다.
    public void setName(String name) {
        this.name = name;
    }

    // getter 메서드: age 변수를 반환합니다.
    public int getAge() {
        return age;
    }

    // setter 메서드: age 변수를 설정합니다.
    public void setAge(int age) {
        this.age = age;
    }

    // getter 메서드: height 변수를 반환합니다.
    public double getHeight() {
        return height;
    }

    // setter 메서드: height 변수를 설정합니다.
    public void setHeight(double height) {
        this.height = height;
    }
}
