package com.java155.shop.filter;

import com.java155.shop.support.ContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class holderFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
		HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
		ContextHolder.setholdSession(httpServletRequest.getSession());
		ContextHolder.setHolderRequest(httpServletRequest);
		ContextHolder.setHolderResponse(httpServletResponse);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
