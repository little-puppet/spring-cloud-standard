package com.standard.demo01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import com.standard.demo01.mapper.TableOneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhangH
 * @date: 2019/10/6 16:17
 * @description:
 */
@Service
public class Demo01Service {


    @Autowired
    private TableOneMapper tableOneMapper;


    public IPage<TableOneEntity> getData() {
        IPage<TableOneEntity> tableOneEntityIPage = tableOneMapper.selectPage(new Page(1, 2), null);
        return tableOneEntityIPage;
    }
}
