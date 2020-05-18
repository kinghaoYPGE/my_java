package com.kinghao.mango.core.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页数量
     */
    private int pageSize = 10;
    /**
     * 查询参数
     */
    private Map<String, Object> parmas = new HashMap<>();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParmas() {
        return parmas;
    }

    public void setParmas(Map<String, Object> parmas) {
        this.parmas = parmas;
    }

}
