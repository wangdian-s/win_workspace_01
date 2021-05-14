package com.wangdian.springboot.dao;

import com.wangdian.springboot.bean.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BookMapper {
    @Select("SELECT * FROM Book WHERE NAME = #{name}")
    Book select(@Param("name") String name);

    @Insert("INSERT INTO Book(NAME) VALUES(#{name})")
    int insert(@Param("name") String name);
}
