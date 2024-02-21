package com.app.dto;

import java.time.LocalDateTime;

public class ApiResponce {
	private String msg;
	LocalDateTime date;
	
	public ApiResponce(String msg) {
		super();
		this.msg = msg;
		this.date = LocalDateTime.now();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

}
