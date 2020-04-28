package io.ss.spring.boot.ws.exception;

public class UserServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6673352052204699844L;

	public static final String USER_NOT_FOUND = "U404";
	
	
     private String code;

     

	public UserServiceException(String message, String code) {
		super(message);
		this.code = code;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
     
     
}
