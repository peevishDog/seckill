/**
 * 文件名:SeckillCloseException.java
 * 包名:org.seckill.exception
 * 创建时间:2017年2月27日下午2:04:44
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.exception;
/**
 * 类名:SeckillCloseException <br/>
 * 秒杀关闭异常. <br/>
 * 创建时间:     2017年2月27日 下午2:04:44 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public class SeckillCloseException extends SeckillException{

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillCloseException(String message) {
		super(message);
	}

	
}

