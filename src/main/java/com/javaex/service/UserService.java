package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	/*
	//아이디 중복검사
	public String idCheck(String id) {
		System.out.println("UserService>idCheck");
		
		return userDao.idCheck(id);
	}
	*/
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserService>join");
		
		int count = userDao.userInsert(userVo);
		
		return count;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService>login");
		
		UserVo ahthUser = userDao.getUser(userVo);
		
		return ahthUser;
	}
	
}
