package com.xiang.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiang.entity.Order;
import com.xiang.mapper.OrderMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 * @date
 * @revisionHistory
 **/
@RestController
public class OrderController {
    @Resource
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    public List<Order> queryOrder(@RequestParam Long userId){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return orderMapper.selectList(queryWrapper);
    }

}
