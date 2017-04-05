/**
 * 文件名:SeckillException.java
 * 包名:org.seckill.exception
 * 创建时间:2017年2月27日下午2:07:16
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.exception;
/**
 * 类名:SeckillException <br/>
 * 秒杀相关业务异常. <br/>
 * 创建时间:     2017年2月27日 下午2:07:16 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public class SeckillException extends RuntimeException{

	public SeckillException(String message, Throwable cause) {		
		super(message, cause);
	}

	public SeckillException(String message) {		
		super(message);
	}


}

