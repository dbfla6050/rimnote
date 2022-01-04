package org.pyr.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/dbtest?serverTimezone=Asia/Seoul";
	private static final String USER="root";
	private static final String PW="wjd2217ghks";
	
	/*
	테스트와 관련된 어노테이선(@)
	@RunWith
	@ContextConfiguration
	@Test
	*/
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try (Connection con=DriverManager.getConnection(URL,USER,PW)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();     // 콘솔에 뭐때문에 문제가있는지 알려줘라
		}
	}
	
}
