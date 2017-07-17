package study.spring.two.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.WebDto;
import study.spring.two.service.Service;

@Controller
public class SelectListController {

	@Autowired
	private Service service;
	
	@RequestMapping("userSelectOne")
	public ModelAndView ListOne(@RequestParam(value="check_sub")int no){
		ModelAndView mView = service.getData(no);
		mView.setViewName("userSelectOne");
		return mView;
	}
	@RequestMapping("selectOne")
	public String one(HttpServletRequest request, @ModelAttribute WebDto dto){
		return "redirect:main.do?pageNum=1";
	}
}
