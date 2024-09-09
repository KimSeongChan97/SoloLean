package user.service;

import java.util.Scanner; // 사용자로부터 입력을 받기 위해 Scanner 클래스 사용

import user.bean.UserDTO; // 사용자 정보를 저장할 DTO 클래스 import
import user.dao.UserDAO; // 사용자 데이터 처리를 위한 DAO 클래스 import

public class UserInsertService implements UserService {

    // UserService 인터페이스의 execute() 메소드를 구현한 부분
    @Override
    public void execute() {
        System.out.println();
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner 객체 생성
        
        // 사용자로부터 이름, 아이디, 비밀번호를 입력받는 부분
        System.out.print(" 이름 입력 : ");
        String name = scan.next(); // 이름 입력 받기
        System.out.print(" 아이디 입력 : ");
        String id = scan.next(); // 아이디 입력 받기
        System.out.print(" 비밀번호 입력 : ");
        String pwd = scan.next(); // 비밀번호 입력 받기
        
        // 입력받은 데이터를 UserDTO 객체에 저장
        UserDTO userDTO = new UserDTO(); // UserDTO 객체 생성
        userDTO.setName(name); // 이름 설정
        userDTO.setId(id); // 아이디 설정
        userDTO.setPwd(pwd); // 비밀번호 설정
        
        // DB에 사용자 정보를 저장하는 부분
        UserDAO userDAO = UserDAO.getInstance(); // 싱글톤 패턴으로 UserDAO 객체를 가져옴
                                                 // 싱글톤 패턴은 객체를 하나만 생성하여 어디서든 동일한 객체를 사용하기 위함
                                                 // 매번 새로운 DAO 객체를 생성하지 않고 하나의 인스턴스를 공유함으로써
        										 // 자원의 낭비를 방지하고 일관된 DB 접근을 가능하게 함
        
    }

}
