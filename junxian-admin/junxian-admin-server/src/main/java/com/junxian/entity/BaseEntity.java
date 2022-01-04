package com.junxian.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname: BaseEntity
 * @Date: 2022-01-04 9:59
 * @Author: tang_junXian
 * @Description: 每个实体都需要继承的公共类
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId
    private Long id;
//    /**
//     * 创建者
//     */
//    @TableField(fill = FieldFill.INSERT)
//    private Long creator;
//    /**
//     * 创建时间
//     */
//    @TableField(fill = FieldFill.INSERT)
//    private Date createDate;

}
