package user.service;

import java.util.Scanner;  // 사용자 입력을 받기 위한 Scanner 클래스 사용

import user.bean.UserDTO;  // 사용자 정보를 저장하는 UserDTO 클래스 사용
import user.dao.UserDAO;   // 데이터베이스와 상호작용하기 위한 UserDAO 클래스 사용
import user.main.UserMain; // 메인 메뉴로 돌아가기 위한 UserMain 클래스 사용

public class UserSearchService implements UserService {

    @Override
    public void execute() {
    	System.out.println();  // 콘솔에 공백 출력, 가독성을 위해 사용
    	
    	Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
    	// Scanner는 콘솔로부터 사용자 입력을 받는 데 사용되며, 입력받은 값은 이후의 로직에서 처리됨.
    	
    	//DB
    	UserDAO userDAO = UserDAO.getInstance(); 
    	// 싱글톤 패턴을 사용하여 UserDAO 객체를 가져옴.
    	// 싱글톤 패턴을 사용함으로써 UserDAO 객체는 애플리케이션 내에서 하나만 생성되고, 이를 모든 곳에서 재사용함.
    	// UserDAO는 데이터베이스와 상호작용하는 로직을 가지고 있으며, 이를 통해 사용자 정보를 조회할 수 있음.
    	
    	System.out.print("검색할 아이디 입력 : "); // 사용자로부터 검색할 아이디 입력받기
    	String id = scan.next();  // 입력된 아이디를 변수 'id'에 저장
    	// 사용자에게 검색할 아이디를 입력하라고 안내 메시지를 출력한 후, Scanner를 통해 입력받은 값을 'id'에 저장함.
    	
    	UserDTO userDTO = userDAO.getUser(id); 
    	// 입력된 ID에 해당하는 사용자 정보를 데이터베이스에서 조회.
    	// userDAO.getUser(id)는 입력된 ID를 가진 사용자를 데이터베이스에서 검색하여, 결과를 UserDTO 객체로 반환함.
    	// 만약 해당 사용자가 존재하지 않으면 null을 반환.
    	
    	  if (userDTO == null) {
    		  // 만약 조회된 userDTO가 null이면, 해당 ID를 가진 사용자가 존재하지 않는다는 의미임.
    		  System.err.println();  // 에러 메시지 앞에 공백을 출력하여 가독성을 높임
          	  System.out.println("--------ERROR !--------");
              System.out.println("해당 아이디가 존재하지 않습니다.");
              // 사용자가 존재하지 않을 때 사용자에게 해당 아이디가 없다는 메시지를 출력함.
              
              UserMain.main(null);  // 메인 메뉴로 돌아가도록 UserMain.main(null)을 호출
              // 메인 메뉴로 돌아가기 위해 UserMain 클래스의 main() 메소드를 호출.
              // null은 main 메소드의 인자로 전달되며, 이 경우 프로그램의 기본 흐름을 따름.
              return; // 메소드 실행을 종료하여 더 이상의 동작이 진행되지 않도록 함
              // 사용자가 없을 경우 이 시점에서 메소드를 종료하여 이후의 코드를 실행하지 않음.
          }
    	  
    	  // 사용자 정보가 정상적으로 조회된 경우 결과를 출력
    	  System.out.println("--------결과 !--------");
    	  System.out.println("사용자 이름 : " + userDTO.getName());  // 사용자 이름 출력
    	  System.out.println("사용자 아이디 : " + userDTO.getId());  // 사용자 아이디 출력
    	  System.out.println("사용자 비밀번호 : " + userDTO.getPwd());  // 사용자 비밀번호 출력
    	  // UserDTO 객체에서 각 필드 값(이름, 아이디, 비밀번호)을 가져와 출력함.
    	  // 이를 통해 데이터베이스에서 조회된 사용자 정보를 콘솔에 출력할 수 있음.
    }
}
