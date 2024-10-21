package user.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import user.bean.UserDTO;

public interface UserService {

	public String login(HttpSession session);

	public UserDTO loginNaver(Map<String, String> map, HttpSession session);

	public Boolean loginSH(Map<String, String> map, HttpSession session);

	public boolean checkUserId(String userid);

	public void joinSubmit(UserDTO userDTO);
	
}
