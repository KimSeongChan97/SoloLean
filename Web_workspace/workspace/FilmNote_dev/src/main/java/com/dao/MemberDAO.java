package com.dao;

import org.apache.ibatis.session.SqlSession;
import com.dto.MemberDTO;

import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
    private SqlSession sqlSession;

    public MemberDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertMember(MemberDTO member) {
        sqlSession.insert("com.mapper.UserMapper.insertMember", member);
    }

    public MemberDTO loginMember(String userid, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("userid", userid);
        params.put("password", password);
        return sqlSession.selectOne("com.mapper.UserMapper.loginMember", params);
    }
}
