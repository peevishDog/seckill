/**
 * 文件名:SuccessLKilled.java
 * 包名:org.seckill.entity
 * 创建时间:2017年2月26日下午2:58:03
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.entity;

import java.util.Date;

/**
 * 类名:SuccessLKilled <br/>
 * 〈功能简述〉. <br/>
 * 〈功能详细描述〉.<br/>
 * (这里描述这个方法的注意事项 – 可选).<br/>
 * 创建时间:     2017年2月26日 下午2:58:03 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public class SuccessKilled {

	private long seckillId;
	
	private long userPhone;
	
	private short state;
	
	private Date createTime;

	public long getSeckillId() {
		return seckillId;
	}

	//变通
	//多对一
	private Seckill seckill;
	
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone="
				+ userPhone + ", state=" + state + ", createTime=" + createTime
				+ "]";
	}
	
}

