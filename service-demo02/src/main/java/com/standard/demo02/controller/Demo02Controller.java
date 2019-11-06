package com.standard.demo02.controller;


import com.standard.common.pojo.DataVo;
import com.standard.common.service.demo02.service.Demo02;
import com.standard.demo02.service.Demo02Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhangH
 * @date: 2019/10/6 12:43
 * @description:
 */
@Api
@RestController
@Slf4j
public class Demo02Controller implements Demo02 {

    @Autowired
    private Demo02Service demo02Service;


    @Autowired
    private RedissonClient redissonClient;


    @Override
    public DataVo getTestData(String id) {
        log.info("hello this is a log");
                return demo02Service.getTestData(id);
    }

    @Override
    public DataVo getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object myTest = request.getSession().getAttribute("myTest");
        return DataVo.ok().data(myTest);
    }

    @Override
    public DataVo setSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("myTest","哈哈  测试session共享");
        return DataVo.ok().message("已经设置session sessionId" + request.getSession().getId());
    }

    @Override
    public DataVo testLock() throws InterruptedException {
        RLock myLock = redissonClient.getFairLock("myLock");
        boolean lock = myLock.tryLock();
        String time = "";
        if (lock){
            try {
                Thread.sleep(10000);
                time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            }catch (Exception e){

            }
            myLock.unlock();
        }
        return DataVo.ok().data(time);
    }

}
