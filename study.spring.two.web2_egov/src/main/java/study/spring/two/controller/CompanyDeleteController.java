package study.spring.two.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import study.spring.two.dto.CompanyDto;
import study.spring.two.service.CompanyService;

@Controller
public class CompanyDeleteController {

	@Autowired
	private CompanyService service;
	
	@RequestMapping("companyDelete")
	public String delete(@RequestParam(value="check_sub") List<Integer> check){
		CompanyDto dto = new CompanyDto();
		for(int value:check){
			dto.setCompanyNo(value);
			service.delete(dto);
		}
		return "redirect:companyMain.do?pageNum=1";
	}
}
