package com.anhanguera.pw.resource.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	public Long timestamp;
	public int status;
	public Error error;
	public String message;
	public String path;
	
	public StandardError(long timestamp, int status, String message, String error) {
		super();
	}

	public StandardError(Long timestamp, int status, Error error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
