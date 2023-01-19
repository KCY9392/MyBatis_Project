package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.member.model.vo.PageInfo;

public interface BoardService {
	
	//게시판리스트 총 수 가져오는 메소드
	int selectListCount();

	//게시판리스트 조회하는 메소드
	ArrayList<Board> selectList(PageInfo pi);

	//게시판 상세조회
	Board boardDetail(int boardNo);

	//검색시, 조회 게시판
	ArrayList<Board> selectSearchList(PageInfo pi, Map<String,String> s);

	//검색시, 조회리스트 개수 구하는 메소드
	int selectSearchListCount(Map<String, String> s);

	//조회수 증가메소드
	int boardCountAdd(int boardNo);

	//댓글목록 조회 메소드
	ArrayList<Reply> selectReplyList(int boardNo);

	//댓글 작성 메소드
	int replyInsert(Map<String, Object> r);
	
	

}
