package study.spring.two.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import study.spring.two.dto.WebDto;
import study.spring.two.service.Service;

@Controller
public class InsertController {

	@Autowired
	private Service service;
	
	@RequestMapping("insert")
	public String insertRequest(HttpServletRequest request, @ModelAttribute WebDto dto){
		service.insert(request, dto);
		return "redirect:main.do?pageNum=1";
	}
}
