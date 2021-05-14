package com.wangdian.springboot.controller;

import com.wangdian.springboot.bean.Person;
import com.wangdian.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class YmlController {
    @Autowired
    User user;

    @Value("${address}")
    String address;


    @Value("${user.lastname}")
    String lastName;

    @Autowired
    Person person;

    @Value("${password}")
    String password;

    @RequestMapping("/yml4")
    @ResponseBody
    public String yml4Test() {
        return "profile: password = " + password;
    }

    @RequestMapping("/yml3")
    @ResponseBody
    public Person yml3Test() {
        return person;
    }

    @RequestMapping("/yml2")
    @ResponseBody
    public String yml2Test() {
        return "address = " + address + " lastName = " + lastName;
    }

    @RequestMapping("/yml")
    @ResponseBody
    public User ymlTest() {
        return user;
    }


}

