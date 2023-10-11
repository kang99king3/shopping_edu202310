package com.edu.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dataSource.DataBase;
import com.edu.shop.constant.ItemSellStatus;
import com.edu.shop.constant.RoleStatus;
import com.edu.shop.dtos.ItemDto;
import com.edu.shop.dtos.ItemImgDto;
import com.edu.shop.dtos.MemberDto;

public class ItemDao extends DataBase{

	private Connection conn;
    private PreparedStatement psmt;
    private ResultSet rs;
	
    //main페이지에 상품목록 보여주기
	public List<ItemDto> itemList(){
		List<ItemDto> list=new ArrayList<>();
		
		String sql=" SELECT i.item_id,i.item_name, i.price, m.img_url, "
				 + " m.img_name "
				 + " FROM item i JOIN item_img m "
				 + " ON i.item_id = m.item_id  "
				 + " ORDER BY i.reg_date DESC ";
		
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				ItemDto dto=new ItemDto();
				ItemImgDto mdto=new ItemImgDto();
				dto.setItem_id(rs.getInt(1));
				dto.setItem_name(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				mdto.setImg_url(rs.getString(4));
				mdto.setImg_name(rs.getString(5));
				dto.setItemImgDto(mdto);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return list;
	}
	
	//상품등록하기
	public boolean addItem(ItemDto dto) {
		int count=0;
		String sql ="insert into item value(null, ?,?,?,?,?,sysdate(),null)";
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getItem_name());
			psmt.setString(2, dto.getItem_detail());
			psmt.setString(3, ItemSellStatus.SELL.name());
			psmt.setInt(4, dto.getPrice());
			psmt.setInt(5, dto.getStock_number());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;
	}
	
	//상품등록하기
	public boolean addItemImg(ItemImgDto dto) {
		int count=0;
		String sql ="insert into item_img value(null,"
				+ "( SELECT AUTO_INCREMENT "
				+ " FROM information_schema.tables "
				+ " WHERE table_name = 'item' "
				+ " AND table_schema = DATABASE( ))-1 "
				+ ",?,?,?,?,sysdate(),null)";
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getImg_name());
			psmt.setString(2, dto.getImg_url());
			psmt.setString(3, dto.getOri_img_name());
			psmt.setString(4, dto.getRepimg_yn());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;
	}
	/*
	 * SELECT AUTO_INCREMENT

FROM information_schema.tables

WHERE table_name = 'table name'

AND table_schema = DATABASE( ) ;
	 */
}






