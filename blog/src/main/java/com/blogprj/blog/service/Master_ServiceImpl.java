package com.blogprj.blog.service;

import com.blogprj.blog.repository.mapper.Master_MapperImpl;

public class Master_ServiceImpl implements Master_Service {
	Master_MapperImpl mapper =  new Master_MapperImpl();

	public void setMapper(Master_MapperImpl mapper) {
		this.mapper = mapper;
	}

}
