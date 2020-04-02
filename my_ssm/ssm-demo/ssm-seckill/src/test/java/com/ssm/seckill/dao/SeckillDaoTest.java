package com.ssm.seckill.dao;

import com.ssm.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        int rowCount = seckillDao.reduceNumber(1000l, new Date());
        assertEquals(1, rowCount);
    }

    @Test
    public void queryById() {
        Seckill seckill = seckillDao.queryById(1000l);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> seckillList = seckillDao.queryAll(0, 100);
        System.out.println(seckillList);
    }

    @Test
    public void executeSeckillProcedure() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("seckillId", 1000l);
        params.put("phone", 190876543765l);
        params.put("killTime", new Date());
        params.put("result", null);
        seckillDao.executeSeckillProcedure(params);
        assertEquals(1, params.get("result"));
    }
}