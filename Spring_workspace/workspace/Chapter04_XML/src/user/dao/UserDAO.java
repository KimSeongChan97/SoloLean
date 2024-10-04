package user.dao;

import java.util.List;
import user.bean.UserDTO;

public interface UserDAO {

    // 사용자 정보를 데이터베이스에 저장하는 메서드
    // userDTO 객체에 담긴 사용자 정보를 DB에 저장하는 역할을 합니다.
    // 이 메서드는 UserInsertService 등에서 호출되어 DB에 새로운 사용자 데이터를 삽입합니다.
    public void write(UserDTO userDTO);

    // 데이터베이스에 저장된 모든 사용자 정보를 반환하는 메서드
    // 이 메서드는 DB에서 저장된 사용자 정보를 List 형태로 반환하며, 
    // 각 사용자의 정보는 UserDTO 객체에 담겨 List로 관리됩니다.
    // UserSelectService 등에서 호출되어 DB에서 사용자 목록을 조회할 때 사용됩니다.
    public List<UserDTO> getUserList();
}
