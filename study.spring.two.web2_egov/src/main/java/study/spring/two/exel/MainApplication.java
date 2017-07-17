
package study.spring.two.exel;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.spring.two.dto.WebDto;
import study.spring.two.dto.WebVo;
import study.spring.two.service.Service;

@Controller
public class MainApplication {
	
	@Autowired
	private Service service;

	// 엑셀 파일 업로드
	@RequestMapping("excel")
	public String excel(@RequestParam (value="check_sub") int no, 
			@RequestParam(value="check_sub") List<Integer> check) {
//	  public static void main(String[] args) {
//		 엑셀로 쓸 데이터 생성
		
		List<WebVo> list = new ArrayList<WebVo>();
		WebDto vo = service.getDataExcel(no);

		String no1 = Integer.toString(vo.getNo());
		String kor_name = vo.getKor_name();
		String jumin1 = vo.getJumin1();
		String gender = vo.getGender();
		String tech = vo.getTech();
		String work_state = vo.getWork_state();
		String work_type = vo.getWork_type();
		
		System.out.println();
		System.out.println("?????????? " + vo);
		
		list.add(new WebVo(no1, kor_name, jumin1, gender, tech, work_state, work_type));
		
		list.add(new WebVo("1", "박선영", "880914", "여자", "초급", "정규직", "SI"));
		list.add(new WebVo("2", "박선영", "880914", "여자", "초급", "정규직", "SI"));
		System.out.println("///////////////////////////////////////no=" + vo.getNo());
		System.out.println("///////////////////////setNo=" + vo.getNo());
		
		
		
		WebExcelWriter excelWriter = new WebExcelWriter();
		
		// xlsx 파일 쓰기
		excelWriter.xlsxWiter(list);
		WebExcelReader excelReader = new WebExcelReader();
		
//		System.out.println("*****xls******");
//		List<WebVo> xlsList = excelReader.xlsxToCustomerVoList("C:\\execel\\testWrite.xls");
//		printList(xlsList);
		
		System.out.println("*****xlsx******");
		List<WebVo> xlsxList = excelReader.xlsxToCustomerVoList("C:\\execel\\testWrite.xlsx");
		printList(xlsxList);
		
		return "redirect:main.do?pageNum=1";
	  }
	  
	  public static void printList(List<WebVo> list) {
		  WebVo vo;
		  
		  for(int i=0; i < list.size(); i++){
			  vo = list.get(i);
			  System.out.println(vo.toString());
		  }
	  }
}
