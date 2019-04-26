package com.myspring.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static ApplicationContext context;
    
    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        Customer obj = (Customer) context.getBean("customerBean");
        System.out.println(obj.toString());
    }
}
