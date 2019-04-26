package com.myspring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.myspring.bean.FileNameGenerator;

public class App {
    private static ApplicationContext context;
    
    public static void main( String[] args ) {
        context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        FileNameGenerator obj = (FileNameGenerator) context.getBean("fileNameGenerator");
        obj.printFileName();
    }
}
