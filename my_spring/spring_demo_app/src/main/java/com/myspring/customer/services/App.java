package com.myspring.customer.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static ApplicationContext context;
    
    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        CustomerService custService = (CustomerService) context.getBean("customerServiceBean");
        custService.setMessage("Message from customerService");
        System.out.println("get Message: " + custService.getMessage());
        
        CustomerService custService2 = (CustomerService) context.getBean("customerServiceBean");
        System.out.println("get Message: " + custService2.getMessage());
    }
}
