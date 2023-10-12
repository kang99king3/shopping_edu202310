package com.edu.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.shop.dao.ItemDao;
import com.edu.shop.dtos.ItemDto;
import com.edu.shop.dtos.ItemImgDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.item")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String requestURI=request.getRequestURI();
		String command=requestURI.substring(request.getContextPath().length());
		System.out.println("command:"+command);
		ItemDao dao=new ItemDao();
		
		if(command.equals("/main.item")) {//메인페이지에 상품목록 보여주기
			System.out.println("main화면");
			List<ItemDto> list=dao.itemList();
			request.setAttribute("list", list);
			dispatch("main.jsp", request, response);
		}else if(command.equals("/addItemForm.item")) {
			System.out.print("상품등록폼");
			dispatch("item/addItemForm.jsp", request, response);
		}else if(command.equals("/addItem.item")) {
			MultipartRequest multi=null;
			
			//파일경로설정
//			String saveDirectory="D:/workspace_20191217_web/13_fileupload_download_MVC2"
//					+ "/WebContent/upload";
			String saveDirectory=request.getSession().getServletContext().getRealPath("/upload");
			System.out.println("saveDirectory:"+saveDirectory);
			//파일사이즈설정
			int maxPostSize=1024*1024*10;
			
			try {
				//해당 경로에 파일 업로드 실행
				multi=new MultipartRequest(request, saveDirectory, maxPostSize,
						"utf-8",new DefaultFileRenamePolicy());
				
				String item_name=multi.getParameter("item_name");
				String sell_status=multi.getParameter("sell_status");
				int price=Integer.parseInt(multi.getParameter("price"));
				int stock_number=Integer.parseInt(multi.getParameter("stock_number"));
				String item_detail=multi.getParameter("item_detail");
				
				dao.addItem(new ItemDto(item_name, item_detail, sell_status, price, stock_number));
				
				Enumeration files=multi.getFileNames();
				boolean isS=true;
				int count=0;
				while(files.hasMoreElements()) {
					String file=(String)files.nextElement();
					System.out.println("file:"+file+":"+multi.getOriginalFileName(file));
					if(multi.getOriginalFileName(file)!=null) {
						//1.원본파일명 구함
						String origin_fname=multi.getOriginalFileName(file);
						
						//2.저장할 파일명 구함(UUID ----> 32자리 랜덤으로 생성)
						String stored_fname=createUUID()
								+origin_fname.substring(origin_fname.lastIndexOf("."));
						//test.txt ---> .의 인덱스는 4  "test.txt".substring(4)
						// 32자리.txt 변환
						//3.파일사이즈 구하기: length() --> long타입으로 반환(형변환 필요)
						int file_size=(int)multi.getFile(file).length();
						
						//4.DB에 정보 저장하기
						isS=dao.addItemImg(
								new ItemImgDto(0,
											   stored_fname,
											   saveDirectory,
											   origin_fname,
											   file.equals("itemImgFile0")?"Y":"N"));
						
						//getOriginalFileName("filename"): 원본파일명
						//getFilesystemName("filename"): 실제로 저장된 파일명
						//--> policy객체가 중복되는 파일명을 재정의한다.
						
						//5.저장된 파일의 이름을 storedName으로 바꾼다.
						File oldFile=new File(saveDirectory+"/"+multi.getFilesystemName(file));
						File newFile=new File(saveDirectory+"/"+stored_fname);
						
						oldFile.renameTo(newFile);//old---> new로 파일명 바뀜
						count++;
						
					}
				}
				if(isS) {
					response.sendRedirect("main.item");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/itemDetail.item")) {
			
		}
	}

	//forward 메서드 구현
	public void dispatch(String url,HttpServletRequest request, 
			  			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);		
	}
	
	//랜덤한 값 32자리 생성하는 메서드 
	public String createUUID() {
		//"12345678-12345678-12345678-12345678"
		return UUID.randomUUID().toString().replaceAll("-", "");//"-"제거하고 32자리로 만듬
	}
}




