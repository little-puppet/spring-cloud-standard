package com.standard.common.service.demo01.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhangH
 * @date: 2019/10/6 14:53
 * @description:
 */
@Data
@TableName("table_two")
public class TableTwoEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    private String name;

    private String note;

}
