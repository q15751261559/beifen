package com.niit.controller;

import com.niit.domain.Fruit;
import com.niit.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/index")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @RequestMapping("/fruit")
    public String fruit(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
        List<Fruit> fruitList = fruitService.queryFruitList();
        model.addAttribute("fruitList", fruitList);
        return "fruit";
    }
}
