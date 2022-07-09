package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//카테고리 정보 추가
	public int cataInsert(CategoryVo cateVo) {
		System.out.println("CateDao>Insert");
		
		int count = sqlSession.insert("category.cateInsert",cateVo);
		
		return count;
	}
}
