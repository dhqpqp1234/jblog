package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//아이디 체크
	public String idCheck(String id) {
		System.out.println("UserDao>idCheck");
		
		return sqlSession.selectOne("user.getUserOne",id);
	}
	
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("userDao>join");
		
		int count = sqlSession.insert("user.userInsert",userVo);
		
		return count;
	}
	
	//로그인
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao>login");
		
		UserVo authUser = sqlSession.selectOne("user.getUser",userVo);
		
		return authUser;
	}
}
