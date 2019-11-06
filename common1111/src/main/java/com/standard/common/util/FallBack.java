package com.standard.common.util;

import com.standard.common.pojo.DataVo;

/**
 * @author: zhangH
 * @date: 2019/10/16 11:20
 * @description:
 */
public class FallBack {

    protected DataVo defaultFallBack() {
        return DataVo.error(100);
    }
}
