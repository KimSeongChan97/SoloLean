package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.control.CommandProcess;
import com.factory.MyBatisConnectionFactory;

public class LoginCommand implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            MemberDAO memberDAO = new MemberDAO(sqlSession);
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");

            MemberDTO member = memberDAO.loginMember(userid, password);
            if (member != null) {
                request.getSession().setAttribute("member", member);
                // 로그인 성공 시 메인 화면으로 이동
                return "/welcome.jsp";
            } else {
                // 로그인 실패 시 다시 로그인 페이지로 이동 (에러 메시지 추가 가능)
                request.setAttribute("error", "Invalid username or password");
                return "/user/userSignIn.jsp";
            }
        } finally {
            sqlSession.close();
        }
    }
}
