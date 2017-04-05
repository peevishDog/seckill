/**
 * 文件名:SeckillDaoTest.java
 * 包名:org.seckill.dao
 * 创建时间:2017年2月26日下午5:57:24
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类名:SeckillDaoTest <br/>
 * 〈功能简述〉. <br/>
 * 〈功能详细描述〉.<br/>
 * (这里描述这个方法的注意事项 – 可选).<br/>
 * 创建时间:     2017年2月26日 下午5:57:24 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
   ///配置spring 和 junit整合，junit启动时加载springIOC容器
	
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryById() {
		long id =1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}

	@Test
	public void testQueryAll() {
		fail("Not yet implemented");
	}

}

