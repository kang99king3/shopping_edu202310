package com.edu.dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataBase {
	
	protected DataSource dataFactory;
	
	public DataBase() {
//	    java:comp/env	응용 프로그램 환경 항목
		//    java:comp/env/jdbc	JDBC Data Source
		//    java:comp/ejb	EJB 컴포넌트
		//    java:comp/UserTransaction	UserTransaction 객체
		//    java:comp/env/mail	JavaMail 연결 객체
		//    java:comp/env/url	URL 정보
		//    java:comp/env/jms	JMS 연결 객체
			try {
	            Context ctx = new InitialContext();
	            dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/mariadb/shop");
	            
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	}
	
	//6단계: DB 연결 닫기
	public void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			System.out.println("6단계:DB닫기 성공");
		} catch (SQLException e) {
			System.out.println("6단계:DB닫기 실패");
			e.printStackTrace();
		}
	}
}
