package com.example.controller;

import com.example.model.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("loginBean",new LoginBean());
        model.getAttribute("loginBean");
        return "login";
    }
    @RequestMapping("/login")
    public String greetingSubmit(@ModelAttribute LoginBean loginBean){
        System.out.println("测试提交的数据"+loginBean.toString());
        return "result";
    }

}
