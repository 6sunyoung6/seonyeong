package study.spring.two.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.WebDto;
import study.spring.two.service.Service;
import study.spring.two.util.Pagination;

@Controller
public class HomeController {

	@Autowired
	private Service service;
	
	@RequestMapping("index")
	public String home(){
		return "index";
	}
	
	@RequestMapping(value={"main", "search"})
	public ModelAndView main(@RequestParam int pageNum, 
			@RequestParam(defaultValue="all")String searchOption,
			@RequestParam(defaultValue="all2")String searchOption2,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String keyword2 ){
		
		System.out.println("SearchOption는 " + searchOption +"입니다.");
		System.out.println("keyword는 " + keyword +"입니다.");
		
		
		Pagination pagination = new Pagination();
		Map<String, Object> page = pagination.pagination(pageNum, service.getTotalRow(searchOption, keyword, searchOption2, keyword2));
		int startRowNum = Integer.parseInt(page.get("startRowNum").toString());
		int endRowNum = Integer.parseInt(page.get("endRowNum").toString());
		
		List<WebDto> testList = service.listAll(searchOption, keyword, startRowNum, endRowNum,searchOption2, keyword2);
		for(WebDto tmp : testList){
			if(tmp.getWork_state().equals("1")){
				tmp.setWork_state("정규직");
			}
			if(tmp.getWork_state().equals("2")){
				tmp.setWork_state("계약직");
			}
			if(tmp.getGender().equals("1")){
				tmp.setGender("남자");
			}
			if(tmp.getGender().equals("2")){
				tmp.setGender("여자");
			}
			if(tmp.getWork_type().equals("1")){
				tmp.setWork_type("SI");
			}
			if(tmp.getWork_type().equals("2")){
				tmp.setWork_type("SM");
			}
		}
		
		int count = service.countArticle(searchOption, keyword, searchOption2, keyword2);
//		int count = service.countArticle(searchOption, keyword);
		
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testList", testList);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("searchOption2", searchOption2);
		map.put("keyword2", keyword2);
		modelAndView.addObject("map", map);
		modelAndView.addAllObjects(page);
		
		System.out.println("k="+ keyword);
		System.out.println("search= "+ searchOption);
		System.out.println("k2=" + keyword2 );
		System.out.println("search2= "+ searchOption2);
		
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping("left")
	public String left(){
		return "left";
	}
	
	@RequestMapping("page4")
	public String page4(){
		return "page4";
	}
	
}
