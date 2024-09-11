package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.main.UserMain;

public class UserSearchService implements UserService {

    @Override
    public void execute() {
        // 사용자 입력을 받기 위해 Scanner 객체를 생성합니다.
        Scanner scan = new Scanner(System.in);
        // 싱글톤 패턴으로 정의된 UserDAO의 인스턴스를 가져옵니다. UserDAO는 데이터베이스와 상호작용을 처리하는 클래스입니다.
        UserDAO userDAO = UserDAO.getInstance();

        // 사용자에게 검색 옵션을 제공하는 부분입니다.
        System.out.println("1. 이름으로 검색");
        System.out.println("2. 아이디로 검색");
        System.out.print("번호 선택 : ");
        int choice = scan.nextInt(); // 사용자가 입력한 번호를 choice 변수에 저장합니다.

        // 검색할 컬럼을 지정할 변수와 검색할 값을 저장할 변수를 선언합니다.
        String column = "";  // 검색할 컬럼 (name 또는 id)
        String value = "";   // 검색할 값

        // 사용자가 선택한 번호에 따라 검색 조건이 달라집니다.
        // 사용자가 1번을 선택하면 이름으로 검색합니다.
        if (choice == 1) {
            System.out.print("검색을 원하는 이름 입력 : ");
            value = scan.next();  // 이름 입력 받기
            column = "name";  // 이름으로 검색
            // 이름 검색은 사용자 이름이 포함된 데이터를 검색하는 것을 의미합니다.
            // column 변수에 "name" 값을 할당하여, MyBatis 쿼리에서 name 컬럼을 대상으로 검색하도록 설정합니다.
            
        // 사용자가 2번을 선택하면 아이디로 검색합니다.
        } else if (choice == 2) {
            System.out.print("검색을 원하는 아이디 입력 : ");
            value = scan.next();  // 아이디 입력 받기
            column = "id";  // 아이디로 검색
            // 아이디 검색은 사용자의 아이디가 포함된 데이터를 검색하는 것을 의미합니다.
            // column 변수에 "id" 값을 할당하여, MyBatis 쿼리에서 id 컬럼을 대상으로 검색하도록 설정합니다.
            
        // 사용자가 1번 또는 2번 외의 번호를 입력한 경우
        } else {
            System.err.println(); // 에러 메시지 앞에 공백을 출력하여 가독성을 높입니다.
            System.out.println("--------ERROR !--------");
            System.out.println("잘못된 선택입니다."); // 잘못된 선택임을 사용자에게 알립니다.
            UserMain.main(null); // 잘못된 입력이므로 메인 메뉴로 돌아갑니다.
            return; // 메소드를 종료하여 더 이상 코드를 실행하지 않도록 합니다.
        }

        // DAO를 통해 데이터베이스에서 검색 작업을 수행합니다.
        List<UserDTO> userList = userDAO.search(column, value);
        // userDAO.search(column, value)는 column(이름 또는 아이디)과 value(검색할 값)를 이용해 
        // 데이터베이스에서 일치하는 사용자 목록을 검색합니다. 검색 결과는 UserDTO 객체 리스트로 반환됩니다.
        // 검색 결과가 없으면 null 또는 빈 리스트가 반환됩니다.

        // 검색 결과가 없는 경우
        if (userList == null || userList.isEmpty()) {
            System.out.println("해당 조건에 맞는 사용자가 존재하지 않습니다.");
            // 검색된 사용자가 없을 경우, 사용자에게 검색 결과가 없음을 알립니다.
            
        // 검색 결과가 있는 경우
        } else {
            System.out.println("--------검색 결과--------");
            // 검색된 사용자 정보를 하나씩 출력하는 부분입니다.
            for (UserDTO userDTO : userList) {
                // 사용자 이름을 출력합니다.
                System.out.println("사용자 이름 : " + userDTO.getName());
                // 사용자 아이디를 출력합니다.
                System.out.println("사용자 아이디 : " + userDTO.getId());
                // 사용자 비밀번호를 출력합니다.
                System.out.println("사용자 비밀번호 : " + userDTO.getPwd());
                System.out.println("------------------------");
                // 이 부분에서는 반복문을 통해 검색된 사용자들의 이름, 아이디, 비밀번호를 차례대로 출력합니다.
                // userDTO 객체는 각 사용자의 정보를 담고 있으며, 이를 이용해 정보를 출력합니다.
            }
        }
    }
}