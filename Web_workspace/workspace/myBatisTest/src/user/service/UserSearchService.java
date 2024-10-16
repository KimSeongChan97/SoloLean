package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.main.UserMain;

public class UserSearchService implements UserService {

    @Override
    public void execute() {
        System.out.println();
        
        // 사용자 입력을 받기 위해 Scanner 객체를 생성합니다. 
        // 사용자로부터 검색할 정보를 입력받기 위한 도구입니다.
        Scanner scan = new Scanner(System.in);
               
        // 사용자에게 검색 옵션을 제공하는 부분입니다. 
        // 검색 조건을 '이름' 또는 '아이디'로 선택할 수 있도록 안내합니다.
        System.out.println("1. 이름 검색"); // 사용자가 1을 입력하면 이름으로 검색할 수 있습니다.
        System.out.println("2. 아이디 검색"); // 사용자가 2를 입력하면 아이디로 검색할 수 있습니다.
        System.out.print("번호 선택 : ");
        int num = scan.nextInt(); // 사용자가 입력한 번호를 선택합니다.
        
        if (num != 1 && num != 2) {
        	System.err.println(); // 에러 메시지를 출력할 때 가독성을 위해 빈 줄을 추가
        	System.out.println("--------ERROR !--------");
            System.out.println("해당 입력은 존재하지 않습니다."); 
                     
            // 사용자가 없을 경우 메인 메뉴로 돌아가도록 UserMain.main(null) 호출
            UserMain.main(null); 
            return;  // 메인 메뉴로 돌아감
        }
        
        // 검색할 값을 담을 변수를 미리 선언합니다.
        String value = null;
        // 검색할 컬럼명을 담을 변수를 선언합니다. 
        // 이름 또는 아이디로 검색을 수행해야 하기 때문에 이 변수에 컬럼명을 할당할 예정입니다.
        String columnName = null;
        
        // 사용자가 선택한 번호에 따라 검색 조건이 달라집니다.
        // 사용자가 1번을 선택하면 이름으로 검색합니다.
        if (num == 1) {
            System.out.print("검색을 원하는 이름 입력 : "); 
            value = scan.next();  // 이름 입력 받기
            columnName = "name";  // 컬럼명을 "name"으로 지정하여 이름으로 검색하도록 설정
            
        // 사용자가 2번을 선택하면 아이디로 검색합니다.
        } else if (num == 2) {
            System.out.print("검색을 원하는 아이디 입력 : "); 
            value = scan.next();  // 아이디 입력 받기
            columnName = "id";    // 컬럼명을 "id"로 지정하여 아이디로 검색하도록 설정
        }
        
        // 검색 조건을 저장할 Map 객체를 생성합니다.
        Map<String, String> map = new HashMap<>();
        // map에 검색할 컬럼명(columnName)을 저장합니다. 
        // SQL 쿼리에서 어떤 컬럼을 기준으로 검색할지를 정하는 역할을 합니다.
        map.put("columnName", columnName);
        // map에 검색할 값(value)을 저장합니다. 
        // 검색할 이름 또는 아이디 값이 들어갑니다.
        map.put("value", value);
            
        // 싱글톤 패턴으로 정의된 UserDAO의 인스턴스를 가져옵니다. 
        // UserDAO는 데이터베이스와 상호작용을 처리하는 클래스입니다.
        UserDAO userDAO = UserDAO.getInstance();
        // userDAO의 search 메소드를 호출하여 검색을 수행하고, 결과를 List로 받습니다.
        // 검색 결과는 UserDTO 객체들의 리스트로 반환됩니다.
        List<UserDTO> list = userDAO.search(map);
        
        // 검색된 사용자 목록을 출력하는 부분입니다.
        // 검색된 사용자 목록은 List에 담겨 있으며, 이를 for-each 문을 사용해 하나씩 출력합니다.
        for (UserDTO userDTO : list) {
            // 검색된 각 사용자(UserDTO 객체)에 대해 이름, 아이디, 비밀번호를 출력합니다.
        	System.out.println(userDTO.getName() + "\t" +
        						userDTO.getId() + "\t" +
        						userDTO.getPwd());
        } // for 문 끝, 모든 검색 결과가 출력된 후 종료
        
    }
}
