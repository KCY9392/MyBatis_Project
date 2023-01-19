package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.Pagination;
import com.kh.mybatis.member.model.vo.PageInfo;


@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardService bs = new BoardServiceImpl();
		
		//1. 조회수 증가시키는 서비스.
		int countAddY = bs.boardCountAdd(boardNo);
		
		
		//2. 댓글 목록 불러오는 서비스
		
			//1. ArrayList로 불러오는 방법
			ArrayList<Reply> rlist = bs.selectReplyList(boardNo);
			//request.setAttribute("rlist", rlist);
			
			//2. 
		
		
		if(countAddY != 1) { //조회수증가 실패
			request.setAttribute("errorMsg", "게시글 상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}else { //조회수증가 성공
			Board b = bs.boardDetail(boardNo);
			request.setAttribute("b", b);
			System.out.println(b); //mapper와 boardVO만 변경시, null값이 들어와잇음
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
