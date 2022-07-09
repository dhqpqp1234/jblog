package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao cateDao;
	
	
	//아이디 중복검사
	public String idCheck(String id) {
		System.out.println("UserService>idCheck");
		
		return userDao.idCheck(id);
	}
	
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserService>join");
		
		int count = userDao.userInsert(userVo);
		
		if(count > 0) {
			
			BlogVo bVo = new BlogVo();
			bVo.setBlogTitle("블로그 입니다.");
			bVo.setLogoFile("기본파일경로입니다");
			bVo.setId(userVo.getId());
			blogDao.blogInsert(bVo);
			
			  CategoryVo cVo = new CategoryVo();
			  
			  cVo.setCataName("미분류"); 
			  cVo.setDescription("카테고리 입니다.");
			  cVo.setId(userVo.getId());
			  cateDao.cataInsert(cVo);
			 
		}
		
		
		
		
		return count;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService>login");
		
		UserVo ahthUser = userDao.getUser(userVo);
		
		return ahthUser;
	}
	
}
