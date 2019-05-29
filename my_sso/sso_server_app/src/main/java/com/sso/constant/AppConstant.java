package com.sso.constant;

public class AppConstant {
    // redis存储ticket的key的前缀
    public static final String REDIS_TICKET_PREFIX = "TICKET:";
    // redis存活时间为1分钟
    public static final int REDIS_TICKET_ACTIVE_SECONDS = 60;
    // 是否重新产生ticket
    public static final boolean ENABLE_DISPOSALBLE_TICKET = false;
}
