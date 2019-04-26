package com.myspring.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.myspring.aspectj.dao.*;
import com.myspring.aspectj.aspect.*;

public class App {
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "SpringAOPAspectJ.xml" });
        ICustomerDao customerDao = (ICustomerDao)appContext.getBean("customerDaoBean");

        customerDao.addCustomer();

        System.out.println("-------------------------------------------");

        customerDao.deleteCustomer();

    }
}
