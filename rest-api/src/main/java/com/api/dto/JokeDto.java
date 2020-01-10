package com.api.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Coa
 * Klasa za rukovanje sa sala objektima
 *
 */

public class JokeDto{
	 private ArrayList < Object > categories = new ArrayList < Object > ();
	 private String created_at;
	 private String icon_url;
	 private String id;
	 private String updated_at;
	 private String url;
	 private String value;
	 
	 private int interval;
	 private long LastTimeExecuted;
	 
	 public JokeDto() {}

	public JokeDto(ArrayList<Object> categories, String created_at, String icon_url, String id, String updated_at,
			String url, String value, int interval, int lastTimeExecuted) {
		super();
		this.categories = categories;
		this.created_at = created_at;
		this.icon_url = icon_url;
		this.id = id;
		this.updated_at = updated_at;
		this.url = url;
		this.value = value;
		this.interval = interval;
		LastTimeExecuted = lastTimeExecuted;
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



	public String getCreated_at() {
	  return created_at;
	 }

	 public String getIcon_url() {
	  return icon_url;
	 }

	 public String getId() {
	  return id;
	 }

	 public String getUpdated_at() {
	  return updated_at;
	 }

	 public String getUrl() {
	  return url;
	 }

	 public String getValue() {
	  return value;
	 }

	 public void setCreated_at(String created_at) {
	  this.created_at = created_at;
	 }

	 public void setIcon_url(String icon_url) {
	  this.icon_url = icon_url;
	 }

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setUpdated_at(String updated_at) {
	  this.updated_at = updated_at;
	 }

	 public void setUrl(String url) {
	  this.url = url;
	 }

	 public void setValue(String value) {
	  this.value = value;
	 }
	 
	 @Override
	    public String toString() {
	        return value;
	    }
}

