package com.standard.demo01.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.standard.common.pojo.DataVo;
import com.standard.common.pojo.PageData;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import com.standard.common.service.demo01.service.Demo01;

import com.standard.demo01.service.Demo01Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhangH
 * @date: 2019/10/6 12:43
 * @description:
 */
@Api
@RestController
@Slf4j
public class Demo01Controller implements Demo01 {

    @Autowired
    private Demo01Service demo01Service;


    @Override
    public DataVo<PageData<TableOneEntity>> getData(String num) {
        log.info("getData getData getData getData");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object myTest = request.getSession().getId();
        log.info("sessionId {}", myTest.toString());
        IPage<TableOneEntity> data = demo01Service.getData();
        return DataVo.ok().data(new PageData<TableOneEntity>(data));
    }

    @Override
    public DataVo getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object myTest = request.getSession().getAttribute("myTest");
        return DataVo.ok().data(myTest);
    }

}
