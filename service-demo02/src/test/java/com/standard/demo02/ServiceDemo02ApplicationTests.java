package com.standard.demo02;

import com.standard.common.pojo.DataVo;
import com.standard.common.pojo.PageData;
import com.standard.common.service.demo01.pojo.TableOneEntity;

import com.standard.common.service.demo01.service.Demo01;
import com.standard.common.service.demo02.service.Demo02;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class ServiceDemo02ApplicationTests {

    @Autowired
    private Demo01 demo01;

    @Test
    void contextLoads() {
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("test","23234");
    }



    @Test
    public void testDemo(){
        DataVo<PageData<TableOneEntity>> data = demo01.getData("");
        System.out.println(data);
    }

}
