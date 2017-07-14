package com.beadnet.test.dto;

public class UsersDto {

	private String id;			// 사용자 ID
	private String pwd;		// 사용자 비밀번호
	private String name;		// 사용자 이름
	private String sex;			// 사용자 성별
	private String home;		// 사용자 국적
	private String birthday;	// 사용자 생년월일
	private String phone;		// 사용자 전화번호
	private String c_num;	// 사용자 카드 번호
	private String c_pwd;		// 사용자 카드 비밀번호
	private String c_cvc;		// 사용자 카드  CVC

	
	// 기본 생성자
	public UsersDto() {
		super();
	}
	
	// 사용자 카드 정보 생성자
	public UsersDto(String c_num, String c_pwd, String c_cvc) {
		super();
		this.c_num = c_num;
		this.c_pwd = c_pwd;
		this.c_cvc = c_cvc;
	}
	
	// 사용자 전체 정보 생성자
	public UsersDto(String id, String pwd, String name, String sex, String home, String birthday, String phone,
			String c_num, String c_pwd, String c_cvc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.home = home;
		this.birthday = birthday;
		this.phone = phone;
		this.c_num = c_num;
		this.c_pwd = c_pwd;
		this.c_cvc = c_cvc;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getC_pwd() {
		return c_pwd;
	}
	public void setC_pwd(String c_pwd) {
		this.c_pwd = c_pwd;
	}
	public String getC_cvc() {
		return c_cvc;
	}
	public void setC_cvc(String c_cvc) {
		this.c_cvc = c_cvc;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", pwd=" + pwd + ", name=" + name + ", sex=" + sex + ", home=" + home + ", birthday="
				+ birthday + ", phone=" + phone + ", c_num=" + c_num + ", c_pwd=" + c_pwd + ", c_cvc=" + c_cvc + "]";
	}
}
