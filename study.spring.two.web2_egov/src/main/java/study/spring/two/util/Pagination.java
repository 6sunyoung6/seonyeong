package study.spring.two.util;

import java.util.HashMap;
import java.util.Map;

public class Pagination{
	public Pagination(){}

	public Map<String, Object> pagination(int pageNum, int totalRow){
		if(pageNum == 0) pageNum = 1;
		// 한 페이지에 나타낼 로우의 갯수
		final int PAGE_ROW_COUNT = 5;
		// 하단 디스플레이 페이지 갯수
		final int PAGE_DISPLAY_COUNT = 5;
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum * PAGE_ROW_COUNT;
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
		// 끝 페이지 번호가 잘못된 값이라면
		if(totalPageCount < endPageNum){
			endPageNum = totalPageCount; // 보정해준다.
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		map.put("totalPageCount", totalPageCount);
		map.put("startPageNum", startPageNum);
		map.put("endPageNum", endPageNum);
		return map;
	}
}
