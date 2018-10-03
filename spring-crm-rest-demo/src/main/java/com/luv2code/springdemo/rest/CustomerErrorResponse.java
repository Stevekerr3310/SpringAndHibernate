package com.luv2code.springdemo.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomerErrorResponse {
	
	private int status;
	private String message;
	private String timeStamp;
	
	public CustomerErrorResponse() {
		
	}

	public CustomerErrorResponse(int status, String message, String timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
