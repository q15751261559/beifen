package com.example.conditional;

import com.example.conditional.ConditionConfig;
import com.example.conditional.MessagePrint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        context=new AnnotationConfigApplicationContext(ConditionConfig.class);
        MessagePrint mp=context.getBean(MessagePrint.class);
        System.out.println(mp.showMessage());
    }
}
