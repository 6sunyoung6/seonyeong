package study.spring.two.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.spring.two.dto.WebDto;
import study.spring.two.dto.WebVo;

@Repository
public class WebDaoImpl implements WebDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<WebDto> getList() {
		List<WebDto> list = sqlSession.selectList("web.getList");
		return list;
	}
	
//	@Override
//	public List<WebVo> getListExcel(){
//		List<WebVo> list = sqlSession.selectList("web.getList");
//		return list;
//	}

	@Override
	public WebDto getData(int no) {
		WebDto dto = sqlSession.selectOne("web.getData", no);
		return dto;
	}

	@Override
	public void insert(WebDto dto) {
		sqlSession.insert("web.insert", dto);
		
	}

	@Override
	public void update(HttpServletRequest request, WebDto dto) {
		sqlSession.update("web.update", dto);
		
	}

	@Override
	public int delete(WebDto dto) {
		return sqlSession.delete("web.delete", dto);
	}

	@Override
	public List<WebDto> pageList(WebDto webDto) {
		return sqlSession.selectList("web.pageList", webDto);
	}

	@Override
	public int getTotalRow(String searchOption, String keyword, String searchOption2, String keyword2) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("searchOption2", searchOption2);
		map.put("keyword2", keyword2);
		return sqlSession.selectOne("web.getTotalRow", map);
	}

	@Override
	public List<WebDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum, String searchOption2, String keyword2) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		map.put("searchOption2", searchOption2);
		map.put("keyword2", keyword2);
		return sqlSession.selectList("web.listAll", map);
	} //////////////////////////
/*
	@Override
	public List<WebDto> listAll2(String searchOption, String keyword,String searchOption2, String keyword2, int startRowNum, int endRowNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		return sqlSession.selectList("web.listAll", map);
	} //////////////////////////
*/	
	@Override
	public int countArticle(String searchOption, String keyword, String searchOption2, String keyword2) {
//	public int countArticle(String searchOption, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("searchOption2", searchOption2);
		map.put("keyword2", keyword2);
		return sqlSession.selectOne("web.countArticle", map);
	}

}
