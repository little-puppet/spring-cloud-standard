package com.standard.demo01;

import com.standard.common.pojo.DataVo;
import com.standard.common.pojo.PageData;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import com.standard.common.service.demo01.service.Demo01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.logging.Logger;

@SpringBootTest

class ServiceDemo01ApplicationTests {

    @Autowired
    private Demo01 service01;



    @Test
    void contextLoads() {
    }



    @Test
    public void testDemo(){
        DataVo<PageData<TableOneEntity>> data = service01.getData("");
        System.out.println(data);
    }

}
