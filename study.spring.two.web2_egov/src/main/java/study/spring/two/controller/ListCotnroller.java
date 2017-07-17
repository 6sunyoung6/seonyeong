package study.spring.two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.service.Service;

@Controller
public class ListCotnroller {

	@Autowired
	private Service service;
	
	@RequestMapping("list")
	public ModelAndView listRequest(){
		ModelAndView mView = service.getList();
		mView.setViewName("main");
		return mView;
	}
}
