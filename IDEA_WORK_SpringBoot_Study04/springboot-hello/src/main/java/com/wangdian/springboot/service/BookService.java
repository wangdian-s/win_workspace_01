package com.wangdian.springboot.service;

import com.wangdian.springboot.bean.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    void delete(int id);

    List<Book> getAll();
}
