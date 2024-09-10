package user.service;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 사용
// Scanner는 콘솔에서 입력을 받을 때 사용되며, 이를 통해 사용자의 아이디, 이름, 비밀번호 등을 입력받을 수 있음.

import user.dao.UserDAO;  // 데이터베이스와 상호작용하기 위해 UserDAO 클래스를 사용
// UserDAO는 데이터베이스와 상호작용하는 클래스이며, 사용자의 정보 조회, 수정, 삭제 등의 작업을 담당함.

import user.main.UserMain; // 입력된 아이디가 없을 때 메인 메뉴로 돌아가기 위해 UserMain 클래스를 사용
// 만약 입력된 아이디에 해당하는 사용자가 없으면, 메인 메뉴로 돌아가기 위해 UserMain 클래스를 호출함.

import user.bean.UserDTO;  // 사용자 정보를 담고 있는 UserDTO 클래스를 사용
// UserDTO는 사용자 정보를 저장하는 객체로, 이름, 아이디, 비밀번호 등의 정보를 담고 있음.

public class UserUpdateService implements UserService {

    @Override
    public void execute() {
    	System.out.println(); // 가독성을 위한 빈 줄 출력
    	// 빈 줄을 출력하여 사용자 콘솔에서의 가독성을 높임. 여러 동작이 출력될 때, 구분하기 쉽도록 하기 위함.
    	
    	Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
    	// Scanner 객체는 사용자가 콘솔에 입력한 값을 받을 수 있게 해줌.
    	// 예를 들어, 사용자가 아이디나 이름을 입력하면 이를 변수에 저장함.
    	
    	// DB와 상호작용하기 위한 UserDAO 객체를 싱글톤 패턴으로 가져옴
    	UserDAO userDAO = UserDAO.getInstance(); 
    	// UserDAO.getInstance()는 이미 생성된 UserDAO 인스턴스를 반환함.
    	// 이는 메모리 자원을 절약하기 위한 싱글톤 패턴으로, 애플리케이션 전체에서 하나의 인스턴스만 사용함.
    	
    	// 사용자로부터 수정할 아이디를 입력받음
    	System.out.print("수정할 아이디 입력 : ");
    	String id = scan.next();  // 아이디 입력받기
    	// 사용자가 수정하고자 하는 아이디를 콘솔에 입력하고, 그 값을 String 변수 'id'에 저장함.
    	
    	// 입력된 아이디에 해당하는 사용자를 DB에서 조회
        UserDTO userDTO = userDAO.getUser(id);
    	// UserDAO 클래스의 getUser() 메소드를 호출하여 해당 ID를 가진 사용자를 조회함.
    	// getUser()는 데이터베이스에서 아이디를 검색하고, 결과를 UserDTO 객체로 반환함.
    	// 만약 사용자가 없으면 null을 반환함.
    	
        // 만약 해당 ID의 사용자가 없을 경우 처리
        if (userDTO == null) { 
        	// 만약 userDTO가 null이면, 입력된 ID를 가진 사용자가 없다는 의미임.
        	System.err.println(); // 에러 메시지를 출력할 때 가독성을 위해 빈 줄을 추가
        	System.out.println("--------ERROR !--------");
            System.out.println("해당 아이디가 존재하지 않습니다."); 
            // 사용자에게 해당 ID가 존재하지 않음을 알림.
            
            // 사용자가 없을 경우 메인 메뉴로 돌아가도록 UserMain.main(null) 호출
            UserMain.main(null); 
            // UserMain의 main 메소드를 호출하여 메인 메뉴로 돌아감.
            // 프로그램이 종료되지 않고, 다시 메뉴 선택 화면으로 돌아가도록 설정함.
            return; // 메소드를 종료하여 더 이상 진행되지 않도록 함
            // 메소드를 종료하고 더 이상 아래 코드를 실행하지 않도록 return을 사용함.
        }
         
        System.out.println();
    	// 수정할 사용자 정보를 입력받음 (이름과 비밀번호)
    	System.out.print("수정할 이름 입력 : ");
    	String name = scan.next(); // 수정할 이름 입력받기
    	// 사용자가 입력한 새로운 이름을 받아서 String 변수 'name'에 저장함.
    	
    	System.out.print("수정할 비밀번호 입력 : ");
    	String pwd = scan.next(); // 수정할 비밀번호 입력받기
    	// 사용자가 입력한 새로운 비밀번호를 받아서 String 변수 'pwd'에 저장함.
    	
    	// 입력받은 새로운 정보를 UserDTO 객체에 설정
    	userDTO.setName(name); // 새로운 이름으로 설정
    	// UserDTO 객체의 setName() 메소드를 사용하여 사용자의 이름을 새로 입력된 이름으로 설정함.
    	
    	userDTO.setPwd(pwd);   // 새로운 비밀번호로 설정
    	// UserDTO 객체의 setPwd() 메소드를 사용하여 사용자의 비밀번호를 새로 입력된 비밀번호로 설정함.
    	
    	// DB에 수정된 사용자 정보를 반영 (업데이트)
    	int su = userDAO.updateUser(userDTO); 
    	// UserDAO의 updateUser() 메소드를 호출하여 데이터베이스에서 해당 사용자의 정보를 업데이트함.
    	// 업데이트 결과로 수정된 행의 개수가 반환되며, 이를 'su' 변수에 저장함.
    	
    	// 업데이트된 행의 개수를 출력
    	System.out.println(su + " 개의 행을 수정하였습니다."); 
    	// 몇 개의 행이 수정되었는지 출력
    	// 수정이 성공적으로 이루어졌을 경우, 수정된 행의 개수를 출력하여 사용자에게 알림.

    }
}
