/**
 * 文件名:SeckillResult.java
 * 包名:org.seckill.dto
 * 创建时间:2017年2月28日下午1:58:57
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.dto;
/**
 * 类名:SeckillResult <br/>
 * 所有ajax请求返回类型，封装json结果
 * 创建时间:     2017年2月28日 下午1:58:57 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public class SeckillResult<T> {

	private boolean success;
	
	private T data;
	
	private String error;

	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}

