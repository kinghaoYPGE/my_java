package com.ssm.seckill.service.impl;

import com.ssm.seckill.dto.Exposer;
import com.ssm.seckill.dto.SeckillExecution;
import com.ssm.seckill.entity.Seckill;
import com.ssm.seckill.exception.SeckillException;
import com.ssm.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info(seckillList.toString());
    }

    @Test
    public void getById() {
        Seckill seckill = seckillService.getById(1000l);
        logger.info(seckill.toString());
    }

    @Test
    public void executeSeckill() {
        Exposer exposer = seckillService.exportSeckillUrl(1000l);
        logger.info(exposer.toString());
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(1000l, 13890876542L, exposer.getMd5());
        } catch (SeckillException e) {
            logger.warn(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void executeSeckillProcedure() {
        Exposer exposer = seckillService.exportSeckillUrl(1000l);
        logger.info(exposer.toString());
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(1000l, 13890876543L, exposer.getMd5());
        } catch (SeckillException e) {
            logger.warn(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}