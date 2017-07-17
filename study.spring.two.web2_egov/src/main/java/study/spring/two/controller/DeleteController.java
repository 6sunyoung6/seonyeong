package study.spring.two.controller;

import java.util.List;

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
public class DeleteController {

	@Autowired
	private Service service;
	
	@RequestMapping("delete")
	public String delete(@RequestParam(value="check_sub")List<Integer> check){
		WebDto dto = new WebDto();
		for(int value:check){
			dto.setNo(value);
			service.delete(dto);
		}
		return "redirect:main.do?pageNum=1";
	}
}
