/**
 * 文件名:SeckillServiceTest.java
 * 包名:org.seckill.service
 * 创建时间:2017年2月27日下午4:47:24
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 类名:SeckillServiceTest <br/>
 * 〈功能简述〉. <br/>
 * 〈功能详细描述〉.<br/>
 * (这里描述这个方法的注意事项 – 可选).<br/>
 * 创建时间:     2017年2月27日 下午4:47:24 <br/>
 * @author  鲁晓磊	  Email:luxiaolei@yijiehulian.com
 * @version  1.0.0
 * @since    JDK 1.8
 * @see 	
 *  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	       "classpath:spring/spring-dao.xml",
	       "classpath:spring/spring-service.xml"
      		})
public class SeckillServiceTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() {
	List<Seckill> list = seckillService.getSeckillList();
	logger.info("list={}",list);
	}

	@Test
	public void testGetById() {
		long id = 1000L;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		long id = 1000L;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}",exposer);
	}

	@Test
	public void testExecuteSeckill() {
		long id = 1000L;
		long phone = 135888811L;
		String md5 = "ed5723fb6d3bcd8fc56e709128cf7ad4";
		try{
			SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
			logger.info("seckillExecution={}",seckillExecution);
		}catch(SeckillCloseException e1){
			logger.error(e1.getMessage());
		}catch (RepeatKillException e2) {
			logger.error(e2.getMessage());
		}
	}

}

