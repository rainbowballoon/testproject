package com.blogprj.blog.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;

public class Master_MapperImpl implements Master_Mapper {

private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
