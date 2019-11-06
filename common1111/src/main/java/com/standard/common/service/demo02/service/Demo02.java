package com.standard.common.service.demo02.service;

import com.standard.common.pojo.DataVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zhangH
 * @date: 2019/10/20 16:12
 * @description:
 */
@FeignClient(value = "SERVICE-DEMO02", fallback = Demo02Fallback.class)
public interface Demo02 {

    @ApiOperation(value = "数据接口测试1")// 使用该注解描述接口方法信息
    @GetMapping("getTestData")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "测试参数1", dataType = "String")
    })
// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    DataVo getTestData(String id);

    @ApiOperation(value = "数据接口测试1")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "测试参数1", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "测试参数2", dataType = "String")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping("getTestDataDemo")
    DataVo getTestDataDemo();
}
