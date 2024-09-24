package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.control.CommandProcess;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class userSignInService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SqlSessionFactory sqlSessionFactory = UserDAO.getInstance().getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			UserDAO userDAO = UserDAO.getInstance();
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			
			UserDTO user = userDAO.loginUser(userid, password);
			
			if (user != null) {
				request.getSession().setAttribute("user", user);
				return "../index.jsp";
			} else {
				// 로그인 실패시 다시 로그인 페이지 (에러메시지 추가 가능)
				request.setAttribute("error", "아이디 또는 비밀번호 오류입니다.");
				return "/user/userSignIn.jsp";
			}
			
		} finally {
			sqlSession.close();
		}
		
	}

}
