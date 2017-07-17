package study.spring.two.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.CompanyDto;
import study.spring.two.service.CompanyService;

@Controller
public class CompanyUpdateController {

	@Autowired
	private CompanyService service;
	
	@RequestMapping("companyUpdateform")
	public ModelAndView updateForm(@RequestParam(value="check_sub") int companyNo){
		ModelAndView mView = service.getData(companyNo);
		mView.setViewName("companyUpdate");
		
		return mView;
	}
	
	@RequestMapping("companyUpdate1")
	public String update(HttpServletRequest request, @ModelAttribute CompanyDto dto){
		service.update(request, dto);
		return "redirect:companyMain.do?pageNum=1";
	}
}
