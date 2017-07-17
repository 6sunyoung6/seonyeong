package study.spring.two.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.WebDto;
import study.spring.two.dto.WebVo;

public interface WebDao {
	
	public List<WebDto> getList();
	
//	public List<WebVo> getListExcel();

	public WebDto getData(int no);
	
	public void insert(WebDto dto);
	
	public void update(HttpServletRequest request, WebDto dto);
	
	public int delete(WebDto dto);
	
	public List<WebDto> pageList(WebDto webDto);
	
	public int getTotalRow(String searchOption, String keyword, String searchOption2, String keyword2);
	
	
	public List<WebDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum, String searchOption2, String keyword2);
	
	public int countArticle(String searchOption, String keyword, String searchOption2, String keyword2);
//	public int countArticle(String searchOption, String keyword);

}
