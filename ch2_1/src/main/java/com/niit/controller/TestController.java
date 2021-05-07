package com.niit.controller;

import com.niit.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/testJson")
    @ResponseBody
    public Map<String,Object>  testJson(@RequestBody Person user){
        System.out.println("pname="+user.getPname()+",password="+user.getPassword()+",page="+user.getPage());
//        return user;
//        ArrayList<Person> allp=new ArrayList<Person>();
//        Person p1=new Person();
//        p1.setPname("陈桓1");
//        p1.setPassword("111");
//        p1.setPage(80);
//        allp.add(p1);
//
//        Person p2=new Person();
//        p2.setPname("陈桓2");
//        p2.setPassword("222");
//        p2.setPage(90);
//        allp.add(p2);
//        return allp;
        Map<String,Object> map=new HashMap<>();
        map.put("pname","陈桓2");
        map.put("password","123456");
        map.put("page",25);
        return map;
//
//        List<Map<String,Object>> allp=new ArrayList<>();
//        allp.add(map);
//        Map<String,Object> map1=new HashMap<>();
//        map1.put("pname","陈桓3");
//        map1.put("password","54321");
//        map1.put("page",55);
//        allp.add(map1);
//        return allp;
    }
}
