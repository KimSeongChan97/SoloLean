package user.service;

import java.util.Scanner; // 사용자로부터 입력을 받기 위해 Scanner 클래스 사용
// Scanner는 표준 입력 장치(주로 키보드)로부터 데이터를 입력받는 역할을 함. 

import user.bean.UserDTO; // 사용자 정보를 저장할 DTO 클래스 import
// UserDTO는 사용자의 이름, 아이디, 비밀번호와 같은 데이터를 담는 객체.
// 이를 통해 사용자 정보를 DB로 전달하거나, DB로부터 받아 처리함.

import user.dao.UserDAO; // 사용자 데이터 처리를 위한 DAO 클래스 import
// UserDAO는 DB와 직접 상호작용하는 클래스. 
// UserDAO의 메소드를 통해 DB에 데이터를 삽입, 수정, 삭제, 조회 등의 작업을 수행함.

public class UserInsertService implements UserService {
    // UserInsertService 클래스는 사용자 정보를 입력받고 DB에 저장하는 역할을 함.
    // 이 클래스는 UserService 인터페이스를 구현함으로써 execute 메소드를 오버라이드하고 있음.
    // UserService는 서비스 로직을 담당하는 인터페이스일 것으로 추정됨.
    
    // UserService 인터페이스의 execute() 메소드를 구현한 부분
    @Override
    public void execute() {
        System.out.println(); // 화면 상에 공백 출력. 단순히 출력 포맷을 맞추기 위한 역할.
        
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위해 Scanner 객체 생성
        // 사용자로부터 데이터를 입력받기 위해 Scanner 클래스를 사용함.
        // scan 객체는 키보드 입력을 읽어오는 역할을 함.

        // 사용자로부터 이름, 아이디, 비밀번호를 입력받는 부분
        System.out.print(" 이름 입력 : ");
        String name = scan.next(); // 이름 입력 받기
        // next() 메소드는 공백을 기준으로 문자열을 입력받음. 여기서는 이름을 입력받고 있음.
        
        System.out.print(" 아이디 입력 : ");
        String id = scan.next(); // 아이디 입력 받기
        // 아이디도 마찬가지로 공백 전까지의 문자열을 입력받음.
        
        System.out.print(" 비밀번호 입력 : ");
        String pwd = scan.next(); // 비밀번호 입력 받기
        // 비밀번호는 입력된 값을 그대로 저장함.

        // 입력받은 데이터를 UserDTO 객체에 저장
        UserDTO userDTO = new UserDTO(); // UserDTO 객체 생성
        // userDTO는 이름, 아이디, 비밀번호를 담을 객체로, 이를 통해 데이터를 묶어서 DAO에 전달할 수 있음.
        
        userDTO.setName(name); // 이름 설정
        // setName() 메소드를 통해 UserDTO 객체에 입력받은 이름을 설정함.
        
        userDTO.setId(id); // 아이디 설정
        // setId() 메소드를 통해 입력받은 아이디를 UserDTO 객체에 저장함.
        
        userDTO.setPwd(pwd); // 비밀번호 설정
        // setPwd() 메소드를 통해 입력받은 비밀번호를 저장함.

        // DB에 사용자 정보를 저장하는 부분
        UserDAO userDAO = UserDAO.getInstance(); // 싱글톤 패턴으로 UserDAO 객체를 가져옴
        // 싱글톤 패턴은 프로그램에서 하나의 인스턴스만 존재하게 보장함.
        // UserDAO 객체는 매번 새로 생성하지 않고, 이미 생성된 인스턴스를 반환함.
        // 이를 통해 메모리 낭비를 줄이고, 일관된 DB 처리를 할 수 있음.
                                                 
        int su = userDAO.write(userDTO); 
        // userDAO 객체의 write() 메소드를 호출하여 DB에 데이터를 삽입함.
        // userDTO 객체에 담긴 데이터를 기반으로 SQL 삽입 작업을 처리함.
        // write() 메소드는 성공적으로 삽입된 레코드 수를 반환하며, 이를 su 변수에 저장함.
        
        
        // 응답
        System.out.println(su + " 개의 행이 삽입되었습니다. ");
        // write() 메소드가 반환한 값(su)을 출력하여, 몇 개의 레코드가 삽입되었는지 사용자에게 보여줌.
        // 이 메시지는 DB 삽입이 성공적으로 이루어졌다는 피드백을 사용자에게 제공함.


    } // execute()

} // UserInsertService 클래스 종료
