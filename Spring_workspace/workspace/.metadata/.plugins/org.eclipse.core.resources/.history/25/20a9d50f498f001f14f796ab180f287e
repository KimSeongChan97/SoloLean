package user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserDTO;

@Mapper
public interface UserDAO {

	public int checkUserId(String userId);

	public void joinUser(UserDTO userDTO);

	public UserDTO loginSH(Map<String, String> map);

	public UserDTO checkNaverLoginId(String userId);
	
}
