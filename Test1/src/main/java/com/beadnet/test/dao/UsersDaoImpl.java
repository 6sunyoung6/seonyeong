package com.beadnet.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beadnet.test.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public UsersDto findID(UsersDto dto) {
		UsersDto dto1 = sqlSession.selectOne("user.findPw");
		return dto1;
	}

	@Override
	public UsersDto findPw(UsersDto dto) {
		UsersDto dto1 = sqlSession.selectOne("user.findPw");
		return dto1;
	}
	
	
}
