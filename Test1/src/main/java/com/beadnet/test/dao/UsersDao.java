package com.beadnet.test.dao;

import com.beadnet.test.dto.UsersDto;

public interface UsersDao {

	// 아이디 찾기
	public UsersDto findID(UsersDto dto);
	
	// 비밀번호 찾기
	public UsersDto findPw(UsersDto dto);
	
}
