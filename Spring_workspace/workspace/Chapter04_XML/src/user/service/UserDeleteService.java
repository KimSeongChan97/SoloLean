package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

    @Setter
    // Lombok의 @Setter 어노테이션을 사용하여 UserDAO의 setter 메서드를 자동으로 생성합니다.
    // 이를 통해 Spring 프레임워크에서 DI(Dependency Injection)를 쉽게 할 수 있습니다.
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println();
        // 사용자로부터 삭제할 아이디를 입력받기 위해 Scanner 객체를 사용합니다.
        Scanner scan = new Scanner(System.in);
        
        System.out.print("삭제 할 아이디 입력 : ");
        String id = scan.next();
        // 사용자가 입력한 아이디를 변수 `id`에 저장합니다.

        // DB에서 해당 아이디가 존재하는지 확인하기 위해 UserDAO의 getExistId 메서드를 호출합니다.
        // getExistId 메서드는 아이디가 존재하면 UserDTO 객체를 반환하고, 존재하지 않으면 null을 반환합니다.
        UserDTO userDTO = userDAO.getExistId(id);
        
        if(userDTO == null) {
            // 아이디에 해당하는 사용자가 없을 경우 메시지를 출력하고 함수 실행을 종료합니다.
            System.out.println("찾고자 하는 아이디가 없습니다.");
            return; // 함수를 종료하여 더 이상의 처리를 진행하지 않음.
        }
        
        System.out.println();
        
        // userDAO의 delete 메서드를 호출하여 입력한 아이디에 해당하는 사용자의 데이터를 삭제합니다.
        userDAO.delete(id);
        
        // 데이터 삭제가 완료된 후 해당 아이디의 사용자 데이터를 삭제했다는 메시지를 출력합니다.
        System.out.println(id + "님의 데이터를 삭제하였습니다.");
    }
}
