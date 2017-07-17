package study.spring.two.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.spring.two.dto.AaaDto;
import study.spring.two.dto.CompanyDto;
import study.spring.two.dto.WebDto;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CompanyDto> getList() {
		List<CompanyDto> list = sqlSession.selectList("company.getList");
		return list;
	}

	@Override
	public CompanyDto getData(int companyNo) {
		CompanyDto dto = sqlSession.selectOne("company.getData", companyNo);
		return dto;
	}

	@Override
	public void insert(CompanyDto dto) {
		sqlSession.insert("company.insert", dto);
	}

	@Override
	public void update(HttpServletRequest request, CompanyDto dto) {
		System.out.println("companyDaoImpl-update 탄?");
		sqlSession.update("company.update", dto);
		System.out.println("companyDaoImpl-update 탄?+++++++++++");
	}

	@Override
	public int delete(CompanyDto dto) {
		return sqlSession.delete("company.delete", dto);
	}

	@Override
	public List<CompanyDto> pageList(CompanyDto comDto) {
		return sqlSession.selectList("company.pageList", comDto);
	}

	@Override
	public int getTotalRow(String searchOption, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		System.out.println("CompanyDao mapper = " + searchOption);
		return sqlSession.selectOne("company.getTotalRow", map);
	}

	@Override
	public List<CompanyDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		
		return sqlSession.selectList("company.listAll", map);
	}

	@Override
	public int countArticle(String searchOption, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("company.countArticle", map);
	}

}
