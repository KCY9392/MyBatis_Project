package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	/**
	 * 회원가입 메소드
	 * @param sqlSession
	 * @param m
	 * @return result(회원추가 실행결과)
	 */
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertMember", m);
		//insert(실행할 쿼리문, 넣을 객체); -> insert메소드 결과값은 실행결과값이다.
		
		/*
		 * sqlSession에서 제공하는 메소드를 통해서 sql문을 찾아서 실행하고, 결과를 바로 받아볼 수 있다.
		 * 
		 * sqlSession.sql문 종류에 맞는 메소드("mapper파일의 namespace.해당sql문의 고유한 id", sql문을 완성시킬 객체);
		 * => 해당 sql문이 미완성된 상태가 아니라면 sql문을 완성시킬 객체는 생략가능.
		 */
	}

	/**
	 * 회원로그인 메소드
	 * @param sqlSession
	 * @param m
	 * @return Member객체(로그인한 회원정보)
	 */
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		//selectOne 메소드 : 조회결과가 없다면, null 반환
		return sqlSession.selectOne("memberMapper.loginMember", m);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
