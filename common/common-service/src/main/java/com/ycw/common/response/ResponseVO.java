package com.ycw.common.response;

import java.io.Serializable;

public class ResponseVO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS = 10000;
	private int code;
	private String message;
	private T data;
	private long timestamp = System.currentTimeMillis();
	private String traceId;

	public static <D> ResponseVO<D> success(D data) {
		return success((String) null, data);
	}

	public static <D> ResponseVO<D> success(String message, D data) {
		ResponseVO<D> ResponseVO = new ResponseVO();
		ResponseVO.setCode(10000);
		ResponseVO.setMessage(message);
		ResponseVO.setData(data);
//		ResponseVO.setTraceId(getTransferTrace());
		return ResponseVO;
	}

	public static <D> ResponseVO<D> fail(int code, String message) {
		ResponseVO<D> ResponseVO = new ResponseVO();
		ResponseVO.setCode(code);
		ResponseVO.setMessage(message);
//		ResponseVO.setTraceId(getTransferTrace());
		return ResponseVO;
	}

//	public static String getTransferTrace() {
//		Tracer tracer = (Tracer) SpringContextUtils.getBean(Tracer.class);
//		if (tracer == null) {
//			return null;
//		} else {
//			return tracer.currentSpan() != null && tracer.currentSpan().context() != null
//					? tracer.currentSpan().context().traceIdString()
//					: null;
//		}
//	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSuccess() {
		return this.code == 10000;
	}

	public String getTraceId() {
		return this.traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
}
