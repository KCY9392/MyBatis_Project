package com.kh.mybatis.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 문자안깨지게 인코딩 필터
 * @author 김채영
 *
 */
@WebFilter("/*") // * -> 모든 서블릿이 실행되기전에 항상 이 필터를 거쳐가도록
public class EncodingFilter implements Filter {

    
    public EncodingFilter() {
    }

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		/*
		 * 현재 필터가 최종필터인 경우 => Servlet 호출
		 * 현재필터가 최종필터가 아닌경우 => 또 다른 필터를 호출
		 */
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
