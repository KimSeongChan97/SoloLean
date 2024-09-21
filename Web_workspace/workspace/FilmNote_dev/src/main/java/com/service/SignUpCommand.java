package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.control.CommandProcess;
import com.factory.MyBatisConnectionFactory;

public class SignUpCommand implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            MemberDAO memberDAO = new MemberDAO(sqlSession);

            // 입력 받은 값을 DTO에 설정
            MemberDTO member = new MemberDTO();
            member.setId(request.getParameter("id"));
            member.setPwd(request.getParameter("pwd"));
            member.setName(request.getParameter("name"));
            member.setGender(request.getParameter("gender"));
            member.setBirth1(request.getParameter("birth1"));
            member.setBirth2(request.getParameter("birth2"));
            member.setBirth3(request.getParameter("birth3"));
            member.setEmail1(request.getParameter("email1"));
            member.setEmail2(request.getParameter("email2"));
            member.setTel1(request.getParameter("tel1"));
            member.setTel2(request.getParameter("tel2"));
            member.setTel3(request.getParameter("tel3"));

            // 회원 정보를 DB에 삽입
            memberDAO.insertMember(member);
            sqlSession.commit();

            // 회원가입 성공 후 로그인 페이지로 이동
            return "/user/userSignIn.jsp";
        } finally {
            sqlSession.close();
        }
    }
}
