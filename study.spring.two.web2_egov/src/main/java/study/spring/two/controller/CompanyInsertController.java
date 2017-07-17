package study.spring.two.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.CompanyDto;
import study.spring.two.service.AaaService;
import study.spring.two.service.CompanyService;

@Controller
public class CompanyInsertController {

	@Autowired
	private CompanyService service;
	
	@RequestMapping("insertCompany")
	public String insertRequest(HttpServletRequest request, @ModelAttribute CompanyDto dto){
		service.insert(request, dto);
		return "redirect:companyMain.do?pageNum=1";
	}
	
//	@RequestMapping("insertCompany")
//	@ResponseBody
//	public void insertRequest(HttpServletRequest request, @ModelAttribute CompanyDto dto){
//		service.insert(request, dto);
//	}
	
//	@RequestMapping("ccc")
//	public String ccc(){
//		return "ccc";
//	}
	
//	@RequestMapping("iii")
//	@ResponseBody
//	public int insert(@RequestParam int daepyoNo, HttpSession session, HttpServletRequest request){
//		CompanyDto dto = new CompanyDto();
//		List<CompanyDto> dto = (List<CompanyDto>) new CompanyDto();
//		/**
//		 * daepyosName -- 각자 대표이름
//		 * daepyosAddress - 각자대표주소
//		 * jumin1 -- 주민등록번호
//		 */
//		String daepyosName = (String)session.getAttribute("daepyosName");
//		String daepyosAddress = (String)session.getAttribute("daepyosAddress");
//		String jumin1 = (String)session.getAttribute("jumin1");
//		dto.setDaepyosName(daepyosName);
//		dto.setDaepyosAddress(daepyosAddress);
//		dto.setJumin1(jumin1);
//		return service.insert(request, dto);
//	}
	
//	
//	@RequestMapping("aaaConfirm")
//	public ModelAndView aaaconfirm(HttpServletRequest req){
//		ModelAndView mav = new ModelAndView();
//		String selected = req.getParameter("list");
//		System.out.println("confirm???" + selected);
//		return mav;
//	}

}
