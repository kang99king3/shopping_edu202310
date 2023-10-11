package com.edu.shop.dtos;

import java.util.Date;

public class ItemDto {
	private int item_id;
	private String item_name;
	private String item_detail;
	private String item_sell_status;
	private int price;
	private int stock_number;
	private Date reg_date;
	private Date up_date;
	
	private ItemImgDto itemImgDto;
	
	public ItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDto(int item_id, String item_name, String item_detail, String item_sell_status, int price,
			int stock_number, Date reg_date, Date up_date) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_detail = item_detail;
		this.item_sell_status = item_sell_status;
		this.price = price;
		this.stock_number = stock_number;
		this.reg_date = reg_date;
		this.up_date = up_date;
	}
	
	public ItemDto(String item_name, String item_detail, String item_sell_status, int price, int stock_number) {
		super();
		this.item_name = item_name;
		this.item_detail = item_detail;
		this.item_sell_status = item_sell_status;
		this.price = price;
		this.stock_number = stock_number;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}
	public String getItem_sell_status() {
		return item_sell_status;
	}
	public void setItem_sell_status(String item_sell_status) {
		this.item_sell_status = item_sell_status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock_number() {
		return stock_number;
	}
	public void setStock_number(int stock_number) {
		this.stock_number = stock_number;
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
	
	public ItemImgDto getItemImgDto() {
		return itemImgDto;
	}
	public void setItemImgDto(ItemImgDto itemImgDto) {
		this.itemImgDto = itemImgDto;
	}
	@Override
	public String toString() {
		return "ItemDto [item_id=" + item_id + ", item_name=" + item_name + ", item_detail=" + item_detail
				+ ", item_sell_status=" + item_sell_status + ", price=" + price + ", stock_number=" + stock_number
				+ ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}
	
}
