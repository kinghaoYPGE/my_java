package com.myspring.auto.services;

import com.myspring.auto.dao.CustomerDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


//@Service("custService")
//@Component
public class CustomerService {
        @Autowired
        CustomerDao customerDao;

        @Override
        public String toString() {
            return "CustomerService [customerDAO=" + customerDao + "]";
        }

}
