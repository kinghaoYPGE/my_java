package com.myspring.auto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.myspring.auto.services.CustomerService;

/**
 * Hello world!
 *
 */

 public class App {
     private static ApplicationContext context;
     public static void main( String[] args ) {
            //context =  new ClassPathXmlApplicationContext(new String[] {"SpringCustomer-auto.xml"});
            context =  new ClassPathXmlApplicationContext(new String[] {"SpringFilter.xml"});

            CustomerService cust = (CustomerService)context.getBean("customerService");
            System.out.println(cust);

        }
}
