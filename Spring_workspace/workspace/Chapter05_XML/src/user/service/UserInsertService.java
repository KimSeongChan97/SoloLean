package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {
    
    @Setter 
    private UserDTO userDTO;
    
    @Setter
    private UserDAO userDAO;
    
    @Override
    public void execute() {
        System.out.println(); // 빈 줄 출력
        Scanner scan = new Scanner(System.in);
        
        // 사용자로부터 이름 입력을 받음
        System.out.println("이름 입력 : ");
        String name = scan.next();
        
        // 사용자로부터 아이디 입력을 받음
        System.out.println("아이디 입력 : ");
        String id = scan.next();
        
        // 사용자로부터 비밀번호 입력을 받음
        System.out.println("비밀번호 입력 : ");
        String pwd = scan.next();
        
        // 입력받은 데이터를 userDTO 객체에 설정 (Setter 주입을 통해 주입된 userDTO 사용)
        userDTO.setName(name);    
        userDTO.setId(id);
        userDTO.setPwd(pwd);
        
        // DB에 데이터를 저장하는 메서드를 호출함 (userDAO는 스프링에서 의존성 주입됨)
        // userDAO.write() 메서드는 데이터베이스에 userDTO 정보를 저장하는 역할을 함
        userDAO.write(userDTO);
        
        // 사용자에게 데이터 저장 완료 메시지를 출력
        System.out.println(name + " 님의 데이터를 저장하였습니다.");
    }
}
