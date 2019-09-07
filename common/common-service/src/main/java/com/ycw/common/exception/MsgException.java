package com.ycw.common.exception;

public class MsgException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int code;

	public MsgException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}

	public MsgException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public MsgException(int code, String message) {
		super(message);
		this.code = code;
	}

	public MsgException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
