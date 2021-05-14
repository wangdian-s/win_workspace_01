package com.wangdian.springboot;

import com.wangdian.springboot.dao.OrderDao;
import com.wangdian.springboot.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Unit test for simple App.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Autowired
    OrderDao orderDao;

    @Test
    public void test1() {
        Order order = new Order();
        order.setId(2);
        order.setAddress("shanghai");
        order.setName("dongfangmingzhu");
        orderDao.insertOrder(order);
    }

    @Test
    public void test2() {
        Order order = new Order();
        order.setId(1);
        order.setAddress("北京");
        order.setName("天安门");
        orderDao.updateOrder(order);
    }

    @Test
    public void test3() {
        Order order = orderDao.getOrder("天安门");
        System.out.println(order);
    }

    @Test
    public void test4() {
        orderDao.deleteOrder(1);
    }
}
