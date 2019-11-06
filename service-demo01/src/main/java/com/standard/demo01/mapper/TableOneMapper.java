package com.standard.demo01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.standard.common.service.demo01.pojo.TableOneEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangH
 * @date: 2019/10/6 15:15
 * @description:
 */

@Repository
@Mapper
public interface  TableOneMapper extends BaseMapper<TableOneEntity> {
}
