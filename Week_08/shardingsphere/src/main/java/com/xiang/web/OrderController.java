package com.xiang.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiang.entity.Order;
import com.xiang.mapper.OrderMapper;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Transactional
    @ShardingSphereTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    @PostMapping("/order")
    public void saveOrder() {

        orderMapper.insert(Order.builder().code("D000100").userId(1L).build());

        orderMapper.insert(Order.builder().code("D000101").userId(2L).build());


    }


}
