package com.edu.shop.dtos;

import java.util.Date;

public class MemberDto {

	private int member_id;
	private String name;
	private String password;
	private String address;
	private String email;
	private String phone;
	private String role;
	private Date reg_date;
	private Date up_date;
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int member_id, String name, String password, String address, String email, String phone,
			String role, Date reg_date, Date up_date) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.reg_date = reg_date;
		this.up_date = up_date;
	}
	
	
	public MemberDto(String name, String password, String address, String email,String phone) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	@Override
	public String toString() {
		return "MemberDto [member_id=" + member_id + ", name=" + name + ", password=" + password + ", address="
				+ address + ", email=" + email + ", phone=" + phone + ", role=" + role + ", reg_date=" + reg_date
				+ ", up_date=" + up_date + "]";
	}
	
	
}
