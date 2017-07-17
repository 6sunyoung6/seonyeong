package study.spring.two.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.CompanyDto;
import study.spring.two.service.CompanyService;
import study.spring.two.util.Pagination;

@Controller
public class CompanyHomeController {

	@Autowired
	private CompanyService comService;
	
	@RequestMapping(value = {"companyMain", "search2"})
	public ModelAndView companyMain(@RequestParam int pageNum,
			@RequestParam(defaultValue="all") String searchOption,
			@RequestParam(defaultValue="")String keyword){
		
		System.out.println("키워드1!!!!!!!" + keyword);
		System.out.println("서치옵션!!!!!!" + searchOption);
		
		Pagination pagination = new Pagination();
		Map<String, Object> page = pagination.pagination(pageNum, comService.getTotalRow(searchOption, keyword));
		int startRowNum = Integer.parseInt(page.get("startRowNum").toString());
		int endRowNum = Integer.parseInt(page.get("endRowNum").toString());
		
		List<CompanyDto> testList = comService.listAll(searchOption, keyword, startRowNum, endRowNum);
		for(CompanyDto tmp : testList){
			if(tmp.getDaepyoType() != null && tmp.getDaepyoType().equals("각자대표")){
				tmp.setDaepyoType("각자대표");
			}
			if(tmp.getDaepyoType() != null && tmp.getDaepyoType().equals("대표")){
				tmp.setDaepyoType("대표");
			}
		}
		int count = comService.countArticle(searchOption, keyword);

		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testList", testList);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		modelAndView.addObject("map", map);
		modelAndView.addAllObjects(page);
		
		System.out.println("keyword= "+ keyword + ", searchOption= " + searchOption);
		
		modelAndView.setViewName("companyMain");
		return modelAndView;
	}
	
	@RequestMapping("companyInsert")
	public String companyInsert(){
		return "companyInsert";
	}
	
	@RequestMapping("ccc")
	public String ccc(){
		return "ccc";
	}
	
//	@RequestMapping("companyUpdate")
//	public String companyUpdate(){
//		return "companyUpdate";
//	}

	
}
