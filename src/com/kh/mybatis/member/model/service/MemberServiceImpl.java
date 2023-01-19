package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao memberDao = new MemberDao();
	
	@Override
	public int insertMember(Member m){
		//원래 하던 방식 Connection conn = JDBCTemplate.getConnection();
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.insertMember(sqlSession, m);
		
		if(result>0) { // 회원추가 성공
			sqlSession.commit();
		}else { // 회원추가 실패
			sqlSession.rollback();
		}
		sqlSession.close();
		//자원관리 직접하기
		
		return result;
	}

	
	@Override
	public Member loginMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginUser = memberDao.loginMember(sqlSession, m);
		
		sqlSession.close();

		return loginUser;
	}
	
}
