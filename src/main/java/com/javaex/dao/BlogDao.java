package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//유저정보 가져오기
	public BlogVo getUser(String id) {
		System.out.println("blogDao>getUSer");
		
		BlogVo bVo = sqlSession.selectOne("blog.getUSer",id);
		
		return bVo;
	}
	
	//블로그 회원정보 추가
	public int blogInsert(BlogVo bVo) {
		
		int count = sqlSession.insert("blog.blogInsert",bVo);
		
		return count;
	}
	
}
