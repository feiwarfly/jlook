package com.zlcd.api;



public class BaseResponse {

    public BaseResponse(){
        this.error=0;
        this.message="";
        this.timestamp=System.currentTimeMillis();
    }

    public BaseResponse(String message){
        this.error=1;
        this.message=message;
        this.timestamp=System.currentTimeMillis();
    }

    public BaseResponse(int error,String message){
        this.error=error;
        this.message=message;
        this.timestamp=System.currentTimeMillis();
    }
    public BaseResponse(int error,String message,String exception){
        this.error=error;
        this.message=message;
        this.exception = exception;
        this.timestamp=System.currentTimeMillis();
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    //返回状态：0正确，1错误
    private int error;
    private String message;
    private Long timestamp;
    //错误编码：方便排查问题所在
    private String code;
    //异常
    private String exception;

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
    

}