package com.api.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

public class UserSubscriptionDto {

	private Long id;
	@NotNull
	private String userId;
	@NotNull
	private String serviceName;
	private int interval;
	private long LastTimeExecuted;
	
	public UserSubscriptionDto() {
		
	}
	
	public UserSubscriptionDto(Long id, String userId, String serviceName, int interval, long lastTimeExecuted) {
		super();
		this.id = id;
		this.userId = userId;
		this.serviceName = serviceName;
		this.interval = interval;
		LastTimeExecuted = lastTimeExecuted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public long getLastTimeExecuted() {
		return LastTimeExecuted;
	}

	public void setLastTimeExecuted(long lastTimeExecuted) {
		LastTimeExecuted = lastTimeExecuted;
	}
	
	
	
}
