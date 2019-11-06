package com.standard.common.service.demo01.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhangH
 * @date: 2019/10/6 14:53
 * @description:
 */
@Data
@TableName("table_one")
@Api("table_one实体类注解")
public class TableOneEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(notes = "id主键")
    private long id;

    @ApiModelProperty(notes = "名字")
    private String name;

    @ApiModelProperty(notes = "备注")
    private String note;

}
