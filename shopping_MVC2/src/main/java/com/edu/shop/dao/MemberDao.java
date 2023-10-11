package com.edu.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.edu.dataSource.DataBase;
import com.edu.shop.constant.RoleStatus;
import com.edu.shop.dtos.MemberDto;

public class MemberDao extends DataBase{
	
	private Connection conn;
    private PreparedStatement psmt;
    private ResultSet rs;
    
	public MemberDao() {}
	
	//회원가입
	public boolean registUser(MemberDto dto) {
		int count=0;
		String sql = "INSERT INTO member VALUES(NULL, ?, ?, ?, "
				   + "?, ?, ?, SYSDATE(), NULL) ";
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getPassword());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getPhone());
			psmt.setString(6, String.valueOf(RoleStatus.USER));
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;
	}
	
	
	
	//이메일체크
	public String emailCheck(String email) {
//		MemberDto dto = new MemberDto();
		String resultEmail=null;
		String sql=" select email "
				+ " from member where email=? ";
		
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs=psmt.executeQuery();
			while(rs.next()) {
				resultEmail=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return resultEmail;
	}
	
	//나의 정보조회
	public MemberDto getMember(int member_id) {
		MemberDto dto = new MemberDto();
		
		String sql=" select member_id, name, address, email, phone, role "
				+ " from member where member_id = ? ";
		
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, member_id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setMember_id(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhone(rs.getString(5));
				dto.setRole(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return dto;
	}
	
	//로그인
	public MemberDto loginMember(String email,String password) {
		MemberDto dto = new MemberDto();
		
		String sql=" select email,role "
				+ " from member where email=? and password=? ";
		
		try {
			conn=dataFactory.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto.setEmail(rs.getString(1));
				dto.setRole(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return dto;
	}
}







