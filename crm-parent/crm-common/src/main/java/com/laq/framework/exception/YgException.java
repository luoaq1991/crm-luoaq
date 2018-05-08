package com.laq.framework.exception;

/**
 * 自定义异常
 * @author Mr.YongGan.Zhang
 *
 */
public class YgException  extends RuntimeException{

	private static final long serialVersionUID = 3745055806049814928L;

	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public YgException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public YgException() {
		super();
	}
	
}
