package com.edu.shop.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.shop.dao.MemberDao;
import com.edu.shop.dtos.MemberDto;

@WebServlet("*.member")
public class MemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String requestURI=request.getRequestURI();
		String command=requestURI.substring(request.getContextPath().length());
		System.out.println(command);
		MemberDao dao=new MemberDao();
		
		HttpSession session=request.getSession();
		if(command.equals("/loginForm.member")) {
			dispatch("member/login.jsp", request, response);
//			response.sendRedirect("member/login.jsp");
		}else if(command.equals("/login.member")) {
			System.out.println("로그인");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			MemberDto dto=dao.loginMember(email, password);
			
			if(dto==null||dto.getEmail()==null) {
				response.sendRedirect("member/login.jsp?msg="
						+URLEncoder.encode("회원정보를 확인하세요", "utf-8"));
			}else {
				session.setAttribute("ldto", dto);
				session.setMaxInactiveInterval(10*60);//10분
				
				response.sendRedirect("main.item");
			}
		}else if(command.equals("/registForm.member")) {
			dispatch("member/registForm.jsp", request, response);
//			response.sendRedirect("member/registForm.jsp");
		}else if(command.equals("/regist.member")) {
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			if(dao.emailCheck(email)==null) {//이메일 중복확인
				boolean isS=dao.registUser(new MemberDto(name,password,address,email,phone));
				if(isS) {
					response.sendRedirect("main.item");
				}else {
					
				}
			}else {
				System.out.println(dao.emailCheck(email));
				response.sendRedirect("member/registForm.jsp?msg="
						+URLEncoder.encode("이미 가입된 회원입니다.", "utf-8"));
				
			}
		}else if(command.equals("/logout.member")) {
			session.invalidate();
			response.sendRedirect("main.item");
		}
	}
	
	//forward 메서드 구현
		public void dispatch(String url,HttpServletRequest request, 
				  			HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher(url).forward(request, response);		
		}
}




