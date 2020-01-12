package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 
 * @author Coa
 * Model za cuvanje veze korisnika sa subskripcijom koju zeli
 * 
 */
@Entity
@Table(indexes = {@Index(columnList = "userId", unique = false)})
public class UserSubsription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userId;
	private String serviceName;
	private int interval;
	private long LastTimeExecuted;

	public UserSubsription() {}

	public UserSubsription(String userId, String serviceName, int interval) {
		this.userId = userId;
		this.serviceName = serviceName;
		this.interval = interval;
		LastTimeExecuted = System.currentTimeMillis();
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

	public String getServiceName() {
		return serviceName;
	}

	public String getUserId() {
		return userId;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
