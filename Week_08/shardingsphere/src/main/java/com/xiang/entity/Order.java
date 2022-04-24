package com.xiang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data //lombok注解，不用管
@Builder
@TableName("s_order")
public class Order extends SuperEntity {

    private Long userId;

    private String code;

}

