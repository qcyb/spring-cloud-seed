package com.ycw.common.exception;

import java.io.IOException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycw.common.response.ResponseVO;

import lombok.extern.slf4j.Slf4j;

/**
 * @类名称 GlobalExceptionHandler.java
 * @类描述 全局异常处理
 * @作者 yuminjun yuminjun@lexiangbao.com
 * @创建时间 2019年8月29日 下午5:55:32
 * @版本 1.00
 *
 * @修改记录
 *
 *       <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.00 	yuminjun 	2019年8月29日
 *     ----------------------------------------------
 *       </pre>
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(MsgException.class)
	public ResponseVO<Object> msgExceptionHandler(MsgException ex) {
		return responseFormat(ex.getCode(), ex);
	}

	// 运行时异常
	@ExceptionHandler(RuntimeException.class)
	public ResponseVO<Object> runtimeExceptionHandler(RuntimeException ex) {
		return responseFormat(99999, ex);
	}

	// 空指针异常
	@ExceptionHandler(NullPointerException.class)
	public ResponseVO<Object> nullPointerExceptionHandler(NullPointerException ex) {
		return responseFormat(99999, ex);
	}

	// 类型转换异常
	@ExceptionHandler(ClassCastException.class)
	public ResponseVO<Object> classCastExceptionHandler(ClassCastException ex) {
		return responseFormat(99999, ex);
	}

	// IO异常
	@ExceptionHandler(IOException.class)
	public ResponseVO<Object> iOExceptionHandler(IOException ex) {
		return responseFormat(99999, ex);
	}

	// 未知方法异常
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseVO<Object> noSuchMethodExceptionHandler(NoSuchMethodException ex) {
		return responseFormat(99999, ex);
	}

	// 数组越界异常
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseVO<Object> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
		return responseFormat(99999, ex);
	}

	// 400错误
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public ResponseVO<Object> requestNotReadable(HttpMessageNotReadableException ex) {
		return responseFormat(99999, ex);
	}

	// 400错误
	@ExceptionHandler({ TypeMismatchException.class })
	public ResponseVO<Object> requestTypeMismatch(TypeMismatchException ex) {
		return responseFormat(99999, ex);
	}

	// 400错误
	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseVO<Object> requestMissingServletRequest(MissingServletRequestParameterException ex) {
		return responseFormat(99999, ex);
	}

	// 405错误
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseVO<Object> request405(HttpRequestMethodNotSupportedException ex) {
		return responseFormat(99999, ex);
	}

	// 406错误
	@ExceptionHandler({ HttpMediaTypeNotAcceptableException.class })
	public ResponseVO<Object> request406(HttpMediaTypeNotAcceptableException ex) {
		return responseFormat(99999, ex);
	}

	// 500错误
	@ExceptionHandler({ ConversionNotSupportedException.class, HttpMessageNotWritableException.class })
	public ResponseVO<Object> server500(RuntimeException ex) {
		return responseFormat(99999, ex);
	}

	// 栈溢出
	@ExceptionHandler({ StackOverflowError.class })
	public ResponseVO<Object> requestStackOverflow(StackOverflowError ex) {
		return responseFormat(99999, ex);
	}

	// 除数不能为0
	@ExceptionHandler({ ArithmeticException.class })
	public ResponseVO<Object> arithmeticException(ArithmeticException ex) {
		return responseFormat(99999, ex);
	}

	// 其他异常
	@ExceptionHandler({ Exception.class })
	public ResponseVO<Object> exception(Exception ex) {
		return responseFormat(99999, ex);
	}

	private <T extends Throwable> ResponseVO<Object> responseFormat(Integer code, T ex) {
		String message = ex.getMessage() == null || "".equals(ex.getMessage()) ? "系统异常，请联系管理员" : ex.getMessage();
		log.error(message, ex);
		return ResponseVO.fail(code,message);
	}

}
