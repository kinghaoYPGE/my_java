package com.myspring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.myspring.demo.helloworld.HelloWorld;
import com.myspring.demo.loosely_coupled.OutputHelper;

public class App {
    private static ApplicationContext context;
    
    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext(new String[] {"SpringBeans.xml", "Spring-Output.xml"});
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
        obj.printHello();
        output.generateOutput();
    }
}
