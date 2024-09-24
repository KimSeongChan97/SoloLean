package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.control.CommandProcess;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class userSignUpService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SqlSessionFactory sqlSessionFactory = UserDAO.getInstance().getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			UserDAO userDAO = UserDAO.getInstance();
			
			// 입력 받은 값을 DTO에 설정
			UserDTO user = new UserDTO();
			user.setId(request.getParameter("id"));
			user.setPwd(request.getParameter("pwd"));
			user.setName(request.getParameter("name"));
			user.setGender(request.getParameter("gender"));
			user.setBirth1(request.getParameter("birth1"));
			user.setBirth2(request.getParameter("birth2"));
			user.setBirth3(request.getParameter("birth3"));
			user.setEmail1(request.getParameter("email1"));
			user.setEmail2(request.getParameter("email2"));
			user.setTel1(request.getParameter("tel1"));
			user.setTel2(request.getParameter("tel2"));
			user.setTel3(request.getParameter("tel3"));

			// 회원 정보를 DB에 삽입
			userDAO.insertUser(user);
			sqlSession.commit();

			// 회원가입 성공 후 로그인 페이지로 이동
			return "/user/userSignIn.jsp";
		} finally {
			sqlSession.close();
		}
	}
}
