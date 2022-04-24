package com.xiang.order;

import com.xiang.entity.Order;
import com.xiang.mapper.OrderMapper;
import org.junit.Assert;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@MapperScan("com.xiang.mapper")
@SpringBootTest
public class SampleTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Order> orderList = orderMapper.selectList(null);
        Assert.assertEquals(0, orderList.size());
        orderList.forEach(System.out::println);
    }

}