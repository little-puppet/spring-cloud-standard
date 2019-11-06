package com.standard.common.service.demo01.service;

import com.standard.common.pojo.DataVo;
import com.standard.common.pojo.PageData;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author: zhangH
 * @date: 2019/10/6 12:26
 * @description:
 */
@FeignClient(value = "SERVICE-DEMO01", fallback = Demo01Fallback.class)
public interface Demo01 {

    @ApiOperation(value = "获取测试数据")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "缓存id", dataType = "String")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping("getData")
    @Cacheable(cacheNames = "SERVICE-DEMO01:getData", key = "#num", unless = "#result == null")
    DataVo<PageData<TableOneEntity>> getData(@RequestParam String num);


    @ApiOperation(value = "获取当前session")// 使用该注解描述接口方法信息
    @GetMapping("getSession")
    DataVo getSession();


}
