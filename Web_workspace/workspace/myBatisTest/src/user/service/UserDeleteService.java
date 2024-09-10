package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.main.UserMain;

public class UserDeleteService implements UserService {

    @Override
    public void execute() {
    	
    	Scanner scan = new Scanner(System.in);
    	// Scanner 객체를 사용하여 사용자로부터 콘솔 입력을 받을 준비를 함
    	
    	//DB
    	UserDAO userDAO = UserDAO.getInstance(); 
    	// 싱글톤 패턴으로 구현된 UserDAO 객체를 가져옴
    	// UserDAO.getInstance()를 통해 이미 생성된 UserDAO 객체를 가져와 DB 작업을 수행함
    	// 싱글톤 패턴은 한 번 생성된 인스턴스를 재사용하기 때문에 메모리 낭비를 줄일 수 있음
    	
    	System.out.println();
    	System.out.print("삭제할 아이디 입력 : ");
    	// 삭제할 사용자 ID를 입력 받기 위해 안내 메시지를 출력함
    	
    	String id = scan.next(); 
    	// 입력받은 ID를 String 타입 변수 'id'에 저장함
    	
    	// 입력된 아이디에 해당하는 사용자를 DB에서 조회
        UserDTO userDTO = userDAO.getUser(id);
    	// UserDAO의 getUser() 메소드를 호출하여 입력된 ID에 해당하는 사용자를 DB에서 가져옴
    	// getUser() 메소드는 해당 ID가 존재하면 UserDTO 객체를 반환하고, 없으면 null을 반환함
    	
        // 만약 해당 ID의 사용자가 없을 경우 처리
        if (userDTO == null) { 
        	System.err.println();
        	System.out.println("--------ERROR !--------");
            System.out.println("해당 아이디가 존재하지 않습니다."); 
            // 입력된 ID가 DB에 존재하지 않는 경우 에러 메시지를 출력하고 처리함
            // 사용자에게 해당 ID가 존재하지 않음을 알림
        	
            // 사용자가 없을 경우 메인 메뉴로 돌아가도록 UserMain.main(null) 호출
            UserMain.main(null); 
            // UserMain 클래스의 main() 메소드를 호출하여 프로그램의 메인 메뉴로 돌아감
            // 여기서 'null'은 메소드의 파라미터로 전달되는 인자 값이 없다는 의미임
        	
            return; // 메소드를 종료하여 더 이상 진행되지 않도록 함
        	// 해당 메소드에서 더 이상 진행할 필요가 없기 때문에 return으로 메소드를 종료함
        }
    	
    	
    	// DB에 수정된 사용자 정보를 반영 (업데이트)
    	int su = userDAO.deleteUser(id); 
    	// deleteUser 메소드를 호출하여 DB에서 입력된 ID의 사용자를 삭제함
    	// deleteUser() 메소드는 삭제된 행의 개수를 반환함
    	
    	// 업데이트된 행의 개수를 출력
    	System.out.println(su + " 개의 행을 삭제하였습니다."); 
    	// 몇 개의 행이 삭제되었는지 출력
    	// 'su' 변수는 삭제된 행의 개수를 저장하고 있으며, 이 값을 출력하여 사용자에게 알림
    	
    }
}
