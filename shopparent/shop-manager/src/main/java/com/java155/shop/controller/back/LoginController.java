package com.java155.shop.controller.back;

import com.java155.shop.common.Result;
import com.java155.shop.config.Contants;
import com.java155.shop.pojo.TbUser;
import com.java155.shop.service.TbUserService;
import com.java155.shop.support.ContextHolder;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;


@Controller()
public class LoginController {

	@Autowired
	private TbUserService tbUserService;

	@GetMapping("/login")
	public String toLogin() {

		return "login";
	}

	/**
	 * 登录
	 * @param tbUser
	 * @return
	 */
	@PostMapping("/login.action")
	public String login(TbUser tbUser,String checked) {
		TbUser user = tbUserService.findByidUser(tbUser);
		ContextHolder.saveUser(user);
		String cookieValue = ContextHolder.getCookie(tbUser.getUsername());
		if(!"true".equals(checked)){
			//删除Cookie  没选
			ContextHolder.removeCookie(Contants.SESSION_LOGIN_USER);
		}else if(cookieValue==null&&checked.length()>0){
			Cookie cookie=new Cookie(Contants.SESSION_LOGIN_USER, tbUser.getUsername());
			cookie.setMaxAge(60*60*24);
			ContextHolder.addCookie(cookie);
		}
		return "redirect:/back/main.jhtml";
	}

	@RequestMapping("/main.jhtml")
	public String index(){

		return "main";
	}

}
