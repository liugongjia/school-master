package com.example.school.util;


import com.example.school.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author zhundian
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> implements Serializable {

	private static final long serialVersionUID = 5480271731510502002L;

	@ApiModelProperty(value = "返回标记：成功标记=0，失败标记=1")
	private int code;

	@ApiModelProperty(value = "业务应用异常码")
	private String bizCode;

	@ApiModelProperty(value = "返回信息")
	private String msg;

	@ApiModelProperty(value = "数据")
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, CommonConstant.SUCCESS, null, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, CommonConstant.SUCCESS, null, null);
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, CommonConstant.SUCCESS, null, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, CommonConstant.FAIL, null, null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, CommonConstant.FAIL, null, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, CommonConstant.FAIL, null, null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, CommonConstant.FAIL, null, msg);
	}

	public static <T> R<T> failed(String bizCode, String msg) {
		return restResult(null, CommonConstant.FAIL, bizCode, msg);
	}

	public static <T> R<T> failed(T data, String bizCode, String msg) {
		return restResult(data, CommonConstant.FAIL, bizCode, msg);
	}

	private static <T> R<T> restResult(T data, int code, String bizCode, String msg) {
		return new R<T>()
				.setData(data)
				.setCode(code)
				.setBizCode(bizCode)
				.setMsg(msg);
	}

}
