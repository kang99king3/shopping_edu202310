package com.edu.shop.dtos;

import java.util.Date;

public class Cart {

	private int cart_id;
	private int member_id;
	private int item_id;
	private int count;
	private Date reg_date;
	private Date up_date;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cart_id, int member_id, int item_id, int count, Date reg_date, Date up_date) {
		super();
		this.cart_id = cart_id;
		this.member_id = member_id;
		this.item_id = item_id;
		this.count = count;
		this.reg_date = reg_date;
		this.up_date = up_date;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
		return "Cart [cart_id=" + cart_id + ", member_id=" + member_id + ", item_id=" + item_id + ", count=" + count
				+ ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}
	
}
