package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존 JDBC
	 * public static Connection getConnection(){
	 * 	// driver.properties파일을 읽어들여서 
	 *  // 설정한 db정보와 접속된 Connection객체를 생성해서 반환
	 * }
	 */
	
	// MyBatis
	public static SqlSession getSqlSession() {
		
		// mybatis-config.xml 파일을 읽어들여서
		// 해당 DB와 접속된 SqlSession객체를 생성해서 반환
		SqlSession sqlSession = null;
		
		// SqlSession 객체를 생성하기 위해서는 ? SqlSessionFactory객체가 필요하다
		// SqlSessionFactory객체를 생성하기위해서는 SqlSessionFactoryBuilder객체가 필요하다
		
		String resource = "/mybatis-config.xml";
		// <-- 최상위 폴더를 의미(resources, src를 의미)
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			//자원과 스트림(통로)를 연결
			
			
			//1단계) new SqlSessionFactoryBuilder() : SqlSessionFactoryBuilder 객체를 생성
			
			//2단계) .build(stream) : 방금연결한 inputStream을 제시해서 통로로부터 mybatis-config.xml파일을 읽어들여서
			//						SqlSessionFactory객체를 만듦
			
			//3단계) .openSession(false) : SqlSession객체를 생성, 앞으로 트랜잭션 처리 시, 자동으로 commit할건지 아닌지 여부를 결정
			//=> false == 자동 commit하지 않겠다 == 개발자가 직접 commit을 하겠다.
			//=> openSession()처럼 매개변수 안쓰면 기본값이 false이다.
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				// 이렇게 하면 안됨new InputStream(resource);
		return sqlSession;
	}
}
