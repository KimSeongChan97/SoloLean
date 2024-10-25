package user.service;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {

    @Setter // Lombok을 이용한 Setter 주입. userDAO 필드에 대한 Setter 메서드를 자동으로 생성하여 스프링에서 주입할 수 있게 함.
    private UserDAO userDAO;

    @Override
    public void execute() {
        // DB에서 사용자 목록을 가져옵니다. userDAO는 스프링에서 의존성 주입받은 DAO 객체입니다.
        List<UserDTO> list = userDAO.getUserList();
        
        // 사용자 정보를 출력할 헤더 부분
        System.out.println("이름\t아이디\t비밀번호");
        
        // list에 저장된 UserDTO 객체들을 순차적으로 출력합니다.
        // 각 UserDTO 객체의 toString() 메서드가 호출되어 객체의 필드 값이 출력됩니다.
        for(UserDTO userDTO : list) {
            System.out.println(userDTO); // UserDTO의 toString() 메서드가 호출되어 자동으로 출력
        }
    }
}
