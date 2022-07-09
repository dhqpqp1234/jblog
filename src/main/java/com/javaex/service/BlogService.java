package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	//회원정보 가져오기
	public BlogVo getUser(String id) {
		System.out.println("blogService>getUser");
		
		BlogVo bVo = blogDao.getUser(id);
		
		return bVo;
	}

	//블로그 회원정보추가
	public int blogInsert(BlogVo bVo) {
		
		int count = blogDao.blogInsert(bVo);
		
		return count;
	}
	
}
