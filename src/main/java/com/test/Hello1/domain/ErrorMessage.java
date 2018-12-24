package com.test.Hello1.domain;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder(alphabetic = true)
public class ErrorMessage {
	
	private int Code;
	private String Message;

	public ErrorMessage() {
	}

	public ErrorMessage(int Code, String msg) {
		this.Code = Code;
		this.Message = msg;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String msg) {
		this.Message = msg;
	}

}
