package study.spring.two.dto;

// 대표등록 정보를 위한 beans
public class CompanyDto {

    private String companyName; // 회사이름
    private int companyNo;   	// 회사고유번호
    private String addr;        // 회사주소
    private String daepyoType; 	// 대표 구분
    private String daepyos;     // 각자대표
    private String daepyosName; // 각자대표명
    private String daepyosAddress;// 각자대표 주소
    private String jumin1;        // 주민등록번호 앞자리
    private String jumin2;        // 주민등록번호 뒷자리
    private String daepyo;      // 대표
    private String homepage;    // 홈페이지주소
    private String etc;          // 기타
    
    private int startRowNum;
	private int endRowNum;
    
	
	// 기본 생성자
	public CompanyDto(){}
	
	// 페이지 처리를 위한 생성자
		public CompanyDto(int startRowNum, int endRowNum){
			super();
			this.startRowNum = startRowNum;
			this.endRowNum = endRowNum;
		}
    
	public CompanyDto(String companyName, int companyNo, String addr, String daepyoType, String daepyos,
				String daepyosName, String daepyosAddress, String jumin1, String jumin2, String daepyo, String homepage,
				String etc, int startRowNum, int endRowNum) {
			super();
			this.companyName = companyName;
			this.companyNo = companyNo;
			this.addr = addr;
			this.daepyoType = daepyoType;
			this.daepyos = daepyos;
			this.daepyosName = daepyosName;
			this.daepyosAddress = daepyosAddress;
			this.jumin1 = jumin1;
			this.jumin2 = jumin2;
			this.daepyo = daepyo;
			this.homepage = homepage;
			this.etc = etc;
			this.startRowNum = startRowNum;
			this.endRowNum = endRowNum;
		}


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDaepyoType() {
		return daepyoType;
	}

	public void setDaepyoType(String daepyoType) {
		this.daepyoType = daepyoType;
	}

	public String getDaepyos() {
		return daepyos;
	}

	public void setDaepyos(String daepyos) {
		this.daepyos = daepyos;
	}

	public String getDaepyosName() {
		return daepyosName;
	}

	public void setDaepyosName(String daepyosName) {
		this.daepyosName = daepyosName;
	}

	public String getDaepyosAddress() {
		return daepyosAddress;
	}

	public void setDaepyosAddress(String daepyosAddress) {
		this.daepyosAddress = daepyosAddress;
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

	public String getDaepyo() {
		return daepyo;
	}

	public void setDaepyo(String daepyo) {
		this.daepyo = daepyo;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
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

	@Override
	public String toString() {
		return "CompanyDto [ companyName=" + companyName + ", companyNo=" + companyNo + ", addr=" + addr
				+ ", daepyoType=" + daepyoType + ", daepyos=" + daepyos + ", daepyosName=" + daepyosName
				+ ", daepyosAddress=" + daepyosAddress + ", jumin1=" + jumin1 + ", jumin2=" + jumin2 + ", daepyo="
				+ daepyo + ", homepage=" + homepage + ", etc=" + etc + ", startRowNum=" + startRowNum + ", endRowNum="
				+ endRowNum + "]";
	}

	
}
