package study.spring.two.dto;

public class AaaDto{
	
	private int dataNo;		// 데이터 번호
	private String data1;   // aaa 테이블, 드롭다운을 구현하고 조인을 걸기 위해 생성
//	private String data2;
//	private String data3;
//	
//	public String getData2() {
//		return data2;
//	}
//
//	public void setData2(String data2) {
//		this.data2 = data2;
//	}
//
//	public String getData3() {
//		return data3;
//	}
//
//	public void setData3(String data3) {
//		this.data3 = data3;
//	}

	public int getDataNo() {
		return dataNo;
	}

	public void setDataNo(int dataNo) {
		this.dataNo = dataNo;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	// 기본 생성자
	public AaaDto() {
		super();
	}

	public AaaDto(int dataNo, String data1) {
		super();
		this.dataNo = dataNo;
		this.data1 = data1;
	}

//	public AaaDto(int dataNo, String data1, String data2, String data3) {
//		super();
//		this.dataNo = dataNo;
//		this.data1 = data1;
//		this.data2 = data2;
//		this.data3 = data3;
//	}

	@Override
	public String toString() {
		return "AaaDto [dataNo=" + dataNo + ", data1=" + data1  + "]";
	}

}
