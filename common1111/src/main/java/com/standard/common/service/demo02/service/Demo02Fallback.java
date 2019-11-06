package com.standard.common.service.demo02.service;

import com.standard.common.pojo.DataVo;
import com.standard.common.pojo.PageData;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import com.standard.common.service.demo01.service.Demo01;
import com.standard.common.util.FallBack;

/**
 * @author: zhangH
 * @date: 2019/10/20 16:19
 * @description:
 */
public class Demo02Fallback extends FallBack implements Demo02 {


    @Override
    public DataVo getTestData(String id) {
        return defaultFallBack();
    }

    @Override
    public DataVo getTestDataDemo() {
        return defaultFallBack();
    }
}
