package org.cornell.fieldmonitor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 */
@Data
public class User implements Serializable {

    //姓
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer money;



}
