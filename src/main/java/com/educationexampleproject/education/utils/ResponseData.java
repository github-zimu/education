package com.educationexampleproject.education.utils;

/**
 *	
 * @author huanggw
 * 所有接口返回结果集
 */
public class ResponseData {
	
	
	public ResponseData(String code, String maessage, Object data) {
		super();
		this.code = code;
		this.maessage = maessage;
		this.data = data;
	}

	

	public ResponseData() {
		super();
	}

	/***
	 *  code默认200
	 * @param maessage 消息提示类
	 * @param data   目的返回类型
	 */
	public ResponseData(String maessage, Object data) {
		super();
		this.code = "200";
		this.maessage = maessage;
		this.data = data;
	}





	/***
	 * 状态代码 200表示成功 否则失败
	 */
	private String code;
	
	/**
	 * 消息提示
	 */
	private String maessage;
	
	
	/**
	 * 返回目的结果集
	 */
	private Object data;


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMaessage() {
		return maessage;
	}


	public void setMaessage(String maessage) {
		this.maessage = maessage;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	

	
}
