package study.spring.two.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.CompanyDto;

public interface CompanyService {
	public void insert(HttpServletRequest request, CompanyDto dto);
//	public int insert(HttpSession session, CompanyDto dto);
	
	public ModelAndView getList();
	
	public int delete(CompanyDto dto);
	
	public void update(HttpServletRequest request, CompanyDto dto);
	public ModelAndView getData(int companyNo);
	
	public List<CompanyDto> pageList(CompanyDto comDto);
	public int getTotalRow(String searchOption, String keyword);
	
	public List<CompanyDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum);
	public int countArticle(String searchOption, String keyword);
	
}
