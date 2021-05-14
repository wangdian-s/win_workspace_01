package com.wangdian.springboot.dao;

import com.wangdian.springboot.entity.Order;


public interface OrderDao {
    void insertOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int id);
    Order getOrder(String name);
}
