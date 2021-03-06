/**
 * 文件名:SeckillServiceImpl.java
 * 包名:org.seckill.service.impl
 * 创建时间:2017年2月27日下午2:16:28
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
 */

package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * 类名:SeckillServiceImpl <br/>
 * seckillService的实现. <br/>
 * 创建时间: 2017年2月27日 下午2:16:28 <br/>
 * 
 * @author 鲁晓磊 Email:luxiaolei@yijiehulian.com
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 * 
 */
@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
    //用于混淆md5
	private final String slat ="owfjioiwjf029jfwif823rjb4ygf2f";
	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0,4);
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() > endTime.getTime()
				|| nowTime.getTime() < startTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(),
					startTime.getTime(), endTime.getTime());
		}
		// 转化特殊字符串
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMD5(long seckillId){
		String base = seckillId + "/" +slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	@Override
	@Transactional
	/**
	 * 使用注解控制事物方法的优点：
	 * 1：开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2：保证事物方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求 或者剥离到事物方法外部
	 * 3：不是所有的方法都需要事物，如只有一条修改操作，只读操作不需要事物控制
	 * 
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone,
			String md5) throws SeckillException, RepeatKillException,
			SeckillCloseException {
		if(md5 == null || !md5.equals(getMD5(seckillId))){
			throw new SeckillException("seckill data rewrite");
		}
		//执行秒杀逻辑：减库存 + 记录购买行为
		Date nowTime = new Date();
		try{
			//减库存
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if(updateCount <= 0){
				//没有更新到记录，秒杀结束
				throw new SeckillCloseException("seckill is closed");
			}else{
				//记录购买行为
				Date createTime = new Date();
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone, createTime);
				//唯一：seckillId，userPhone
				if(insertCount <= 0){
					//重复秒杀
					throw new RepeatKillException("seckill repeated");
				}else{
					SuccessKilled successKilled =successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS, successKilled);
				}
			}
		}catch(SeckillCloseException e1){
			throw e1;
		}catch(RepeatKillException e2){
			throw e2;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			//所有编译异常转换为运行期异常
			throw new SeckillException("seckill inner error:"+e.getMessage());
		}

	}

}
