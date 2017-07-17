package study.spring.two.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dao.WebDao;
import study.spring.two.dto.WebDto;
import study.spring.two.dto.WebVo;

@Component
public class ServiceImpl implements Service{

	@Autowired
	private WebDao webDao;
	
	@Override
	public void insert(HttpServletRequest request, WebDto dto) {
		// 파일을 저장할 폴더의 절대 경로를 얻어온다.
		/*String realPath = request.getSession().getServletContext().getRealPath("/upload");*/
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		
		// MultipartFile 객체의 참조값 얻어오기
		System.out.println(dto.getFile());
		// FileDto에 담긴  MultipartFile 객체의 참조값을 얻어온다.
		MultipartFile mFile = dto.getFile();
		// 원본파일명
		String orgFileName = mFile.getOriginalFilename();
		
		System.out.println("orgFileName" + orgFileName);
		// 파일 사이즈
		long fileSize = mFile.getSize();
		// 저장할 파일의 상세 경로
		String filePath = realPath+File.separator;
		// 디렉토리를 만들 파일 객체 생성
		File file = new File(filePath);
		if(!file.exists()){ // 디렉토리가 존재하지 않는다면
			file.mkdir();// 디렉토리를 만든다.
		}
		// 파일 시스템에 저장할 파일명을 만든다.(겹치지 않게)
		String saveFileName = System.currentTimeMillis()+orgFileName;
		try{
			// upload 폴더에 파일을 저장한다.
			mFile.transferTo(new File(filePath+saveFileName));
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(dto.getImg());
		// FileDto 객체에 추가 정보를 담는다.
		dto.setImg(saveFileName);
		// FileDao 객체를 이용해서 DB에 저장하기
		System.out.println(dto.getImg());
		System.out.println();
		webDao.insert(dto);
	}

	@Override
	public ModelAndView getList() {
		List<WebDto> list = webDao.getList();
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}

	@Override
	public int delete(WebDto dto) {
		return webDao.delete(dto);
	}

	@Override
	public void update(HttpServletRequest request, WebDto dto) {
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		
		
		// MultipartFile 객체의 참조값 얻어오기
		System.out.println(dto.getFile());
		// FileDto에 담긴 MultipartFile 객체의 참조값을 얻어온다.
		MultipartFile mFile = dto.getFile();
		// 원본 파일명
		String orgFileName = mFile.getOriginalFilename();
		// 파일 사이즈
		long fileSize = mFile.getSize();
		// 저장할 파일의 상세 경로
		String filePath = realPath+File.separator;
		// 디렉토리를 만들 파일 객체 생성
		File file = new File(filePath);
		if(!file.exists()){ // 디렉토리가 존재하지 않는다면
			file.mkdir(); // 디렉토리를 만든다.
		}
		// 파일 시스템에 저장할 파일명을 만든다. (겹치지 않게)
		String saveFileName = System.currentTimeMillis()+orgFileName;
		try {
			// upload 폴더에 파일을 저장한다.
			mFile.transferTo(new File(filePath+saveFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto.getImg());
		//FileDto 객체에 추가 정보를 담는다.
		dto.setImg(saveFileName);
		//FileDao 객체를 이용해서  DB에 저장하기
		 System.out.println(dto.getImg());
		 
		 webDao.update(request, dto);
	}
	@Override
	public ModelAndView getData(int no) {
		WebDto dto = webDao.getData(no);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto",dto);
		return mView;
	}

	@Override
	public List<WebDto> pageList(WebDto webDto) {
		return webDao.pageList(webDto);
	}

	@Override
	public int getTotalRow(String searchOption, String keyword, String searchOption2, String keyword2) {
		return webDao.getTotalRow(searchOption, keyword, searchOption2, keyword2);
	}

	@Override
	public List<WebDto> listAll(String searchOption, String keyword, int startRowNum, int endRowNum, String searchOption2, String keyword2) {
		return webDao.listAll(searchOption, keyword, startRowNum, endRowNum, searchOption2, keyword2);
	}

	@Override
	public int countArticle(String searchOption, String keyword, String searchOption2, String keyword2) {
		return webDao.countArticle(searchOption, keyword, searchOption2, keyword2);
	}
//	@Override
//	public int countArticle(String searchOption, String keyword) {
//		return webDao.countArticle(searchOption, keyword);
//	}

	@Override
	public WebDto getDataExcel(int no) {
		return webDao.getData(no);
	}

//	

}
