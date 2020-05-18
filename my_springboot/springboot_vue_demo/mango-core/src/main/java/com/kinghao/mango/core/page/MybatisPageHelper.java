package com.kinghao.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 分页查询助手
 */
public class MybatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询
     * @param pageRequest
     * @param mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, findPage);
    }

    public static PageResult findPage(PageRequest pageRequest, Object mapper,
                                      String queryName, Object...args) {

        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        Object result = ReflectionUtils.invokeMethod((Method) mapper, queryName, args);

        return getPageResult(pageRequest, new PageInfo((List)result));
    }

    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getSize());
        return null;

    }

}
