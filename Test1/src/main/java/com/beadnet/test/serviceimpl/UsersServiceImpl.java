package com.beadnet.test.serviceimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beadnet.test.dto.UsersDto;
import com.beadnet.test.service.UsersService;

@Component
public class UsersServiceImpl implements UsersService{

	@Override
	public UsersDto selectIdMember(UsersDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersDto selectPwdUsers(UsersDto user) {
		// TODO Auto-generated method stub
		return null;
	}


}
