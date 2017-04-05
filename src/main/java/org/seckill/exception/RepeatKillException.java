/**
 * 文件名:RepeatKillException.java
 * 包名:org.seckill.exception
 * 创建时间:2017年2月27日下午2:00:23
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.exception;
/**
 * 类名:RepeatKillException <br/>
 * 重复秒杀异常(运行期异常) <br/>
 * 创建时间:     2017年2月27日 下午2:00:23 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public class RepeatKillException extends SeckillException{

	public RepeatKillException(String message){
		super(message);
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}

