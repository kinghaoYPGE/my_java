package com.ssm.seckill.dao;

import com.ssm.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
     * 减少库存
     * @param seckKillId: 秒杀商品id
     * @param killTime: 秒杀商品时间
     * @return 影响的商品数量
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询库存信息
     * @param seckillId: 秒杀商品id
     * @return 秒杀商品库存信息
     */
    Seckill queryById(long seckillId);

    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 调用存储过程
     * @param params
     */
    void executeSeckillProcedure(Map<String, Object> paramMap);

}
