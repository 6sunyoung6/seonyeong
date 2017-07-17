package study.spring.two.dto;

import org.springframework.web.multipart.MultipartFile;

public class WebDto {

	  /**
    no -> 사원번호, pk
    kor_name 한글이름
    eng_name 영어이름
    han_name 한문이름
    jumin1   주민번호1
    jumin2   주민번호2
    img      사진파일명
    b_year   생년
    b_month  월
    b_day    일
    calender 양/음력
    gender   성별
    marry    결혼
    work_date 년차
    sal_type 급여타입
    work_type 근무형태(SI/SM)
    work_state 계약 형태(정규/계약)
    postcode 우편주소
    addr1 주소1
    addr2 주소2
    tel1  전화번호1
    tel2  전화번호2
    tel3  전화번호3
    email 이메일
    tech  기술등급
    drink  주량
    */
	private int no;
	private String kor_name;
	private String eng_name;
	private String han_name;
	private String jumin1;
	private String jumin2;
	private String img;
	private String b_year;
	private String b_month;
	private String b_day;
	private String calender;
	private String gender;
	private String marry;
	private String work_date;
	private String sal_type;
	private String work_type;
	private String work_state;
	private String postcode;
	private String addr1;
	private String addr2;
	private String tel1;
	private String tel2;
	private String tel3;
	private String email;
	private String tech;
	private String drink;
		    
	private int startRowNum;
	private int endRowNum;
	
	private MultipartFile file;
	private String orgFileName;
	private long fileSize;
	
	// 기본생성자
	public WebDto(){}
	
	// 페이지 처리를 위한 생성자
	public WebDto(int startRowNum, int endRowNum){
		super();
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	}
	

	
	
	// 엑셀 다운로드를 위한 생성자
	public WebDto(int no, String kor_name, String jumin1, String gender, String work_type, String work_state) {
		super();
		this.no = no;
		this.kor_name = kor_name;
		this.jumin1 = jumin1;
		this.gender = gender;
		this.work_type = work_type;
		this.work_state = work_state;
	}

	// 정보를 위한 생성자
		public WebDto(int no, String kor_name, String eng_name, String han_name, String jumin1, String jumin2, String img,
				String b_year, String b_month, String b_day, String calender, String gender, String marry, String work_date,
				String sal_type, String work_type, String work_state, String postcode, String addr1, String addr2,
				String tel1, String tel2, String tel3, String email, String tech, String drink, int startRowNum,
				int endRowNum, MultipartFile file, String orgFileName, long fileSize) {
			super();
			this.no = no;
			this.kor_name = kor_name;
			this.eng_name = eng_name;
			this.han_name = han_name;
			this.jumin1 = jumin1;
			this.jumin2 = jumin2;
			this.img = img;
			this.b_year = b_year;
			this.b_month = b_month;
			this.b_day = b_day;
			this.calender = calender;
			this.gender = gender;
			this.marry = marry;
			this.work_date = work_date;
			this.sal_type = sal_type;
			this.work_type = work_type;
			this.work_state = work_state;
			this.postcode = postcode;
			this.addr1 = addr1;
			this.addr2 = addr2;
			this.tel1 = tel1;
			this.tel2 = tel2;
			this.tel3 = tel3;
			this.email = email;
			this.tech = tech;
			this.drink = drink;
			this.startRowNum = startRowNum;
			this.endRowNum = endRowNum;
			this.file = file;
			this.orgFileName = orgFileName;
			this.fileSize = fileSize;
		}

	@Override
	public String toString() {
		return "WebDto [no=" + no + ", kor_name=" + kor_name + ", eng_name=" + eng_name + ", han_name=" + han_name
				+ ", jumin1=" + jumin1 + ", jumin2=" + jumin2 + ", img=" + img + ", b_year=" + b_year + ", b_month="
				+ b_month + ", b_day=" + b_day + ", calender=" + calender + ", gender=" + gender + ", marry=" + marry
				+ ", work_date=" + work_date + ", sal_type=" + sal_type + ", work_type=" + work_type + ", work_state="
				+ work_state + ", postcode=" + postcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", tel1=" + tel1
				+ ", tel2=" + tel2 + ", tel3=" + tel3 + ", email=" + email + ", tech=" + tech + ", drink=" + drink
				+ ", startRowNum=" + startRowNum + ", endRowNum=" + endRowNum + ", file=" + file + ", orgFileName="
				+ orgFileName + ", fileSize=" + fileSize + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getKor_name() {
		return kor_name;
	}

	public void setKor_name(String kor_name) {
		this.kor_name = kor_name;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getHan_name() {
		return han_name;
	}

	public void setHan_name(String han_name) {
		this.han_name = han_name;
	}

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getJumin2() {
		return jumin2;
	}

	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getB_year() {
		return b_year;
	}

	public void setB_year(String b_year) {
		this.b_year = b_year;
	}

	public String getB_month() {
		return b_month;
	}

	public void setB_month(String b_month) {
		this.b_month = b_month;
	}

	public String getB_day() {
		return b_day;
	}

	public void setB_day(String b_day) {
		this.b_day = b_day;
	}

	public String getCalender() {
		return calender;
	}

	public void setCalender(String calender) {
		this.calender = calender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getWork_date() {
		return work_date;
	}

	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}

	public String getSal_type() {
		return sal_type;
	}

	public void setSal_type(String sal_type) {
		this.sal_type = sal_type;
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	public String getWork_state() {
		return work_state;
	}

	public void setWork_state(String work_state) {
		this.work_state = work_state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	
	
}
