package com.edu.shop.main;

import com.edu.shop.dao.MemberDao;
import com.edu.shop.dtos.MemberDto;

public class MainTest {

	public static void main(String[] args) {
		MemberDao dao=new MemberDao();
		System.out.println(dao.getMember(1));
	}
}
