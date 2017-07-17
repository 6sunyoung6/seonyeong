package study.spring.two.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.AaaDto;
import study.spring.two.service.AaaService;

@Controller
public class AaaController {

	@Autowired
	private AaaService aaaService;
	
	@RequestMapping("aaa.do")
	public ModelAndView aaa(){
		ModelAndView mView = new ModelAndView();
		List<AaaDto> list = aaaService.getData();
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		mView.setViewName("aaa");
		mView.addObject("list", list);
		return mView;
	}
	
	@RequestMapping("confirm.do")
	public ModelAndView confirm(HttpServletRequest request){
		ModelAndView mView = new ModelAndView();
		
		String selected = request.getParameter("list");
		System.out.println("confirm~~~~~~~~~ list : " + selected);
		return mView;
	}
	
	
//	@RequestMapping("confirm.do")
//	public String confirm(HttpServletRequest request){
//		
//		String selected = request.getParameter("list");
//		System.out.println("confirm~~~~~~~~~ list : " + selected);
//		
//		return "redirect:aaaConfirm.do";
//	}
	
	
}
