package user.bean;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter // Lombok을 사용하여 자동으로 getter 메서드를 생성합니다.
// 이 어노테이션 덕분에 name, id, pwd 필드에 대한 getter 메서드를 따로 작성하지 않아도 됩니다.
@Setter // Lombok을 사용하여 자동으로 setter 메서드를 생성합니다.
// 이 어노테이션 덕분에 name, id, pwd 필드에 대한 setter 메서드를 따로 작성하지 않아도 됩니다.
@Component // Spring에서 이 클래스를 빈(Bean)으로 등록하여 관리할 수 있도록 하는 어노테이션입니다.
// 즉, 이 클래스는 스프링 컨테이너에 의해 관리되는 객체가 됩니다. 다른 클래스에서 의존성 주입으로 사용할 수 있습니다.
public class UserDTO {
    String name; // 사용자의 이름을 저장하는 필드입니다.
    String id;   // 사용자의 아이디를 저장하는 필드입니다.
    String pwd;  // 사용자의 비밀번호를 저장하는 필드입니다.

    // toString() 메서드는 객체의 정보를 문자열로 반환하는 역할을 합니다.
    // 여기서는 name, id, pwd 값을 탭("\t")으로 구분하여 문자열로 반환합니다.
    @Override
    public String toString() {
        return name + "\t" + id + "\t" + pwd;
    }
}
