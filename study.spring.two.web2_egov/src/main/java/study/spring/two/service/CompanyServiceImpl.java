package study.spring.two.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dao.CompanyDao;
import study.spring.two.dto.AaaDto;
import study.spring.two.dto.CompanyDto;

@Component
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao comDao;
	
	@Override
	public void insert(HttpServletRequest request, CompanyDto dto) {
		comDao.insert(dto);
		
	}
	
	@Override
	public ModelAndView getList() {
		List<CompanyDto> list = comDao.getList();
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		
		return mView;
	}

	@Override
	public int delete(CompanyDto dto) {
		
		return comDao.delete(dto);
	}

	@Override
	public void update(HttpServletRequest request, CompanyDto dto) {
		System.out.println("comServiceImpl 타니");
		comDao.update(request, dto);
		System.out.println("comServiceImpl 타니-----------------");
	}

	@Override
	public ModelAndView getData(int companyNo) {
		CompanyDto dto = comDao.getData(companyNo);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}
	
	@Override
	public List<CompanyDto> pageList(CompanyDto comDto) {
		return comDao.pageList(comDto);
	}

	@Override
	public int getTotalRow(String searchOption, String keyword) {
		return comDao.getTotalRow(searchOption, keyword);
	}

	@Override
	public List<CompanyDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum) {
		return comDao.listAll(searchOption, keyword, startRowNum, endRowNum);
	}

	@Override
	public int countArticle(String searchOption, String keyword) {
		return comDao.countArticle(searchOption, keyword);
	}

	


}
