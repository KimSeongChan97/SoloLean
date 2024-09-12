package com.jstl;

// Lombok의 어노테이션을 사용하여 코드를 자동으로 생성해주는 기능을 설정
import lombok.AllArgsConstructor;   // 모든 필드를 포함하는 생성자를 자동으로 생성해주는 Lombok 어노테이션
import lombok.Data;                 // Getter, Setter, toString, equals, hashCode 메서드를 자동으로 생성
import lombok.NoArgsConstructor;    // 기본 생성자(파라미터가 없는 생성자)를 자동으로 생성해주는 Lombok 어노테이션
import lombok.NonNull;              // 필드에 null이 허용되지 않도록 설정하는 Lombok 어노테이션
import lombok.RequiredArgsConstructor; // @NonNull이 붙은 필드만을 인자로 받는 생성자를 생성하는 Lombok 어노테이션
//import lombok.Getter; // Lombok의 Getter 어노테이션으로, 해당 필드의 getter 메서드를 자동 생성
//import lombok.Setter; // Lombok의 Setter 어노테이션으로, 해당 필드의 setter 메서드를 자동 생성

// 모든 필드 값을 인자로 받는 생성자를 생성해주는 어노테이션 (@AllArgsConstructor)
// 예: new PersonDTO("이름", 25);
@AllArgsConstructor

// 기본 생성자(인자가 없는 생성자)를 자동으로 생성해주는 어노테이션 (@NoArgsConstructor)
// 예: new PersonDTO();
@NoArgsConstructor

// @NonNull이 붙은 필드만 포함하는 생성자를 자동으로 생성 (@RequiredArgsConstructor)
// name 필드는 @NonNull이 붙었기 때문에 해당 필드를 포함하는 생성자가 생성됨
// 예: new PersonDTO("이름");
@RequiredArgsConstructor

//@Getter 어노테이션: 이 어노테이션을 사용하면 클래스의 각 필드에 대한 getter 메서드가 자동으로 생성됨
//@Setter 어노테이션: 이 어노테이션을 사용하면 클래스의 각 필드에 대한 setter 메서드가 자동으로 생성됨
// 이 두 어노테이션은 @Data 어노테이션에 포함되어 있으므로 주석 처리되어 있음

// @Data 어노테이션: @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 등을 포함
// 즉, 이 어노테이션 하나만으로 모든 필드의 getter, setter 메서드를 자동으로 생성하고, 
// toString(), equals(), hashCode() 메서드도 자동으로 생성됨
@Data
public class PersonDTO {

    // @NonNull 어노테이션: 이 필드는 null 값을 허용하지 않음
    // 즉, 이 클래스의 생성자에서 name 필드를 null로 설정하려고 하면 NullPointerException이 발생함
    // @NonNull은 기본적으로 @RequiredArgsConstructor와 함께 작동하여 name 필드를 필수로 설정하도록 만듦
    @NonNull
    private String name; // 사람의 이름을 저장하는 필드, null이 될 수 없으며 필수 값임

    private int age;     // 사람의 나이를 저장하는 필드, 기본적으로 0 이상의 정수 값을 가짐

    // Lombok을 통해 자동으로 getter, setter, toString, equals, hashCode 등의 메서드가 생성되므로
    // 이러한 메서드를 명시적으로 작성하지 않아도 됨
}
