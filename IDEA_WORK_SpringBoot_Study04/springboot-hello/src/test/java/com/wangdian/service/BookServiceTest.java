package com.wangdian.service;


import com.wangdian.springboot.HelloSpringboot;
import com.wangdian.springboot.service.BookService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HelloSpringboot.class})
public class BookServiceTest {
    @Autowired
    BookService2 bookService2;

    @Test
    public void testSave() {
        bookService2.save("Junit Test");
    }
}
