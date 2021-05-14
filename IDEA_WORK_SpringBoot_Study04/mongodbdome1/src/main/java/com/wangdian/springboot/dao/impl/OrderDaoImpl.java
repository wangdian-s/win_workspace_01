package com.wangdian.springboot.dao.impl;

import com.wangdian.springboot.dao.OrderDao;
import com.wangdian.springboot.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertOrder(Order order) {
        mongoTemplate.save(order);
    }

    @Override
    public void updateOrder(Order order) {
        Query query = new Query(Criteria.where("id").is(order.getId()));
        Update update = new Update().set("address", order.getAddress()).set("name", order.getName());
        // 单条
        mongoTemplate.updateFirst(query, update, Order.class);
        // 多条
        mongoTemplate.updateMulti(query, update, Order.class);
    }

    @Override
    public void deleteOrder(int id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Order.class);//传入类，让其将manggodbd的_id转换成对应类的字段自动转换成
    }

    @Override
    public Order getOrder(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Order.class);
    }
}
