package com.wmeimob.yzfs.exception;

public class CustomException  extends Exception{

	/**
	 * 自定义异常
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;//异常编码
	
	private String msg;//异常提示信息
	
    public CustomException(){
    	super();
    }
    
    public CustomException(String msg){
    	super(msg);
    }
    
    public CustomException(int code,String msg) throws CustomException{
    	this.code=code;
    	this.msg=msg;
    	throw new CustomException();
    	
    }
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
