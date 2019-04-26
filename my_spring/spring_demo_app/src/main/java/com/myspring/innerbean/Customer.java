package com.myspring.innerbean;

public class Customer {
    private Person person;
    //带参构造方法
    public Customer(Person person) {
        this.person = person;
    }
    //有带参构造方法一定要有默认构造方法
    public Customer(){}

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Customer [person=" + person + "]";
    }
}