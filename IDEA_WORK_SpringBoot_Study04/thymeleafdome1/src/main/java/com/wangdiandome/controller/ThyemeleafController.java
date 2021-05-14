package com.wangdiandome.controller;

import com.wangdiandome.anlity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller//区分于RestController:将字符串welcomefan返回到浏览器
public class ThyemeleafController {

    @RequestMapping(value = "/welcome")//加了@ResponseBody:将字符串welcomefan返回到浏览器
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/welcome");
        mv.addObject("title", "欢迎使用Thymeleaf!");
        return mv;
    }

    @RequestMapping(value = "/welcome2")
    public String test(Model mv) {
        List<String> books = new ArrayList<>();
        books.add("yidiankt.com");
        books.add("iduoan.com");
        books.add("springboot");
        mv.addAttribute("books", books);
        return "welcome";
    }

    @RequestMapping(value = "/user")
    public String test2(Model m) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i<10;i++){
            User user = new User("name"+i, "age" + i);
            users.add(user);
        }
        m.addAttribute("users",users);
        m.addAttribute("isMarry",true);
        m.addAttribute("scode",1);
        return "users";
    }
}
