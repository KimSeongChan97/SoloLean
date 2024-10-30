package member.service;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	public String login(String id, String pwd);

}
