package study.spring.two.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dao.AaaDao;
import study.spring.two.dto.AaaDto;

@Component
public class AaaServiceImpl implements AaaService{
	@Autowired
	private AaaDao aaaDao;
	
	@Override
	public List<AaaDto> getData() {
		List<AaaDto> list = aaaDao.getData();
		return list;
	}

}
