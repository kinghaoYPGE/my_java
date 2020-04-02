package com.ssm.seckill.web;

import com.ssm.seckill.dto.Exposer;
import com.ssm.seckill.dto.SeckillExecution;
import com.ssm.seckill.dto.SeckillResult;
import com.ssm.seckill.entity.Seckill;
import com.ssm.seckill.enums.SeckillStateEnum;
import com.ssm.seckill.exception.*;
import com.ssm.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seckill") // 模块seckill
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    /**
     * 秒杀列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> seckillList = seckillService.getSeckillList();
        model.addAttribute("list", seckillList);
        return "list";
    }

    /**
     * 秒杀详情页
     * @param seckillId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (null == seckillId) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (null == seckill) {
            return "forword:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    /**
     * 生成秒杀地址
     * @param seckillId
     * @return
     */
    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody  // 返回json
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    /**
     * 执行秒杀
     * @param seckillId
     * @param md5
     * @param phone
     * @return
     */
    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "killPhone", required = false) Long phone) {
        if (null == phone) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, seckillExecution);
        } catch (SeckillUnexistedException e) {
            logger.error(e.getMessage(), e);
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.UNEXIST);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        } catch (SeckillUnstartedException e) {
            logger.error(e.getMessage(), e);
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.UNSTARTED);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        } catch (SeckillClosedException e) {
            logger.error(e.getMessage(), e);
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.END);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        } catch (RepeatkillException e) {
            logger.error(e.getMessage(), e);
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.REPEATED);
            return new SeckillResult<SeckillExecution>(false, seckillExecution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new SeckillResult<SeckillExecution>(false, e.getMessage());
        }
    }

    /**
     * 得到系统时间
     * @return
     */
    @RequestMapping(value = "/now", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SeckillResult<Long> getNow() {
        return new SeckillResult<Long>(true, new Date().getTime());
    }

}
