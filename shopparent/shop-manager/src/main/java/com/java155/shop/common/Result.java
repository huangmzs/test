package com.java155.shop.common;

import org.springframework.stereotype.Component;

import java.io.Serializable;

public class Result<T> implements Serializable {

	//状态
	 int status;
	//消息
	 String msg;
	//是否成功
	 boolean success;
	// 数据
	 T data;

public static Result success(String msg){
	Result result=new Result();
	result.setStatus(200);
	result.setMsg(msg);
	result.setData(msg);
	result.setSuccess(true);
	return result;
}

	public static Result fail(int status,String msg){
		Result result=new Result();
		result.setStatus(status);
		result.setMsg(msg);
		result.setSuccess(false);
		return result;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
