package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CommentsVo;

@Repository
public class CommentsDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
}
