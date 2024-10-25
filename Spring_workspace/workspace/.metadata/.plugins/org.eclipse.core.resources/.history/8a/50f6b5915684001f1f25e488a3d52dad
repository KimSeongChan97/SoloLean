package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

    // 사용자 정보를 데이터베이스에 저장하는 메서드
    // userDTO 객체에 담긴 사용자 정보를 DB에 저장하는 역할을 합니다.
    // 이 메서드는 UserInsertService 등에서 호출되어 DB에 새로운 사용자 데이터를 삽입합니다.
    //
    // 추가 설명:
    // - 매개변수로 전달되는 userDTO는 사용자 정보를 담고 있는 데이터 전송 객체 (DTO: Data Transfer Object)입니다.
    // - 이 메서드는 DAO(Data Access Object) 패턴을 따르는 메서드로, 데이터베이스에 직접 접근하여 데이터를 처리합니다.
    // - `write` 메서드는 사용자 정보를 데이터베이스의 특정 테이블에 INSERT하는 SQL 쿼리를 실행하게 됩니다.
    // - 주로 사용자 등록 화면이나 회원가입 서비스에서 호출됩니다.
    public void write(UserDTO userDTO);

    // 데이터베이스에 저장된 모든 사용자 정보를 반환하는 메서드
    // 이 메서드는 DB에서 저장된 사용자 정보를 List 형태로 반환하며, 
    // 각 사용자의 정보는 UserDTO 객체에 담겨 List로 관리됩니다.
    // UserSelectService 등에서 호출되어 DB에서 사용자 목록을 조회할 때 사용됩니다.
    //
    // 추가 설명:
    // - `getUserList`는 모든 사용자 정보를 조회하는 역할을 합니다.
    // - 반환 타입이 List<UserDTO>인 이유는 여러 명의 사용자 정보를 한 번에 가져오고자 할 때, 이를 목록으로 관리하기 위함입니다.
    // - 내부적으로는 SELECT SQL 쿼리를 사용하여 데이터베이스의 사용자 테이블에서 모든 레코드를 가져옵니다.
    // - 결과적으로, 이 메서드는 여러 개의 UserDTO 객체를 리스트에 담아 반환합니다.
    public List<UserDTO> getUserList();
    
    // 특정 아이디가 존재하는지 확인하고 해당 아이디의 사용자 정보를 반환하는 메서드
    // 주어진 id를 바탕으로 DB에서 해당 사용자의 정보를 조회합니다.
    // 
    // 추가 설명:
    // - 이 메서드는 주어진 아이디가 데이터베이스에 존재하는지 확인하고, 
    //   존재할 경우 해당 사용자의 정보를 UserDTO 객체로 반환합니다.
    // - 만약 해당 아이디가 존재하지 않으면 null을 반환합니다.
    public UserDTO getExistId(String id);
	
    // 사용자 정보를 업데이트하는 메서드
    // 매개변수로 전달된 Map 객체에 담긴 정보(이름, 비밀번호, 아이디)를 이용하여 데이터베이스에서 사용자 정보를 업데이트합니다.
    //
    // 추가 설명:
    // - `update` 메서드는 `Map` 객체를 통해 사용자 정보를 전달받습니다.
    // - Map은 key-value 쌍으로 데이터를 관리하며, key는 필드명(name, id, pwd)이고 value는 각각의 수정된 사용자 정보입니다.
    // - 이 메서드는 전달된 Map을 이용해 UPDATE SQL 쿼리를 실행하여 데이터베이스에서 사용자 정보를 수정합니다.
    public void update(Map<String, String> map);

    // 특정 사용자를 데이터베이스에서 삭제하는 메서드
    // 매개변수로 전달된 아이디를 이용하여 DB에서 해당 사용자의 정보를 삭제합니다.
    //
    // 추가 설명:
    // - `delete` 메서드는 주어진 id 값을 바탕으로 데이터베이스에서 해당 사용자의 정보를 삭제합니다.
    // - 내부적으로 DELETE SQL 쿼리를 사용하며, 아이디를 기준으로 특정 사용자의 데이터를 삭제하게 됩니다.
    // - 주로 회원 탈퇴 기능이나 관리자 권한으로 사용자를 삭제할 때 사용됩니다.
    public void delete(String id);

}
