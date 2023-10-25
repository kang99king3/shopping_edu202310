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
				 + " ON i.item_id = m.item_id "
				 + " where repimg_yn='Y' "
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
	
	//admin:상품등록하기
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
	
	//admin:상품 이미지 등록하기
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
	//admin:상품관리-상품목록 보여주기
		public List<ItemDto> itemListMng(){
			List<ItemDto> list=new ArrayList<>();
			
			String sql=" SELECT item_id, item_name,item_sell_status,reg_date "
					 + " FROM item "
					 + " ORDER BY reg_date DESC ";
			
			try {
				conn=dataFactory.getConnection();
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while(rs.next()) {
					ItemDto dto=new ItemDto();
					dto.setItem_id(rs.getInt(1));
					dto.setItem_name(rs.getString(2));
					dto.setItem_sell_status(rs.getString(3));
					dto.setReg_date(rs.getDate(4));
					list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs, psmt, conn);
			}
			
			return list;
		}
	//admin:상품관리 상세보기
	public ItemDto itemDetailMg(int item_id){
		
		ItemDto dto=new ItemDto();
		List<ItemImgDto>list=new ArrayList<>();
	
		String sql=" SELECT i.item_id,i.item_name,i.item_detail, "
				+ "         i.item_sell_status, i.price, "
				+ "		    i.stock_number,m.item_img_id, m.img_url, m.ori_img_name, m.img_name "
				+ " FROM item i JOIN item_img m "
				+ " ON i.item_id = m.item_id "
				+ " WHERE i.item_id = ? "
				+ " order by m.repimg_yn desc";
		
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, item_id);
			rs=psmt.executeQuery();
			int count=0;
			while(rs.next()) {
				//1대n 관계 매핑
				if(count==0) {
					dto.setItem_id(rs.getInt(1));
					dto.setItem_name(rs.getString(2));
					dto.setItem_detail(rs.getString(3));
					dto.setItem_sell_status(rs.getString(4));
					dto.setPrice(rs.getInt(5));
					dto.setStock_number(rs.getInt(6));					
					count=1;
				}
				//1개 상품에 대한 이미지 여러개는 list에 담아서 마지막에 dto에 추가한다
				ItemImgDto mdto=new ItemImgDto();
				mdto.setItem_img_id(rs.getInt(7));
				mdto.setImg_url(rs.getString(8));
				mdto.setOri_img_name(rs.getString(9));
				mdto.setImg_name(rs.getString(10));
				list.add(mdto);
			}
			dto.setItemImgDtoList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return dto;
	}

}






