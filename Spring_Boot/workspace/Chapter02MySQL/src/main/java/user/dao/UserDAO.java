package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserDTO;

@Mapper
public interface UserDAO {

	public UserDTO getExistId(String id);

	public void write(UserDTO userDTO);

	public List<UserDTO> list();

	public UserDTO getUser(String id);

	public void update(UserDTO userDTO);

	public void delete(String id);
	
	
	
	
	
	
}
