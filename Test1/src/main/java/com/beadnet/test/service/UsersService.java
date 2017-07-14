package com.beadnet.test.service;

import com.beadnet.test.dto.UsersDto;


public interface UsersService {

	/**
	 * 회원 아이디 찾기
	 * */
	public UsersDto selectIdMember(UsersDto user) ;
	
	
	/**
	 * 회원 비밀번호 찾기
	 * */
	public UsersDto selectPwdUsers(UsersDto user);
}
