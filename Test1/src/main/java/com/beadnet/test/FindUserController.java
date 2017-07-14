package com.beadnet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beadnet.test.dao.UsersDao;
import com.beadnet.test.service.UsersService;

@Controller
public class FindUserController {

	@Autowired
	private UsersService service;

	@RequestMapping("find.do")
	public String find(){
		return "find";
	}
	
	@RequestMapping("findId")
	public void findId(String c_num, String c_pwd, String c_cvc, HttpServletResponse res) throws IOException{

		// 출력시 한글깨짐현상 방지를 위해 새로 encoding해줌. UTF-8로
		res.setCharacterEncoding("utf-8");
		// 자바출력객체 printwriter에 서블릿객체의 값을 저장해 생성
		PrintWriter out = res.getWriter();
	}
}