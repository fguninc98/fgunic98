package com.api.dto;

public class JokeMail {
	
	private String value;
	private String userMail;
	
	public JokeMail() {}
	
	public JokeMail(String value, String userMail) {
		this.value = value;
		this.userMail = userMail;
	}
	
	public String getUserMail() {
		return userMail;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
