package study.spring.two.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import study.spring.two.dto.AaaDto;
import study.spring.two.dto.CompanyDto;
import study.spring.two.dto.WebDto;

public interface CompanyDao {

	// 회사 정보 전체 조회
	public List<CompanyDto> getList();
	
	// 회사 정보 조회
	public CompanyDto getData(int companyNo);
	
	// 회사정보 등록
	public void insert(CompanyDto dto);

	// 회사정보 수정
	public void update(HttpServletRequest request, CompanyDto dto);
	
	// 회사 정보 삭제
	public int delete(CompanyDto dto);
	
	public List<CompanyDto> pageList(CompanyDto comDto);
	
	public int getTotalRow(String searchOption, String keyword);
	

	public List<CompanyDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum);
	
	public int countArticle(String searchOption, String keyword);

}
