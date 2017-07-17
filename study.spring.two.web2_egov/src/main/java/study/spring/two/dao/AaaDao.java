package study.spring.two.dao;

import java.util.List;

import study.spring.two.dto.AaaDto;

public interface AaaDao {

	// 1인 대표 드롭다운 조회
	public List<AaaDto> getData();
}
