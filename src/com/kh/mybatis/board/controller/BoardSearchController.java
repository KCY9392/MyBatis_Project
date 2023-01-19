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

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.Pagination;
import com.kh.mybatis.member.model.vo.PageInfo;


@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String category = request.getParameter("category");  //검색카테고리
		String keyword = request.getParameter("keyword");    //검색키워드
		
		Map<String, String> s = new HashMap<>();
		s.put("category", category);
		s.put("keyword", keyword);
		
		//1. 페이징 처리
		int listCount = new BoardServiceImpl().selectSearchListCount(s);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 5;
				
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
				
				
		//2. 리스트 조회
		ArrayList<Board> list = new BoardServiceImpl().selectSearchList(pi, s);
		
				
		//3. 페이징객체와 리스트객체 request에 저장시키고, forwarding
		request.setAttribute("spi", pi);
		request.setAttribute("list", list);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
