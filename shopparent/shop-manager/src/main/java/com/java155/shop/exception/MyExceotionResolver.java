package com.java155.shop.exception;

import com.alibaba.fastjson.JSON;
import com.java155.shop.common.Result;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class MyExceotionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(
					HttpServletRequest request,
					HttpServletResponse response,
					Object o, Exception e) {

		ModelAndView mv = new ModelAndView();
		String header = request.getHeader("X-Requested-With");
		if(header!=null&&header.equals("XMLHttpRequest")) {
			//ajax请求
			Result result = Result.fail(400, "未知异常");
			if(e instanceof LoginException){
				result.setMsg("登录失败，原因："+e.getMessage());
		}
			String r = JSON.toJSONString(result);
			mv.addObject("result", r);
			mv.setViewName("jsonView");
			return mv;
		}
		mv.setViewName("error");
		return mv;
	}
}
