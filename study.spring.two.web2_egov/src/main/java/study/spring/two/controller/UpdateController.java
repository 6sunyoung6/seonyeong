package study.spring.two.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import study.spring.two.dto.WebDto;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.service.Service;

@Controller
public class UpdateController {

	@Autowired
	private Service service;
	
	@RequestMapping("updateform")
	public ModelAndView updateForm(@RequestParam (value="check_sub") int no){
		ModelAndView mView = service.getData(no);
		mView.setViewName("page5");
		return mView;
	}

	@RequestMapping("update")
	public String update(HttpServletRequest request, @ModelAttribute WebDto dto){
		service.update(request, dto);
		return "redirect:main.do?pageNum=1";
	}
}
