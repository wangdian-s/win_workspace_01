package com.wangdian.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TemplateController {

    @RequestMapping("/wangdian")
    public String other(Map<String, Object> map) {
        map.put("name", "一点课堂");
        map.put("address", "2");
        List<String> listResult = new ArrayList<String>();
        listResult.add("linux");
        listResult.add("springboot");
        listResult.add("dubbo");
        map.put("listResult", listResult);
        return "other";//返回到other.ftl
    }
}
