package com.edu.shop.dtos;

import java.util.Date;

public class ItemImgDto {
	private int item_img_id;
	private int item_id;
	private String img_name;
	private String img_url;
	private String ori_img_name;
	private String repimg_yn;
	private Date reg_date;
	private Date up_date;
	public ItemImgDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemImgDto(int item_img_id, int item_id, String img_name, String img_url, String ori_img_name, String repimg_yn,
			Date reg_date, Date up_date) {
		super();
		this.item_img_id = item_img_id;
		this.item_id = item_id;
		this.img_name = img_name;
		this.img_url = img_url;
		this.ori_img_name = ori_img_name;
		this.repimg_yn = repimg_yn;
		this.reg_date = reg_date;
		this.up_date = up_date;
	}
	
	public ItemImgDto(int item_id, String img_name, String img_url, String ori_img_name, String repimg_yn) {
		super();
		this.item_id = item_id;
		this.img_name = img_name;
		this.img_url = img_url;
		this.ori_img_name = ori_img_name;
		this.repimg_yn = repimg_yn;
	}
	public int getItem_img_id() {
		return item_img_id;
	}
	public void setItem_img_id(int item_img_id) {
		this.item_img_id = item_img_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getOri_img_name() {
		return ori_img_name;
	}
	public void setOri_img_name(String ori_img_name) {
		this.ori_img_name = ori_img_name;
	}
	public String getRepimg_yn() {
		return repimg_yn;
	}
	public void setRepimg_yn(String repimg_yn) {
		this.repimg_yn = repimg_yn;
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
		return "ItemImg [item_img_id=" + item_img_id + ", item_id=" + item_id + ", img_name=" + img_name + ", img_url="
				+ img_url + ", ori_img_name=" + ori_img_name + ", repimg_yn=" + repimg_yn + ", reg_date=" + reg_date
				+ ", up_date=" + up_date + "]";
	}
	
}
