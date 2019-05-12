CREATE DATABASE ssm_seckill_db;
USE ssm_seckill_db;
CREATE TABLE seckill (
  `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` INT NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '记录创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  key idx_create_time(create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存表';

INSERT INTO seckill(name, number, start_time, end_time)
VALUES
  ('6000元秒杀iphoneX', 20, '2019-05-09 00:00:00', '2019-05-10 00:00:00'),
  ('10000元秒杀Macbook Pro', 5, '2019-05-09 00:00:00', '2019-05-10 00:00:00'),
  ('2000元秒杀小米6', 100, '2019-05-09 00:00:00', '2019-05-10 00:00:00'),
  ('5000元秒杀华为P20', 100, '2019-05-09 00:00:00', '2019-05-10 00:00:00');

CREATE table success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品id',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号码',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '秒杀状态：-1：无效 0：成功 1：已付款',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀成功明细表';
