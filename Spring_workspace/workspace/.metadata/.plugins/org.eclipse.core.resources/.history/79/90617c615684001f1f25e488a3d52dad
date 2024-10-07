package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

    @Setter 
    // Lombok의 @Setter 어노테이션을 사용하여 UserDAO에 대한 setter 메서드를 자동으로 생성합니다.
    private UserDAO userDAO;

    @Setter
    // Lombok의 @Setter 어노테이션을 사용하여 UserDTO에 대한 setter 메서드를 자동으로 생성합니다.
    private UserDTO userDTO;

    @Override
    public void execute() {
        System.out.println();
        // 사용자 입력을 받기 위한 Scanner 객체를 생성합니다.
        Scanner scan = new Scanner(System.in);
        
        System.out.println("수정할 아이디 입력 : ");
        String id = scan.next();
        // 사용자가 입력한 아이디를 변수 `id`에 저장합니다. 이 아이디는 수정할 사용자를 식별하는 데 사용됩니다.
        
        // DB에서 해당 아이디로 사용자 정보를 가져옵니다.
        UserDTO userDTO = userDAO.getExistId(id);
        // getExistId 메서드는 주어진 아이디가 데이터베이스에 있는지 확인하고, 그 사용자 정보를 반환합니다.
        // 만약 해당 아이디가 존재하지 않으면 null을 반환합니다.
        
        if(userDTO == null) {
            // 아이디에 해당하는 사용자가 없는 경우 출력 메시지를 보여주고 함수 실행을 중단합니다.
            System.out.println("찾고자 하는 아이디가 없습니다.");
            return; // 함수 종료
        }
        
        System.out.println();
        System.out.println("이름\t아이디\t비밀번호");
        System.out.println(userDTO);
        // 가져온 사용자 정보를 출력합니다. `toString` 메서드가 적절히 구현되어 있으면 `userDTO` 객체의 정보를 출력할 수 있습니다.

        System.out.println();
        System.out.println("이름 입력 : ");
        String name = scan.next();
        System.out.println("비밀번호 입력 : ");
        String pwd = scan.next();
        // 사용자가 수정할 이름과 비밀번호를 입력받아 각각 변수에 저장합니다.

        // 수정할 데이터를 Map으로 생성합니다.
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("id", id);
        map.put("pwd", pwd);
        // 수정할 사용자 정보를 `Map`에 저장합니다. key로는 필드명(name, id, pwd), value로는 사용자가 입력한 값을 저장합니다.
        // Map을 사용하는 이유는 데이터의 유연성을 높이고, 나중에 데이터를 처리하는 방식을 확장하기 용이하기 때문입니다.

        userDAO.update(map);
        // userDTO 객체를 기반으로 사용자 정보를 DB에 업데이트합니다. 
        // DAO 클래스에서 이 메서드가 구현되어 있으며, 주로 UPDATE SQL 쿼리를 실행하게 됩니다.

        System.out.println(id + " 님의 데이터를 수정하였습니다.");
        // 수정이 완료되면 성공 메시지를 출력합니다.
    }
}
