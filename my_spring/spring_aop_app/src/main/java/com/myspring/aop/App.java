package com.myspring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.myspring.aop.advice.CustomerService;

public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "SpringAOPAdvice-autoproxy.xml" });

        CustomerService cust = (CustomerService) appContext.getBean("customerService");
        //CustomerService cust = (CustomerService)appContext.getBean("customerServiceProxy");
        System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printURL();
        System.out.println("*************************");
        try {
            cust.printThrowException();
        } catch (Exception e) {
        }
    }
}