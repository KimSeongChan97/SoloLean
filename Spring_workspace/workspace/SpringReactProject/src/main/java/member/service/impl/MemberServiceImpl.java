package member.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import member.service.MemberService;


@Transactional
@Service
public class MemberServiceImpl implements MemberService {
    
	@Autowired
    private MemberDAO memberDAO;
	@Autowired
	private HttpSession session;
    
	 @Override
	    public String login(String id, String pwd) {
	        Map<String, String> map = new HashMap<>();
	        map.put("id", id);
	        map.put("pwd", pwd);
	        
	        MemberDTO memberDTO = memberDAO.login(map); // 로그인 시도
	        if (memberDTO == null) {
	            return "fail"; // 로그인 실패 시
	        } else {
	            // 로그인 성공 시 세션에 사용자 정보 저장
	            session.setAttribute("memId", memberDTO.getId());
	            session.setAttribute("memName", memberDTO.getName());
	            session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
	            
	            return "success"; // 로그인 성공 시
	        }
	    }
	}
