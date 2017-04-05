/**
 * 文件名:SuccessKilledDaoTest.java
 * 包名:org.seckill.dao
 * 创建时间:2017年2月27日上午9:58:07
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.dao;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类名:SuccessKilledDaoTest <br/>
 * 〈功能简述〉. <br/>
 * 〈功能详细描述〉.<br/>
 * (这里描述这个方法的注意事项 – 可选).<br/>
 * 创建时间:     2017年2月27日 上午9:58:07 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;
	@Test
	public void testInsertSuccessKilled() {
		long id = 1001L;
		long phone = 13522228888L;
		Date createTime = new Date();
		int insertCount = successKilledDao.insertSuccessKilled(id, phone,createTime);
		System.out.println("insertCount="+insertCount);
	}
	/**
	 */
	@Test
	public void testQueryByIdWithSeckill() {
		long id = 1001L;
		long phone = 13522228888L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
	}

}

