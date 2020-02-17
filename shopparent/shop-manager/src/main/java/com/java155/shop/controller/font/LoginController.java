package com.java155.shop.controller.font;

import com.alibaba.fastjson.JSON;
import com.java155.shop.common.Result;
import com.java155.shop.config.Contants;
import com.java155.shop.exception.LoginException;
import com.java155.shop.pojo.TbUser;
import com.java155.shop.service.TbUserService;
import com.java155.shop.support.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

@RestController
public class LoginController {

	@Autowired
	private TbUserService tbUserService;

	@PostMapping("/login.action")
	public Result ajaxLogin(TbUser tbUser,String checkd){
		TbUser user = tbUserService.findByidUser(tbUser);
		ContextHolder.saveUser(user);
		if("true".equals(checkd)){
			Cookie cookie=new Cookie(Contants.Cookie_LOGIN_USER, JSON.toJSONString(user));
			cookie.setMaxAge(60*60*24);
			ContextHolder.addCookie(cookie);
			ContextHolder.saveUser(user);
		}else {
			ContextHolder.removeCookie(Contants.Cookie_LOGIN_USER);
		}
		Result result=new Result();
		result.setStatus(200);
		result.setMsg("登录成功");
		result.setSuccess(true);
		result.setData(user);
		return result;

	}

	@GetMapping("/logout.action")
	public Result ajaxLogout(){//注销登录
		ContextHolder.removeUser();
		ContextHolder.removeCookie(Contants.Cookie_LOGIN_USER);
		return Result.success("您好，欢迎光临易易城！<a href=\"#\">[登录]</a> <a href=\"#\">[注册]</a>");
	}

	@GetMapping("/get_user_status.action")
	public Result getUserStatus(){//获取登录状态
		TbUser tbUser = ContextHolder.getUser();
		if(tbUser!=null){
			Result result=new Result();
			result.setData(tbUser);
			result.setStatus(200);
			result.setSuccess(true);
			return result;
		}
		return Result.fail(500, "未登录");
	}
}
