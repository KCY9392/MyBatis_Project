package com.kh.mybatis.board.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.template.Template.*;

import java.util.ArrayList;
import java.util.Map;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.member.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService{

	private BoardDao bd = new BoardDao();
	
	
	@Override
	//게시판 리스트 총 수 가져오는 메소드
	public int selectListCount() {
		
		SqlSession sqlSession = getSqlSession();
		
		int listCount = bd.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}


	@Override
	//게시판리스트 조회하는 메소드
	public ArrayList<Board> selectList(PageInfo pi) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = bd.selectListCount(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	//게시판 상세조회 메소드
	public Board boardDetail(int boardNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		Board b = bd.boardDetail(sqlSession, boardNo);
		
		sqlSession.close();
		
		return b;
	}

	
	@Override
	//검색시, 조회 게시판 메소드
	public ArrayList<Board> selectSearchList(PageInfo pi, Map<String,String> s) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = bd.selectSearchList(sqlSession, pi, s);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	//검색시, 조회되는 리스트 개수 구하는 메소드
	public int selectSearchListCount(Map<String, String> s) {
		
		SqlSession sqlSession = getSqlSession();
		
		int listCount = bd.selectSearchListCount(sqlSession, s);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	//조회수 증가 메소드
	public int boardCountAdd(int boardNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		int countAddY = bd.boardCountAdd(sqlSession, boardNo);
		
		if(countAddY >0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return countAddY;
	}
	
	@Override
	//댓글 목록 조회 메소드
	public ArrayList<Reply> selectReplyList(int boardNo){
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Reply> rlist = bd.selectReplyList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return rlist;
	}

	@Override
	public int replyInsert(Map<String, Object> r) {
		
		SqlSession sqlSession = getSqlSession();
		
		int insertRY = bd.replyInsert(sqlSession, r);
		
		if(insertRY > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return insertRY;
	}
}
