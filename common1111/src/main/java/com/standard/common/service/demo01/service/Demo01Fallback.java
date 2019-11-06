package com.standard.common.service.demo01.service;

import com.standard.common.pojo.DataVo;
import com.standard.common.pojo.PageData;
import com.standard.common.util.FallBack;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import org.springframework.stereotype.Component;

/**
 * @author: zhangH
 * @date: 2019/10/20 01:56
 * @description:
 */
@Component
public class Demo01Fallback extends FallBack implements Demo01 {

    @Override
    public DataVo<PageData<TableOneEntity>> getData(String num) {
        return defaultFallBack();
    }
}
