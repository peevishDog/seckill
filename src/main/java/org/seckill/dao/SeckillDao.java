/**
 * 文件名:SeckillDao.java
 * 包名:org.seckill.dao
 * 创建时间:2017年2月26日下午3:04:31
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.seckill.entity.Seckill;

/**
 * 类名:SeckillDao <br/>
 * 〈功能简述〉. <br/>
 * 〈功能详细描述〉.<br/>
 * (这里描述这个方法的注意事项 – 可选).<br/>
 * 创建时间:     2017年2月26日 下午3:04:31 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
public interface SeckillDao {
	/**
	 * 
	 * reduceNumber:减库存. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId 
	 * @param killTime
	 * @return   如果影响行数>1，表示更新的记录行数
	 * @since JDK 1.8
	 */
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);

	/**
	 * 
	 * queryById:根据id查询秒杀对象. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId
	 * @return
	 * @since JDK 1.8
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 
	 * queryAll:根据偏移量查询秒杀商品列表. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param offet
	 * @param limit
	 * @return
	 * @since JDK 1.8
	 */
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);
}

