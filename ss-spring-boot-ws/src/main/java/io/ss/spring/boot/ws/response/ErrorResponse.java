package io.ss.spring.boot.ws.response;

import java.util.Date;

public class ErrorResponse {

	private Date timestamp;
	
	private String message;
	
	private String localizedMessage;
	
	private String errorCode;

	public ErrorResponse(Date timestamp, String message, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorCode = errorCode;
	}

	public ErrorResponse(Date timestamp, String message, String localizedMessage, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.localizedMessage = localizedMessage;
		this.errorCode = errorCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
