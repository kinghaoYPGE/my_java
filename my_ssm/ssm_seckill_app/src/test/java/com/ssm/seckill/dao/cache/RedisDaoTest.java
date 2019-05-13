package com.ssm.seckill.dao.cache;

import com.ssm.seckill.dao.SeckillDao;
import com.ssm.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void getSeckill() {
        Seckill seckill = redisDao.getSeckill(1000l);
        logger.info(seckill.toString());
    }

    @Test
    public void putSeckill() {
        Seckill seckill = seckillDao.queryById(1000l);
        String result = redisDao.putSeckill(seckill);
        logger.info(result);
    }
}