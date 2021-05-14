package com.wangdian.springboot.service.impl;

import com.wangdian.springboot.bean.Book;
import com.wangdian.springboot.dao.BookMapper;
import com.wangdian.springboot.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl2 implements BookService2 {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int save(String name) {
        return bookMapper.insert(name);
    }

    @Override
    public Book getBook(String name) {
        return bookMapper.select(name);
    }
}
