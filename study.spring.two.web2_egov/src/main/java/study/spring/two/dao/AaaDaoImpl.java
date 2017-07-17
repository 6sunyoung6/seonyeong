package study.spring.two.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.spring.two.dto.AaaDto;

@Repository
public class AaaDaoImpl implements AaaDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AaaDto> getData() {
		List<AaaDto> list = sqlSession.selectList("aaa.getData");
		return list;
	}

	
}
