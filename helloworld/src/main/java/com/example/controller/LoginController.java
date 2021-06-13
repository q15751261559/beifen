package com.example.controller;

import com.example.model.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLogin(@ModelAttribute("loginBean") LoginBean loginBean){
        loginBean.setUname("初始化用户名");
        loginBean.setAge(0);
        loginBean.setDate(new Date());
        return "login";
    }
    @RequestMapping("/login")
    public String greetingSubmit(@ModelAttribute("loginBean") @Validated LoginBean loginBean, BindingResult rs){

        if (rs.hasErrors())
        {
            return "login";
        }
        else {return "result";}

    }

}
