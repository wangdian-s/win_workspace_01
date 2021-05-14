package com.wangdian.springboot.controller;

import com.wangdian.springboot.bean.Book;
import com.wangdian.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/addBook/{name}")
    @ResponseBody
    public Book addBook(@PathVariable("name") String name) {
        Book book = new Book();
        book.setName(name);
        bookService.save(book);
        return book;
    }

    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public String queryAll() {
        List<Book> list = bookService.getAll();
        return Arrays.toString(list.toArray());
    }

    @RequestMapping(value = "/deleteBook/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
        return "ok";
    }
}
