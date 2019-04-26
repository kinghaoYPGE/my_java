package com.myspring.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static ApplicationContext context;
    
    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext("SpringCollections.xml");

        // list
        Customer customer = (Customer) context.getBean("customerBean");
        System.out.println(customer.getLists().toString());

        // set
        System.out.println(customer.getSets().toString());

        // map
        System.out.println(customer.getMaps().toString());

        // props
        System.out.println(customer.getPros().toString());

        // person
        System.out.println(customer.toString());
    }
}
