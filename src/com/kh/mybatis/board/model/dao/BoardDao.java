package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.Pagination;
import com.kh.mybatis.member.model.vo.PageInfo;

public class BoardDao {

	//게시판리스트 가져오는 메소드
	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	//게시판리스트 조회하는 메소드
	public ArrayList<Board> selectListCount(SqlSession sqlSession, PageInfo pi) {

		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, Pagination.getRowBounds(pi));
		return list;
		
	}

	//게시판 상세조회 메소드
	public Board boardDetail(SqlSession sqlSession, int boardNo) {
		
		return (Board)sqlSession.selectOne("boardMapper.boardDetail", boardNo);
	}

	//검색 시, 조회 게시판 메소드
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, PageInfo pi, Map<String,String> s) {
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", s, Pagination.getRowBounds(pi));
	}

	//검색 시, 조회되는 리스트 개수 구하는 메소드
	public int selectSearchListCount(SqlSession sqlSession, Map<String, String> s) {
		return sqlSession.selectOne("boardMapper.selectSearchListCount", s);
	}

	//조회수 증가 메소드
	public int boardCountAdd(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.CountAdd", boardNo);
	}

	//댓글목록 조회 메소드
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}

	//댓글작성 메소드
	public int replyInsert(SqlSession sqlSession, Map<String, Object> r) {
		return sqlSession.insert("boardMapper.insertReply", r);
	}

	
	
}
