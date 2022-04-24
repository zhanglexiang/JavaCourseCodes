package com.xiang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data //lombok注解，不用管
@TableName("s_order")
public class Order extends SuperEntity {

    private String code;

}

