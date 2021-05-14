package com.wangdian.springboot.dao;

import com.wangdian.springboot.bean.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
