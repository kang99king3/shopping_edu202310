package com.edu.shop.dtos;

import java.util.Date;

public class OrdersDto {

	private int order_id;
	private int member_id;
	private int item_id;
	private String order_status;
	private int count;
	private Date order_date;
	private Date reg_date;
	private Date up_date;
	public OrdersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersDto(int order_id, int member_id, int item_id, String order_status, int count, Date order_date,
			Date reg_date, Date up_date) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
		this.item_id = item_id;
		this.order_status = order_status;
		this.count = count;
		this.order_date = order_date;
		this.reg_date = reg_date;
		this.up_date = up_date;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
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
		return "Orders [order_id=" + order_id + ", member_id=" + member_id + ", item_id=" + item_id + ", order_status="
				+ order_status + ", count=" + count + ", order_date=" + order_date + ", reg_date=" + reg_date
				+ ", up_date=" + up_date + "]";
	}
	
}
