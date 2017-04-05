/**
 * 文件名:SuccessKilledDao.java
 * 包名:org.seckill.dao
 * 创建时间:2017年2月26日下午3:10:19
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * 类名:SuccessKilledDao <br/>
 * 〈功能简述〉. <br/>
 * 〈功能详细描述〉.<br/>
 * (这里描述这个方法的注意事项 – 可选).<br/>
 * 创建时间:     2017年2月26日 下午3:10:19 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public interface SuccessKilledDao {

	/**
	 * 
	 * insertSuccessKilled:插入购买明细，可过滤重复. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId
	 * @param userPhone
	 * @return 插入的行数
	 * @since JDK 1.8
	 */
	int insertSuccessKilled(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone,@Param("createTime")Date createTime);
	/**
	 * 
	 * queryByIdWithSeckill:根据id查询SuccessKilled并携带秒杀产品对象实体. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId
	 * @return
	 * @since JDK 1.8
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone);
}

