package com.wangdian.springboot.service;

import com.wangdian.springboot.bean.Book;

public interface BookService2 {

    int save(String name);

    Book getBook(String name);
}
