package com.wangdian.springboot.controller;

import com.wangdian.springboot.bean.Book;
import com.wangdian.springboot.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController2 {
    @Autowired
    private BookService2 bookService2;

    @RequestMapping(value = "/add/{name}")
    @ResponseBody
    public String addBook(@PathVariable("name") String name) {
        Book book = new Book();
        book.setName(name);
       int code= bookService2.save(name);
        return "code="+code;
    }

    @RequestMapping(value = "/book/{name}")
    @ResponseBody
    public Book query(@PathVariable("name") String name) {
       Book book= bookService2.getBook(name);
        return book;
    }
}
