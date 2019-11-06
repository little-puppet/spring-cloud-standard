package com.standard.demo02.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.standard.common.pojo.DataVo;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import com.standard.common.service.demo01.service.Demo01;
import com.standard.common.service.demo02.service.Demo02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhangH
 * @date: 2019/10/6 16:17
 * @description:
 */
@Service
public class Demo02Service {


    @Autowired
    private Demo01 demo01;

    public DataVo getTestData(String num){
        return demo01.getData(num);
    }

    public DataVo getTestDataDemo() {
        return demo01.getData("1");
    }



}
