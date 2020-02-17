package com.java155.shop.support;

import com.java155.shop.config.Contants;
import com.java155.shop.pojo.TbUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ContextHolder {

	static ThreadLocal<HttpSession> holderSession=new ThreadLocal<HttpSession>();
	static ThreadLocal<HttpServletRequest> holderRequest=new ThreadLocal<HttpServletRequest>();
	static ThreadLocal<HttpServletResponse> holderResponse=new ThreadLocal<HttpServletResponse>();
	//登录保存session
	public static void saveUser(TbUser tbUser){
		holderSession.get().setAttribute(Contants.SESSION_LOGIN_USER, tbUser);
	}
	//获取session
	public static TbUser getUser(){
		return (TbUser)holderSession.get().getAttribute(Contants.SESSION_LOGIN_USER);
	}
	//获取session
	public static void removeUser(){
		holderSession.get().removeAttribute(Contants.SESSION_LOGIN_USER);
	}


	public static void setholdSession(HttpSession session){
		holderSession.set(session);
	}
	public static void setHolderRequest(HttpServletRequest httpServletRequest){
		holderRequest.set(httpServletRequest);
	}
	public static void setHolderResponse(HttpServletResponse httpServletResponse){
		holderResponse.set(httpServletResponse);
	}

	public static Cookie[] getCookies(){//获取Cookie数组
		return holderRequest.get().getCookies();
	}

	public static String getCookie(String cookieName){
		Cookie[] cookies = getCookies();//获取Cookie中的值
		if(cookies!=null){
			for (Cookie cookie:cookies){
				if(cookie.getName().equals(cookieName)){
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static void removeCookie(String cookieName){
		Cookie[] cookies = getCookies();
		if(cookies!=null){
			for (Cookie cookie:cookies){
				if(cookie.getName().equals(cookieName)){
					cookie.setMaxAge(0);
					addCookie(cookie);
				}
			}
		}
	}

	public static void addCookie(Cookie cookie){//添加Cookie
		cookie.setDomain("localhost");
		holderResponse.get().addCookie(cookie);
	}
}
