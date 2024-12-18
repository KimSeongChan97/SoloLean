package user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public String getExistId(String id) {
		UserDTO userDTO = userDAO.getExistId(id);
		System.out.println(userDTO);
		
		if(userDTO == null)
			return "non_exist";
		else
			return "exist";
		
	};
	
	@Override
	public void write(UserDTO userDTO) {
		if ("exist".equals(getExistId(userDTO.getId()))) {
	        throw new IllegalArgumentException("중복된 ID입니다. 다른 ID를 사용해 주세요.");
	    }
		userDAO.write(userDTO);
		
	};
	
	@Override
	public List<UserDTO> list() {
		
		return userDAO.list();
	}
	
	@Override
	public UserDTO getUser(String id) {

		return userDAO.getUser(id);
	}
	
	@Override
	public void update(UserDTO userDTO) {
		userDAO.update(userDTO);
		
	};
	
	
	@Override
	public void delete(String id) {
		userDAO.delete(id);
	}
	
	
	
	
}
