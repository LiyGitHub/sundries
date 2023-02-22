package com.practice.bootintegrate.common;

/**
 *
 * @author chaixg
 *
 */
public class JsonResult<T> {

	private Integer code = 0;
	private String message = "success";
	private String errorCode;
	private T data;
	private boolean success;


	/**
	 * 只为序列化，不能使用
	 */
	public JsonResult() {
		super();
	}

	/**
	 * 构造不对外
	 *
	 * @param code
	 * @param message
	 * @param data
	 * @param throwable
	 */
	private JsonResult(Integer code, String errorCode, String message, T data, boolean success, Throwable throwable) {
		super();
		this.code = code;
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
		this.success =success;
		//供应商有部分接口吃异常没记录日志，暂时放在返回结果里
		if (this.message == null && throwable != null) {
			this.message = new StringBuilder(throwable.toString()).append("; ").append(throwable.getStackTrace()).toString();
		}
	}

	public JsonResult(String message) {
		super();
		this.message = message;
	}


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 自定义成功信息
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午6:00:11
	 */
	public static <T> JsonResult<T> success(String message, T data) {
		return new JsonResult<T>(0,null, message, data, true,null);
	}

	/**
	 *
	 * @描述： 默认success成功信息
	 * @param
	 * @author liugj
	 * @time ：2017年8月2日 下午6:01:00
	 */
	public static <T> JsonResult<T> success(T result) {
		return new JsonResult<T>(0,null, "success", result, true,null);
	}

	/**
	 * 默认的成功信息，data为空
	 *
	 * @描述：
	 * @param
	 * @author liugj
	 * @time ：2017年8月2日 下午6:01:50
	 */
	public static <T> JsonResult<T> success() {
		return new JsonResult<T>(0,null, "success", null,true, null);
	}

	/**
	 * 无异常信息的时候使用
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午5:42:14
	 */
//	public static <T> JsonResult<T> error(ExceptionResolvable exceptionCode) {
//		return new JsonResult<T>(exceptionCode.getCode(),exceptionCode.getErrorCode(),
//				exceptionCode.getMessage(), null, false,null);
//	}

	/**
	 * 500
	 */
   private static final Integer EXCEPTION_CODE_500=500;
   /**
    * 400
    */
   private static final Integer EXCEPTION_CODE_400=400;
   /**
    * 500 Default message
    */
   private static final String EXCEPTION_MESSAGE_500="Server Internal Error";
   /**
    * 400 Default message
    */
   private static final String EXCEPTION_MESSAGE_400="Bad request";
	/**
	 * 无异常信息的时候使用
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午5:42:14
	 */
   public static <T>JsonResult<T> error(Integer code,String message){
      if(code==null)
         code=EXCEPTION_CODE_500;
      if(message==null)
         message=EXCEPTION_CODE_400.equals(code)?EXCEPTION_MESSAGE_400:EXCEPTION_MESSAGE_500;
      return new JsonResult<T>(code,null,message,null,false,null);
   }

	public static <T>JsonResult<T> error(Integer code,String message,T data){
		if(code==null)
			code=EXCEPTION_CODE_500;
		if(message==null)
			message=EXCEPTION_CODE_400.equals(code)?EXCEPTION_MESSAGE_400:EXCEPTION_MESSAGE_500;
		return new JsonResult<T>(code,null,message,data,false,null);
	}
   /**
    * 默认错误时使用
    *
    * @描述：
    * @param
    * @time ：2017年8月2日 下午5:42:14
    */
   public static <T>JsonResult<T> error(){
      return error(EXCEPTION_CODE_500,null);
   }
   /**
    * 仅指定code时使用
    *
    * @描述：
    * @param
    * @time ：2017年8月2日 下午5:42:14
    */
   public static <T>JsonResult<T> error(Integer code){
      return error(code,null);
   }
   /**
    * 仅指定message时使用
    *
    * @描述：
    * @param
    * @time ：2017年8月2日 下午5:42:14
    */
   public static <T>JsonResult<T> error(String message){
      return error(null,message);
   }
	/**
	 * 有异常信息的时候使用
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午5:42:24
	 */
//	public static <T> JsonResult<T> error(ExceptionResolvable exceptionCode,
//			Throwable ex) {
//		return new JsonResult<T>(exceptionCode.getCode(),exceptionCode.getErrorCode(),
//				exceptionCode.getMessage(), null,false, ex);
//	}

	/**
	 * 有异常信息的时候
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午6:02:27
	 */
	public static  JsonResult<Void> error(Integer code, String message,
			Throwable ex) {
		return new JsonResult<Void>(code,null, message, null,false, ex);
	}

	public static  JsonResult<Void> error(Integer code, String errorCode, String message,
			Throwable ex) {
		return new JsonResult<Void>(code,errorCode, message, null,false, ex);
	}

	/**
	 * 只有异常信息的错误
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午6:25:39
	 */
	public static <T> JsonResult<T> error(Exception ex) {
		return new JsonResult<T>(500,null, ex.getMessage(), null,false, ex);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

//	public Throwable getThrowable() {
//		return throwable;
//	}
//
//	public void setThrowable(Throwable throwable) {
//		this.throwable = throwable;
//	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
