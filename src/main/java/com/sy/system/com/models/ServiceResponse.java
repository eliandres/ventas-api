package com.sy.system.com.models;

import lombok.Data;

@Data
public class ServiceResponse {

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	Boolean success;
	String message;
}
