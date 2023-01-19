package com.kh.mybatis.common;

import org.apache.ibatis.session.RowBounds;

import com.kh.mybatis.member.model.vo.PageInfo;

public class Pagination {
	
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		int maxPage = (int)Math.ceil( (double)listCount / boardLimit );
		
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		int endPage = startPage + pageLimit - 1;
		endPage = endPage > maxPage ? maxPage : endPage;
		
				
		int offset = (currentPage - 1) * boardLimit;
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage, offset);	
	
		return pi;
	}
	
	public static RowBounds getRowBounds(PageInfo pi) {
		
		return new RowBounds(pi.getOffset(), pi.getBoardLimit());
		
	}
	
}
