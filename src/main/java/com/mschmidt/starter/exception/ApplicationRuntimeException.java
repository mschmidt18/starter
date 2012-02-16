package com.mschmidt.starter.exception;

/**
 * 
 * @author mschmidt18@gmail.com
 *
 */
public class ApplicationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4482190625887833590L;

	public ApplicationRuntimeException() {
		// TODO Auto-generated constructor stub
	}

	public ApplicationRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ApplicationRuntimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ApplicationRuntimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
