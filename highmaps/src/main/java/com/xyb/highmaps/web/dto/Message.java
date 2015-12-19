package com.xyb.highmaps.web.dto;

import com.xyb.highmaps.biz.utils.Constant;

public class Message {
	
	private String msg;
	private boolean success;
	
	public Message(boolean success){
		this.success = success;
		if(success) {
			this.msg = Constant.HANDLE_SUCCESS;
		}else {
			this.msg = Constant.HANDLE_FAIL;
		}
	}
	
	public Message(String msg, boolean success) {
		this.msg = msg;
		this.success = success;
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
	

}
