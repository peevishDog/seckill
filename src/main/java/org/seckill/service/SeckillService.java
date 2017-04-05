/**
 * 文件名:SeckillService.java
 * 包名:org.seckill.service
 * 创建时间:2017年2月27日上午11:32:40
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

/** 	
 * 业务接口：站在"使用者"角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型(return 类型/异常)
 */
public interface SeckillService {
	
	/**
	 * 〈功能简述〉. <br/>
	 * 查询所有秒杀记录
	 */
	List<Seckill> getSeckillList();
	/**
	 * 
	 * getById:查询单个秒杀记录. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId
	 * @return
	 * @since JDK 1.8
	 */
	Seckill getById(long seckillId);
	/**
	 * 
	 * exportSeckillUrl:秒杀开启是输出秒杀接口地址
	 *                  否则输出系统时间和秒杀时间. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId
	 * @since JDK 1.8
	 */
	Exposer exportSeckillUrl (long seckillId);
	/**
	 * 
	 * executeSeckill:执行秒杀操作. <br/>
	 * @author 鲁晓磊	  Email:luxiaolei@yijiehulian.com
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @throws SeckillException
	 * @throws RepeatKillException
	 * @throws SeckillCloseException
	 * @since JDK 1.8
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
	    throws SeckillException,RepeatKillException,SeckillCloseException;
}

