package study.spring.two.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 엑셀 파일에 담을 vo
// 엑셀과 Query의 mapping을 위한 VO 클래스
public class WebVo implements Serializable{

	private String no;
	private String kor_name;
	private String jumin1;
	private String gender;
	private String tech;
	private String work_state;
	private String work_type;

	public WebVo(){
		
	}
	public WebVo(String no, String kor_name, String jumin1, String gender, String tech, String work_state,
			String work_type) {
		super();
		this.no = no;
		this.kor_name = kor_name;
		this.jumin1 = jumin1;
		this.gender = gender;
		this.tech = tech;
		this.work_state = work_state;
		this.work_type = work_type;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getKor_name() {
		return kor_name;
	}

	public void setKor_name(String kor_name) {
		this.kor_name = kor_name;
	}

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public String getWork_state() {
		return work_state;
	}

	public void setWork_state(String work_state) {
		this.work_state = work_state;
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("no: " +no);
		sb.append(", 이름: " + kor_name);
		sb.append(", 주민번호: " + jumin1);
		sb.append(", 성별: " + gender);
		sb.append(", 기술: " + tech);
		sb.append(", 상태: " + work_state);
		sb.append(", 근무: " + work_type);
		
//		
//		return "WebVo [no=" + no + ", kor_name=" + kor_name + ", jumin1=" + jumin1 + ", gender=" + gender + ", tech="
//				+ tech + ", work_state=" + work_state + ", work_type=" + work_type + "]";
		return sb.toString();
	}
	
	@RequestMapping("/sale/listExcelVOCategory.do")
	public ModelAndView selectCategoryVOList() throws Exception{
		
		List<WebVo> lists = new ArrayList<>();
		
		WebVo web = new WebVo();
		
		// map<String, String> mapCategory = new HashMap<String, String>();
		web.setNo(no);
		web.setKor_name(kor_name);
		web.setJumin1(jumin1);
		web.setGender(gender);
		web.setTech(tech);
		web.setWork_state(work_state);
		web.setWork_type(work_type);
		
		lists.add(web);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", lists);
		
		return new ModelAndView("categoryExcelView", "categoryMap", map);
	}
}
