package user.service;

import java.util.List; // List 인터페이스를 사용하기 위해 import
// List는 여러 개의 객체를 담을 수 있는 자료구조로, 여기서는 UserDTO 객체를 여러 개 담아 사용자 목록을 처리할 때 사용됨.

import user.bean.UserDTO; // 사용자 정보를 담는 UserDTO 클래스를 사용하기 위해 import
// UserDTO는 한 명의 사용자의 이름, 아이디, 비밀번호와 같은 정보를 담는 데이터 전송 객체 (DTO)임.
// 이를 통해 사용자 정보를 한 번에 처리할 수 있음.

import user.dao.UserDAO; // 데이터베이스와의 상호작용을 위한 UserDAO 클래스를 사용하기 위해 import
// UserDAO는 데이터베이스와의 상호작용을 담당하는 클래스임.
// 사용자 정보를 데이터베이스에서 읽어오거나 수정, 삭제하는 등의 기능을 수행함.

public class UserSelectService implements UserService {

    @Override
    public void execute() {
    	System.out.println(); // 공백 출력. 화면 출력 시의 가독성을 위해 사용
    	// 프로그램 실행 시 출력되는 내용 사이에 빈 줄을 넣어 가독성을 높임.
    	
    	//DB
    	UserDAO userDAO = UserDAO.getInstance(); 
    	// 싱글톤 패턴을 통해 UserDAO 인스턴스를 가져옴
    	// UserDAO는 데이터베이스와 상호작용하는 객체로, getAllList() 메소드를 통해 사용자 리스트를 가져옴
    	// 싱글톤 패턴을 사용하여 하나의 UserDAO 인스턴스만 사용하도록 보장함.
    	
    	List<UserDTO> list = userDAO.getAllList(); 
    	// getAllList() 메소드는 데이터베이스에서 모든 사용자 정보를 조회하여 List<UserDTO>로 반환
    	// List는 여러 개의 UserDTO 객체를 담는 자료구조로, 모든 사용자 정보를 담고 있음
    	// 즉, 'list'는 여러 명의 사용자 정보를 담고 있으며, 각 사용자 정보는 UserDTO 객체에 저장됨.
    	
    	//응답
    	for (UserDTO userDTO : list) {
    	    // 향상된 for문을 사용하여 list에 담긴 모든 UserDTO 객체를 하나씩 꺼내옴
    	    // 각 userDTO는 한 명의 사용자 정보를 담고 있음
    	    // list는 사용자 전체 목록을 담고 있으므로, for-each문을 사용하여 모든 사용자 정보를 순차적으로 처리함.
    		
    		System.out.println(userDTO.getName() + "\t"
    							+ userDTO.getId() + "\t"
    							+ userDTO.getPwd());
    		// 각 사용자의 이름, 아이디, 비밀번호를 탭으로 구분하여 출력
    		// getName(), getId(), getPwd() 메소드를 통해 UserDTO 객체에서 해당 필드 값을 가져옴
    		// UserDTO 객체에는 각 사용자의 정보가 저장되어 있으므로, getter 메소드를 사용하여 각각의 정보를 꺼냄.
    		// 이 출력문은 사용자 이름, ID, 비밀번호를 한 줄에 출력하며, 각 필드 간의 구분을 위해 '\t' (탭) 문자를 사용하여 가독성을 높임.
    		
    		// 예를 들어, 결과는 다음과 같은 형태로 출력될 수 있음:
    		// 홍길동   user1   password1
    		// 김철수   user2   password2
    		// 여러 사용자 정보가 각 줄에 출력됨.
    	}
    	// 만약 list가 비어있다면, for-each문은 실행되지 않음. 즉, 데이터베이스에 사용자가 없을 경우 아무것도 출력되지 않음.
    }
}
