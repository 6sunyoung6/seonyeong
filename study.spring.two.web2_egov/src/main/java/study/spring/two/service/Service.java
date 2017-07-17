package study.spring.two.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.WebDto;
import study.spring.two.dto.WebVo;

public interface Service {

	public void insert(HttpServletRequest request, WebDto dto);
	
	public ModelAndView getList();
	
	public WebDto getDataExcel(int no);
	
	public int delete(WebDto dto);
	
	public void update(HttpServletRequest request, WebDto dto);
	public ModelAndView getData(int no);
	
	public List<WebDto> pageList(WebDto webDto);
	public int getTotalRow(String searchOption, String keyword , String searchOption2, String keyword2);
	
	public List<WebDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum, String searchOption2, String keyword2);
	public int countArticle(String searchOption, String keyword,String searchOption2, String keyword2);
//	public int countArticle(String searchOption, String keyword);
	
//	public List<Object> getAllObjects(String target);
	
	// 엑셀 업로드용 
//	public List<WebDto> uploadExcel(WebDto dto);
	
}
