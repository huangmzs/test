package com.java155.shop.filter;

import com.alibaba.fastjson.JSON;
import com.java155.shop.config.Contants;
import com.java155.shop.pojo.TbUser;
import com.java155.shop.service.TbUserService;
import com.java155.shop.support.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLoginFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = 	(HttpServletRequest)servletRequest;
		HttpServletResponse response = 	(HttpServletResponse)servletResponse;
		String cookieValue = ContextHolder.getCookie(Contants.Cookie_LOGIN_USER);
			TbUser sessionUser = ContextHolder.getUser();
			if(cookieValue!=null){
				if(sessionUser==null){
					TbUser tbUser = JSON.parseObject(cookieValue, TbUser.class);
					ContextHolder.saveUser(tbUser);
				}
					response.sendRedirect("/index.html");
			}
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {

	}
}
