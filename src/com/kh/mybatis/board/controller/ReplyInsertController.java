package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.member.model.vo.Member;

@WebServlet("/insert.re")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String replyText = request.getParameter("replyText");
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		int userNo = loginUser.getUserNo();
		
		Map<String, Object> r = new HashMap<>();
		r.put("boardNo", boardNo);
		r.put("replyText", replyText);
		r.put("userNo", userNo);
		
		BoardService bs = new BoardServiceImpl();
		
		int insertRY = bs.replyInsert(r);
		
		if(insertRY > 0) {//댓글작성 실패
			request.setAttribute("errorMsg", "댓글작성 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}else {
			
			ArrayList<Reply> rlist = bs.selectReplyList(boardNo);
			request.setAttribute("rlist", rlist);
			
			Board b = bs.boardDetail(boardNo);
			request.setAttribute("b", b);
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
